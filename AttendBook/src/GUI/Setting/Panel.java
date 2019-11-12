package GUI.Setting;

import java.awt.Color;

import javax.swing.JPanel;

public class Panel extends JPanel{
	private static final long serialVersionUID = -766801029714990939L;
	
	public enum type{
		PRIME, SECOND, BACK, SHADOW, INVIS
	};
	
	public Panel(type t) {
		
		switch (t) {
			case PRIME : this.setBackground(Styles.PRIMARY); break;
			case SECOND : this.setBackground(Styles.SECONDARY); break;
			case BACK : this.setBackground(Styles.BACKGROUND); break;
			case SHADOW : this.setBackground(Styles.SHADOW); break;
			case INVIS : this.setBackground(Styles.INVISIBLE); break;
		}
	}
}