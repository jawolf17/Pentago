package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import controller.Controller;

public class Gui{
	private JFrame frame;
	private Controller cont;
	private JButton[][] buttons;
	public Gui(Controller con){
		cont = con;
	    frame = new JFrame("Pentago");
	    frame.getContentPane().setLayout(new GridLayout());
	    buttons = new JButton[6][6];
	    
	    for(int i = 0;i < buttons[0].length;i++){
	    	for(int j = 0;j<buttons.length;j++){
	    		int x = i;
	    		int y = j;
	    		buttons[i][j] = new JButton("0");
	    		buttons[i][j].addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    				cont.place(x,y,cont.getCurrentPlayer().getColor());
	    			}
	    		});
	    		frame.add(buttons[i][j]);
	    	}
	    }

	    // put the button on the frame
	   
	    
	 
	    // set up the jframe, then display it
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.setPreferredSize(new Dimension(300, 200));
	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
	  }
		public void update(int[][] bigBoard) {
			for(int i = 0;i<bigBoard[0].length;i++){
				for(int j = 0;j<bigBoard.length;j++){
					buttons[i][j].setText(""+bigBoard[i][j]);
				}
			}
			
		}
	}
	
