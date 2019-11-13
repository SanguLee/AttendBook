package GUI.Setting;

import java.awt.Color;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final long serialVersionUID = -766801029714990939L;

	public static final Color TITLE = Styles.PRIMARY;
	public static final Color MENU = Styles.SECONDARY;
	public static final Color BACK = Styles.SHADOW;
	public static final Color WHITE = Styles.BACKGROUND;
	
	public Panel() {
		this.setBackground(Styles.INVISIBLE);
	}

	public Panel(Color c) {
		this.setBackground(c);
	}
}
