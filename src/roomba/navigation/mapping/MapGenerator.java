package roomba.navigation.mapping;

import java.awt.Dimension;
import java.util.ArrayList;

public class MapGenerator {
	private ArrayList<FloorMap> houseMap = new ArrayList<FloorMap>();
	private int roomNumber;
	
	public MapGenerator() {
		this.roomNumber = 0;
	}
	
	public void generateMap(Dimension size) {
		FloorMap fm = new FloorMap(size);
		houseMap.add(fm);
		roomNumber++;
		
		System.out.println("New map generated");
	}
	
	public ArrayList<FloorMap> getHouseMap(){
		return houseMap;
	}
	
	public FloorMap getRoom(int roomNumber) {
		if(houseMap.size()<roomNumber)
			return null;
		return houseMap.get(roomNumber-1);
	}
}
