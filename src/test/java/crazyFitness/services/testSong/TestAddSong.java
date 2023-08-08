package crazyFitness.services.testSong;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import crazyFitness.services.SongService;
import crazyFitness.services.exceptions.ServiceException;
import crazyFitness.model.Song;

public class TestAddSong {

	
	@Test
	public void testCreateSongSuccessful() {
		SongService songService = new SongService();
		Song song = new Song(1,"ETHIR NEECHAL","../assets/images/MUSIC/ethir_neechal.jpg", "../assets/audio/Ethir-Neechal.mp3");
		try {
			assertTrue(songService.SongCreate(song));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}
	
}
