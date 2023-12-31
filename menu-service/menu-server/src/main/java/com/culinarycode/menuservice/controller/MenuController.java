package com.culinarycode.menuservice.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culinarycode.menuservice.client.dto.MenuRequest;
import com.culinarycode.menuservice.client.dto.MenuResponse;
import com.culinarycode.menuservice.service.MenuService;

@RestController
@RequestMapping("/api/v1/restaurants/{restaurantId}/menus")
public class MenuController {

	private final MenuService menuService;

	public MenuController( final MenuService menuService ) {
		this.menuService = menuService;
	}

	@PostMapping
	public ResponseEntity<MenuResponse> createMenu(
			@PathVariable("restaurantId") final Long restaurantId,
			@Valid @RequestBody final MenuRequest menuRequest ) {
		return new ResponseEntity<>( menuService.createMenu( menuRequest, restaurantId ), HttpStatus.CREATED );
	}

	@GetMapping
	public ResponseEntity<List<MenuResponse>> getAllMenus( @PathVariable("restaurantId") final Long restaurantId ) {
		return new ResponseEntity<>( menuService.getAllMenus( restaurantId ), HttpStatus.OK );
	}

	@PutMapping("/{menuId}")
	public ResponseEntity<MenuResponse> updateMenu(
			@Valid @RequestBody final MenuRequest menuRequest,
			@PathVariable("restaurantId") final Long restaurantId,
			@PathVariable("menuId") final Long menuId ) {
		return new ResponseEntity<>( menuService.updateMenu( menuRequest, menuId, restaurantId ), HttpStatus.OK );
	}

}
