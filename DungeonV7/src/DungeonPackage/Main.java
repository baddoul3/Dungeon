package DungeonPackage;

import DungeonPackage.*;
import RoomPackage.*;

public class Main {

	public static void main(String[] args) {
		Player player = new Player(3, 3);

		FirstDungeon dungeon1 = new FirstDungeon("first", player);
		FinalDungeon dungeon2 = new FinalDungeon("final", player);
		
		if (!dungeon1.transition)
			dungeon1.start();
		
		if(dungeon1.transition)
				dungeon2.start();
		

	}

}
