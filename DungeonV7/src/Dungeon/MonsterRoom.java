package Dungeon;

import java.util.ArrayList;
import java.util.HashSet;

public class MonsterRoom extends Room {

	public MonsterRoom(String name) {
		super(name);

		this.commandList = new HashSet<>();
		this.commandList.add("kill");
		this.commandList.add("precedent");

	}

	@Override
	public void test(String command) {
		
		this.commandList.add("kill");

		if (command.equals("kill")) {

			this.commandList.remove("kill");		
			this.commandList.add("exit");
		

		}

	}

}
