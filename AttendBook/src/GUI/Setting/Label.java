package GUI.Setting;

import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
	private static final long serialVersionUID = 7036064893078447973L;
	public final static String FONTNAME = " Noto Sans CJK KR";
	public enum type{
		TITLE, BACK
	};
	public Label(type t, int size) {
		switch (t) {
		case TITLE:	
			this.setFont(new Font(FONTNAME, Font.BOLD, size)); 
			this.setForeground(Styles.PRIMEFONT);
			break;
		case BACK : 
			this.setFont(new Font(FONTNAME, Font.PLAIN, size)); 
			this.setForeground(Styles.BACKFONT);
			break;
		}
		
	}
}
