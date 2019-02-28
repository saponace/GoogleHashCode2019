package com.poireau.hashcode;

import java.util.*;

import com.poireau.hashcode.comparator.OccurenceComparator;
import com.poireau.hashcode.entity.Photo;
import com.poireau.hashcode.entity.SlideVertical;

public class VerticalPhotoSorting {

	public List<SlideVertical> sortPhotoByTag(List<Photo> photos, Map<String, Integer> tagsOccurrence) {
		for (Photo photo : photos) {
			photo.computeOccurrences(tagsOccurrence);
		}
		
		photos.sort(new OccurenceComparator());
		
		List<SlideVertical> slideVerticalList = new ArrayList<>();
		Integer nbHalfPhotos = photos.size() / 2;
		for (int i = 0; i < nbHalfPhotos; i++) {
			Photo photoVertical1 = photos.get(i);
			Photo photoVertical2 = photos.get(i + nbHalfPhotos);
			SlideVertical slidevertical = new SlideVertical(photoVertical1, photoVertical2);
			slideVerticalList.add(slidevertical);
		}
		
		return slideVerticalList;
	}
	
}
