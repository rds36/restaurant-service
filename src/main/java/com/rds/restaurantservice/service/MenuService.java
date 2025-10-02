package com.rds.restaurantservice.service;

import com.rds.restaurantservice.domain.repository.MenuItemRepository;
import com.rds.restaurantservice.dto.CreateMenuItemRequest;
import com.rds.restaurantservice.dto.MenuItemResponse;
import com.rds.restaurantservice.dto.UpdateAvailabilityMenuItemRequest;
import com.rds.restaurantservice.exception.DataNotFoundException;
import com.rds.restaurantservice.mapper.MenuItemMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuItemRepository menuItemRepository;
    private final RestaurantService restaurantService;

    @Cacheable(cacheNames = "menu", key = "#restaurantId")
    public List<MenuItemResponse> getMenu(Long restaurantId){
        var restaurant = restaurantService.getRestaurantById(restaurantId);
        var menuItems = menuItemRepository.findByRestaurantAndIsAvailableTrue(restaurant);

        // map to response
        return menuItems.stream()
                .map(MenuItemMapper::mapToResponse)
                .toList();
    }

    @CacheEvict(cacheNames = "menu", key = "#restaurantId")
    public void addMenuItem(Long restaurantId, CreateMenuItemRequest request){
        var restaurant = restaurantService.getRestaurantById(restaurantId);
        var menuItem = MenuItemMapper.mapToEntity(request, restaurant);
        menuItemRepository.save(menuItem);
    }

    @CacheEvict(cacheNames = "menu", key = "#restaurantId")
    public void updateMenuItemAvailability(Long restaurantId, Long menuItemId, UpdateAvailabilityMenuItemRequest request){
        var restaurant = restaurantService.getRestaurantById(restaurantId);
        var menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new DataNotFoundException("Menu item not found"));

        // check if menu item belongs to the restaurant
        if (!menuItem.getRestaurant().equals(restaurant)) {
            throw new DataNotFoundException("Menu doesn't exist in restaurant");
        }

        menuItem.setIsAvailable(request.isAvailable());
        menuItemRepository.save(menuItem);
    }

    @CacheEvict(cacheNames = "menu", key = "#restaurantId")
    public void deleteMenuItem(Long restaurantId, Long menuItemId){
        var restaurant = restaurantService.getRestaurantById(restaurantId);
        var menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new DataNotFoundException("Menu item not found"));
        if (!menuItem.getRestaurant().equals(restaurant)) {
            throw new DataNotFoundException("Menu doesn't exist in restaurant");
        }
        menuItemRepository.delete(menuItem);
    }
}
