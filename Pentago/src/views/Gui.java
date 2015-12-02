package views;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.Controller;
import models.Player;

public class Gui{
	private JPanel info;
	private JFrame main;
	private JPanel boardGui;
	private JPanel frame;
	private JPanel rotate;
	private Controller cont;
	private JButton[][] buttons;
	private JButton[] rotatebuttons;
	private GridBagConstraints c;
	private JButton endTurn;
	private String _size;
	
	public Gui(Controller con, String size){
		_size=size;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		main = new JFrame("Pentago");
		main.getContentPane().setLayout(new FlowLayout());
		info = new JPanel(new FlowLayout());
		boardGui = new JPanel(new GridBagLayout());
		endTurn = new JButton("Skip Rotate");
		c = new GridBagConstraints();		
		cont = con;
	    frame = new JPanel(new GridLayout(6,6));
	    rotate = new JPanel(new GridLayout(2,4));
	    buttons = new JButton[6][6];
	    rotatebuttons = new JButton[8];
	    endTurn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				if(cont.isNeutral()){
    					cont.dummyRotate();
    				}
    				else{
    					JOptionPane.showMessageDialog(frame,"As there is not a neutral board, you need to rotate before you can end your turn.");
    				}
    				
    			}
    		});
	    rotatebuttons[0] = new JButton(new ImageIcon("src/Icons/"+size+"/arrowtopleft.jpg")); 
		rotatebuttons[0].setBorder(BorderFactory.createEmptyBorder());
		rotatebuttons[0].setContentAreaFilled(false);
		rotatebuttons[1] = new JButton(new ImageIcon("src/Icons/"+size+"/arrowsidelefttop.jpg")); 
		rotatebuttons[1].setBorder(BorderFactory.createEmptyBorder());
		rotatebuttons[1].setContentAreaFilled(false);
		rotatebuttons[2] = new JButton(new ImageIcon("src/Icons/"+size+"/arrowsiderighttop.jpg")); 
		rotatebuttons[2].setBorder(BorderFactory.createEmptyBorder());
		rotatebuttons[2].setContentAreaFilled(false);
		rotatebuttons[3] = new JButton(new ImageIcon("src/Icons/"+size+"/arrowright.jpg")); 
		rotatebuttons[3].setBorder(BorderFactory.createEmptyBorder());
		rotatebuttons[3].setContentAreaFilled(false);
		rotatebuttons[4] = new JButton(new ImageIcon("src/Icons/"+size+"/arrowbottomleft.jpg")); 
		rotatebuttons[4].setBorder(BorderFactory.createEmptyBorder());
		rotatebuttons[4].setContentAreaFilled(false);
		rotatebuttons[5] = new JButton(new ImageIcon("src/Icons/"+size+"/arrowsideleftbottom.jpg")); 
		rotatebuttons[5].setBorder(BorderFactory.createEmptyBorder());
		rotatebuttons[5].setContentAreaFilled(false);
		rotatebuttons[6] = new JButton(new ImageIcon("src/Icons/"+size+"/arrowsiderightbottom.jpg")); 
		rotatebuttons[6].setBorder(BorderFactory.createEmptyBorder());
		rotatebuttons[6].setContentAreaFilled(false);
		rotatebuttons[7] = new JButton(new ImageIcon("src/Icons/"+size+"/arrowbottomright.jpg")); 
		rotatebuttons[7].setBorder(BorderFactory.createEmptyBorder());
		rotatebuttons[7].setContentAreaFilled(false);
	    
	    rotatebuttons[0].addActionListener(new ActionListener() {
	    		public void actionPerformed(ActionEvent e) {
	    				cont.rotate('a',true);
	    			
	    		}});
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 2;
	    c.gridy = 0;
	    c.insets = new Insets(0,110,0,0);
	    boardGui.add(rotatebuttons[0],c);
	    c.insets = new Insets(0,0,0,0);
	    rotatebuttons[1].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('a',false);
    			}
    		});
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 1;
	    c.insets = new Insets(90,0,0,0);
	    boardGui.add(rotatebuttons[1],c);
	    c.insets = new Insets(0,0,0,0);
	    rotatebuttons[2].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('b',true);
    			}
    		});
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 5;
	    c.gridy = 1;
	    c.insets = new Insets(90,0,0,0);
	    boardGui.add(rotatebuttons[2],c);
	    c.insets = new Insets(0,0,0,0);
	
	    rotatebuttons[3].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('b',false);
    			}
    		});
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 4;
	    c.gridy = 0;
	    c.insets = new Insets(0,110,0,0);
	    boardGui.add(rotatebuttons[3],c);
	    c.insets = new Insets(0,0,0,0);
	    rotatebuttons[4].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('c',false);
    			}
    		});
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 2;
	    c.gridy = 5;
	    c.insets = new Insets(0,110,0,0);
	    boardGui.add(rotatebuttons[4],c);
	    c.insets = new Insets(0,0,0,0);
	    rotatebuttons[5].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('c',true);
    			}
    		});
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 0;
	    c.gridy = 4;
	    c.insets = new Insets(50,0,0,0);
	    boardGui.add(rotatebuttons[5],c);
	    c.insets = new Insets(0,0,0,0);
	    rotatebuttons[6].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('d',false);
    			}
    		});
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 5;
	    c.gridy = 4;
	    c.insets = new Insets(50,0,0,0);
	    boardGui.add(rotatebuttons[6],c);
	    c.insets = new Insets(0,0,0,0);
	    rotatebuttons[7].addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    				cont.rotate('d',true);
    			}
    		});
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.gridx = 4;
	    c.gridy = 5;
	    c.insets = new Insets(0,110,0,0);
	    boardGui.add(rotatebuttons[7],c);
	    c.insets = new Insets(0,0,0,0);
	    for(int i = 0;i < buttons[0].length;i++){
	    	for(int j = 0;j<buttons.length;j++){
	    		int x = i;
	    		int y = j;
	    		
	    		
	    		if((x==0&&y==0)||(x==3&&y==0)||(x==0&&y==3)||(x==3&&y==3)){
	    			buttons[i][j] = new JButton(new ImageIcon("src/Icons/"+size+"/topleftempty.jpg")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    		
	    		}
	    		else if((x==0&&y==2)||(x==0&&y==5)||(x==3&&y==2)||(x==3&&y==5)){
	    			buttons[i][j] = new JButton(new ImageIcon("src/Icons/"+size+"/toprightempty.jpg")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    		
	    		}
	    		else if((x==2&&y==0)||(x==2&&y==3)||(x==5&&y==0)||(x==5&&y==3)){
	    			buttons[i][j] = new JButton(new ImageIcon("src/Icons/"+size+"/bottomleftempty.jpg")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    		
	    		}
	    		else if((x==2&&y==2)||(x==2&&y==5)||(x==5&&y==2)||(x==5&&y==5)){
	    			buttons[i][j] = new JButton(new ImageIcon("src/Icons/"+size+"/bottomrightempty.jpg")); 
	    			buttons[i][j].setBorder(BorderFactory.createEmptyBorder());
	    			buttons[i][j].setContentAreaFilled(false);
		    		buttons[i][j].addActionListener(new ActionListener() {
		    		public void actionPerformed(ActionEvent e) {
		    				cont.place(x,y,getPlayersColor());
		    			}
		    		});
		    		
	    		}
	    		else{
	    			buttons[i][j] = new JButton(new ImageIcon("src/Icons/"+size+"/middleempty.jpg")); 
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
	    c.fill = GridBagConstraints.HORIZONTAL;
	    c.insets = new Insets(0,0,0,0);
	    c.gridx = 1;
	    c.gridy = 1;
	    c.gridheight = 4;
	    c.gridwidth = 4;
	    boardGui.add(frame,c);
	    boardGui.setBackground(Color.white);
	    info.add(endTurn);
	    main.add(info);
	    main.add(boardGui);
	 
	    // set up the jframe, then display it
	    main.setBackground(Color.WHITE);
	    main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/topleftgray.jpg")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/topleftblack.jpg")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/topleftempty.jpg")));
		    			}
		    		}
		    		else if((i==0&&j==2)||(i==0&&j==5)||(i==3&&j==2)||(i==3&&j==5)){
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/toprightgray.jpg")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/toprightblack.jpg")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/toprightempty.jpg")));
		    			}
			    		
		    		}
		    		else if((i==2&&j==0)||(i==2&&j==3)||(i==5&&j==0)||(i==5&&j==3)){
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/bottomleftgray.jpg")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/bottomleftblack.jpg")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/bottomleftempty.jpg")));
		    			}
			    		
		    		}
		    		else if((i==2&&j==2)||(i==2&&j==5)||(i==5&&j==2)||(i==5&&j==5)){
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/bottomrightgray.jpg")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/bottomrightblack.jpg")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/bottomrightempty.jpg")));
		    			}
			    		
		    		}
		    		else{
		    			if(bigBoard[i][j] == 1){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/middlegray.jpg")));
		    			}
		    			else if(bigBoard[i][j] == 2){
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/middleblack.jpg")));
		    			}
		    			else{
		    				buttons[i][j].setIcon((new ImageIcon("src/Icons/"+_size+"/middleempty.jpg")));
		    			}
			    	}
				}
			}
			endTurn.setEnabled(cont.isNeutral());
			boardGui.revalidate();
			boardGui.repaint();
			
		}
		public void endGame(Player p) {
			String verb = "";
			if(p.getName().equals("You")){
				verb = "have";
			}
			else{
				verb="has";
			}
			JFrame end_game = new JFrame("Game Over");
			end_game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			JPanel pane = new JPanel();
			pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
			JButton play = new JButton("Play Again");
			JButton end = new JButton("Exit");
			play.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					end_game.dispose();
					main.dispose();
					cont.launchMenu();
				}
				
			});
			end.addActionListener( new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
					
				}
				
			});
			JLabel message = new JLabel(p.getName()+ " " + verb+ " won");
			message.setAlignmentX(Container.CENTER_ALIGNMENT);
			play.setAlignmentX(Container.CENTER_ALIGNMENT);
			end.setAlignmentX(Container.CENTER_ALIGNMENT);
			pane.add(message);
			pane.add(play);
			pane.add(end);
			end_game.add(pane);
			end_game.setBounds(0, 0, 400, 150);
			end_game.setLocationRelativeTo(main);
			end_game.setAlwaysOnTop(true);
			end_game.setVisible(true);
			
		}
	}
	
