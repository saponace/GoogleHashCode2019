package com.poireau.hashcode.entity;

import java.util.ArrayList;
import java.util.List;

public class Presentation {

	private List<Slide> slides;
	
	public Presentation() {
	    slides = new ArrayList<>();
	}
	
	public void addSlide(Slide slide) {
		this.slides.add(slide);
	}

	public List<Slide> getSlides() {
		return slides;
	}

	public void addSlides(List<SlideVertical> slideVerticales) {
		this.slides.addAll(slideVerticales);
		
	}
	
	
	
}
