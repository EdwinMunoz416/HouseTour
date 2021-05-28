package game;

import java.util.*;

import fixtures.Room;
import move.Direction;

public class Game {
	
	/*
	 * 1: create a map, need to put rooms in ArrayList
	 */
	
	// limit list to room objs only 
	private ArrayList <Room>map; 
	private Trainee player; 	
	
	// we make commands/objects lists that are parced l8r here
	//  atm 'n s w e' are saved as individual strings in a list
	List<String> commands = new ArrayList<>(Arrays.asList("n","s","w","e"));
	// we create a list string of 'objects' to interact with
	//List<String> objects = new ArrayList<>(Arrays.asList("key"));
	
// game will start and stop in here	
public Game() {
	
	
	// CREATE map in new generic ArrayList that only takes room objects
	this.map = new ArrayList<Room>(); 
	
	/*
	 * --make a map of generic list of Rooms--
	 *
	 * We can begin to ADD rooms, INDEX assigned when created
	 * new rooms have TITLE, SHORT D, int n, int s, int w, int e
	 * how to point ? - number represent the exits... assign it to the room INDEX you wish to navigate to
	 */
	

	// 0 
	map.add(new Room("Outside", "A misty moring on the mountains of Japan", 1 , Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
	// 1
	map.add(new Room("Garage", "The garage is dark and cold", Direction.NOEXIT, 0, Direction.NOEXIT, 2));
	// 2
	map.add(new Room("Storage", "Look at all the car parts!", Direction.NOEXIT, 3, 1, Direction.NOEXIT));
	// 3
	map.add(new Room("Shop", "Tig ... Mig... Stick ... Awesome in house machines", 2, Direction.NOEXIT, Direction.NOEXIT, Direction.NOEXIT));
	
	// create an object player from Trainee class and place in room 0 (ie the Room at index 0 of map is the start)
	player = new Trainee("Newbie", "A lost soul in the drifting mountains.", map.get(0));


	}

//---access methods for map---
// map
ArrayList<Room> getMap() {
	return map;
}

//-- map methods -- 
// set no return .. set to ...
void setMap(ArrayList<Room> aMap) {
	map = aMap;
}

// --access method for player

//get playuer
public Trainee getPlayer() {
	return player;
}
//-- player method -- 
//set player
public void setPlayer(Trainee aPlayer) {
	player = aPlayer;
}

/*
 * 2: move your player thru the rooms
 */

// set new obj p in tranversed aRoom
void movePlayerTo(Trainee p, Room aRoom) {
	p.setRoom(aRoom);
}

// return : constant rep the room number moved to... can be called to move any object as well
int moveTo(Trainee aTrainee, Direction dir) {
	
	Room r = aTrainee.getRoom();
	int exit;
	
	switch (dir) {
		// checks for exits in every direction, says no exit if no exit is found
		case NORTH:
			exit = r.getN(); // gets const for aN for exits in N direction
			break;
		case SOUTH:
			exit = r.getS();
			break;
		case WEST:
			exit = r.getW();
			break;
		case EAST:
			exit = r.getE();
			break;
			// if no exits reads to console NO EXIT!
		default:
			exit = Direction.NOEXIT;
			break;
	}
	if (exit != Direction.NOEXIT) {
		// moves aTrainee to room with same exit dir
		movePlayerTo(aTrainee, map.get(exit));
	}
	return exit;
}	

// pass dir cnst to player using NORTH SOUTH EAST WEST
public int movePlayerTo(Direction dir) {
	// get
	// return : a const that represents the room NUMBER moved to... or NOEXIT
	return moveTo(player, dir); // calls moveTo method to move
}

// allows passage thru exit if exit matches same direction CALL
private void goN() {
	updateOutput(movePlayerTo(Direction.NORTH));
}
private void goS() {
	updateOutput(movePlayerTo(Direction.SOUTH));
}
private void goW() {
	updateOutput(movePlayerTo(Direction.WEST));
}
private void goE() {
	updateOutput(movePlayerTo(Direction.EAST));
}

//updates room player is in, controller
void updateOutput(int roomNumber) {
	// if roomNumber = NOEXIT, display a special messgae, otherwise 
	// display text (eg name and description of room)
	String s;
	if (roomNumber == Direction.NOEXIT) {
		s = "NO EXIT!";
	} else {
		Room r = getPlayer().getRoom();
		s = "You are in " + r.getName() + ". " + r.getDescript();
	}
	System.out.println(s);
}

	
// move player in x dir
public String Action(List<String> wl) {
		String action;
		String msg = "";
		//index to 1st item..only 1 word in list anyways 
		action = wl.get(0);
		if (!commands.contains(action)) {
			msg = action + " is not a reconized action.";
		} else {
			// switch calls appropriate method to move player in specified direction
			switch (action) {
			case "n":
				goN();
				break;
			case "s":
				goS();
				break;
			case "w":
				goW();
				break;
			case "e":
				goE();
				break;
			default:
				msg = action + " (NOT YET IMPLEMENTED)";
				break;
		}
	}
	return msg;
}
//get command 
public String ParseCommand(List<String> wl) {
		// when size of 1 string is found place in word list
		String msg;
		if(wl.size() == 1) {
			msg = Action(wl);
		} 
		
		else {
			msg = "Only 1 character commands plz.";
		}
		return msg;
	}



public void showIntro() {
	String s;
	
	s = "***Welcome to Drift MonKEY Garage Newbie!!***"
			+ "\n---------------------------------------------"
			+ "\nHello" + " " + player.getName() 
			+ ", "
			+ player.getDescript()
			+ "\nIts your 1st Day! I hope you have the shop keys... "
			+ "\nTime to get to work!"
			+ "\n.\n.\n.\n"
			+ "\n*You forgot the shop keys!!*\n.\n."
			+ "\nYou see the garage door rattling on the West side of building,"
			+ "\nAs well as a tiny open window on the North Entrance"
			+ "\n REMEMBER TO CHECK IN YOUR TOOLBOX FOR A SPARE KEY"
			+ "\n----------------------------------------------"
			+ "\n*FIND A WAY IN TO AVOID GETTING FIRED*"
			+ "\n\n[use NSWE commands to navigate as well as "
			+ "INSPECT DROP and GO for interacting with rooms."
			+ "\nType: 'q' anytime to exit game].\n"
			+ "\n\n";
	
	System.out.println(s);
}

// stores our string list input in AL.. GET 
public List<String> WordList(String input) {
    List<String> strlist = new ArrayList<>();
    StringTokenizer tokenizer = new StringTokenizer(input);
    String t;

    while (tokenizer.hasMoreTokens()) {
        t = tokenizer.nextToken();
        strlist.add(t);
    }
    return strlist;
}

//GET
public String RunCommand(String inputstr) {
    List<String> wl;
    String s = "I QUIT!";
    String lowstr = inputstr.trim().toLowerCase();     
    // false go to next if 
    if (!lowstr.equals("q")) {
        if (lowstr.equals("")) {
            s = "You must enter a command";
        } else {
        	// call WL
            wl = WordList(lowstr);  
             //call parse thru world list
            s = ParseCommand(wl);
        }
    }
    return s;
}

public void showCurrR() {
	String c;
	Room sR = getPlayer().getRoom();
	c = "You are in " + sR.getName() + ". " + sR.getDescript() + "\n";
	System.out.print(c);
}


	
}
