package Dungeon;

public class KeyRoom extends Room{
	
	
	public KeyRoom(String name) {
		super(name);
		
		this.commandList.add("open");
		this.commandList.add("cross");
		this.commandList.add("precedent");	
	}

	@Override
	public void interpretCommands(String command) {
		// TODO Auto-generated method stub
		
	}

}
