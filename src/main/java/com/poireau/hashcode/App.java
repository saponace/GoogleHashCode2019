package com.poireau.hashcode;

import com.poireau.hashcode.utils.IoUtils;
import com.poireau.hashcode.utils.Profiler;
import com.poireau.hashcode.utils.FilesPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;



public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        execute(FilesPaths.EXAMPLE_INPUT_FILE_PATH, FilesPaths.OUTPUT_DATA_SET_EXAMPLE_TXT);
    }

    /**
     * Execute the main algorithm
     *
     * @param inputFile
     * @param outputFile
     * @throws IOException cant parse the input file
     */
    public static void execute(String inputFile, String outputFile) throws IOException {
        Profiler profiler = new Profiler();
        String output = "Hello World !";
        IoUtils.writeToFile(outputFile, output);
        LOGGER.info("FINISHED for " + inputFile + "!!!!!");
        LOGGER.info(profiler.measure(inputFile + " execution time: "));
    }
}
