package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import GUI.Contents.AttendPanel;
import GUI.Setting.Label;
import GUI.Setting.Panel;
import GUI.Setting.Styles;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	static Dimension[] scale = { new Dimension(960, 640), new Dimension(1280, 960), new Dimension(1280, 720),
			new Dimension(1920, 1080) };

	Panel title = new Panel(Panel.TITLE);
	Panel menubar = new Panel(Panel.MENU);
	Panel content = new Panel(Panel.BACK);

	Label titlename = new Label(Label.PRIMEFONT, Label.BIG, "�⼮ ���� ���α׷�");

	static int state = 0;

	MenuButton[] menu = { new MenuButton("�⼮ ����"), new MenuButton("�ο� ����"), new MenuButton("��� �ڷ�"), };

	public MainFrame() {
		setBorder();
		Showing();
	}

	public void Showing() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setUndecorated(true);
		setTitle("�⼮ ���α׷�");
		setSize(scale[2]);
		setVisible(true);
	}

	public void setBorder() {
		this.setLayout(new BorderLayout());

		// ��� Ÿ��Ʋ �� �����
		this.add(title, BorderLayout.NORTH);
		setTitle();

		// ���� �޴� �� �����
		this.add(menubar, BorderLayout.WEST);
		setMenubar();

		// ��� ������ ���������
		this.add(content, BorderLayout.CENTER);
		setContent();

	}

	public void setTitle() {
		title.setPreferredSize(new Dimension(0, 40));
		title.setLayout(new BorderLayout());

		// Panel none = new Panel(Panel.type.TITLE);
		// none.setPreferredSize(new Dimension(180,0));
		// title.add(none, BorderLayout.WEST);

		title.add(titlename, BorderLayout.CENTER);
		titlename.setHorizontalAlignment(JLabel.CENTER);
	}

	public void setMenubar() {
		menubar.setPreferredSize(new Dimension(180, 60));
		menubar.setLayout(new GridLayout(8, 1));

		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (MenuButton mb : menu) {
					mb.change(false);
					content.removeAll();
				}
				MenuButton mb = (MenuButton) e.getSource();
				mb.change(true);

				switch (mb.getText()) {
				case "�⼮ ����":
					content.add(new AttendPanel());
					break;
				case "�ο� ����":
					break;
				case "��� �ڷ�":
					break;
				}
				
				repaint();
				revalidate();
			}
		};

		for (MenuButton mb : menu) {
			menubar.add(mb);
			mb.addActionListener(al);
		}
	}

	public void setContent() {
		//content.add(c);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

}

class MenuButton extends JButton {
	private static final long serialVersionUID = -5569540577820539119L;

	public MenuButton(String n) {
		this.setBackground(Panel.MENU);
		this.setForeground(Label.PRIMEFONT);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		// this.setFont(new Font(Styles.FONTNAME, Font.BOLD, 18));
		this.setText(n);
	}

	public void change(boolean isClicked) {
		if (isClicked) {
			// ������ ��
			this.setBackground(Styles.SHADOW);
			this.setForeground(Label.BACKFONT);
		} else {
			// �ȴ����� ��
			this.setBackground(Panel.MENU);
			this.setForeground(Label.PRIMEFONT);
		}
	}
}
