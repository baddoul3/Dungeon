package DungeonPackageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import RoomPackage.*;

public class ButtonRoomTest {

	protected Room buttonRoom;

	@Before
	public void createKeysRoom() {
		buttonRoom = new ButtonRoom("key");
	}

	// The test of initialization of the buttonRoom set
	@Test
	public void creationTest() {
		assertEquals(buttonRoom.getCommandList().contains("description"), true);
		assertEquals(buttonRoom.getCommandList().contains("use potion"), true);

	}

	// The of all changes when the player write "description" in this room set
	@Test
	public void descriptionCommandIn() {
		buttonRoom.getSpecificInterpretation("description");
		assertEquals(buttonRoom.getCommandList().contains("button"), true);
		assertEquals(buttonRoom.getCommandList().contains("precedent"), true);
		assertEquals(buttonRoom.getCommandList().contains("description"), false);

	}

	// The of all changes when the player write "button" in this room set
	@Test
	public void buttonCommandIn() {
		buttonRoom.getSpecificInterpretation("button");
		assertEquals(buttonRoom.getCommandList().contains("exit"), true);
		assertEquals(buttonRoom.getCommandList().contains("precedent"), true);
		assertEquals(buttonRoom.getCommandList().contains("button"), false);

	}

	@Test
	public void interpretCommandTest() {

		// The test of wrong command
		buttonRoom.interpretCommands("bad command");
		assertEquals(buttonRoom.isBadCommand(), true);

		// The of all changes when the player write "use potion" in this room
		// set
		buttonRoom.interpretCommands("use potion");
		assertEquals(buttonRoom.isExitDungeon(), true);

		// The of all changes when the player write "precedent" in this room set
		buttonRoom.interpretCommands("precedent");
		assertEquals(buttonRoom.isPrecedentCommand(), true);

	}

}
