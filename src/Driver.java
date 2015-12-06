/**
 * Driver used to test program.
 * 
 * @author Cian Skelly
 */
public class Driver {

	public static void main(String[] args) {   
		
		Playlist list1 = new Playlist("Greatest list ever!");  // Tester playlist
	      
		  /////////////////////////////////////
		  //  Tracks to be added
		  /////////////////////////////////////
		
	      Track track1 = new Track("She Loves You", "The Beatles", 1964, 136);
	      Track track2 = new Track("A Hard Days Night", 1967, "The Beatles");
	      Track track3 = new Track("Hey You", "Pink Floyd", 1975, 278);
	      Track track4 = new Track("Heartbreaker", 1969, "Led Zeppelin", 388);
	      Track track5 = new Track("Ticket To Ride", 1967, "The Beatles");
	      Track track6 = new Track("Help", 1966, "The Beatles", 139);
	      Track track7 = new Track("Ramble On", "Led Zeppelin");
	      Track track8 = new Track("Comfortably Numb", 1967, "Pink Floyd", 464);
	      Track track9 = new Track("heartbreaker", "led ZEPPELIN");   //Added twice with different parameters
	      Track track10 = new Track("Paperback Writer", "The Beatles", 138);
	      Track track11 = new Track("Octupus's Garden", "The Beatles", 1969, 156);
	      Track track12 = new Track("Pigs on the Wing", 1977, "Pink Floyd");
	      Track track13 = new Track("Red House", 1975, "Jimi Hendrix", 238);
	      Track track14 = new Track("Chinatown", "Thin Lizzy", 1980, 198);  
	      Track track15 = new Track("Golden Slumbers", 1969, "The Beatles");
	      Track track16 = new Track("Help", 1966, "The Beatles", 139);  //Added twice with same parameters
	      Track track17 = new Track("Strange Brew", 1967, "Cream", 176);
	      Track track18 = new Track("The End", "The Doors", 703);
	      Track track19 = new Track("Jailbreak", 1979, "thin lizzy", 244);  
	      Track track20 = new Track("Rocks Off", "The Rolling Stones", 1967, 238);
	     
	      /////////////////////////////////////
	      //  Various functions
	      /////////////////////////////////////
	      
	      list1.add(track1);               
	      list1.add(track2);               
	      list1.add(track3);                
	      list1.add(track4);                
	      list1.add(track5);               
	      list1.add(track6);                
	      list1.add(track7);
	      list1.add(track8);
	      list1.add(track9);
	      list1.add(track10);     
	      list1.add(track11);               
	  //  list1.add(track12);               
	      list1.add(track13);                
	      list1.add(track14);                
	      list1.add(track15);               
	      list1.add(track16);                
	      list1.add(track17);
	      list1.add(track18);
	      list1.add(track19);
	      list1.add(track20);
	   
	      list1.playAll();
	      list1.playAll(true);
	      list1.playTrack(1967, true);
	      list1.playTrack(1967);
	      list1.playTrack("The Beatles", false);
	      list1.playTrack("The Beatles", true);
	      list1.playTrack("The Beatles");
	  
	      list1.remove(track6);            
	      list1.remove("strange brew", "cream");
	      list1.remove(track12);
	      list1.add(track12, 14);
	      list1.setName("60's and 70's Classics");
	      list1.moveTo("help", "the beatles", 4);
	      list1.moveTo(5, 13);
	      list1.moveTo(track18, 0);
	      
	      list1.showList(); 
	      list1.playNameOrder(true);
	      list1.playNameOrder(false);
	}

}
