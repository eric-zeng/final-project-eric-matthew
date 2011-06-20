package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class menuPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JButton b;
	private JButton b2;
	private JComponent c;
	private JTextField text;
	private int ballNum;
	private JTextField staticText;
	private JTextField staticText2;
	private JTextField text2;
	private int ballNum2;

	private JTextField ballCounter;

	private JCheckBox colButton;

	private JButton b3;

	private JTextField staticText3;

	private JTextField staticText4;

//	private JTextField collision;
	//private JButton b3;
	
	public menuPanel(JComponent comp){
		ballNum = 1;
		ballNum2 = 1;
		c = comp;
		
		ballCounter = new JTextField("Total Balls: " + ((DrawComponent)c).getTotalBalls(), 10);
		ballCounter.setEditable(false);
		
		/*b = new JButton("Add more balls!!!");
		add(b);
		b.addActionListener(this);
		b.setActionCommand("addBalls");
		
		b2 = new JButton("Remove balls!!!");
		add(b2);
		b2.addActionListener(this);
		b2.setActionCommand("removeBalls"); */
		
		staticText = new JTextField("Create balls", 7);
		staticText.setEditable(false);
		add(staticText);
		
		text = new JTextField("1",6);
		text.setEditable(true);
		add(text);
		text.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	try{
            		ballNum = Integer.parseInt(text.getText());
            		if(((DrawComponent)c).getTotalBalls() + ballNum < 500){
            			((DrawComponent)c).addBalls(ballNum);
                		ballCounter.setText("Total Balls: " + ((DrawComponent)c).getTotalBalls());
					}else{
						text.setText("" + 1);
					}
            	}catch(NumberFormatException derp){
            		text.setText("" + ballNum);
            	}
            }
		});
		
		staticText2 = new JTextField("Remove Balls", 7);
		staticText2.setEditable(false);
		add(staticText2);
		
		text2 = new JTextField("1",6);
		text2.setEditable(true);
		add(text2);
		text2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
	            try{
					ballNum2 = Integer.parseInt(text2.getText());
	            	((DrawComponent)c).removeBalls(ballNum2);
	            	ballCounter.setText("Total Balls: " + ((DrawComponent)c).getTotalBalls());
	            }catch(NumberFormatException derp){
            		text2.setText("" + ballNum2);
            	}
            }
		});
		
	
		
		add(ballCounter);
		
		/*collision = new JTextField("Collision", 10);
		collision.setEditable(false);
		add(collision);*/
		
		colButton = new JCheckBox("Collision");
		colButton.setSelected(false);
		colButton.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
			    Object source = e.getItemSelectable();
			    if (source == colButton) {
			        ((DrawComponent)c).setCol(!((DrawComponent)c).getCol());
			    }
			}
		});
		add(colButton);
		
		b3 = new JButton("Remove all balls");
		add(b3);
		b3.addActionListener(this);
		b3.setActionCommand("removeAll");
		
		staticText3 = new JTextField("Left click to add one ball", 12);
		staticText3.setEditable(false);
		add(staticText3);
		staticText4 = new JTextField("Right click to add 25 balls", 13);
		staticText4.setEditable(false);
		add(staticText4);
		
		b2 = new JButton("Make Happiness!!!");
		add(b2);
		b2.setEnabled(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if("addBalls".equals(e.getActionCommand())){
			((DrawComponent) c).addBalls(ballNum);
		}else if("removeBalls".equals(e.getActionCommand())){
			((DrawComponent) c).removeBalls(ballNum);
		}else if("removeAll".equals(e.getActionCommand())){
			((DrawComponent) c).removeBalls(((DrawComponent)c).getTotalBalls());
			ballCounter.setText("Total Balls: " + ((DrawComponent)c).getTotalBalls());
		}
		
	}
	
	public void rightClickAdd(){
		ballCounter.setText("Total Balls: " + ((DrawComponent)c).getTotalBalls());
	}
}
