package RoomPackage;

import java.util.Scanner;
import java.util.Set;

public abstract class Room {

	protected String name;
	protected Set<String> commandList;
	protected boolean crossCommand = false;
	protected boolean precedentCommand = false;
	protected boolean exitDungeon = false;
	protected boolean badCommand=false;
	protected boolean exitCommand=true;
	protected final Scanner scanner = new Scanner(System.in);
	public Room(String name) {
		this.name = name;
		

	}
	/*
	 * By using the Template Pattern we send a message(request) to each obgect of sub classes and 
	 * get the informations to complete the common code
	 */
	public abstract void getSpecificInterpretation(String command);

	public void interpretCommands(String command) {
		
		//When the player set a wrong command

		if(!commandList.contains(command) ){
			
			System.out.println("wrong command, tray again!!");
			this.badCommand=true;
			
		}
		
		//Adding of a specific code from sub classes
		getSpecificInterpretation(command);
		
		//When the player choose to leave the actual dungeon
		if (command.equals("use potion"))
			this.exitDungeon = true;
		
		//when the player choose to leave the actual room	
		if (command.equals("exit") && exitCommand)
		  this.crossCommand = true;
		
		//When the player choose to come back
		if (command.equals("precedent"))
			this.precedentCommand = true;
		
		

	}
	public String getName() {
		return name;
	}
	public Set<String> getCommandList() {
		return commandList;
	}
	public boolean isCrossCommand() {
		return crossCommand;
	}
	public boolean isPrecedentCommand() {
		return precedentCommand;
	}
	public boolean isExitDungeon() {
		return exitDungeon;
	}
	public void setCrossCommand(boolean crossCommand) {
		this.crossCommand = crossCommand;
	}
	public void setPrecedentCommand(boolean precedentCommand) {
		this.precedentCommand = precedentCommand;
	}
	public boolean isBadCommand(){
		return badCommand;
	}

}
