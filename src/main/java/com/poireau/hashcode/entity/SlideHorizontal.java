package com.poireau.hashcode.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SlideHorizontal implements Slide {

	private Photo photoHorizontale;
	
	public SlideHorizontal(Photo photoHorizontale) {
		this.photoHorizontale = photoHorizontale;
	}

	@Override
	public Set<String> getTags() {
		return new HashSet<>(this.photoHorizontale.getTags());
	}
	
}
