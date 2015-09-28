package Dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Dungeon {
	protected Room currentRoom;
	protected Room precedent;
	protected int indexCurentRoom;
	protected int indexPrecedentRoom;
	protected boolean gameIsFinished = false;
	protected List<Room> crossedRooms = new ArrayList<>();
	protected Gamer gamer;
	protected final Scanner scanner = new Scanner(System.in);

	public Dungeon() {

	}

	public Dungeon(Gamer gamer) {
		this.gamer = gamer;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	/*
	 * public void interpretCommand(String command) {
	 * 
	 * String go = command.substring(0, 2); if (go.equals("go")) { String
	 * direction = command.substring(3);
	 * if(currentRoom.interpretDirection(currentRoom, direction)!=null)
	 * currentRoom=currentRoom.interpretDirection(currentRoom, direction); }
	 * else System.out.println("please start your command by \"go\"?"); }
	 */

	public Room getRandomRoom() {
		List<Room> roomListes = new ArrayList();
		roomListes.add(new NormalRoom("normal"));
		roomListes.add(new NormalRoom("monster"));
		roomListes.add(new NormalRoom("key"));
		roomListes.add(new NormalRoom("button"));

		int randomRoom = new Random().nextInt(4);
		return roomListes.get(randomRoom);

	}

	/* This method creates a random romm, which is a current room. Also it creates
	* the precedent room. it use only two choices of the gamer: whene he chooses 
	* the "cross" command or the precedent command. The others command are process 
	* in the rooms clacess using polymorphism. 	
	*/
	public void start() {
		currentRoom = getRandomRoom();
		crossedRooms.add(currentRoom);

		indexCurentRoom = crossedRooms.indexOf(currentRoom);
		System.out.println("l'index current room :" + indexCurentRoom);
		System.out.println("name current room: " + currentRoom.name);

		do {
			System.out.println("This is the commands choice:");
			for (String commands : currentRoom.commandList) {
				System.out.println(commands);
			}

			System.out.println("What do you want to do?");
			System.out.print("> ");
			// Read a command from the user (stdin)
			String line = scanner.nextLine();
			currentRoom.interpretCommands(line);

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
		} while (!gameIsFinished());

		// System.out.println("You are in " + getCurrentRoom().name);
		if (gameIsWon()) {
			System.out.println("You win!");
		} else {
			System.out.println("You loose!");
		}
	}

	public boolean gameIsFinished() {
		return gameIsLost() || gameIsWon();
	}

	public boolean gameIsLost() {

		// il reste bouton etc
		return currentRoom.name.equals("trap");
	}

	public boolean gameIsWon() {
		return currentRoom.name.equals("exit");
	}
}
