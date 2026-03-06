package com.luisa.leasehub.service;

import com.luisa.leasehub.DTOs.UserRequest;
import com.luisa.leasehub.DTOs.UserResponse;
import com.luisa.leasehub.exception.EmailAlreadyExistsException;
import com.luisa.leasehub.exception.ResourceNotFoundException;
import com.luisa.leasehub.model.User;
import com.luisa.leasehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public static UserResponse mapFromUser(User user){
        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhone(),
                user.getRole(),
                user.getCreatedAt()
        );
        return userResponse;
    }
    public static User mapToUser(UserRequest userRequest){
        User user = new User(
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getEmail(),
                userRequest.getPhone(),
                userRequest.getRole(),
                LocalDateTime.now().toString()
        );
        return user;
    }

    public UserResponse createUser(UserRequest userRequest){
        String email = userRequest.getEmail();
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            throw new EmailAlreadyExistsException("Email already exists");
        }else {
            User newUser = mapToUser(userRequest);
            UserResponse userResponse = mapFromUser(userRepository.save(newUser));
            return userResponse;
        }
    }

    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream().map(UserService::mapFromUser).toList();
        return userResponses;
    }

    public UserResponse findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with id :"+userId));
        UserResponse userResponse = mapFromUser(user);
        return userResponse;
    }

}
