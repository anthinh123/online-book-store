package com.thinh.onlinebookstore.requestdto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {

    @Email
    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Password is required")
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    private String password;
}
