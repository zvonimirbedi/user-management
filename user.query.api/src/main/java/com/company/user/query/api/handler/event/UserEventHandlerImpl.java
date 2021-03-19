package com.company.user.query.api.handler.event;

import com.company.user.core.event.UserRegisteredEvent;
import com.company.user.core.event.UserRemovedEvent;
import com.company.user.core.event.UserUpdatedEvent;
import com.company.user.query.api.repository.RepositoryUser;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@ProcessingGroup("user-group")
public class UserEventHandlerImpl implements UserEventHandler {

    @Autowired
    RepositoryUser repositoryUser;

    @EventHandler
    @Override
    public void on(UserRegisteredEvent event) {

        repositoryUser.save(event.getUser());
    }

    @EventHandler
    @Override
    public void on(UserUpdatedEvent event) {
        repositoryUser.save(event.getUser());
    }

    @EventHandler
    @Override
    public void on(UserRemovedEvent event) {
        repositoryUser.deleteById(event.getId());
    }
}
