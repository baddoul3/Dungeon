package DungeonPakage;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Room {

	protected String name;
	protected Set<String> commandList;
	protected boolean crossCommand = false;
	protected boolean precedentCommand = false;
	protected boolean exitDungeon = false;

	public Room(String name) {
		this.name = name;
		

	}
	/*
	 * By using the Template Pattern we send a message(request) to each sub class and 
	 * get the informations to complete the common 
	 */
	protected abstract void getSpecificInterpretation(String command);

	public void interpretCommands(String command) {
		
		if (!commandList.contains(command))
			System.out.println("wrong command, tray again!!");
		
		getSpecificInterpretation(command);
		
		
		if (command.equals("use potion"))
			this.exitDungeon = true;
		else if (command.equals("exit"))
			this.crossCommand = true;
		else if (command.equals("precedent"))
			this.precedentCommand = true;
		
		

	}

}
