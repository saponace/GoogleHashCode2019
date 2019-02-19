package com.poireau.hashcode.utils;


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
     * Parse
     *
     * @param file input file
     * @return
     * @throws IOException parsing fail
     */
    public static List<Object> parse(String file) throws IOException {
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fileReader);
            //skip a line with slice instructions
            br.readLine();
            List<Object> retVal = new ArrayList<>();
            int row = 0;
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                for (int column = 0; column < fileLine.length(); column++) {
                    Character literal = fileLine.charAt(column);
                    // TODO: 18/02/2019
                }
                row++;
            }
            return retVal;
        }
    }

    /**
     * Write content to file
     * @param fileName
     * @param outputDate
     * @throws IOException
     */
    public static void writeToFile(String fileName, String outputDate) throws IOException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(outputDate);
        }
    }

    /**
     * Read content from file
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String readFromFile(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        StringBuilder stringBuilder = new StringBuilder();
        lines.forEach(
                line -> stringBuilder.append(line).append("\n")
        );
        return stringBuilder.toString();
    }
}

