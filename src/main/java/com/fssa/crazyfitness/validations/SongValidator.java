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
			throw new InvalidSongException("The Song details are  Invalid");
		}
	}

	public static boolean validateId(int id) throws InvalidSongException {
		if (id <= 0) {
			throw new InvalidSongException("Invalid song Id");
		}
		return true;
	}

	public static boolean validateSongName(String name) throws InvalidSongException {
		
		if (name == null || name.isEmpty()) {
			throw new InvalidSongException("Invalid song name");
			
		}
		String regex = "^[A-Za-z0-9\\s\\-_'&()]+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		boolean match = m.matches();
		if (match) {
			return true;
		} else {
			throw new InvalidSongException("Invalid song name");

		}
		
	}

	public static boolean validateSongImage(String image) throws InvalidSongException {
		if (image == null || image.isEmpty()) {
			throw new InvalidSongException("Invalid song image url");
		}
		return true;
	}

	public static boolean validateSongURL(String url) throws InvalidSongException {
		if (url == null || url.isEmpty()) {
		 throw new InvalidSongException("Invalid song url");
		}
		return true;
	}
}
