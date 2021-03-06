package com.poireau.hashcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poireau.hashcode.comparator.AssociationSlideComparator;
import com.poireau.hashcode.comparator.OccurenceComparator;
import com.poireau.hashcode.entity.AssociationSlide;
import com.poireau.hashcode.entity.Presentation;
import com.poireau.hashcode.entity.Slide;

public class Algo {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public Presentation algoPresentation(List<Slide> slides) {
        Presentation presentation = new Presentation();
        List<AssociationSlide> associationSlideList = new ArrayList<>();

        // Construction des paires de slides
        for (int i = 0; i < slides.size() / 2; i = i + 2) {
            AssociationSlide association = new AssociationSlide(slides.get(i), slides.get(i+1));
            associationSlideList.add(association);
        }

        // Trier la liste slidesPair selon le score DESC
		Collections.sort(associationSlideList, new AssociationSlideComparator());
        presentation.addSlide(associationSlideList.get(0).getLeftSlide());
        presentation.addSlide(associationSlideList.get(0).getRightSlide());
        deleteSlide(associationSlideList, associationSlideList.get(0).getLeftSlide());
		
        while(!associationSlideList.isEmpty()) {
        	Slide lastSlide = presentation.getSlides().get(presentation.getSlides().size()-1);
        	Slide slideToAdd = getNext(associationSlideList, lastSlide);
        	if (slideToAdd == null) {
        		return presentation;
        	}
        	presentation.addSlide(slideToAdd);
        	deleteSlide(associationSlideList, lastSlide);
        }
        
        return presentation;

    }

	private Slide getNext(List<AssociationSlide> associationSlideList, Slide slide) {
		for (Iterator<AssociationSlide> it = associationSlideList.iterator(); it.hasNext();) {
			AssociationSlide next = it.next();
			if (next.getLeftSlide() == slide) {
				return next.getRightSlide();
			}
		}
		return null;
	}
	
	private void deleteSlide(List<AssociationSlide> associationSlideList, Slide slideToRemove) {
		for (Iterator<AssociationSlide> itRemove = associationSlideList.iterator(); itRemove.hasNext();) {
			AssociationSlide next = itRemove.next();
			if (next.getLeftSlide() == slideToRemove || next.getRightSlide() == slideToRemove) {
				itRemove.remove();
			}
		}
	}
}
