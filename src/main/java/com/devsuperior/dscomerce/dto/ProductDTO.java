package com.devsuperior.dscomerce.dto;

import com.devsuperior.dscomerce.entities.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductDTO(
		Long id,
		@NotBlank(message = "Recurso obrigatório") 
		@Size(min = 3, max = 80, message = "Nome precisa ter entre 3 a 80 caracteres")
		String name,
		@NotBlank(message = "Recurso obrigatório")
		@Size(min = 10, message = "Descrição deve ter no mínimo 10 caracteres")
		String description,
		@Positive(message = "O preço deve ser um número positivo")
		Double price,
		String imgUrl) {
	public static ProductDTO fromProduct(Product p) {
		return new ProductDTO(
				p.getId(),
				p.getName(),
				p.getDescription(),
				p.getPrice(),
				p.getImgUrl());
	}

	public Long id() {
		return id;
	}

	public String name() {
		return name;
	}

	public String description() {
		return description;
	}

	public Double price() {
		return price;
	}

	public String imgUrl() {
		return imgUrl;
	}
	
	
}
