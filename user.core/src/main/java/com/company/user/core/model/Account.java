package com.company.user.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Size(min = 2, message = "field too short")
    private String username;
    @Size(min = 7, message = "field too short")
    private String password;
    @NotNull(message = "field is mandatory and must be valid")
    private List<Role> roles;
}
