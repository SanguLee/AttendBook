package GUI.Contents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import GUI.Setting.GridBag;
import GUI.Setting.Label;
import GUI.Setting.Panel;
import GUI.Setting.Styles;

public class AttendPanel extends Content {
	private static final long serialVersionUID = -1280465224088539851L;

	@Override
	void setHead() {
		head.add(new JButton("제 ㅡ 목"), BorderLayout.CENTER);
	}

	@Override
	void setBody() {
		// TODO Auto-generated method stub
		GridBag grid = new GridBag(10);
		JButton[] b = new JButton[7];

		for (int i = 0; i < 7; i++) {
			b[i] = new JButton(i + "");

			if (i < 5) {
				// 1,2,3 학년, 새신자, 교사
				grid.addGrid(new Attend(i, null), i / 4, i % 4, 1, 1);
			}
			if (i == 5) {
				grid.addGrid(b[i], i / 4, i % 4, 1, 1);
			}
			if (i == 6) {
				grid.addGrid(b[i], i / 4, i % 4, 2, 1);
			}
			if (i == 7) {
				// do nothing in here
			}
		}

		body.add(grid, BorderLayout.CENTER);
	}
}

class Attend extends Panel {
	private static final long serialVersionUID = 2022117008532120900L;

	static final int maxcol = 2;
	static final int maxrow = 8;

	public static final String[] titles = { "1학년", "2학년", "3학년", "새신자", "교사" };
	public static final String[] sexs = { "남자", "여자" };

	GridBag head;
	Panel title;
	Panel[] sex = new Panel[maxcol];
	Panel body;
	Panel[][] field = new Panel[maxcol][maxrow];

	public Attend(int t, String[] names) {
		int b = 1;
		LineBorder border = new LineBorder(Panel.MENU, b);
		this.setBorder(border);

		// 헤드 ( 타이틀 ) 설정
		head = new GridBag(b);

		title = new Panel(Panel.TITLE);
		title.add(new Label(Label.PRIMEFONT, Label.SMALL, titles[t]));
		title.setBorder(border);
		head.addGrid(title, 0, 0, 2, 1);

		for (int i = 0; i < maxcol; i++) {
			sex[i] = new Panel(Panel.TITLE);
			sex[i].add(new Label(Label.PRIMEFONT, Label.SMALL, sexs[i]));
			sex[i].setBorder(border);
			head.addGrid(sex[i], 1, i, 1, 1);
		}

		this.add(head, BorderLayout.NORTH);

		// 바디 ( 필드값 ) 설정
		body = new Panel();
		body.setLayout(new GridLayout(maxrow, maxcol));

		for (int i = 0; i < maxcol; i++) {
			for (int j = 0; j < maxrow; j++) {
				Panel tmp;
				// row 배열 설정
				tmp = new Panel(Panel.WHITE);

				if (names != null && j < names.length)
					tmp.add(new Label(Label.NORMALFONT, Label.SMALL, names[j]), BorderLayout.CENTER);

				else
					tmp.add(new Label(Label.NORMALFONT, Label.SMALL, "\t"), BorderLayout.CENTER);

				tmp.add(new JCheckBox(), BorderLayout.EAST);

				tmp.setBorder(border);
				body.add(tmp);
			}
		}
		body.setBorder(border);
		this.add(body, BorderLayout.CENTER);
	}
}

class Sum extends Panel {
	public Sum() {

	}
}
