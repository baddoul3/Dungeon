package Dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class Room {
	protected String name;
	// protected Room precedentRoom;
	protected Set<String> commandList;
	protected boolean crossCommand = false;
	protected boolean precedentCommand = false;

	public Room(String name) {
		this.name = name;

	}

	protected abstract void test(String chaine);

	public void interpretCommands(String command) {
		test(command);
		if (command.equals("exit"))
			this.crossCommand = true;
		else if (command.equals("precedent"))
			this.precedentCommand = true;
		else if (commandList.contains(command))
			System.out.println("wrong command, tray again!!");

	}

}
