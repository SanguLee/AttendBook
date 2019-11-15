package GUI.Contents;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

import GUI.Setting.GridBag;
import GUI.Setting.Label;
import GUI.Setting.Panel;
import GUI.Setting.Styles;

public class AttendPanel extends Content {
	private static final long serialVersionUID = -1280465224088539851L;

	@Override
	void setHead() {
		// TODO Auto-generated method stub
		head.add(new JButton("제 ㅡ 목"), BorderLayout.CENTER);
	}

	@Override
	void setBody() {
		// TODO Auto-generated method stub
		GridBag grid = new GridBag(6);
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

	Panel Head;
	Panel Body;

	Panel[] Bodies = new Panel[2];

	public static final String[] title = { "1학년", "2학년", "3학년", "새신자", "교사" };
	public static final String[] sex = { "남자", "여자" };

	Panel[] cols = new Panel[maxcol];
	Panel[][] rows = new Panel[maxcol][maxrow];

	static final int maxcol = 2;
	static final int maxrow = 8;

	public Attend(int t, String[] names) {

		// 헤드 ( 타이틀 ) 설정
		Head = new Panel(Panel.TITLE);
		this.add(Head, BorderLayout.NORTH);

		Head.add(new Label(Label.PRIMEFONT, Label.SMALL, title[t]));

		// 바디 ( 필드값) 설정
		Body = new Panel();
		Body.setLayout(new GridLayout(1, 2));
		this.add(Body, BorderLayout.CENTER);

		// 바디즈 ( 필드 2개 ) 설정
		for (int i = 0; i < maxcol; i++) {
			Bodies[i] = new Panel();
			Bodies[i].setLayout(new GridLayout(maxrow + 1, 1));
			Body.add(Bodies[i]);

			// 컬럼 ( 남녀 ) 설정
			cols[i] = new Panel(Panel.TITLE);
			cols[i].add(new Label(Label.PRIMEFONT, Label.SMALL, sex[i]));

			Bodies[i].add(cols[i]);

			// 로우 ( 필드 ) 설정
			for (int j = 0; j < maxrow; j++) {
				rows[i][j] = new Panel(Panel.WHITE);
				rows[i][j].setBorder(new EmptyBorder(3, 3, 3, 3));

				if (names!=null &&  j < names.length) {
					rows[i][j].add(new Label(Label.NORMALFONT, Label.SMALL, names[j]), BorderLayout.CENTER);
					rows[i][j].add(new JCheckBox(), BorderLayout.EAST);
				} else
					rows[i][j].add(new Label(Label.NORMALFONT, Label.SMALL, "\t"), BorderLayout.CENTER);

				Bodies[i].add(rows[i][j]);
			}
		}
	}
}

class Sum extends Panel {
	public Sum() {

	}
}
