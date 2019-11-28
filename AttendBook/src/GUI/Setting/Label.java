package GUI.Setting;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel {
	private static final long serialVersionUID = 7036064893078447973L;
	public final static String FONTNAME = " Noto Sans CJK KR";

	public final static Color PRIMEFONT = Styles.BACKGROUND;
	public final static Color BACKFONT = Styles.SECONDARY;
	public final static Color NORMALFONT = Styles.DARKEST;

	public final static int BIG = 21;
	public final static int SMALL = 12;
	public final static int TINY = 8;

	public Label(Color color, int size, String text) {
		// 글자 색상
		this.setForeground(color);

		// 글자 크기
		this.setFont(new Font(FONTNAME, Font.PLAIN, size));

		// 글자 내부 내용
		this.setText(text);
	}
}
