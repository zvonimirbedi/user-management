package com.company.user.cmd.api.controller;

import com.company.user.cmd.api.command.UpdateUserCommand;
import com.company.user.core.dto.BaseResponse;
import com.company.user.cmd.api.dto.RegisterUserResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/updateUser")
public class ControllerUpdateUser {
    @Autowired
    CommandGateway commandGateway;


    @PutMapping
    public ResponseEntity<BaseResponse> updateUser(@Valid @RequestBody UpdateUserCommand command) {
        String id = command.getId();
        try {
            commandGateway.sendAndWait(command);

            return new ResponseEntity<>(new BaseResponse("User successfully updated!"), HttpStatus.CREATED);
        } catch (Exception e) {
            var safeErrorMessage = "Error while processing update user request for id - " + id;
            System.out.println(e.toString());

            return new ResponseEntity<>(new RegisterUserResponse(id, safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
