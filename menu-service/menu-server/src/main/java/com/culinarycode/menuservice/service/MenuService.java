package com.culinarycode.menuservice.service;

import com.culinarycode.menuservice.client.dto.MenuRequest;
import com.culinarycode.menuservice.client.dto.MenuResponse;

public interface MenuService {

	MenuResponse createMenu( final MenuRequest menuRequest );

}
