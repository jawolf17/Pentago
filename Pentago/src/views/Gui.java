package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.Controller;

public class Gui{
	private JFrame main;
	private JPanel frame;
	private JPanel rotate;
	private Controller cont;
	private JButton[][] buttons;
	private JButton[] rotatebuttons;
	public Gui(Controller con){
		main = new JFrame("Pentago");
		main.getContentPane().setLayout(new GridLayout(2,1));
		cont = con;
	    frame = new JPanel(new GridLayout(6,6));
	    rotate = new JPanel(new GridLayout(2,4));
	    buttons = new JButton[6][6];
	    rotatebuttons = new JButton[8];
	    rotatebuttons[0] = new JButton(">");
	    rotatebuttons[1] = new JButton("<");
	    rotatebuttons[2] = new JButton(">");
	    rotatebuttons[3] = new JButton("<");
	    rotatebuttons[4] = new JButton(">");
	    rotatebuttons[5] = new JButton("<");
	    rotatebuttons[6] = new JButton(">");
	    rotatebuttons[7] = new JButton("<");
	    
	    rotatebuttons[0].addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    				cont.rotate('a',false);
	    			}
	    		});
	    rotatebuttons[1].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('a',true);
    			}
    		});
	    rotatebuttons[2].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('b',false);
    			}
    		});
	    rotatebuttons[3].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('b',true);
    			}
    		});
	    rotatebuttons[4].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('c',false);
    			}
    		});
	    rotatebuttons[5].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('c',true);
    			}
    		});
	    rotatebuttons[6].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('d',false);
    			}
    		});
	    rotatebuttons[7].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('d',true);
    			}
    		});
	    for(int i = 0;i < buttons[0].length;i++){
	    	for(int j = 0;j<buttons.length;j++){
	    		int x = i;
	    		int y = j;
	    		buttons[i][j] = new JButton("0");
	    		buttons[i][j].addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    				cont.place(x,y,getPlayersColor());
	    			}
	    		});
	    		frame.add(buttons[i][j]);
	    	}
	    }
	    
	    // put the button on the frame
	   for(int l = 0;l<rotatebuttons.length;l++){
		   rotate.add(rotatebuttons[l]);
	   }
	   main.add(frame);
	   main.add(rotate);
	 
	    // set up the jframe, then display it
	    main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    main.setPreferredSize(new Dimension(300, 200));
	    main.pack();
	    main.setLocationRelativeTo(null);
	    main.setVisible(true);
	  }
		public int getPlayersColor(){
			return cont.getCurrentPlayer().getColor();
		}
		public void update(int[][] bigBoard) {
			for(int i = 0;i<bigBoard[0].length;i++){
				for(int j = 0;j<bigBoard.length;j++){
					buttons[i][j].setText(""+bigBoard[i][j]);
				}
			}
			main.revalidate();
			main.repaint();
			
		}
	}
	
