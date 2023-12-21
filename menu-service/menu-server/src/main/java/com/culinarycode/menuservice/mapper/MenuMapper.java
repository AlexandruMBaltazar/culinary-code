package com.culinarycode.menuservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import com.culinarycode.menuservice.client.dto.MenuRequest;
import com.culinarycode.menuservice.client.dto.MenuResponse;
import com.culinarycode.menuservice.client.model.Menu;

@Component
@Mapper(componentModel = "spring")
public interface MenuMapper {

	@Mapping(target = "id", ignore = true)
	Menu menuRequestToMenu( final MenuRequest menuRequest );

	MenuResponse menuToMenuResponse( final Menu menu );

}
