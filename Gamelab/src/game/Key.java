package game;

public class Key extends Item {

	public boolean canTake = true;
	public Key(String n, String desc) {
		super( n, desc);
		
	}
	
	public void use() {
		if (Game.getItem("key") != null){
		Room lockedDoor = Game.currentRoom.getExit('u');
				if (lockedDoor.getName().equals("Dining Room")) {
					if(lockedDoor.getLock()== true) {
						Game.currentRoom.getExit('u').setUnlock();
						Game.print("You unlocked the door, Time to get out");
						Game.inventory.remove(Game.getItem("key"));
					}
					else {
						Game.print("You have already used this and the door is open.");
					}
				}
				else {
					Game.print("Now's not the time to use this.");
				}
		}
		else if(Game.getItem("diamondkey") != null) {
			Room lockedDoor = Game.currentRoom.getExit('w');
			if(lockedDoor.getName().equals("Closet")) {
				if(lockedDoor.getLock()==true) {
					Game.currentRoom.getExit('w').setUnlock();
					Game.print("The closet has now been unlocked.");
					Game.inventory.remove(Game.getItem("diamondkey"));				}
				else {
					Game.print("You have already used this and the door is open.");
				}
			}
			else {
				Game.print("Now's not the time to use this.");
			}
		}
		
		else if(Game.getItem("skeletonkey")!=null) {
			Room lockedDoor = Game.currentRoom.getExit('n');
			if (lockedDoor.getName().equals("Outside")) {
				if (lockedDoor.getLock()==true) {
					Game.currentRoom.getExit('n').setUnlock();
					Game.print("The Front door has now been opened. It seems like you can Finally escape.");
					Game.inventory.remove(Game.getItem("skeletonkey"));
				}
					else {
					Game.print("You have already used this and the door is open.");
				}
			}
			else {
				Game.print("Now's not the time to use this.");
				
			}
		}
	}
}