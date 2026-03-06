package com.luisa.leasehub.controller;

import com.luisa.leasehub.DTOs.LoginRequest;
import com.luisa.leasehub.DTOs.LoginResponse;
import com.luisa.leasehub.DTOs.UserRequest;
import com.luisa.leasehub.DTOs.UserResponse;
import com.luisa.leasehub.model.User;
import com.luisa.leasehub.security.JwtService;
import com.luisa.leasehub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;


    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody UserRequest request){
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return userService.login(request);
    }

}
