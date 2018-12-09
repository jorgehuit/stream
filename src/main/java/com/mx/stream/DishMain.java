package com.mx.stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j;

@Log4j
public class DishMain {

	public static void main(String[] args) {
		List<Dish> listDishes = cargarMenus();
		
		List<String> nombrePlatosLigeros = 
				listDishes.stream()
				.filter(plato -> plato.getCalorias() < 80)
				.sorted(comparing(Dish::getCalorias))
				.map(Dish::getNombre)
				.collect(toList());
		List<Integer> getMilanesaPollo = 
				listDishes.stream()
				.filter(plato -> plato.getNombre().equals("MilanesaPollo"))
				.map(Dish::getCalorias)
				.collect(toList());
		
		getMilanesaPollo.forEach(nombre -> log.info(nombre));

		nombrePlatosLigeros.forEach(nombre -> log.info(nombre));
		
		Dish dish = listDishes.stream().findFirst().get();
		dish.getCalorias();
		Map<DishType, List<Dish>> dishesByType =
				listDishes.stream().collect(groupingBy(Dish::getType));
		
		log.info(dishesByType);

	}

	
	private static List<Dish> cargarMenus() {
		List<Dish> listDishes = Arrays.asList(
				new Dish(100, "MilanesaPollo", DishType.CARNE),
				new Dish(30, "Ostion", DishType.PESCADO),
				new Dish(90, "MilanesaRes", DishType.CARNE), 
				new Dish(52, "Camaron", DishType.PESCADO), 
				new Dish(56, "Jamon", DishType.CARNE),
				new Dish(30, "Arroz", DishType.OTRO), 
				new Dish(150, "Guisantes", DishType.OTRO));
		return listDishes;
	}

}
