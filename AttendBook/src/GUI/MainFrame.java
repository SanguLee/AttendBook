package GUI;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame() {
		Showing();
	}
	public void Showing() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(960,640);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
