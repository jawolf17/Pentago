package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	    rotatebuttons[0] = new JButton("Rotate Top-Left Quadrant right");
	    rotatebuttons[1] = new JButton("Rotate Top-Left Quadrant left");
	    rotatebuttons[2] = new JButton("Rotate Top-right Quadrant right");
	    rotatebuttons[3] = new JButton("Rotate Top-right Quadrant left");
	    rotatebuttons[4] = new JButton("Rotate Bottom-Left Quadrant right");
	    rotatebuttons[5] = new JButton("Rotate Bottom-Left Quadrant left");
	    rotatebuttons[6] = new JButton("Rotate Bottom-right Quadrant right");
	    rotatebuttons[7] = new JButton("Rotate Bottom-right Quadrant left");
	    
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
	    		
	    		
	    		if((x==0&&y==0)||(x==3&&y==0)||(x==0&&y==3)||(x==3&&y==3)){
	    			buttons[i][j] = new JButton(new ImageIcon("src/topleftempty.png")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    		
	    		}
	    		else if((x==0&&y==2)||(x==0&&y==5)||(x==3&&y==2)||(x==3&&y==5)){
	    			buttons[i][j] = new JButton(new ImageIcon("src/toprightempty.png")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    		
	    		}
	    		else if((x==2&&y==0)||(x==2&&y==3)||(x==5&&y==0)||(x==5&&y==3)){
	    			buttons[i][j] = new JButton(new ImageIcon("src/bottomleftempty.png")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    		
	    		}
	    		else if((x==2&&y==2)||(x==2&&y==5)||(x==5&&y==2)||(x==5&&y==5)){
	    			buttons[i][j] = new JButton(new ImageIcon("src/bottomrightempty.png")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    		
	    		}
	    		else{
	    			buttons[i][j] = new JButton(new ImageIcon("src/middleempty.png")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    	}
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
	    main.setPreferredSize(new Dimension(340, 600));
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
		    		if((i==0&&j==0)||(i==3&&j==0)||(i==0&&j==3)||(i==3&&j==3)){
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/topleftgray.png")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/topleftblack.png")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/topleftempty.png")));
		    			}
		    		}
		    		else if((i==0&&j==2)||(i==0&&j==5)||(i==3&&j==2)||(i==3&&j==5)){
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/toprightgray.png")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/toprightblack.png")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/toprightempty.png")));
		    			}
			    		
		    		}
		    		else if((i==2&&j==0)||(i==2&&j==3)||(i==5&&j==0)||(i==5&&j==3)){
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/bottomleftgray.png")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/bottomleftblack.png")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/bottomleftempty.png")));
		    			}
			    		
		    		}
		    		else if((i==2&&j==2)||(i==2&&j==5)||(i==5&&j==2)||(i==5&&j==5)){
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/bottomrightgray.png")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/bottomrightblack.png")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/bottomrightempty.png")));
		    			}
			    		
		    		}
		    		else{
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/middlegray.png")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/middleblack.png")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/middleempty.png")));
		    			}
			    	}
				}
			}
			main.revalidate();
			main.repaint();
			
		}
	}
	
