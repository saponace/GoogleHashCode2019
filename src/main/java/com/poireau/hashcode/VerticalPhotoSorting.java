package com.poireau.hashcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.poireau.hashcode.comparator.OccurenceComparator;
import com.poireau.hashcode.entity.Photo;
import com.poireau.hashcode.entity.Slide;
import com.poireau.hashcode.entity.SlideVertical;

public class VerticalPhotoSorting {

	public List<SlideVertical> sortPhotoByTag(List<Photo> photosVerticales, HashMap<String, Integer> tagsOccurrence) {
		for (Photo photo : photosVerticales) {
			photo.calculateOccurrences(tagsOccurrence);
		}
		
		Collections.sort(photosVerticales, new OccurenceComparator());
		
		List<SlideVertical> slideVerticalList = new ArrayList<>();
		for (int i = 0; i < photosVerticales.size() / 2; i++) {
			Photo photoVertical1 = photosVerticales.get(i);
			Photo photoVertical2 = photosVerticales.get(i + photosVerticales.size());
			SlideVertical slidevertical = new SlideVertical(photoVertical1, photoVertical2);
			slideVerticalList.add(slidevertical);
		}
		
		return slideVerticalList;
	}
	
}
