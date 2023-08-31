package com.fssa.crazyfitness.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import  com.fssa.crazyfitness.services.exceptions.ServiceException;
import  com.fssa.crazyfitness.model.Song;

class TestAddSong { 

	
	@Test
	 void testCreateSongSuccessful() {
		SongService songService = new SongService();
		Song song = new Song(1,"ETHIR NEECHAL","../assets/images/MUSIC/ethir_neechal.jpg", "../assets/audio/Ethir-Neechal.mp3");
		try {
			assertTrue(songService.SongCreate(song));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	@Test 
	void testCreateNullSong() {
		SongService songService = new SongService();
		Song song = null;
		try {
			assertFalse(songService.SongCreate(song));
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
