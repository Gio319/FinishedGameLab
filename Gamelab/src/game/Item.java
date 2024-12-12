package game;

import java.io.Serializable;

public class Item implements Serializable {

	private String name;
	private String description;
	private boolean canTake = true;
	private boolean canOpen = false;
	
	public Item(String n ,String desc) {
		description = desc;
		name = n;		
	}
	public String toString() {
	return name + "";
	}
	
	public String getDesc() {
	return description;
	}
	
	public String getName() {
		return name;
	
	}
	public void setDesc(String d) {
		description = d;
	}
	public void setName(String n) {
		name = n;
	}
	public void open() {
		Game.print("You can't open that! ");
	}
	public void use() {
		Game.print("You can't use that! ");
	}
	public void setTake() {
		canTake = true;
	}
	public void setcantTake() {
		canTake = false;
	}
	
	public boolean getTake() {
		return canTake;
	}
	public boolean getOpen() {
		return canOpen;
	}
	public void setCanOpen() {
		canOpen = true;
	}
	public void setCantOpen() {
		canOpen = false;
	}
	
}
