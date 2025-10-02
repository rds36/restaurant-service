package com.rds.restaurantservice.service;

import com.rds.restaurantservice.domain.entity.Restaurant;
import com.rds.restaurantservice.domain.repository.RestaurantRepository;
import com.rds.restaurantservice.dto.CreateRestaurantRequest;
import com.rds.restaurantservice.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(CreateRestaurantRequest request){
        var restaurant = Restaurant.builder()
                .name(request.name())
                .city(request.city())
                .createdAt(Instant.now())
                .isActive(true)
                .build();
        return restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantById(Long id){
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Restaurant not found"));
    }
}
