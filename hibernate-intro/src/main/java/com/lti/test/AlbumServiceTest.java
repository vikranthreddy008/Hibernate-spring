package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Song;
import com.lti.entity.User;
import com.lti.service.AlbumService;

public class AlbumServiceTest {
	
	@Test
	
	public void addAlbum() {
		
		AlbumService service=new AlbumService();
		Album alb=new Album();
		alb.setName("Jalsa");
		alb.setCopyright("Mango Media");
		alb.setReleaseDate(LocalDate.of(2018, 10, 30));
		
		service.createAlbum(alb);
		
	}
	
	@Test
	
	public void addSongs() {
		AlbumService service=new AlbumService();
	
		Song sng=new Song();
		sng.setTitle("echota");
		sng.setDuration(180);
		sng.setSinger("satya");
		
		service.addSong( sng,270);
		
		
	}
	
	
	
	
	
	
	
	

}
