package crazyFitness.services;

import crazyFitness.model.Song;
import crazyFitness.dao.SongDAO;
import crazyFitness.dao.exceptions.DAOException;
import crazyFitness.services.exceptions.ServiceException;
import crazyFitness.validation.SongValidator;
import crazyFitness.validation.exceptions.InvalidSongException;

public class SongService {
	public boolean SongCreate(Song song) throws ServiceException {
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
