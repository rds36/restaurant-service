package com.rds.restaurantservice.domain.repository;

import com.rds.restaurantservice.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
