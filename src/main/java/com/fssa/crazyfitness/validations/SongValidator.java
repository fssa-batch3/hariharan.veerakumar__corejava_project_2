package com.fssa.crazyfitness.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.crazyfitness.model.Song;
import com.fssa.crazyfitness.validations.exceptions.InvalidSongException;

public class SongValidator {

	public static boolean validateSong(Song song) throws InvalidSongException {
		if (song != null && validateId(song.getSongId()) && validateSongName(song.getSongName())
				&& validateSongImage(song.getSongImage()) && validateSongURL(song.getSongUrl())) {
			return true;
		} else {
			throw new InvalidSongException("The Song details are Invalid");
		}
	} 

	public static boolean validateId(int id) throws InvalidSongException {
		if (id <= 0) {
			throw new InvalidSongException("Song Id should not be in negative values and 0");

		}
		return true;
	}

	public static boolean validateSongName(String name) throws InvalidSongException {
		
		if (name == null ) 
			throw new InvalidSongException("Song name should not be null");
			
			if (name.isEmpty()) 
				throw new InvalidSongException("Song name should not be empty");
			
		
		String regex = "^[A-Za-z0-9\\s\\-_'&()]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		boolean match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidSongException("Song name can contain combine alphabetic characters and numeric characters and spaces");

		}
		
	}

	public static boolean validateSongImage(String image) throws InvalidSongException {
		if (image == null ) 
			throw new InvalidSongException("Song image url should not be null");
		if ( image.trim().isEmpty()) {
			throw new InvalidSongException("Song image url shouldnot be empty");
		}
		return true;
	}

	public static boolean validateSongURL(String url) throws InvalidSongException {
		if (url == null) 
		 throw new InvalidSongException("Song url should not be null");
		if (url.trim().isEmpty()) {
			 throw new InvalidSongException("Song url should not be empty");

		}
		return true;
	}
}
