package RoomPackage;

import java.util.HashSet;

public class MonsterRoom extends Room {

	public MonsterRoom(String name) {
		super(name);

		this.commandList = new HashSet<>();
		this.commandList.add("precedent");
		this.commandList.add("use weapon");
		this.commandList.add("use potion");
		this.exitCommand = false;
	}

	/*
	 * This method test if the player choose to kill the monster
	 *
	 * 
	 */
	@Override
	public void getSpecificInterpretation(String command) {

		// The player choose use weapon, so he can kill the monster
		if (command.equals("use weapon")) {
			this.commandList.remove("use weapon");
			this.commandList.add("kill");

		}
		// The player has killed the monster, so he can exit
		else if (command.equals("kill")) {
			this.commandList.remove("kill");
			this.commandList.add("exit");
			this.exitCommand=true;

		}

	}

}
