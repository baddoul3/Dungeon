package Dungeon;

public class MonsterRoom extends Room{

	public MonsterRoom(String name) {
		super(name);
		
		this.commandList.add("kill monster");
		this.commandList.add("cross");
		this.commandList.add("precedent");	
		
	}

	@Override
	public void interpretCommands(String command) {
		// TODO Auto-generated method stub
		
	}


}
