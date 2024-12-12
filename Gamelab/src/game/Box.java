package game;

public class Box extends Item  {

	public Box(String n, String desc) {
		super(n,desc);
	}
	public boolean canTake = true;
	
	@Override 
	public void open() {
		if(Game.getItem("box")!=null) {
			
		if( Game.getItem("lighter") == null) {
			Game.print("You don't have a lighter so this box will stay Sealed.");
		}
		else {
			Game.print("Using the lighter you slowly get the box opened.\nYou get wax melted enough until you can wedge your finger into it and pry it open.\nThe box explodes open and a skeleton key. On the key it has something engraved on the side.");
			Key Skeletonkey = new Key ("skeletonkey","This is a Skeleton Key with the word out carved into the side.");
			Game.inventory.add(Skeletonkey);
		}
		}
		if (Game.getItem("vase")!= null){
			Game.print("You reach your hand into the vase and pick out a note ");
			Item note = new Item("Note","The silver key is in the Bathroom cabinet. Use it to unlock the fridge.");
			Game.inventory.add(note);
		}
	}
}
