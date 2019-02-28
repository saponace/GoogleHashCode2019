package com.poireau.hashcode.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Photo {

	private Integer id;
	private List<String> tags;
	private Boolean vertical;
	private Integer tagOccurence;
	
	public Photo(Integer id, List<String> tags, Boolean vertical) {
		this.id = id;
		this.tags = tags;
		this.vertical = vertical;
	}
	
	public void calculateOccurrences(Map<String, Integer> tagsOccurence) {
		Integer score = 0;
		for (String tag : tags) {
			score += tagsOccurence.get(tag);
		}
		this.tagOccurence = score;
	}

	public Integer getId() {
		return id;
	}

	public List<String> getTags() {
		return tags;
	}

	public Boolean getVertical() {
		return vertical;
	}

	public Integer getTagOccurence() {
		return tagOccurence;
	}
}
