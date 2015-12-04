import java.util.Arrays;
import java.util.Collections;

/**
 * Represents a playlist of tracks. Maximum 100 tracks
 * 
 * @author xianskel
 */

public class Playlist {

	////////////////////////////////////////
	// Instance Variables
	////////////////////////////////////////
	
	private Track[] playlist;     // New track array to hold playlist
	private String listName;      // Name of playlist
	
	////////////////////////////////////////
	// Constructors
	////////////////////////////////////////
	
	/**
	 * Constructs a new playlist with starting length 0 and default name.
	 * 
	 */
	public Playlist(){
		this.playlist = new Track[0];    
		this.listName = "Untitled Playlist";        
	}
	
	/**
	 * Constructs a new playlist with starting length 0 and a custom name.
	 * 
	 * @param listName is playlist name
	 */
	public Playlist(String listName){
		this.playlist = new Track[0];    
		this.listName = listName;        
	}
	
	////////////////////////////////////////
	// Public Methods
	////////////////////////////////////////
	
	/**
	 * Gets the name of the playlist.
	 * 
	 * @return the playlist name
	 */
	public String getName(){
		return this.listName;
	}
	
	/**
	 * Sets the name of the playlist.
	 * 
	 * @param listName is new playlist name
	 */
	public void setName(String listName){
		this.listName = listName;
	}
	
	/**
	 * Adds a new track into playlist.
	 * Ensures it's not in list first.
	 * Increases array size to accommodate new track.
	 * New track is added to the end of list.
	 * Sets maximum length of list to 100 tracks.
	 * 
	 * @param t is track to be added
	 */
	public void add(Track t){
		if(this.playlist.length>=100){
			System.out.println("\""+t.getName()+"\""+" cannot be added. Playlist is full.");
		}
		else if(indexOf(t)!=-1){
   			System.out.println("\""+t.getName()+"\""+" cannot be added. Track is already in playlist.");
			}
		else{
			this.playlist = Arrays.copyOf(this.playlist, this.playlist.length + 1);
		    this.playlist[this.playlist.length-1] = t;			  
			}
		
	}
	
	/**
	 * Adds a new track to playlist at specified position.
	 * Duplicates are not allowed.
	 * Increases array size to accommodate track.
	 * 
	 * @param t is track to be added
	 * @param pos is position to place track 
	 */
	public void add(Track t, int pos){
		add(t);
		moveTo(t, pos);
	}
	
	/**
	 * Removes a selected track from playlist.
	 * Checks whether track is in list.
	 * Decreases size of array when track is removed.
	 * 
	 * @param t is track to be removed
	 */
	public void remove(Track t){

		if(this.playlist.length==0){
			System.out.println("\""+t.getName()+"\""+" could not be removed. Playlist is empty");
		}
		else if(indexOf(t)==-1){
		    	System.out.println("\""+t.getName()+"\""+" cannot be removed. Track not in playlist");
		}
		else{
			for(int i=indexOf(t); i<this.playlist.length-1; i++){
					this.playlist[i] = this.playlist[i+1];	
				}
			this.playlist = Arrays.copyOf(this.playlist, this.playlist.length-1);
			System.out.println("Track Removed: " + t.toString());
			}
		}
	
	/**
	 * Allows users to remove track by entering track name and artist
	 * Letter casing is irrelevant.
	 * Checks whether track is in the list
	 * Decreases playlist size when removed
	 * 
	 * @param name of the track
	 * @param artist who recorded track
	 */
	public void remove(String name, String artist){
		Track temp = new Track(name, artist);
		remove(temp);
	}
	
	/**
	 * Moves a track to a new position in the playlist
	 * Shifts other tracks up or down to accommodate the move.
	 * Refers to track's number in playlist, not array position.
	 * Starts at position 1, not 0..
	 * 
	 * @param pos is position of track to be moved.
	 * @param newPos is position to move track to
	 */
	public void moveTo(int pos, int newPos){
		if(pos<=this.playlist.length && newPos<=this.playlist.length){
			if(pos>0 && newPos>0){
				 Track temp = this.playlist[pos-1];
			     if(pos>newPos){
					 for(int i=pos-1; i>newPos-1; i--){
					    this.playlist[i] = this.playlist[i-1];
			   	     }
			     }
		   	     if(pos<newPos){
				     for(int i=pos-1; i<newPos-1; i++){
					    this.playlist[i] = this.playlist[i+1];
				     }
				 }
			    this.playlist[newPos-1] = temp;
		    }
			else System.out.println("Cannot move track. \""+Math.min(pos, newPos)+"\" is not a valid track number");
	    }
	    else System.out.println("Cannot move track. \""+Math.max(pos, newPos)+"\" is not a valid track number");
	}
	
	/**
	 * Moves a track to a new position.
	 * Shifts other tracks up or down to accommodate the move.
	 * Refers to tracks number in playlist, not array position.
	 * No position 0.
	 * 
	 * @param t is track to be moved
	 * @param newNum is new position of track
	 */
	public void moveTo(Track t, int newNum){
		if(indexOf(t)!=-1){
			moveTo(indexOf(t)+1, newNum);
		}
		else
			System.out.println("\"" + t.getName() + "\""  + " cannot be moved. Track not in playlist");
	}
	
	/**
	 * Moves a track to a new position in playlist.
	 * Shifts other tracks up or down to accommodate the move.
	 * Allows user to enter name and artist of track.
	 * Letter casing is irrelevant.
	 * 
	 * @param name
	 * @param artist
	 * @param newNum
	 */
	public void moveTo(String name, String artist, int newNum){
		Track temp = new Track(name, artist);
		moveTo(temp, newNum);
	}
	
