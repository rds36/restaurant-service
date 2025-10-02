package com.rds.restaurantservice.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="menu_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @Column(nullable=false, length=200)
    private String name;

    @Column(nullable=false)
    private Long price;

    @Column(nullable=false)
    private Boolean isAvailable = true;
}