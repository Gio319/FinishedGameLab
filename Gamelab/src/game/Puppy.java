package game;

public class Puppy extends NPC {
	public int count = 1;
	public Puppy() {
		super("puppy", "A hideous puppy wags his tail.");
	}
	@Override
	public void talk() {
		if (count == 1) {
		say("Hi! I'm an adorable puppt!");
		String[] options = {
				"yes you are! Who's a good boy",
				"Ew, no. You're kinda hideous and i'm more of a cat person."
		};
		getResponse(options);   
		
		}
		else if(count == 2) {
			say("Hey Wanna play fetch! Say yes! Say yes!");
			String[] options = {
					"Yes! I love Fetch!",
					"No. I am a horrible person and don't like playing with puppies."};
			getResponse(options);
			
		}
		else if(count == 3) {
			say("yip");
			{
				
			}
		}
		}
	
	@Override
	public void response(int option) {
		if (count == 1) {
		switch(option) {
		case 1:
			say("I am! I'm a good boy!");
			count += 1;
			break;
		case 2:
			say("I am adorable!!! Why are you so mean?");
			Game.print("The puppy bites you. you deserve it.");
			count += 1;
			break;
		}}
		else if (count == 2) {
			switch(option) {
			case 1:
				say("\"Yay! Fetch!\" (The puppy runs off and returns with a ball. The player recives the ball)");
				break;
			case 2:
				say("\"You're a bad person! I don't like you!\"(The puppy runs away and doesn't come back.)");
				count +=1;
				break;
			}
		}
		
			
	}
}