	/**
	 * Plays all tracks in playlist.
	 * Plays in original order if boolean random is false.
	 * Plays in random order if boolean random is true.
	 * Plays by displaying to screen.
	 * 
	 * @param random order if true
	 */
	public void playAll(boolean random){
		if(!random){
			showList();
		}
		else{
			shuffle().showList();
		}
	}
	
	/**
	 * Plays all tracks if boolean is not entered.
	 * Plays in original order
	 * Plays by displaying to screen
	 * 
	 */
	public void playAll(){
		playAll(false);
	}
	
	/**
	 * Plays tracks in Alphabetical order.
	 * Orders by track name.
	 * If track names are the same it orders by artist name.
	 * If boolean is true it plays in ascending order.
	 * If boolean is false it plays in descending order.
	 * Plays by displaying on screen
	 * 
	 * @param asc plays in ascending order if true and descending if false
	 */
	public void playNameOrder(boolean asc){
		Playlist alphaList = new Playlist(getName()+" -Ordered by Name");
		alphaList.playlist = Arrays.copyOf(this.playlist, this.playlist.length);
		
        if(asc){
    		Arrays.sort(alphaList.playlist);
		}
        else{
        	Arrays.sort(alphaList.playlist, Collections.reverseOrder());
			alphaList.setName(alphaList.getName()+" Descending");
        }
	    alphaList.showList();
	}
	
	/**
	 * Plays all tracks in alphabetical order if boolean is not entered.
	 * Plays in ascending order
	 * Plays by displaying to screen
	 * 
	 */
	public void playNameOrder(){
		playNameOrder(true);
	}
	
	/**
	 * Plays tracks by a particular artist.
	 * Plays in random order if boolean random is true.
	 * Plays by displaying on screen.
	 * 
	 * @param artist to be played
	 * @param random order if true
	 */
	public void playTrack(String artist, boolean random){
			Playlist artistList = new Playlist("Songs by "+artist+" in "+ getName());
			for(Track a:this.playlist){
				if(artist.equalsIgnoreCase(a.getArtist())){
					artistList.add(a);
				}
			}
		if(artistList.playlist.length==0){
			System.out.println("There are no tracks by \"" + artist + "\" in the playlist");
		}
		else if(!random){
			artistList.showList();
		}
		else{
			artistList.shuffle().showList();
		}
	}
	
	/**
	 * Plays tracks by artist if random boolean parameter is not entered.
	 * Plays in normal sequence.
	 * Plays by displaying to screen.
	 * 
	 */
	public void playTrack(String artist){
		playTrack(artist, false);
	}
	
	/**
	 * Plays tracks from a given year.
	 * Plays in random order if boolean random is true.
	 * Plays by displaying on screen.
	 * 
	 * @param year of tracks to be played
	 * @param random order if random is true
	 */
	public void playTrack(int year, boolean random){
		Playlist yearList = new Playlist("Songs from "+year+" in "+ getName());
		for(Track a:this.playlist){
			if(year==(a.getYear())){
				yearList.add(a);
			}
		}	
        if(yearList.playlist.length==0){
			System.out.println("There are no tracks from " + year + " in the playlist");
        }
        else if(!random){
        yearList.showList();
        }
		else{
	    yearList.shuffle().showList();
		}
	}
	
	/**
	 * Plays tracks from year even if random boolean parameter is not entered.
	 * Plays in normal sequence if boolean is not selected.
	 * Plays by displaying to screen.
	 * 
	 */
	public void playTrack(int year){
		playTrack(year, false);
	}
	
	/**
	 * Prints a Track[] out to the screen.
	 * Shows the songs number in the playlist.
	 * Each track is printed on separate line.
	 * Playlist name, total duration and number of tracks in array are shown at the top.
	 * 
	 */
	public void showList(){
		System.out.println("Playlist: " + listName);
		System.out.println("Duration: " + totalDuration());
		System.out.println("Track Count: " + this.playlist.length);
		for(int i=0; i<this.playlist.length; i++){
			System.out.println(i+1 + ": " + this.playlist[i].toString());
	    }
	}

	////////////////////////////////////////////
	// Private Methods
	////////////////////////////////////////////
	
	/**
	 * Shuffles a playlist into a random order.
	 * 
	 * @param playlist to be shuffled
	 * @return the shuffled playlist
	 */
	private Playlist shuffle(){ 
		Playlist randList = new Playlist(getName()+" -Shuffled");
		randList.playlist = Arrays.copyOf(this.playlist, this.playlist.length);
		for(int i=0; i<randList.playlist.length; i++){
		    int rand = (int) (Math.random()*randList.playlist.length);
	    	Track temp = randList.playlist[i];
	    	randList.playlist[i] = randList.playlist[rand];
		    randList.playlist[rand] = temp;
	    }
	    return randList;
	}
	
	/**
	 * Finds the position of a track in the playlist array.
	 * Compares name and artist of track.
	 * Letter casing is irrelevant.
	 * Returns -1 if track is not in array.
	 * 
	 * @param t is track to indexed
	 * @return is the position of track in array
	 */
	private int indexOf(Track t){
		for(int i=0; i<this.playlist.length; i++){
			if(this.playlist[i].equalsIgnoreCase(t)){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Calculates the total playing time of the playlist.
	 * Returns time in proper two digit format.
	 * Cannot account for tracks without duration information.
	 * 
	 * @return total time of playlist as String
	 */
	private String totalDuration(){
		int sum =0;
		for(Track a:this.playlist){
			sum += a.getDuration();
		}
		return Track.formDuration(sum);
	}
}
