package roomba.navigation.mapping;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import drawing2D.Game;

public class FloorMap {
	private final Dimension size;
	
	private floorState[][] pixels;
	private BufferedImage pixelMask;
	
	enum floorState{
		CLEAN(0),
		DIRT(1),
		SOLID(2),
		WALL(3),
		WET(4);
		
		private floorState(int value) {
			this.value = value;
		}
		
		private int value;
		
		public int getValue() {
			return this.value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
	}
	
	public FloorMap(Dimension size) {
		this.size = size;
		generatePixelMask();
	}
	
	
	private void generatePixelMask() {
        pixels = new floorState[size.height][size.width];
        pixelMask = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_ARGB);
        Color semiBlack = new Color(0, 0, 0, 100);
        Color black = Color.BLACK;

        for (int y = 0; y < size.height; y++) {
            for (int x = 0; x < size.width; x++) {
                pixels[y][x] = floorState.DIRT;
                pixelMask.setRGB(x, y, semiBlack.getRGB());
            }
        }
        
        for(int y = 100; y < 400; y++) {
        	for(int x = 100; x< 400; x++) {
        		pixels[y][x] = floorState.SOLID;
                pixelMask.setRGB(x, y, black.getRGB());
        	}
        }
    }
	
	public BufferedImage getDirtMask() {
		return pixelMask;
	}
	
	public void set(Point position, int value) {
		this.pixels[position.y][position.x].setValue(value);
	}
	
	public floorState[][] get(){
		return pixels;
	}
	
	public int getWidth() {
		return this.size.width;
	}
	
	public int getHeight() {
		return this.size.height;
	}
}

