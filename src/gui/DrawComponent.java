package gui;

import java.util.ArrayList;

import javax.swing.JComponent;

import physicsSim.Thing;

public class DrawComponent extends JComponent{
	
	public void paintComponent(ArrayList<Thing> things){
		for(Thing t : things){
			int x = t.getPoint().x;
			int y = t.getPoint().y;
		}
	}

}
