
import java.util.LinkedHashMap;

public class Room {
	private String name;
	private String description;
	private LinkedHashMap<String, Room> neighbors;
	private int changehp;
	private boolean goal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LinkedHashMap<String,Room> getNeighbors() {
		return neighbors;
	}
	public Room getNeighbor(String dir) {
		return neighbors.get(dir);
	}
	public void setNeighbor(String dir, Room rm) {
		neighbors.put(dir, rm);
	}
	public int getChange(){
		return changehp;
	}
	public void setChange(int changehp){
		this.changehp = changehp;
	}
	public boolean isGoal(){
		return goal; 
	}
	public void setGoal(boolean goal){
		this.goal = goal;
	}
	public String getNeighborsAsString() {
		String output = "";
		output = output + "North: " + getNeighborName("N") + "\t";
		output = output + "South: " + getNeighborName("S") + "\t";
		output = output + "East: " + getNeighborName("E") + "\t";
		output = output + "West: " + getNeighborName("W");
		return output;
	}
	@Override
	public boolean equals(Object other) {
		Room otherRoom = (Room)other;
		return name.equalsIgnoreCase(otherRoom.getName());
	}
	public boolean matchByName(String otherName) {
		return name.equalsIgnoreCase(otherName);
	}
	public Room() {
		name = "";
		description = "";
		neighbors = new LinkedHashMap<String,Room>();
	}
	public Room(String name, String desc) {
		this();
		this.name = name;
		this.description = desc;
	}
	public String getNeighborName(String dir) {
		dir = dir.toUpperCase().trim();
		Room rm = getNeighbor(dir);
		if (rm == null) {
			return "";
		} else {
			return rm.getName();
		}
	}
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%s\t%s\t%s", name, description, 
        getNeighborName("N"),getNeighborName("S"),getNeighborName("E"),
        getNeighborName("W"));
	}
}



