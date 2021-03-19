package com.company.user.cmd.api.command;

import com.company.user.core.model.User;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class RegisterUserCommand {

    @TargetAggregateIdentifier
    private String id;
    @NotNull(message = "must not be null")
    @Valid
    private User user;


}
