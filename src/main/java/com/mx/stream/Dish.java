package com.mx.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dish {
	private Integer calorias;
	private String nombre;
	private DishType type;
	public Dish() {}
	
}

