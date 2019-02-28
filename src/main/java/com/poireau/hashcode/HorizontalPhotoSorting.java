package com.poireau.hashcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.poireau.hashcode.comparator.OccurenceComparator;
import com.poireau.hashcode.entity.Photo;
import com.poireau.hashcode.entity.SlideHorizontal;

public class HorizontalPhotoSorting {

	public List<SlideHorizontal> sortPhotoByTag(List<Photo> photos, Map<String, Integer> tagsOccurrence) {
		for (Photo photo : photos) {
			photo.computeOccurrences(tagsOccurrence);
		}
		
		photos.sort(new OccurenceComparator());
		
		List<SlideHorizontal> slideHorizontalList = new ArrayList<>();
		Integer nbPhotos = photos.size();
		for (int i = 0; i < nbPhotos; i++) {
			Photo photoVertical1 = photos.get(nbPhotos);
			SlideHorizontal slidevertical = new SlideHorizontal(photoVertical1 );
			slideHorizontalList.add(slidevertical);
		}
		
		return slideHorizontalList;
	}
	
}
