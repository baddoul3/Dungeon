package Dungeon;
import java.util.ArrayList;
import java.util.List;

public abstract class Room {
	protected String name;
	//protected Room precedentRoom;
	protected List<String> commandList;
	protected boolean crossCommand = false; 
	protected boolean precedentCommand = false;

	

	public Room(String name) {
		this.name = name;
		
		
	}

	public void interpretCommands(String command)
	{
		if(command.equals("cross"))
			this.crossCommand = true; 
		else if(command.equals("precedent"))
			this.precedentCommand = true;
		else if(command.equals("description"))
			System.out.println("you are in room :"+this.name);
		else 
			System.out.println("wrong command, tray again!!");
		
	}

}
