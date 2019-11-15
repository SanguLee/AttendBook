package GUI.Setting;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public 
class GridBag extends Panel{
	private static final long serialVersionUID = 676976489761767857L;
	
	GridBagLayout grid = new GridBagLayout();
	GridBagConstraints con = new GridBagConstraints();
	int b = 0;
	
	public GridBag(int border) {
		this.b = border;
		this.setLayout(grid);
		con.weightx = 1.0;
		con.weighty = 1.0;
		con.fill=GridBagConstraints.BOTH;
	}
	
	public void addGrid(JComponent c, int x, int y, int w, int h) {
		c.setBorder(BorderFactory.createEmptyBorder(b, b, b, b));
		con.gridx = y;
		con.gridy = x;
		con.gridwidth = w;
		con.gridheight = h;
		this.add(c,con);
	}
}