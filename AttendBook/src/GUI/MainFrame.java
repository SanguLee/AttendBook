package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.Setting.Panel;

public class MainFrame extends JFrame{
	static Dimension[] scale = {new Dimension(960,640), new Dimension(1280,720), new Dimension(1920,1080)};
	
	Panel title = new Panel(Panel.type.PRIME);
	Panel menubar = new Panel(Panel.type.SECOND);
	Panel content = new Panel(Panel.type.BACK);
	
	JLabel titlename = new JLabel();
	
	public MainFrame() {
		setBorder();
		Showing();
	}
	public void Showing() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(scale[1]);
		setVisible(true);
	}
	
	public void setBorder() {
		this.setLayout(new BorderLayout());
		
		this.add(title, BorderLayout.NORTH);
		title.setPreferredSize(new Dimension(0,40));

		title.add(titlename);
		titlename.setText("출석 관리");
		
		
		this.add(menubar, BorderLayout.WEST);
		menubar.setPreferredSize(new Dimension(120,0));
		
		
		
		this.add(content, BorderLayout.CENTER);
		content.setLayout(new BorderLayout());
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
