package game;

public class Cabinet extends Item{
	public Cabinet (String n, String desc) {
		super(n, desc);
	}
	public boolean cantake = false;
	public boolean hassilverkey = false;
	public void open() {
					if(Game.getItem("Silver Key")==null) {
					Key silverKey = new Key ("Silver Key","This is a Silver key that goes to a sliver lock.");
					Game.print("You open up the cabinet and there lies a Silver Key you quickly pick up the key and put it in your pocket.");
					Game.inventory.add(silverKey);
					hassilverkey = true;}
					else {
						Game.print("The cabinet is empty");
					}
	}
	
}
