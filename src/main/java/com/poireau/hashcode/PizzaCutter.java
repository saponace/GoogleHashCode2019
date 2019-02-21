package com.poireau.hashcode;

import com.poireau.hashcode.utils.IoUtils;
import com.poireau.hashcode.utils.Profiler;
import com.poireau.hashcode.entity.IngredientEnum;
import com.poireau.hashcode.entity.Pizza;
import com.poireau.hashcode.entity.Slice;
import com.poireau.hashcode.entity.SubjectParameters;
import com.poireau.hashcode.utils.FilesPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PizzaCutter {
    private Pizza pizza;
    private SubjectParameters params;

    public PizzaCutter(Pizza p, SubjectParameters s) {
        pizza = p;
        params = s;
    }

    public Pizza cutSlices() {
        for (Integer row = 0; row < pizza.getNumberOfRows(); row++) {
            for (Integer col = 0; col < pizza.getNumberOfColumns(); col++) {
                if (pizza.isCellInSlices(row, col)) {
                    continue;
                }

                for (Integer rowInSlice = row; rowInSlice < pizza.getNumberOfRows() - row; rowInSlice++) {
                    for (Integer colInSlice = col; colInSlice < pizza.getNumberOfColumns() - col; colInSlice++) {
                        if (!pizza.isCellInSlices(row, col)) {
                            Slice slice = new Slice(row, col, rowInSlice, colInSlice);
                            getContentOfSlice(pizza, slice, row, col, rowInSlice, colInSlice);

                            if (slice.hasTooMuchIngredients(params.getH())) {
                                break;
                            }

                            if (slice.hasEnoughOfEachIngredient(params.getL())) {
                                pizza.addSlice(slice);
                                row = slice.getR1();
                                col = slice.getC2() + 1;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return pizza;
    }

	private void getContentOfSlice(Pizza pizza, Slice slice, Integer row, Integer col, Integer rowInSlice, Integer colInSlice) {
		for (Integer rowCount = row; rowCount <= rowInSlice; rowCount++) {
			for (Integer colCount = col; colCount <= colInSlice; colCount++) {
				slice.addIngredient(pizza.getContentCell(rowCount, colCount));
			}
		}
	}

    //public Boolean isValid() {
        //// Est ce que le decoupage est valide par rapport au problème
        //return false;
    //}
}
