import java.util.*;
import java.io.*;

public class BuildingBuilder {
	public static Building buildFromFile(String fname) {
		File f = new File(fname);
		return buildFromFile(f);
	}

	public static Building buildFromFile(File f) {
		try {
			Scanner fsc = new Scanner(f);
			String line;
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> descs = new ArrayList<String>();
			ArrayList<String> norths = new ArrayList<String>();
			ArrayList<String> souths = new ArrayList<String>();
			ArrayList<String> easts = new ArrayList<String>();
			ArrayList<String> wests = new ArrayList<String>();
			ArrayList<String> changes = new ArrayList<String>();
			String[] parts;
			Room rm;
			Building bldg = new Building();
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				parts = line.split("\t");
				names.add(parts[0]);
				descs.add(parts[1]);
				rm = new Room(parts[0],parts[1]);
				bldg.addRoom(rm);
				norths.add(parts[2]);
				souths.add(parts[3]);
				easts.add(parts[4]);
				wests.add(parts[5]);
				changes.add(parts[6]);
			}
			int roomNum = 0;
			ArrayList<Room> allRooms = bldg.getRooms();
			Random rnd = new Random();
			int i = (rnd.nextInt(10)+1);
			for (Room room : allRooms) {	
				bldg.setNeighborsByName(room,norths.get(roomNum),
				souths.get(roomNum),easts.get(roomNum),wests.get(roomNum));
				room.setChange(Integer.parseInt(changes.get(roomNum)));
				if(roomNum == i) {
					room.setGoal(true);
				}
				roomNum++;
			}
			fsc.close();
			return bldg;
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
}
