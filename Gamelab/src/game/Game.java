package game;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap; 
import java.io.IOException;


public class Game {

	public static Scanner input = new Scanner(System.in);
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	public static HashMap <String ,String> rooms = new HashMap <String,String>();
	public static Room currentRoom;
	// curroom is the current rooms
	public static HashMap <String, Room> curroom = new HashMap <String,Room>();
	public static void main(String[] args) {
		buildRoom();
		currentRoom = World.buildWorld();
		gui = new GUI();
		if(currentRoom.getName().equals("Outside")) {
			print("Congradulations for beating my game!\nI hope you enjoyed playing as much as I did making it."); 
		}
		print(currentRoom.getDesc());
		
		
	}
	
	public static void print(Object obj) {
		gui.print(obj.toString());}
		
	private static GUI gui;
	 
	
	
	public static Item getItem(String n) {
		for (Item i : inventory) {
			String c =i.toString();
		if (c.equals(n)) {
			return i;}
		
		}
		return null;
	}
	public static void processCommand(String command) {
		
		String[] words = command.split(" "); 
		
		switch(words[0]) {
		// Take cases
		case "take":  
		case "Take":
		case "t":
				print("You are trying to grab "+ words[1]+".");
			if (currentRoom.objects.containsKey(words[1]) == false) {
				print("There is no object to take");
				break;
			}
			else {
				if (currentRoom.getObject(words[1]).getTake() == false) {
					print("You can't carry" + words[1]);
					break;
				}
				else {
			inventory.add(currentRoom.getObject(words[1]));
				print("You took " + currentRoom.getObject(words[1]).getName()+"\n");
			currentRoom.removeItem(words[1]);
			break;}
			}
			
			// Look cases
		case "look":
		case "Look":
		case "l":
				print("You are trying to look at " + words[1]);

				if (getItem(words[1])!=null) {
					for (Item i : inventory) {
						if (words[1] .equals(i.getName())) {
							print(i.getDesc());	
			
						}
					}
			
				}
					
			//	}
				else {
					print("You look at "+ currentRoom.getObject(words[1]));
					print(currentRoom.getObject(words[1]).getDesc()+"\n");
					
				}
			break;
			
			
		case "use":
		case "Use":
			print("You are trying to use" + words[1]);
			if (getItem(words[1]) != null) {
						getItem(words[1]).use();
						break;
						
					}
					else {
						print("This item is no where to be found.\n");
						print("So you can't use "+words[1]);
						break;
					}
			
				
				
	// The open switch statements to open any items containing things	
			
		case "open":
			print("You are trying to open " + words[1]);		
			if(currentRoom.getObject(words[1]) !=null) {
				currentRoom.getObject(words[1]).open();}
			else {
				if(getItem(words[1]) == null) {
					print("There is no such item.");
				}
				else {
					getItem(words[1]).open();
				}
			}
			
			break;
			
// Inventory cases
		case "i":
			if (inventory.size()>0) {
				print("");
				print("Your inventory: ");
				for (int i = 0;i<inventory.size();i++) {
					Item s = inventory.get(i);
					print(s);
				}
				print("");
			}
			else {
				
				print("\n There is nothing in you're inventory.\n");
				
			}
			break;
		case "n":
		case "w":
		case "e":
		case "s":
		case "u":
		case "d":
			Room nextRoom = currentRoom.getExit(command.charAt(0));
			if (nextRoom == null) {
				print("That is not a direction you can go. ");
				break;
			}
			else {
				if (nextRoom.getLock() == true) {
					print("The door is locked Try finding something to open it.");
					break;
				}
				else {
				currentRoom = nextRoom;
				print(currentRoom.getDesc());
			print("");
			break;}}
		
		case "x":
			print("Thanks for playing my game.");
			break;
		case "save":
		case "Save":
		case "save game":
		case "Save game":
		case "Save Game":
			saveGame("save");
			break;
		case "load":
		case "Load":
		case "load game":
		case "Load game":
		case "Load Game":
			loadGame("save");
			break;
		case "talk":
			print("You are trying to speak to "+words[1]+".");
			if(currentRoom.getNPC(words[1]) != null) {
				currentRoom.getNPC(words[1]).talk();
			}
			else {
				print("That Entity doesn't Exist.... Are you okay??");
			}
			break;
			
		default:
			print("I don't know what that means.");
		}
	}
	
	
	

	public static void buildRoom() {
		try {
		Scanner room = new Scanner(new File ("rooms.txt"));
		while (room.hasNextLine()) {	
			String line = new String(room.nextLine());
			//System.out.println(line);
			String desc = new String (room.nextLine());
			rooms.put(line, desc);
			if (!room.nextLine().equals("#")) {		
			}
			else {   
				
				
			}
			
		}room.close();
		
	}catch (FileNotFoundException e) {
		System.out.println("This file can not be found");
	}
}
	
	
	public static void saveGame(String fileName) {
		File file = new File (fileName);
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream stream = new ObjectOutputStream(fos);
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(curroom);
			stream.close();
			print("game has been saved");
		} catch (FileNotFoundException e) {
			print("File"+ file + "has not been found!");
		} catch (IOException e) {
			print("Bummer");
		}
		
	}
	
	
	public static void loadGame(String SaveState) {
		File load = new File(SaveState);
		try {
			FileInputStream fos = new FileInputStream(load);
			ObjectInputStream stream = new ObjectInputStream(fos);
			currentRoom = (Room) stream.readObject();
			inventory = (ArrayList<Item>) stream.readObject();
			curroom = (HashMap<String, Room>) stream.readObject();
			stream.close();
			print("Save state has been loaded");
		}catch (FileNotFoundException e ) {
			print("File"+ SaveState +"Has not been found");
			System.exit(0);
		}catch (IOException ex) {
			print("Bummer");
		}catch (ClassNotFoundException ex) {
			print("Not an object");
		}
	}
	
	
	
	
	
}

