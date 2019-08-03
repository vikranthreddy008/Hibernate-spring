package com.lti.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ALB")
public class Album {
	@Id
	@GeneratedValue
	private int albno;
	
	@Column(name="ALB_NAME")
	private String name;
	
	private String copyright;
	private LocalDate releaseDate;
	
	@OneToMany(mappedBy="album" ) 
	private Set<Song> songs;

	public int getAlbno() {
		return albno;
	}

	public void setAlbno(int albno) {
		this.albno = albno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
}
