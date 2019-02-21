package com.poireau.hashcode.entity;

public class Slice {

	private Integer r1;
	private Integer c1;
	private Integer r2;
	private Integer c2;
	private Integer numberOfMushroom;
	private Integer numberOfTomatoes;
	
	public Slice(Integer r1, Integer c1, Integer r2, Integer c2) {
		this.r1 = r1;
		this.c1 = c1;
		this.r2 = r2;
		this.c2 = c2;
	}
	
	public void addIngredient(IngredientEnum ingredient) {
		if (IngredientEnum.TOMATO.equals(ingredient)) {
			numberOfTomatoes++;
		} else if (IngredientEnum.MUSHROOM.equals(ingredient)) {
			numberOfMushroom++;
		}
	}
	
	public Boolean hasEnoughOfEachIngredient(Integer numberOfEachIngredient) {
		return (numberOfMushroom >= numberOfEachIngredient &&
				numberOfTomatoes >= numberOfEachIngredient);
	}
	
	public Boolean hasTooMuchIngredients(Integer numberOfIngredients) {
		return (numberOfMushroom + numberOfTomatoes > numberOfIngredients);
	}

	public Integer getR1() {
		return r1;
	}

	public Integer getC1() {
		return c1;
	}

	public Integer getR2() {
		return r2;
	}

	public Integer getC2() {
		return c2;
	}

	public Integer getNumberOfMushroom() {
		return numberOfMushroom;
	}

	public Integer getNumberOfTomatoes() {
		return numberOfTomatoes;
	}
	
	
	
}
