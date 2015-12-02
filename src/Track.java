/**
 * Represents an individual track
 * 
 * @author xianskel
 */
public class Track implements Comparable<Track>{
	
	////////////////////////////////////////
	// Instance Variables
	////////////////////////////////////////

	private String name;     // name of the track as a string
	private String artist;   // name of artist as a string
	private int year;        // year of track release as an integer
	private int duration;    // Duration of track as an integer in seconds
	
	///////////////////////////////////////
	// Constructors
	///////////////////////////////////////
	
	/**
	 * Constructs a track object with combination of variables. 
	 * Year and duration are optional parameters
	 * 
	 * @param name      the name of song
	 * @param artist    the track artist
	 * @param year      the year of release
	 * @param duration  the length of track
	 */
	
	public Track(String name, String artist){
		this.name = name;
		this.artist = artist;
		this.year = 0;
		this.duration = 0;
	}
	
	public Track(String name, int year, String artist){
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.duration = 0;
	}
	
	public Track(String name, String artist, int duration){
		this.name = name;
		this.artist = artist;
		this.duration = duration;
		this.year = 0;
	}
	
	public Track(String name, int year, String artist, int duration){
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.duration = duration;
	}
	
	public Track(String name, String artist, int year, int duration){
		this.name = name;
		this.artist = artist;
		this.year = year;
		this.duration = duration;
	}
	
	///////////////////////////////////////
	// Public Methods
	///////////////////////////////////////
	
	/**
	 * Returns the name of the track
	 * 
	 * @return the track name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Sets the name of a the track
	 * 
	 * @param name of track
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Returns the name of the track's artist
	 * 
	 * @return artist name
	 */
	public String getArtist(){
		return this.artist;
	}
	
	/**
	 * Sets the name of the track's artist
	 * 
	 * @param artist name
	 */
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	/**
	 * Returns the year that the track was released
	 * 
	 * @return track year
	 */
	public int getYear(){
		return this.year;
	}
	
	/**
	 * Sets the year in which the track was released
	 * 
	 * @param year of track
	 */
	public void setYear(int year){
		this.year = year;
	}
	
	/**
	 * Returns the duration of the track in seconds
	 * 
	 * @return track duration
	 */
	public int getDuration(){
		return this.duration;
	}
	
	/**
	 * Sets the duration of the track
	 * 
	 * @param durationof track
	 */
	public void setDuration(int duration){
		this.duration = duration;
	}
	
	/**
	 * Calculates the number of seconds, minute and hours in duration
	 * Returns the time in proper two digit format
	 * Assumes all songs and playlists are longer than a second and shorter than 24hrs
	 * 
	 * @param duration in seconds
	 * @return duration in new format
	 */
	public static String formDuration(int duration){
		int s = duration%60;
		int m = duration%(60*60)/60;
		int h = duration/(60*60);
		if(h==0){
			return twoDigits(m) + ":" + twoDigits(s);
		}
		return twoDigits(h) + ":" + twoDigits(m) + ":" + twoDigits(s);
	}
	
	/**
	 * Returns all elements of a track formatted as a string
	 * Only returns elements which were entered
	 */
	public String toString(){
		if(this.year==0 && this.duration==0){
			return(this.name + " - " + this.artist);
		}
		if(this.year==0){
			return(this.name + " - " + this.artist  + " - " + formDuration(this.duration));
		}
		if(this.duration==0){
			return(this.name + " - " + this.artist + " - " + Integer.toString(this.year));
		}
		return(this.name + " - " + this.artist + " - " + Integer.toString(this.year)  + " - " + formDuration(this.duration));
	}
	
	/**
	 * Compares two tracks to see if they are the same
	 * Only checks mandatory fields (name & artist)
	 * Letter casing is irrelevant
	 * 
	 * @param other track to compare to
	 * @return true if the same
	 */
	public boolean equalsIgnoreCase(Track other){
		return(this.name.equalsIgnoreCase(other.name) && this.artist.equalsIgnoreCase(other.artist));
	}
	
	/**
	 * Compare two tracks lexicographically.
	 * First compares track name, then compares artist name.
	 * Does not compare any optional parameters ie.year and duration.
	 * Returns an negative integer if object Track lexicographically precedes argument Track.
	 * Returns a positive integer if object Track follows argument Track.
	 * Returns 0 if Tracks are the same.
	 * 
	 * @param other is the Track to be compared
	 * @return Integer equal to zero, less than zero or greater than zero.
	 */
	public int compareTo(Track other){
	int nNum = this.name.compareTo(other.name);
	int aNum = this.artist.compareTo(other.artist);
				
	if(nNum==0){
		if(aNum!=0){   
	    return aNum;
	   }
	 }	
	return nNum;
	}
	
	/////////////////////////////////////
	// Private Methods
	/////////////////////////////////////

	/**
	 * Converts integer into a string with two digits
	 * for use in formatted time
	 * 
	 * @param num of seconds/minutes/hours
	 * @return num in two digit format
	 */
	private static String twoDigits(int num){
		if(num==0){
			return "00";
		}
		if(num/10==0){
			return "0" + num;
		}
		return String.valueOf(num);
	}
	
}