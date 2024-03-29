package GUI.Contents;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import GUI.Setting.Panel;

public abstract class Content extends Panel {
	private static final long serialVersionUID = -1801618486491267486L;

	protected Panel head = new Panel();
	protected Panel body = new Panel();

	public Content() {
		this.setBackground(Panel.BACK);
		//this.setLayout(new BorderLayout());

		head.setPreferredSize(new Dimension(0, 120));

		this.add(head, BorderLayout.NORTH);
		this.add(body, BorderLayout.CENTER);

		head.setLayout(new BorderLayout());
		body.setLayout(new BorderLayout());

		head.setBorder(BorderFactory.createEmptyBorder(20, 30, 10, 30));
		body.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
		
		setHead();
		setBody();
	}

	abstract void setHead();

	abstract void setBody();
}
