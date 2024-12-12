package game;

public class Fridge extends Item{
	
	public Fridge(String n, String desc) {
		super(n, desc);
	}
	
	public boolean hascombo = false;
	public boolean cantake = false;
	public void open() {
		if (Game.getItem("Silver Key")== null) {
			Game.print("The fridge is locked with a Silver lock. Try finding the Key.");
		}
		else {
			Game.print("Using the Silver Key the chains on the fridge Fall to the ground allowing you to open it.");
			Game.print("Inside the fridge there is a note that has a combination for what looks like a safe");
			Combination safeCombo = new Combination ("Safe Combination","A piece of paper with what looks like the combo to a safe.");
			Game.inventory.add(safeCombo);
		}
		 
	}
}
