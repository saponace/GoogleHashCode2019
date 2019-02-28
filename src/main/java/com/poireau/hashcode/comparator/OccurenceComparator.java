package com.poireau.hashcode.comparator;

import java.util.Comparator;

import com.poireau.hashcode.entity.Photo;

public class OccurenceComparator implements Comparator<Photo> {

	@Override
	public int compare(Photo photo1, Photo photo2) {
		return photo1.getTagOccurence().compareTo(photo2.getTagOccurence());
	}

}
