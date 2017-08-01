package com.waracle.cakemgr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cake implements Serializable {

	private static final long serialVersionUID = -1798070786993154676L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "title", unique = true, nullable = false, length = 100)
	private String title;

	@Column(name = "description", unique = false, nullable = false, length = 100)
	private String description;

	@Column(name = "image", unique = false, nullable = false, length = 300)
	private String image;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}