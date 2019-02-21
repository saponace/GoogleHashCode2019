package com.poireau.hashcode.utils;


import com.poireau.hashcode.entity.IngredientEnum;
import com.poireau.hashcode.entity.Pizza;
import com.poireau.hashcode.entity.Slice;
import com.poireau.hashcode.entity.SubjectParameters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Team Poireau
 */
public class IoUtils {
    private IoUtils() {
    }

    /**
     * Parse a pizza
     *
     * @param filePath input filePath representing a pizza
     * @return The pizza
     * @throws IOException parsing fail
     */
    public static Pizza readPizza(String filePath) throws IOException {
        try (FileReader fileReader = new FileReader(filePath)) {
            BufferedReader br = new BufferedReader(fileReader);
            Pizza pizza = parseDescriptionLineForPizza(br.readLine());
            int row = 0;
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                for (int column = 0; column < fileLine.length(); column++) {
                    Character literal = fileLine.charAt(column);
                    IngredientEnum ingredient = getIngredientFromChar(literal);
                    pizza.setIngredient(row, column, ingredient);
                }
                row++;
            }
            return pizza;
        }
    }

    /**
     * Convert a character to ingredient
     * @param character
     * @return The ingredient
     */
    private static IngredientEnum getIngredientFromChar(Character character){
        switch (character) {
            case 'M':
                return IngredientEnum.MUSHROOM;
            case 'T':
                return IngredientEnum.TOMATO;
                default:
                    throw new RuntimeException("Invalid input file: '" + character + "' not recognized");
        }
    }

    /**
     * Create a pizza initiazlized with the size specified in the config line
     * @param line
     */
    private static Pizza parseDescriptionLineForPizza(String line){
        String[] slicedLine = line.split(" ");
        int nbRows = Integer.parseInt(slicedLine[0]);
        int nbCols = Integer.parseInt(slicedLine[1]);
        return new Pizza(nbRows, nbCols);
    }

    /**
     * Read subject parameters (h & l) from the subject file
     * filePath Path to the subject file
     *
     * @return
     */
    public static SubjectParameters readSubjectParameters(String filePath) throws IOException{
        try (FileReader fileReader = new FileReader(filePath)) {
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            String[] slicedLine = line.split(" ");
            int l = Integer.parseInt(slicedLine[2]);
            int h = Integer.parseInt(slicedLine[3]);
            return new SubjectParameters(l, h);
        }


    }

    /**
     * Write slices to file
     * @param pizza
     * @param fileName
     * @throws IOException
     */
    public static void writeSlices(Pizza pizza, String fileName) throws IOException {
        List<Slice> slices = pizza.getSlices();
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(slices.size());
            pizza.getSlices().forEach(s -> out.println(s.toString()));
        }
    }
}

