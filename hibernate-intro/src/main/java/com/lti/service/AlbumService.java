package com.lti.service;

import com.lti.dao.GenericDao;
import com.lti.entity.Album;
import com.lti.entity.Song;

public class AlbumService {

	public void createAlbum(Album alb ) {
		GenericDao dao=new GenericDao();
		dao.save(alb);
	}
    
	public void addSong(Song sng, int albno ){
		GenericDao dao=new GenericDao();
		Album alb=dao.fetchById(Album.class, albno );
		sng.setAlbum(alb);
		dao.save(sng);
		
	}

}


