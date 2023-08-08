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
			if (songDAO.CreateSong(song)) {
				System.out.println( song.getSong_name() + " added Successfully");
				return true;
			} else {
				System.out.println( song.getSong_name() + " adding not Successful");
				return false;
			}
		} catch (DAOException | InvalidSongException e) {
			throw new ServiceException(e);
		}
	}
}
