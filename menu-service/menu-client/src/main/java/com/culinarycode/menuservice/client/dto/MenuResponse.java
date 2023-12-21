package com.culinarycode.menuservice.client.dto;

public record MenuResponse( Long id, Long restaurantId, String name, String description ) {
}
