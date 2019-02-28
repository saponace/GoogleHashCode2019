package com.poireau.hashcode.comparator;

import java.util.Comparator;

import com.poireau.hashcode.entity.AssociationSlide;

public class AssociationSlideComparator implements Comparator<AssociationSlide> {

	@Override
	public int compare(AssociationSlide association1, AssociationSlide association2) {
		return association1.getScore().compareTo(association2.getScore());
	}

}
