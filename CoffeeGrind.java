import java.util.Scanner;

public class CoffeeGrind {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of file: ");
		String fname = sc.nextLine();
		Building bldg = BuildingBuilder.buildFromFile(fname);
		System.out.println(bldg);
		GameManager gm = new GameManager(bldg);
		gm.play(bldg);
	}
}
