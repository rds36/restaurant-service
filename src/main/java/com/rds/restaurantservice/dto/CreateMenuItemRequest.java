package com.rds.restaurantservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateMenuItemRequest(
        @NotBlank String name,
        @NotNull @Positive Long price,
        @NotNull Boolean isAvailable
){}