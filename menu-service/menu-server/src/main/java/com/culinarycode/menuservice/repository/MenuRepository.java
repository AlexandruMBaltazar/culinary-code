package com.culinarycode.menuservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culinarycode.menuservice.client.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

	List<Menu> findByRestaurantId( final Long restaurantId );

	boolean existsByIdAndRestaurantId( final Long id, final Long restaurantId );

}
