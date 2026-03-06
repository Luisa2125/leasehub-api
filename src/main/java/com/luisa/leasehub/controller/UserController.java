package com.luisa.leasehub.controller;

import com.luisa.leasehub.DTOs.UserRequest;
import com.luisa.leasehub.DTOs.UserResponse;
import com.luisa.leasehub.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    public final UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

//    @PostMapping
//    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest request){
//        UserResponse newUser = userService.createUser(request);
//        return newUser != null ? ResponseEntity.status(HttpStatus.CREATED).build()
//                : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> listAll() {
        List<UserResponse> users = userService.findAll();
        return users.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.ok(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findById(userId));
    }
}
