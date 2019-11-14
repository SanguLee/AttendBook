package GUI.Contents;

import java.awt.BorderLayout;

import javax.swing.JButton;

import GUI.Setting.GridBag;
import GUI.Setting.Label;
import GUI.Setting.Panel;
import GUI.Setting.Styles;
import GUI.Setting.Label.type;

public class AttendPanel extends Content {
	private static final long serialVersionUID = -1280465224088539851L;
	
	@Override
	void setHead() {
		// TODO Auto-generated method stub
		head.add(new JButton("제 ㅡ 목"), BorderLayout.CENTER);
		System.out.println("실행중");
	}

	@Override
	void setBody() {
		// TODO Auto-generated method stub
		GridBag grid = new GridBag();
		JButton[] b = new JButton[7];
		for (int i = 0; i < 7; i++) {
			b[i] = new JButton(i + "");
			if (i < 5) {
				grid.addGrid(b[i], i / 4, i % 4, 1, 1);
			}
			if (i == 5) {
				grid.addGrid(b[i], i / 4, i % 4, 1, 1);
			}
			if (i == 6) {
				grid.addGrid(b[i], i / 4, i % 4, 2, 1);;
			}
			if (i == 7) {
				// do nothing in here
			}
		}
		body.add(grid, BorderLayout.CENTER);
	}
}

class Attend extends Panel {
	Panel Head;

	Panel Body;
	Panel[] Bodies = new Panel[2];

	public static final String[] title = { "1학년", "2학년", "3학년", "새신자", "교사" };
	public static final String[] sex = { "남자", "여자" };

	Panel[] cols;
	Panel[][] rows;

	static final int maxrow = 8;

	public Attend(int t) {
		Head = new Panel(Styles.PRIMARY);
		this.add(Head, BorderLayout.NORTH);
		Head.add(new Label(type.NORMAL, title[t]));

		this.add(Body, BorderLayout.CENTER);

		for (int i = 0; i < maxrow; i++) {
			for (int j = 0; j < 2; j++) {

			}
		}
	}
}
