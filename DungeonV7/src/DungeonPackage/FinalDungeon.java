package DungeonPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import RoomPackage.*;

public class FinalDungeon extends Dungeon{
	protected ExitRoom exitRoom;
	public FinalDungeon(String name, Player player) {
		super(name, player);
		
	}
	@Override
	public Room getRandomRoom() {
		List<Room> roomListes = new ArrayList<>();
		
		roomListes.add(new NormalRoom("normal"));
		roomListes.add(new NormalRoom("exit room"));
		roomListes.add(new MonsterRoom("monster"));
		roomListes.add(new KeyRoom("key"));
		roomListes.add(new ButtonRoom("button"));

		int randomRoom = new Random().nextInt(4);
		return roomListes.get(randomRoom);

	}
}
