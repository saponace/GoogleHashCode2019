package com.poireau.hashcode.entity;

public class SubjectParameters {

	private Integer minimumOfEachIngredient;
	private Integer maximumOfIngredients;
	
	public SubjectParameters(Integer minimimOfEachIngredient, Integer maximumOfIngredients) {
		this.minimumOfEachIngredient = minimimOfEachIngredient;
		this.maximumOfIngredients = maximumOfIngredients;
	}

	public Integer getMinimumOfEachIngredient() {
		return minimumOfEachIngredient;
	}

	public Integer getMaximumOfIngredients() {
		return maximumOfIngredients;
	}
	
	
	
}
