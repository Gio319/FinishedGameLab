package game;

public class Safe extends Item {
	
	public Safe(String n, String desc) {
		super(n, desc);
		
	}

	public boolean hascombo = false;
	public boolean canTake = false;
	
	@Override
	public void open() {
		if(Game.getItem("Safe Combination") == null) {
			Game.print("The safe is locked and you don't have the combination.");
		}
		else {
			Game.print("Using the combination you unlock the safe. Inside there is a diamond key that doesn't have any markings.");
			Key diamondKey = new Key ("diamondkey","A Diamond key that doesn't have any markings at all");
			Game.inventory.add(diamondKey);
		}
	}
}

		
		
		
		
		
		



