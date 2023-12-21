package com.culinarycode.menuservice.client.dto;

import jakarta.validation.constraints.NotBlank;

public record MenuRequest( @NotBlank(message = "Name is required") String name,
		@NotBlank(message = "Description is required") String description ) {
}
