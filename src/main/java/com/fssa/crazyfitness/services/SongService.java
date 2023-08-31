package com.fssa.crazyfitness.services;

import com.fssa.crazyfitness.model.Song;
import com.fssa.crazyfitness.dao.SongDAO;
import com.fssa.crazyfitness.dao.exceptions.DAOException;
import com.fssa.crazyfitness.services.exceptions.ServiceException;
import com.fssa.crazyfitness.validations.SongValidator;
import com.fssa.crazyfitness.validations.exceptions.InvalidSongException;

public class SongService {
	public boolean songCreate(Song song) throws ServiceException {
		SongDAO songDAO = new SongDAO();
		try {
			SongValidator.validateSong(song); 
			if (songDAO.createSong(song)) {
				System.out.println( song.getSongName() + " added Successfully");
				return true;
			} else {
				System.out.println( song.getSongName() + " adding not Successful");
				return false;
			}
		} catch (DAOException | InvalidSongException e) {
			throw new ServiceException(e);
		}
	} 
}
