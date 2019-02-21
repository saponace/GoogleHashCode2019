package com.poireau.hashcode.entity;

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
		this.grid = new IngredientEnum[rows][columns];
	}
	
	public IngredientEnum getContentCell(Integer row, Integer col) {
		return grid[row][col];
	}
	
	public Boolean isSliceValid(Slice slice, SubjectParameters parameters) {
		Integer numberOfTomatoes = slice.getNumberOfTomatoes();
		Integer numberOfMushrooms = slice.getNumberOfMushroom();
		return (numberOfTomatoes >= parameters.getL() &&
				numberOfMushrooms >= parameters.getL() &&
				numberOfTomatoes+numberOfMushrooms <= parameters.getH());
	}
	
	public Boolean isCellInSlices(Integer row, Integer column) {
		for (Slice slice : slices) {
			if (row >= slice.getR1() && row <= slice.getR2() &&
				column >= slice.getC1() && column <= slice.getC2()) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public void setIngredient(Integer row, Integer column, IngredientEnum ingredient) {
		grid[row][column] = ingredient;
	}
	
	public void addSlice(Slice slice) {
		slices.add(slice);
	}

    public List<Slice> getSlices() {
        return slices;
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
