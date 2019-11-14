package GUI.Setting;

import java.awt.Color;

public class Styles {
	final static Color[] palette = {
			new Color(255, 255, 255),
			new Color(240, 247, 247),
			
			new Color(13, 255, 237),
			new Color(12, 189, 232),
			new Color(0, 138, 255),
			new Color(12, 73, 232),
			new Color(13, 16, 255), 
	};
	
	public final static Color BACKGROUND = palette[0];
	public final static Color SHADOW = palette[1];
	
	
	public final static Color PRIMARY = palette[5];
	public final static Color SECONDARY = palette[4];
	
	public final static Color PRIMEFONT = palette[0];
	public final static Color BACKFONT = palette[4];
	public final static Color NORMALFONT = palette[6];
	
	public final static Color INVISIBLE = new Color(0,0,0,0);

}
