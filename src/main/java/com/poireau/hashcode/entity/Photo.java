package com.poireau.hashcode.entity;

import java.util.List;

public class Photo {

	private Integer id;
	private List<String> tags;
	private Boolean vertical;
	
	public Photo(Integer id, List<String> tags, Boolean vertical) {
		this.id = id;
		this.tags = tags;
		this.vertical = vertical;
	}
}
