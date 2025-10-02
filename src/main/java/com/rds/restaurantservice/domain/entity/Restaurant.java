package com.rds.restaurantservice.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name="restaurant", schema = "restaurant_service")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=200)
    private String name;

    @Column(length=100)
    private String city;

    @Column(nullable=false)
    private Boolean isActive = true;

    @Column(nullable=false)
    private Instant createdAt;

}