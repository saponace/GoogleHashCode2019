package com.poireau.hashcode;

import com.poireau.hashcode.entity.Photo;
import com.poireau.hashcode.entity.Presentation;
import com.poireau.hashcode.utils.IoUtils;
import com.poireau.hashcode.utils.Profiler;
import com.poireau.hashcode.utils.FilesPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;


public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        execute(FilesPaths.A_INPUT_FILE_PATH, FilesPaths.A_OUTPUT_FILE_PATH);
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
        List<Photo> photos = IoUtils.readPhotoList(inputFile);

        // TODO: 2/28/19 Call algorithm here
        Presentation presentation = new Presentation();

        IoUtils.writePresentation(outputFile, presentation);

        LOGGER.info("FINISHED for " + inputFile + "!!!!!");
        LOGGER.info(profiler.measure(inputFile + " execution time: "));
    }
}
