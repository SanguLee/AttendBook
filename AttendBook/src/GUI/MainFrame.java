package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.Setting.Label;
import GUI.Setting.Panel;
import GUI.Setting.Styles;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	static Dimension[] scale = { new Dimension(960, 640), new Dimension(1280, 960), new Dimension(1280, 720), new Dimension(1920, 1080) };

	Panel title = new Panel(Panel.type.BACK);
	Panel menubar = new Panel(Panel.type.PRIME);
	Panel content = new Panel(Panel.type.BACK);

	Label titlename = new Label(Label.type.BACK, 21);

	static int state = 0;

	MenuButton[] menu = { new MenuButton("�⼮ ����"), new MenuButton("�ο� ����"), new MenuButton("��� �ڷ�"), };

	public MainFrame() {
		setBorder();

		Showing();
	}

	public void Showing() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setUndecorated(true);
		setSize(scale[2]);
		setVisible(true);
	}

	public void setBorder() {
		this.setLayout(new BorderLayout());

		// ���� �޴� �� �����
		this.add(menubar, BorderLayout.WEST);
		menubar.setPreferredSize(new Dimension(180, 0));
		setMenubar();
		
		// ��� ������ ���������
		this.add(content, BorderLayout.CENTER);
		content.setLayout(new BorderLayout());
		setContent();

		// ��� Ÿ��Ʋ �� �����
		this.add(title, BorderLayout.NORTH);
		title.setPreferredSize(new Dimension(0, 40));
		title.setLayout(new BorderLayout());
		
		Panel none = new Panel(Panel.type.PRIME);
		none.setPreferredSize(new Dimension(180,0));
		title.add(none, BorderLayout.WEST);
		
		title.add(titlename, BorderLayout.CENTER);
		titlename.setText("�⼮ ���� ���α׷�");
		titlename.setHorizontalAlignment(JLabel.CENTER);
	}

	public void setMenubar() {
		menubar.setLayout(new GridLayout(8, 1));

		menubar.add(new Panel(Panel.type.PRIME));
		//menubar.add(new Panel(Panel.type.SECOND));
		// menubar.add(new Panel(Panel.type.BACK));
		for (MenuButton mb : menu) {
			menubar.add(mb);
		}
	}

	public void setContent() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}

class MenuButton extends JButton {
	private static final long serialVersionUID = -5569540577820539119L;
	boolean isClicked = false;

	public MenuButton(String n) {
		this.setBackground(Styles.PRIMARY);
		this.setForeground(Styles.PRIMEFONT);
		this.setBorder(new EmptyBorder(0, 0, 0, 0));
		// this.setFont(new Font(Styles.FONTNAME, Font.BOLD, 18));
		this.setText(n);
	}

	public void change() {
		if (!isClicked) { // �ȴ��ȴٰ� -> ����
			this.setBackground(Styles.BACKGROUND);
			this.setForeground(Styles.BACKFONT);
			isClicked = true;
		} else { // ���ȴٰ� -> �ȴ���
			this.setBackground(Styles.SECONDARY);
			this.setForeground(Styles.PRIMEFONT);
			isClicked = false;
		}
	}
}
