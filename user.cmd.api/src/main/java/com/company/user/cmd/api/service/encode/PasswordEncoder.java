package com.company.user.cmd.api.service.encode;

public interface PasswordEncoder {
    String hashPassword(String password);
}
