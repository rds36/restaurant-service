package com.rds.restaurantservice.dto;

import java.io.Serializable;

public record MenuItemResponse(
        Long id,
        String name,
        Long price,
        Boolean isAvailable
) implements Serializable {}