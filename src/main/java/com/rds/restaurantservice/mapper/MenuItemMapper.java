package com.rds.restaurantservice.mapper;

import com.rds.restaurantservice.domain.entity.MenuItem;
import com.rds.restaurantservice.domain.entity.Restaurant;
import com.rds.restaurantservice.dto.CreateMenuItemRequest;
import com.rds.restaurantservice.dto.MenuItemResponse;

public class MenuItemMapper {
    public static MenuItemResponse mapToResponse(MenuItem menuItem) {
        return new MenuItemResponse(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getPrice(),
                menuItem.getIsAvailable()
        );
    }

    public static MenuItem mapToEntity(CreateMenuItemRequest request, Restaurant restaurant) {
        return new MenuItem(
                null,
                restaurant,
                request.name(),
                request.price(),
                request.isAvailable()
        );
    }
}
