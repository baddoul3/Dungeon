package Dungeon;

public class ButtonRoom extends Room {

	public ButtonRoom(String name) {
		super(name);
		
		this.commandList.add("Description");
		this.commandList.add("cross");
		this.commandList.add("precedent");	
	}

	@Override
	public void interpretCommands(String command) {
		// TODO Auto-generated method stub
		
	}


}
