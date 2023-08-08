package crazyFitness.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import crazyFitness.model.Song;
import crazyFitness.validation.exceptions.InvalidSongException;

public class SongValidator {

	
	public static boolean validateSong(Song song) throws InvalidSongException{
		if(song != null && validateId(song.getSong_id()) && validateSongName(song.getSong_name()) && validateSongImage(song.getSong_image()) && validateSongURL(song.getSong_url())) {
			return true;
		}
		else { 
			throw new InvalidSongException("The Song details are  Invalid");
		}
	}
	
	
	public static boolean validateId(int id) {
		boolean match = true;
		if(id <= 0) {
			System.out.println("The ID is Invalid");
			return false;
		}
		System.out.println("The ID is valid");
		return match;
	}
	
	
	public static boolean validateSongName(String name) {
		boolean match = true;
		if(name == null || name.isEmpty()) {
			System.out.println("The song name looks null or empty, please give valid ones");
			return false;
		}
		String regex = "^[A-Za-z0-9\\s\\-_'&()]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		match = m.matches();
		if (match) {
			System.out.println("The Song name is Valid");
		
		} else {
          System.out.println("The Song name is Invalid");
       
		}
		return match;
	}
	
	public static boolean validateSongImage(String image) {
		if(image == null || image.isEmpty()) {
			System.out.println("The Image URL looks null or empty, please give valid");
			return false;
		}
		return true;
	}

	
	public static boolean validateSongURL(String url) {
		if(url == null || url.isEmpty()) {
			System.out.println("The Song URL looks null or empty, please give valid");
			return false;
		}
		return true;
	}
}
