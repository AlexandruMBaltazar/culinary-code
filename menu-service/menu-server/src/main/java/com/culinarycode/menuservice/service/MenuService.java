package com.culinarycode.menuservice.service;

import java.util.List;

import com.culinarycode.menuservice.client.dto.MenuRequest;
import com.culinarycode.menuservice.client.dto.MenuResponse;

public interface MenuService {

	MenuResponse createMenu( final MenuRequest menuRequest, final Long restaurantId );

	List<MenuResponse> getAllMenus( final Long restaurantId );

}
