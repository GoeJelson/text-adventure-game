
import java.util.ArrayList;

public class Building {
	private String name;
	private ArrayList<Room> rooms;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	public Room getRoom(Room rm, String dir) {
		return rm.getNeighbor(dir);
	}
	public Building() {
		name = "";
		rooms = new ArrayList<Room>();
	}
	public Building(String name) {
		this();
		this.name = name;
	}
	public void addRoom(Room rm) {
		rooms.add(rm);
	}
	public void addRoom(String startFrom, String dir, String newRoomName, 
	String desc) {
		Room startRoom = findRoomByName(startFrom);
		if (startRoom != null) {
			startRoom.setNeighbor(dir, new Room(newRoomName,desc));
		}
	}
	public void setNeighborByName(Room room, String dir, String name) {
		room.setNeighbor(dir, findRoomByName(name));
	}
	public void setNeighborsByName(Room room, String north, String south, 
	String east, String west) {
		setNeighborByName(room,"N",north);
		setNeighborByName(room,"S",south);
		setNeighborByName(room,"E",east);
		setNeighborByName(room,"W",west);
	}
	public Room findRoomByName(String name) {
		for (Room rm : rooms) {
			if (rm.matchByName(name)) {
				return rm;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		String result = "";
		for (Room rm : rooms) {
			result = result + rm.toString() + "\n";
		}
		return result;
	}
}
