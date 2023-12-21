package com.culinarycode.menuservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.culinarycode.menuservice.client.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
}
