package RoomPackage;

import java.util.HashSet;

public class TreasureRoom extends Room {

	public TreasureRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		this.commandList.add("exit");
		this.commandList.add("precedent");
		this.commandList.add("get treasure");
	}

	/*
	 * This method updates the RoomTreasure set
	 * 
	 * */
	@Override
	public void getSpecificInterpretation(String command) {
		
		if (command.equals("get treasure"))
			this.commandList.remove("get treasure");

	}

}
