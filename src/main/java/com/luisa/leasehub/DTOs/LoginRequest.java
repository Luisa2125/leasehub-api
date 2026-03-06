package com.luisa.leasehub.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class LoginRequest {
    @NotBlank(message = "Email must no be empty")
    @Email(message = "Email must be valid")
    private String email;
    @NotBlank(message = "Password must no be null")
    @Size(min = 8, max = 12, message = "Password must be between 8 and 12 Characters")
    private String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
