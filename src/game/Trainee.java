/*
 * Step 4: create a trainee constructor that can pass super and which room hes in
 * a) 3 parameters 
 */
package game;

import fixtures.Fixture;
import fixtures.Room;

public class Trainee extends Fixture {
	
	private Room room;
	
	// construct method that inherits from super and assigns 
	// room value to go with player
	public Trainee(String aName, String aDescript, Room aRoom) {
		super(aName, aDescript); // init super class
		this.room = aRoom;
	}
	
// get / set methods 
public Room getRoom() {
	return this.room;
	}
public void setRoom(Room aRoom) {
	this.room = aRoom;
	}


}
