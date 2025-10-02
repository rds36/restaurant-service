package com.rds.restaurantservice.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateAvailabilityMenuItemRequest(
        @NotNull Boolean isAvailable
){ }
