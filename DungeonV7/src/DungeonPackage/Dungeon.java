package DungeonPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import RoomPackage.*;

/*
 * This class contains the mainly common  methods of dungeon type, all dungeons
 *  are a children of this class except the final dungeon which have a specific 
 *  room (ExitRoom)
 */
public abstract class Dungeon {
	protected String name;
	protected Room currentRoom;
	protected Room precedent;
	protected int indexCurentRoom;
	protected int indexPrecedentRoom;
	protected boolean gameIsFinished = false;
	protected List<Room> crossedRooms = new ArrayList<>();
	protected Player player;
	protected int treasure;
	protected boolean transition = false;
	protected final Scanner scanner = new Scanner(System.in);

	public Dungeon() {

	}

	public Dungeon(String name, Player player) {
		this.player = player;
		this.name = name;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	/*
	 * This methode implements a temporary list with a liste of romms and
	 * generates a new Room and returns it to be use in a dungeon
	 * 
	 */
	public Room getRandomRoom() {
		List<Room> roomListes = new ArrayList();

		roomListes.add(new NormalRoom("normal"));
		roomListes.add(new MonsterRoom("monster"));
		roomListes.add(new KeyRoom("key"));
		roomListes.add(new ButtonRoom("button"));
		roomListes.add(new TreasureRoom("treasure"));

		int randomRoom = new Random().nextInt(4);
		return roomListes.get(randomRoom);

	}

	/*
	 * This method is called when the player starts the game or chooses 
	 * to leave the current dungeon
	 */
	public void start() {

		currentRoom = getRandomRoom();

		crossedRooms.add(currentRoom);

		indexCurentRoom = crossedRooms.indexOf(currentRoom);
		System.out.println("You are in the  " + this.name + " dungeon ");

		//When the  player chooses to leave the current room or use an object
		do {

			System.out.println("You have  : " + this.player.getKeys() + " keys");
			System.out.println("You have  : " + this.player.getWeapons() + " weapons");
			System.out.println("You have  : " + this.player.getTreasure() + " treasure");
			System.out.println("                                         ");
			
			//If the player is in any rooms except the button room
			if (!this.currentRoom.getName().equals("button"))				
				System.out.println("You are in room :" + currentRoom.getName());
			
			System.out.println("                                         ");
			System.out.println("This is the commands choice:");
			System.out.println("=============================");
			
			//Display of all possibles current room commands 
			for (String commands : currentRoom.getCommandList()) {
				System.out.println(commands);
			}
			
			System.out.println("=============================");
			System.out.println("What do you want to do?");
			System.out.print("> ");
			
			
			currentRoom.setCrossCommand(false);
			currentRoom.setPrecedentCommand(false);

			// Read a command from the user (stdin)
			String line = scanner.nextLine();

			currentRoom.interpretCommands(line);
			
			// Tests if the command is open, use weapon, get treasure, or use potion
			this.dungeonSpecificCommand(line);
			
			//If the choose to go to the next room
			if (currentRoom.isCrossCommand()) {
				
				precedent = currentRoom;
				indexPrecedentRoom = indexCurentRoom;
				currentRoom = getRandomRoom();
				indexCurentRoom++;
				crossedRooms.add(currentRoom);
				crossedRooms.set(indexPrecedentRoom, precedent);

				//If the choose to go to the precedent room
			} else if (currentRoom.isPrecedentCommand()) {
				
				//If the player is in the first room
				if (indexCurentRoom == 0)
					System.out.println("you cant go back !!");
				
				//If the player is in the second room
				else if (indexPrecedentRoom == 0) {
					currentRoom = crossedRooms.get(indexPrecedentRoom);
					precedent = null;
					indexCurentRoom--;
					System.out.println("indexCurentRoom" + indexCurentRoom);
					System.out.println("indexPrecedentRoom" + indexPrecedentRoom);

				} else {
					currentRoom = crossedRooms.get(indexPrecedentRoom);
					precedent = crossedRooms.get(indexPrecedentRoom - 1);
					indexCurentRoom--;
					indexPrecedentRoom--;
				}

			}

			System.out.println("*****************************");
			System.out.println("*****************************");
		} while (!gameIsFinished());

		if (gameIsWon()) {
			System.out.println("You win!");
		} else if (gameIsLost()) {
			System.out.println("You loose!");
		}

	}
	/*THis method changes the values of player keys, weapons or treasure.
	 * also it changes the value of transition for using to change a dungeon
	 */
	
	public void dungeonSpecificCommand(String command){
		if (command.equals("open"))
			this.player.decreaseKeys();

		else if (command.equals("use weapon"))
			this.player.decreaseWeapons();

		else if (command.equals("get treasure"))
			this.player.setTreasure();

		else if (command.equals("use potion"))
			this.transition = true;
	}
	
	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon() || dungeonIsChanged();
	}

	public boolean gameIsLost() {
		return !this.player.haveKeys() || !this.player.haveWeapons();

	}

	public boolean gameIsWon() {
		return currentRoom.getName().equals("exit room");
	}

	public boolean dungeonIsChanged() {

		return this.transition;
	}
}
