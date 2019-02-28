package com.poireau.hashcode.entity;

public class SlideVertical implements Slide {

	private Photo photoVertical1;
	private Photo photoVertical2;
	
	public SlideVertical(Photo photoVertical1, Photo photoVertical2) {
		this.photoVertical1 = photoVertical1;
		this.photoVertical2 = photoVertical2;
	}

	@Override
	public String toString() {
		return photoVertical1.getId() + " " + photoVertical2.getId();
	}
}
