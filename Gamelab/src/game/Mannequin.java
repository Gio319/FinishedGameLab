package game;

public class Mannequin extends NPC{
	public int count = 0;
	public Mannequin() {
		super ("Mannequin","Its a lifeless Mannequin, but yet so livley");
	}
	@Override
	public void talk() {
		if (count == 0) {
			say("What are you doing here? Visitors who come here are doomed.");
			String[] options = {
					"Where am I? Who are you? How can I get out",
					"I don't know why I am here, all i know is i woke up downstairs and was locked in the basement."};
			getResponse(options);
			}
		else if (count == 1) {
			say("Good now that you found the note and was able to follow its directions. there is one more thing I can do To help.");
			String[] options = {
					" I didn't read it yet",
					"Yes but i don't know what to do now!"};
			getResponse(options);
		}
		else if(count ==2) {
			say("That all I got for yah kid, now go get outta here!");
		}
		}
	@Override
	public void response(int option) {
		if(count == 0) {
			switch(option){
			case 1:
				say("You are in a house of horrors.\n This the house of a mad man who brings people here and then chops them up and sells them as burgers.\n As for who I am. i'm unfortunatley one of this deranged mans victims.\n Something to help you get out will be in this vase.");
				count += 1;
				break;
			case 2:
				say("well buddy you better get a grip because soon im not the only spirit haunting a stupid mannequin");
				say("I don't know how to get out, but before I died here I saw the man who did this to use put something in that vase. Try breaking it open using \"open\".");
				break;
			}
		}
		else if (count==1) {
			switch(option) {
			case 1:
				say("Oh well then read the note and Go!");
				break;
			case 2:
				if(Game.getItem("notes") != null) {
				say("Heres the last final clue, The final key Is in a box that needs a lighter to break the wax seal!");
				count+=1;
				break;}
				else {
					say("Quit lyin to me im right next to it I can tell!");
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
