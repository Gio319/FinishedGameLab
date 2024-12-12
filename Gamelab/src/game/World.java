package game;

public class World {

	public static Room buildWorld() {
		// Room constructs
	
		Room darkBasement = new Room("Dark Basement");
		Room boilerRoom = new Room("Boiler Room");
		Room westHall = new Room("West Hall");
		Room eastHall = new Room("East Hall"); 
		Room livingroom = new Room("Living Room");
		Room diningroom = new Room("Dining Room");
		Room closet = new Room("Closet");
		Room kitchen = new Room("Kitchen");
		Room bathroom = new Room("Bathroom");
		Room outside = new Room("Outside");
		
		
		
		//Item Constructs
		Safe safe = new Safe("safe", "It's an impressive safe!");
		Item doll = new Item("doll","its a creepy all raggedy doll, feels like its watching.");
		Item crowbar = new Item ("crowbar", "this is a rusty crowbar"); // The item that they would brake the door to get out of the basement.
		Item finger = new Item("finger","a part of a body thats not on a body, how'd it get here.");
		Item knife = new Item("knife","It has a red crusty residue on it... Best hope its from cooking..."); 
		Item lighter = new Item ("lighter","Its a steel rusty zippo lighter that smells like ciggars."); // Lighter to melt the wax on the box
		Box box = new Box("box"," Its a wax sealed box that has something small and metal rattling around in it."); // This box will hold the key to the outside
		Box vase = new Box("vase", "its a vase that is old and dusty");
		Key key = new Key ("key","A key with a paper tag that spells \"basement\".");
		Fridge fridge = new Fridge("fridge", "A Fridge wrapped in chains with a silver lock on it.");
		Cabinet cabinet = new Cabinet("cabinet","Its a drawer that half open it looks like someting is shining off it.");
		Mannequin mannequin = new Mannequin();
		// NPC Constructs
		Puppy pup = new Puppy();
		
		
		// Basement Code
		darkBasement.addExit(boilerRoom, 'e');
		darkBasement.addExit(diningroom,'u');
		darkBasement.addObject(safe);
		darkBasement.addObject(key);
		darkBasement.addNpc(pup);
		safe.setcantTake();
		safe.setCanOpen();
		key.setTake();

		//Boiler Room Code
		boilerRoom.addExit(darkBasement, 'w');
		boilerRoom.addObject(crowbar);
		crowbar.setTake();
		boilerRoom.addObject(lighter);
		lighter.setTake();
		
		
		//Dining Room Code
		diningroom.addExit(eastHall, 'e');
		diningroom.addExit(westHall, 'w');
		diningroom.addExit(livingroom,'n');
		diningroom.addExit(kitchen,'s');
		diningroom.addExit(darkBasement, 'd');
		diningroom.addObject(finger);
		diningroom.setLocked();
		
		//West Hall Code
		westHall.addExit(diningroom, 'e');
		westHall.addExit(closet, 'w');
		
		// Closet Code
		closet.addExit(westHall, 'e');
		closet.addObject(box);
		closet.setLocked();
		 
		
		// East Hall Code
		eastHall.addExit(diningroom, 'w');
		eastHall.addExit(bathroom, 's');
		eastHall.addObject(doll);
		
		// Bathroom Code
		bathroom.addExit(eastHall, 'n');
		
		bathroom.addObject(cabinet);
		
		
		//Kitchen Code
		kitchen.addExit(diningroom, 'n');
		kitchen.addObject(knife);
		kitchen.addObject(fridge);
		fridge.setcantTake();
		
		// Living Room code
		livingroom.addExit(diningroom, 's');
		livingroom.addExit(outside, 'n');
		livingroom.addObject(vase);
		livingroom.addNpc(mannequin);
		
		
		outside.setLocked();
		
		return darkBasement;
		
	
		
		
		
		
		
		
	

		
	}
}
