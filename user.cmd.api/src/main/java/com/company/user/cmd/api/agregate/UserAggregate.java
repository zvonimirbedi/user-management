package com.company.user.cmd.api.agregate;


import com.company.user.cmd.api.command.RegisterUserCommand;
import com.company.user.cmd.api.command.RemoveUserCommand;
import com.company.user.cmd.api.command.UpdateUserCommand;
import com.company.user.cmd.api.service.encode.PasswordEncoder;
import com.company.user.core.event.UserRegisteredEvent;
import com.company.user.core.event.UserRemovedEvent;
import com.company.user.core.event.UserUpdatedEvent;
import com.company.user.core.model.User;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Aggregate
@NoArgsConstructor
public class UserAggregate {

    @AggregateIdentifier
    private String id;
    private User user;


    @CommandHandler
    public UserAggregate(RegisterUserCommand command, PasswordEncoder passwordEncoder) {
        var newUser = command.getUser();
        newUser.setId(command.getId());
        var password = newUser.getAccount().getPassword();
        var hashedPassword = passwordEncoder.hashPassword(password);
        newUser.getAccount().setPassword(hashedPassword);

        var event = UserRegisteredEvent.builder()
                .id(command.getId())
                .user(newUser)
                .build();

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(UpdateUserCommand command, PasswordEncoder passwordEncoder) {
        var updatedUser = command.getUser();
        updatedUser.setId(command.getId());
        var password = updatedUser.getAccount().getPassword();
        var hashedPassword = passwordEncoder.hashPassword(password);
        updatedUser.getAccount().setPassword(hashedPassword);

        var event = UserUpdatedEvent.builder()
                .id(UUID.randomUUID().toString())
                .user(updatedUser)
                .build();

        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public void handle(RemoveUserCommand command) {
        var event = new UserRemovedEvent();
        event.setId(command.getId());

        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UserRegisteredEvent event) {
        this.id = event.getId();
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserUpdatedEvent event) {
        this.user = event.getUser();
    }

    @EventSourcingHandler
    public void on(UserRemovedEvent event) {
        AggregateLifecycle.markDeleted();
    }
}

