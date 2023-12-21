package com.culinarycode.menuservice.client.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Menu.MenuBuilder.class)
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Getter
@Entity(name = "menus")
public final class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private final Long id;

	@Column(nullable = false)
	private final Long restaurantId;

	@Column(nullable = false)
	private final String name;

	@Column(nullable = false)
	private final String description;

	@JsonPOJOBuilder(withPrefix = "")
	public static final class MenuBuilder {
	}

}
