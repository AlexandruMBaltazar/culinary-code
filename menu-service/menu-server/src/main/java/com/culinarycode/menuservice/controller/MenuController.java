package com.culinarycode.menuservice.controller;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.culinarycode.menuservice.client.dto.MenuRequest;
import com.culinarycode.menuservice.client.dto.MenuResponse;
import com.culinarycode.menuservice.service.MenuService;

@RestController
@RequestMapping("/api/v1/menus")
public class MenuController {

	private final MenuService menuService;

	public MenuController( final MenuService menuService ) {
		this.menuService = menuService;
	}

	@PostMapping
	public ResponseEntity<MenuResponse> createMenu( @Valid @RequestBody final MenuRequest menuRequest ) {
		return new ResponseEntity<>( menuService.createMenu( menuRequest ), HttpStatus.CREATED );
	}

}
