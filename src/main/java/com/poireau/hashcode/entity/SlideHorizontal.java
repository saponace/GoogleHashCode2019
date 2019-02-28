package com.poireau.hashcode.entity;

public class SlideHorizontal implements Slide {

	private Photo photoHorizontale;
	
	public SlideHorizontal(Photo photoHorizontale) {
		this.photoHorizontale = photoHorizontale;
	}
	@Override
	public String toString() {
		return String.valueOf(photoHorizontale.getId());
	}
}
