package com.rds.restaurantservice.controller;

import com.rds.restaurantservice.dto.CreateMenuItemRequest;
import com.rds.restaurantservice.dto.MenuItemResponse;
import com.rds.restaurantservice.dto.UpdateAvailabilityMenuItemRequest;
import com.rds.restaurantservice.service.MenuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/{restaurantId}")
    public List<MenuItemResponse> getMenu(@PathVariable Long restaurantId){
        return  menuService.getMenu(restaurantId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{restaurantId}")
    public void addMenuItem(@PathVariable Long restaurantId, @RequestBody @Valid CreateMenuItemRequest request){
        menuService.addMenuItem(restaurantId, request);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/{restaurantId}/{menuItemId}")
    public void updateMenuItemAvailability(
            @PathVariable Long restaurantId,
            @PathVariable Long menuItemId,
            @RequestBody @Valid UpdateAvailabilityMenuItemRequest request
    ){
        menuService.updateMenuItemAvailability(restaurantId, menuItemId, request);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{restaurantId}/{menuItemId}")
    public void deleteMenuItem(@PathVariable Long restaurantId, @PathVariable Long menuItemId){
        menuService.deleteMenuItem(restaurantId, menuItemId);
    }


}
