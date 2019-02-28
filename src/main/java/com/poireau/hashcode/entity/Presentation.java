package com.poireau.hashcode.entity;

import java.util.List;

public class Presentation {

	private List<Slide> slides;
	
	public Presentation() {
		// par defaut
	}
	
	public void addSlide(Slide slide) {
		this.slides.add(slide);
	}

	public List<Slide> getSlides() {
		return slides;
	}
	
	
	
}
