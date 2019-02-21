package com.poireau.hashcode.entity;

public class Pizza {

	private IngredientEnum[][] grid;

	public Pizza(Integer rows, Integer columns) {
		grid = new IngredientEnum[rows][columns];
	}
	
}
