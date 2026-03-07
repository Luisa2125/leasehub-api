package com.luisa.leasehub.service;

import ch.qos.logback.core.util.PropertySetterException;
import com.luisa.leasehub.DTOs.PropertyRequest;
import com.luisa.leasehub.DTOs.PropertyResponse;
import com.luisa.leasehub.exception.ResourceNotFoundException;
import com.luisa.leasehub.model.Property;
import com.luisa.leasehub.model.User;
import com.luisa.leasehub.repository.PropertyRepository;
import com.luisa.leasehub.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;
    private final UserRepository userRepository;

    public PropertyService(PropertyRepository propertyRepository, UserRepository userRepository){
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }

    public Property mapToProperty(PropertyRequest request, User user){
        return new Property(
                request.getTitle(),
                request.getDescription(),
                request.getAddress(),
                request.getCity(),
                request.getState(),
                request.getPostcode(),
                request.getRentAmount(),
                LocalDateTime.now().toString(),
                user
        );
    }

    public PropertyResponse mapFromProperty(Property property){
        return new PropertyResponse(
                property.getId(),
                property.getTitle(),
                property.getDescription(),
                property.getAddress(),
                property.getCity(),
                property.getState(),
                property.getPostcode(),
                property.getRentAmount(),
                UserService.mapFromUser(property.getUser())
        );
    }
    public PropertyResponse createProperty(PropertyRequest request) throws PropertySetterException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        request.setUserId(user.getId());
        Optional<Property> property = propertyRepository.findByAddressIgnoreCaseAndPostcode(request.getAddress(),request.getPostcode());
        if(property.isPresent()){
            throw new PropertySetterException("Property already exists");
        }else{
            Property newProperty = mapToProperty(request, user);
            PropertyResponse propertyResponse = mapFromProperty(propertyRepository.save(newProperty));
            return propertyResponse;
        }
    }


}
