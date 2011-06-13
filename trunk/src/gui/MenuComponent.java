package gui;

import javax.swing.JButton;
import javax.swing.JComponent;

public class MenuComponent extends JComponent{
	
	private static final long serialVersionUID = 1;
	
	private JButton b;
	
	public MenuComponent(){
		b = new JButton("Hi");
		b.setVisible(true);
	}
}
