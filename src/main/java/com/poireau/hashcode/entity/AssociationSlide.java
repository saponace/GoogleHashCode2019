package com.poireau.hashcode.entity;

import java.util.HashSet;
import java.util.Set;

public class AssociationSlide {

	private Slide leftSlide;
	private Slide rightSlide;
	private Integer score;
	
	public AssociationSlide(Slide leftSlide, Slide rightSlide) {
		this.leftSlide = leftSlide;
		this.rightSlide = rightSlide;
		this.score = calculateScore(leftSlide, rightSlide);
		
	}

	private Integer calculateScore(Slide leftSlide, Slide rightSlide) {
		Integer tagCommun = 0;
		Integer tagLeftOnly = 0;
		Integer tagRightOnly = 0;
		
		Set<String> tagsLeftSlide = leftSlide.getTags();
		Set<String> tagsRightSlide = rightSlide.getTags();
		
		Set<String> intersection = new HashSet<>(tagsLeftSlide);
		intersection.retainAll(tagsRightSlide);
		tagCommun = intersection.size();
		
		Set<String> onlyLeft = new HashSet<>(tagsLeftSlide);
		onlyLeft.removeAll(tagsRightSlide);
		tagLeftOnly = onlyLeft.size();
		
		Set<String> onlyRight = new HashSet<>(tagsRightSlide);
		onlyRight.retainAll(tagsLeftSlide);
		tagRightOnly = onlyRight.size();
		
		return Math.min(tagCommun, Math.min(tagLeftOnly, tagRightOnly));
	}

	public Slide getLeftSlide() {
		return leftSlide;
	}

	public Slide getRightSlide() {
		return rightSlide;
	}

	public Integer getScore() {
		return score;
	}
	
	
	
}
