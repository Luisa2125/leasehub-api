package com.luisa.leasehub.repository;

import com.luisa.leasehub.model.Property;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    Optional<Property> findByAddressIgnoreCaseAndPostcode(String address, String postcode);
}
