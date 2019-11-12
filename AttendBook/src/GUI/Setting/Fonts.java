package GUI.Setting;

import java.awt.Font;

public class Fonts extends Font{
	public enum type{
		TITLE, BACK
	};
	public Fonts() {
		super(Styles.FONTNAME, PLAIN, 21);
	}
}
