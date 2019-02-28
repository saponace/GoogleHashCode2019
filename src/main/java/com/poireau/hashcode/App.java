package com.poireau.hashcode;

import com.poireau.hashcode.entity.Photo;
import com.poireau.hashcode.entity.Presentation;
import com.poireau.hashcode.entity.Slide;
import com.poireau.hashcode.entity.SlideHorizontal;
import com.poireau.hashcode.entity.SlideVertical;
import com.poireau.hashcode.utils.IoUtils;
import com.poireau.hashcode.utils.Profiler;

import ch.qos.logback.core.joran.spi.NoAutoStart;

import com.poireau.hashcode.utils.FilesPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    public static void main(String[] args) throws IOException {
        execute(FilesPaths.D_INPUT_FILE_PATH, FilesPaths.D_OUTPUT_FILE_PATH);
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
        Algo algo = new Algo();
        List<Photo> photos = IoUtils.readPhotoList(inputFile);
        List<Photo> photosVerticales = photos.stream().filter(x -> x.getVertical()).collect(Collectors.toList());
        List<Photo> photosHorizontales = photos.stream().filter(x -> !x.getVertical()).collect(Collectors.toList());

        List<SlideVertical> slideVerticales = new VerticalPhotoSorting().sortPhotoByTag(photosVerticales, Utils.getTagsNbOccurences(photosVerticales));
        List<SlideHorizontal> slidesHorizontales = new HorizontalPhotoSorting().sortPhotoByTag(photosHorizontales, Utils.getTagsNbOccurences(photosHorizontales));
        
        List<Slide> slides = new ArrayList<>();
        slides.addAll(slideVerticales);
        slides.addAll(slidesHorizontales);

        Presentation presentation = new Presentation();
        presentation.addSlidesVertical(slidesHorizontales);
        presentation.addSlides(slideVerticales);
        // Commented out for performance reasons
        // Presentation presentation = algo.algoPresentation(slides);

        IoUtils.writePresentation(outputFile, presentation);

        LOGGER.info("FINISHED for " + inputFile + "!!!!!");
        LOGGER.info(profiler.measure(inputFile + " execution time: "));
    }
}
