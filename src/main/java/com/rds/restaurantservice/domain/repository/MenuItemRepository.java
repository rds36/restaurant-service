package com.rds.restaurantservice.domain.repository;

import com.rds.restaurantservice.domain.entity.MenuItem;
import com.rds.restaurantservice.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    List<MenuItem> findByRestaurantAndIsAvailableTrue(Restaurant restaurant);
}
