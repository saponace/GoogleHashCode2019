package com.poireau.hashcode;

import com.poireau.hashcode.utils.IoUtils;
import com.poireau.hashcode.utils.Profiler;
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
                        Slice slice = new Slice(row, col, rowInSlice, colInSlice);

                        if (slice.hasTooMuchIngredients(params.getMaximumOfIngredients())) {
                            break;
                        }

                        if (slice.hasEnoughOfEachIngredient(params.getMinimumOfEachIngredient())) {
                            pizza.addSlice(slice);
                            break;
                        }
                    }
                }
            }
        }

        return pizza;
    }

    //public Boolean isValid() {
        //// Est ce que le decoupage est valide par rapport au problème
        //return false;
    //}
}
