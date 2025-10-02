package com.rds.restaurantservice.controller;

import com.rds.restaurantservice.domain.entity.Restaurant;
import com.rds.restaurantservice.dto.CreateRestaurantRequest;
import com.rds.restaurantservice.service.RestaurantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody @Valid CreateRestaurantRequest request){
        return ResponseEntity.ok(restaurantService.createRestaurant(request));
    }
}
