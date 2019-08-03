package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_SNG")
public class Song {
	
	
	@Id
	@GeneratedValue
	private int sngno;
	
	@Column(name="SNG_TITLE")
	private String title;
	
	private double duration;
	private String singer;
	
	@ManyToOne
	@JoinColumn(name="ALBNO")
	private Album album;
	
	
	public int getId() {
		return sngno;
	}
	public void setId(int id) {
		this.sngno = sngno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}

}

