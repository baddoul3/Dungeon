package RoomPackage;

import java.util.HashSet;

public class ExitRoom extends Room {

	public ExitRoom(String name) {
		super(name);
		this.commandList = new HashSet<>();
		/*
		 * this room is necessary to win, when the game choose randomly this
		 * room in the last dungeon the game is stopped and the the player win
		 * 
		 */

	}

	@Override
	public void getSpecificInterpretation(String command) {

	}

}