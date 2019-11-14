package GUI.Setting;

import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel{
	private static final long serialVersionUID = 7036064893078447973L;
	public final static String FONTNAME = " Noto Sans CJK KR";
	public enum type{
		TITLE, BACK, NORMAL
	};
	public Label(type t, String s) {
		switch (t) {
		case TITLE:	
			this.setFont(new Font(FONTNAME, Font.BOLD, 21)); 
			this.setForeground(Styles.PRIMEFONT);
			break;
		case BACK : 
			this.setFont(new Font(FONTNAME, Font.PLAIN, 10)); 
			this.setForeground(Styles.BACKFONT);
			break;
		case NORMAL : 
			this.setFont(new Font(FONTNAME, Font.PLAIN, 10)); 
			this.setForeground(Styles.NORMALFONT);
			break;
		}
		
	}
}
