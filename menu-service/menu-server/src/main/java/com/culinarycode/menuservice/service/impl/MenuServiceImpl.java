package com.culinarycode.menuservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.culinarycode.commonservice.exception.GlobalApiRequestException;
import com.culinarycode.menuservice.client.dto.MenuRequest;
import com.culinarycode.menuservice.client.dto.MenuResponse;
import com.culinarycode.menuservice.client.model.Menu;
import com.culinarycode.menuservice.mapper.MenuMapper;
import com.culinarycode.menuservice.repository.MenuRepository;
import com.culinarycode.menuservice.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	private final MenuRepository menuRepository;
	private final MenuMapper menuMapper;

	public MenuServiceImpl( final MenuRepository menuRepository, final MenuMapper menuMapper ) {
		this.menuRepository = menuRepository;
		this.menuMapper = menuMapper;
	}

	@Override
	public MenuResponse createMenu( final MenuRequest menuRequest, final Long restaurantId ) {
		final Menu createdMenu = menuRepository.save( menuMapper.menuRequestToMenu( menuRequest, restaurantId ) );
		return menuMapper.menuToMenuResponse( createdMenu );
	}

	@Override
	public List<MenuResponse> getAllMenus( final Long restaurantId ) {
		return menuRepository.findByRestaurantId( restaurantId )
				.stream()
				.map( menuMapper::menuToMenuResponse )
				.collect( Collectors.toList() );
	}

	@Override
	public MenuResponse updateMenu( final MenuRequest menuRequest, final Long menuId, final Long restaurantId ) {
		if ( !menuRepository.existsByIdAndRestaurantId( menuId, restaurantId ) ) {
			throw new GlobalApiRequestException( "Menu does not exist", HttpStatus.NOT_FOUND );
		}

		final Menu updatedMenu =
				menuRepository.save( menuMapper.updateMenuRequestToMenu( menuRequest, menuId, restaurantId ) );
		return menuMapper.menuToMenuResponse( updatedMenu );
	}

}
