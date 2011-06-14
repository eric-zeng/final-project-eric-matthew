package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
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
	private JButton b3;
	
	public menuPanel(JComponent comp){
		ballNum = 1;
		c = comp;
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
            	ballNum = Integer.parseInt(text.getText());
            	((DrawComponent)c).addBalls(ballNum);
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
            	ballNum2 = Integer.parseInt(text2.getText());
            	((DrawComponent)c).removeBalls(ballNum2);
            }
		});
		
		b3 = new JButton("Change Background Color");
		add(b3);
		b3.addActionListener(this);
		b3.setActionCommand("background");
		
		b2 = new JButton("Make Happiness!!!");
		add(b2);
		b2.setEnabled(false);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if("addBalls".equals(e.getActionCommand())){
			((DrawComponent) c).addBalls(ballNum);
		}else if("removeBalls".equals(e.getActionCommand())){
			((DrawComponent) c).removeBalls(ballNum);
		}else if("background".equals(e.getActionCommand())){
			((DrawComponent) c).removeBalls(ballNum);
		}
		
	}
	
}
