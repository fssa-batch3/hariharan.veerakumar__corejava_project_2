package com.fssa.crazyfitness.model;

public class Song {
  private int songId;
  private String songName;
  private String songImage;
  private String songUrl;
  
public Song(int songId, String songName, String songImage, String songUrl) {
	super();
	this.songId = songId;
	this.songName = songName; 
	this.songImage = songImage;
	this.songUrl = songUrl;
}
public Song() {
	
}
public int getSongId() {
	return songId;
}
public void setSongId(int songId) {
	this.songId = songId;
}
public String getSongName() {
	return songName; 
}
public void setSongName(String songName) {
	this.songName = songName;
}
public String getSongImage() {
	return songImage;
}
public void setSongImage(String songImage) {
	this.songImage = songImage;
}
public String getSongUrl() {
	return songUrl;
}
public void setSongUrl(String songUrl) {
	this.songUrl = songUrl;
}
@Override
public String toString() {
	return "Song [song_id=" + songId + ", song_name=" + songName + ", song_image=" + songImage + ", song_url="
			+ songUrl + "]"; 
}


  
  
}
