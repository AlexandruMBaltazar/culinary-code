package com.culinarycode.menuservice.client.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MenuRequest( @NotNull(message = "Restaurant id is required") Long restaurantId,
		@NotBlank(message = "Name is required") String name,
		@NotBlank(message = "Description is required") String description ) {
}
