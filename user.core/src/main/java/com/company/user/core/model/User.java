package com.company.user.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    @Id
    private String id;
    @NotEmpty(message = "field is mandatory")
    private String firstname;
    @NotEmpty(message = "field is mandatory")
    private String lastname;
    @Email(message = "field is mandatory and must be valid")
    private String email;
    @NotNull(message = "field is mandatory and must be valid")
    @Valid
    private Account account;



}
