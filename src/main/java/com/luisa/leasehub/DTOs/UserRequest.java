package com.luisa.leasehub.DTOs;

import com.luisa.leasehub.enums.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequest {
    @NotBlank(message = "First name must no be empty")
    @Size(max = 50, message = "First Name cannot exceed 50 characters")
    private String firstName;
    @NotBlank(message = "Last name must no be empty")
    @Size(max = 50, message = "First Name cannot exceed 50 characters")
    private String lastName;
    @NotBlank(message = "Email must no be empty")
    @Email(message = "Invalid format")
    private String email;
    @NotBlank(message = "Phone must no be empty")
    private String phone;
    @NotNull(message = "Role must no be empty")
    private Role role;


    public UserRequest(String firstName, String lastName, String email, String phone, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
