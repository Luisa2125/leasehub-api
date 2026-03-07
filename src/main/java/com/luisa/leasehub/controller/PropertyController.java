package com.luisa.leasehub.controller;

import ch.qos.logback.core.util.PropertySetterException;
import com.luisa.leasehub.DTOs.PropertyRequest;
import com.luisa.leasehub.DTOs.PropertyResponse;
import com.luisa.leasehub.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/property")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService){
        this.propertyService = propertyService;
    }

    @PostMapping("/create")
    public PropertyResponse createProperty(@Valid @RequestBody PropertyRequest request) throws PropertySetterException {
        return propertyService.createProperty(request);
    }
}
