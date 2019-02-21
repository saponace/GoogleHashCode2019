package com.poireau.hashcode.entity;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Pizza {

	private IngredientEnum[][] grid;
	private Integer numberOfRows;
	private Integer numberOfColumns;
	private List<Slice> slices = new ArrayList<>();

	public Pizza(Integer rows, Integer columns) {
		this.numberOfRows = rows;
		this.numberOfColumns = columns;
		this.grid = new IngredientEnum[rows-1][columns-1];
	}
	
	private Boolean isSliceValid(Slice slice, SubjectParameters parameters) {
		Integer numberOfTomatoes = slice.getNumberOfTomatoes();
		Integer numberOfMushrooms = slice.getNumberOfMushroom();
		return (numberOfTomatoes >= parameters.getMinimumOfEachIngredient() && 
				numberOfMushrooms >= parameters.getMinimumOfEachIngredient() && 
				numberOfTomatoes+numberOfMushrooms <= parameters.getMaximumOfIngredients());
	}
	
	private Boolean isCellInSlices(Integer row, Integer column) {
		for (Slice slice : slices) {
			if (row >= slice.getR1() && row <= slice.getR2() &&
				column >= slice.getC1() && column <= slice.getC2()) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
	
	private void setIngredient(Integer row, Integer column, IngredientEnum ingredient) {
		grid[row][column] = ingredient;
	}
	
	private void addSlice(Slice slice) {
		slices.add(slice);
	}
	
	
	public IngredientEnum[][] getGrid() {
		return grid;
	}

	public Integer getNumberOfRows() {
		return numberOfRows;
	}

	public Integer getNumberOfColumns() {
		return numberOfColumns;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		for (Integer rowCount = 0; rowCount < this.getNumberOfRows(); rowCount++) {
			for(Integer columnCount = 0; columnCount < this.getNumberOfColumns(); columnCount++) {
				buffer.append(grid[rowCount][columnCount].toString());
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}
	
}
