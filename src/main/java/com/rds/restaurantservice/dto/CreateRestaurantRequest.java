package com.rds.restaurantservice.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateRestaurantRequest (
        @NotBlank String name,
        String city
){}
