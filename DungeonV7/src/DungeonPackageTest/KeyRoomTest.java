package DungeonPackageTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import RoomPackage.*;

public class KeyRoomTest {
	protected Room keyRoom;

	@Before
	public void createKeysRoom() {
		keyRoom = new KeyRoom("key");
	}

	//The test of initialization of the KeyRoom set
	@Test
	public void creationTest() {
		assertEquals(keyRoom.getCommandList().contains("open"), true);
		assertEquals(keyRoom.getCommandList().contains("precedent"), true);
		assertEquals(keyRoom.getCommandList().contains("use potion"), true);
	}

	// The of all changes when the player write "open" in this room set
	@Test
	public void getSpecificInterpretationTest() {
		keyRoom.getSpecificInterpretation("open");
		assertEquals(keyRoom.getCommandList().contains("exit"), true);
		assertEquals(keyRoom.getCommandList().contains("open"), false);
	}

	@Test
	public void interpretCommandTest() {

		// The test of wrong command
		keyRoom.interpretCommands("bad command");
		assertEquals(keyRoom.isBadCommand(), true);

		// The of all changes when the player write "use potion" in this room
		keyRoom.interpretCommands("use potion");
		assertEquals(keyRoom.isExitDungeon(), true);

		// The of all changes when the player write "precedent" in this room set
		keyRoom.interpretCommands("precedent");
		assertEquals(keyRoom.isPrecedentCommand(), true);

	}

}
