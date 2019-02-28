package com.poireau.hashcode;

import java.util.*;

import com.poireau.hashcode.comparator.OccurenceComparator;
import com.poireau.hashcode.entity.Photo;
import com.poireau.hashcode.entity.SlideHorizontal;
import com.poireau.hashcode.entity.SlideVertical;

public class VerticalPhotoSorting {

	public List<SlideHorizontal> sortPhotoByTag(List<Photo> photos, Map<String, Integer> tagsOccurrence) {
		for (Photo photo : photos) {
			photo.computeOccurrences(tagsOccurrence);
		}
		
		photos.sort(new OccurenceComparator());
				
		return slideVerticalList;
	}
	
}
