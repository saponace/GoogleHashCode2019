package com.poireau.hashcode.entity;

import java.util.*;

public class SlideVertical implements Slide {

	private Photo photoVertical1;
	private Photo photoVertical2;
	
	public SlideVertical(Photo photoVertical1, Photo photoVertical2) {
		this.photoVertical1 = photoVertical1;
		this.photoVertical2 = photoVertical2;
	}

	@Override
	public Set<String> getTags() {
		List<String> fullTag = new ArrayList<>();
		fullTag.addAll(photoVertical1.getTags());
		fullTag.addAll(photoVertical2.getTags());
		return new HashSet<>(fullTag);
	}
	
}
