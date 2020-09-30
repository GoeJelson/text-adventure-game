import java.util.*;

public class GameManager {
	private Room position;
	private Building building;
	private Health health;
	public GameManager(Building bldg) {
		building = bldg;
	}
	public String move(String dir) {
		Room newPosition = building.getRoom(position, dir);
		if (newPosition == null) {
			return "You can't move in that direction.";
		} else {
			position = building.getRoom(position,dir);
			return "You are now in room " + position.getName();
		}
	}
	public void play(Building bldg) {
		Scanner sc = new Scanner(System.in);
		position = bldg.findRoomByName("shore");
		String dir = "";
		String again ="Y";
		boolean check;
		while (again.equals("Y")){
			health = new Health();
			while (!dir.equals("Q")) {
				System.out.printf("Your current health is: %d", health.getHealth());
				System.out.print("\nEnter direction (N, S, E, W, or Q to quit): ");
				dir = sc.nextLine().toUpperCase().trim();
				if (!dir.equals("Q")) {
					System.out.println(move(dir));
					health.setHealth(health.healthChange(health.getHealth(), position.getChange()));
				}
				if(health.getHealth() <= 0) {
					System.out.println("Oh no! You've lost too much health! GAME OVER");
					System.out.println("Would you like to play again? Y/N: ");
					again = sc.nextLine().toUpperCase().trim();
					if(again.equals("Y")) {
						position = bldg.findRoomByName("shore");
					}
					break;
				}
				check = position.isGoal();
				if(check == true) {
					System.out.println("You found the treasure! You've won the game!");
					System.out.println("Would you like to play again? Y/N: ");
					again = sc.nextLine().toUpperCase().trim();
					if(again.equals("Y")) {
						position = bldg.findRoomByName("shore");
					}
					break;
				}
			}	
		}	
	}
}
