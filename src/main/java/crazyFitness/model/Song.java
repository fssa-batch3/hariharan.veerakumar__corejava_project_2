package crazyFitness.model;

public class Song {
  public int song_id;
  public String song_name;
  public String song_image;
  public String song_url;
  
public Song(int song_id, String song_name, String song_image, String song_url) {
	super();
	this.song_id = song_id;
	this.song_name = song_name;
	this.song_image = song_image;
	this.song_url = song_url;
}
public Song() {
	
}
public int getSong_id() {
	return song_id;
}
public void setSong_id(int song_id) {
	this.song_id = song_id;
}
public String getSong_name() {
	return song_name;
}
public void setSong_name(String song_name) {
	this.song_name = song_name;
}
public String getSong_image() {
	return song_image;
}
public void setSong_image(String song_image) {
	this.song_image = song_image;
}
public String getSong_url() {
	return song_url;
}
public void setSong_url(String song_url) {
	this.song_url = song_url;
}
@Override
public String toString() {
	return "Song [song_id=" + song_id + ", song_name=" + song_name + ", song_image=" + song_image + ", song_url="
			+ song_url + "]";
}


  
  
}
