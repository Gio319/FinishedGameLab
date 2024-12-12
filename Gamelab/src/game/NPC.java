package game;

import javax.swing.JOptionPane;

public class NPC {
private String name;
private String desc;

public NPC(String name, String Desc) {
	this.name = name;
	this.desc = desc;
}
public String getName() {
	return name;
}
public void setDesc() {
	this.desc = desc; 
}
public void say(String dialog) { 
	Game.print(name+": "+dialog);
}
public void talk() {
	Game.print("You can't talk to "+name+".");
}
public void response(int option) {
	
}
public void getResponse(String [] options) {
	String s = "";
	for(int i=0; i<options.length; i++) {
		s += "option"+(i+1)+": "+ options[i];
	}
	s += "Enter an option (1-"+options.length+"): ";

	int option = Integer.parseInt(JOptionPane.showInputDialog(s));
	response(option); 
	
} 
}
