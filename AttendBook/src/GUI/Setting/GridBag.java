package GUI.Setting;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public 
class GridBag extends Panel{
	private static final long serialVersionUID = 676976489761767857L;
	
	GridBagLayout grid = new GridBagLayout();
	GridBagConstraints con = new GridBagConstraints();
	
	public GridBag() {
		this.setLayout(grid);
		con.weightx = 1.0;
		con.weighty = 1.0;
		con.fill=GridBagConstraints.BOTH;
	}
	
	public void addGrid(Component c, int x, int y, int w, int h) {
		con.gridx = y;
		con.gridy = x;
		con.gridwidth = w;
		con.gridheight = h;
		this.add(c,con);
	}
}