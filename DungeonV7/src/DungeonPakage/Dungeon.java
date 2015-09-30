package DungeonPakage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import RoomPakage.ButtonRoom;
import RoomPakage.KeyRoom;
import RoomPakage.MonsterRoom;
import RoomPakage.NormalRoom;
import RoomPakage.TreasureRoom;

public abstract class Dungeon {
	protected String name;
	protected Room currentRoom;
	protected Room precedent;
	protected int indexCurentRoom;
	protected int indexPrecedentRoom;
	protected boolean gameIsFinished = false;
	protected List<Room> crossedRooms = new ArrayList<>();
	protected Player player;
	protected int usedKeys;
	protected int usedWeapons;
	protected int treasure ;
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
	 * This method creates a random room, which is a current room. Also it
	 * creates the precedent room. it use only two choices of the player: when
	 * he chooses the "cross" command or the precedent command.
	 */

	public void start() {

		currentRoom = getRandomRoom();
		crossedRooms.add(currentRoom);

		indexCurentRoom = crossedRooms.indexOf(currentRoom);
		System.out.println("the dungeon is: " + this.name);
		usedKeys = this.player.keys;
		usedWeapons = this.player.weapons;

		do {

		
			System.out.println("You have  : " + this.usedKeys + " keys");
			System.out.println("You have  : " + this.usedWeapons + " weapons");
			System.out.println("You have  : " + this.player.getTreasure() + " treasure");

			if (!this.currentRoom.name.equals("button"))
				System.out.println("you are in room :" + currentRoom.name);

			System.out.println("This is the commands choice:");
			System.out.println("=============================");
			for (String commands : currentRoom.commandList) {
				System.out.println(commands);
			}
			System.out.println("=============================");
			System.out.println("What do you want to do?");
			System.out.print("> ");
			// Read a command from the user (stdin)
			String line = scanner.nextLine();			

			currentRoom.interpretCommands(line);

			if (line.equals("open"))				
				usedKeys--;
			
			else if (line.equals("use weapon"))
				usedWeapons--;
			
			else if (line.equals("get treasure"))
				this.player.setTreasure(treasure+=100);
			
			else  if (line.equals("use potion"))
				this.transition = true;

			if (currentRoom.crossCommand) {
				if (crossedRooms.size() > indexCurentRoom) {
					precedent = currentRoom;
					indexPrecedentRoom = indexCurentRoom;
					currentRoom = getRandomRoom();
					indexCurentRoom++;
					crossedRooms.add(currentRoom);
					crossedRooms.set(indexPrecedentRoom, precedent);

				} else {
					precedent = crossedRooms.get(indexCurentRoom);
					indexPrecedentRoom = indexCurentRoom;
					currentRoom = crossedRooms.get(indexCurentRoom);

				}
				currentRoom.crossCommand = false;

			} else if (currentRoom.precedentCommand) {
				if (indexCurentRoom == 0)
					System.out.println("you cant go back !!");
				else if (indexPrecedentRoom == 0) {
					currentRoom = crossedRooms.get(indexPrecedentRoom);
					precedent = null;
					indexCurentRoom--;
				} else {
					currentRoom = crossedRooms.get(indexPrecedentRoom);
					precedent = crossedRooms.get(indexPrecedentRoom - 1);
					indexCurentRoom--;
					indexPrecedentRoom--;
				}
				currentRoom.crossCommand = false;

			}
			
			
			
			System.out.println("*****************************");
			System.out.println("*****************************");
		} while (!gameIsFinished());

		if (gameIsWon()) {
			System.out.println("You win!");
		}else if (gameIsLost()) {
			System.out.println("You loose!");
		}
		 
			
	}

	public boolean gameIsFinished() {
		
				
		return gameIsLost() || gameIsWon() || dungeonIsChanged();
	}

	public boolean gameIsLost() {
		return usedKeys == 0 || usedWeapons == 0;

	}

	public boolean gameIsWon() {
		return currentRoom.name.equals("exit room");
	}
	public boolean dungeonIsChanged(){		
			
		return this.transition ;
	}
}
