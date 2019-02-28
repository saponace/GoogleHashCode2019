package com.poireau.hashcode.utils;


import com.poireau.hashcode.entity.Photo;
import com.poireau.hashcode.entity.Presentation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
    public static List<Photo> readPhotoList(String file) throws IOException {
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fileReader);

            // Ignore first line
            br.readLine();

            List<Photo> retVal = new ArrayList<>();
            int i = 0;
            String line;
            while ((line = br.readLine()) != null) {
                List<String> lineData = Arrays.asList(line.split(" "));
                Character phtoOrientation = lineData.get(0).charAt(0);
                List<String> tags = lineData.subList(2, lineData.size());
                retVal.add(new Photo(i, tags, getPhotoOrientationBooleanFromChar(phtoOrientation)));
                i++;
            }
            return retVal;
        }
    }

    /**
     * Get the orientation boolean of a photo from its char form
     * @param c
     * @return
     */
    private static boolean getPhotoOrientationBooleanFromChar(Character c) {
        switch (c) {
            case 'H':
                return false;
            case 'V':
                return true;
            default:
                throw new RuntimeException("Orientation " + c + " not recognized");
        }
    }

    /**
     * Write content to file
     * @param fileName
     * @param presentation
     * @throws IOException
     */
    public static void writePresentation(String fileName, Presentation presentation) throws IOException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(presentation.getSlides().size());
            presentation.getSlides().forEach(s -> out.println(s.toString()));
        }
    }
}

