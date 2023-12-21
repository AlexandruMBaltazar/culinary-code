package com.culinarycode.menuservice.service.impl;

import com.culinarycode.menuservice.client.model.Menu;
import org.springframework.stereotype.Service;

import com.culinarycode.menuservice.client.dto.MenuRequest;
import com.culinarycode.menuservice.client.dto.MenuResponse;
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
	public MenuResponse createMenu( final MenuRequest menuRequest ) {
		final Menu createdMenu = menuRepository.save( menuMapper.menuRequestToMenu( menuRequest ) );
		return menuMapper.menuToMenuResponse( createdMenu );
	}

}
