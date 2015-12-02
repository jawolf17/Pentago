/**
 * New Launcher for Pentago. Improved Layout and Feel
 */
package views;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.*;
import controller.Controller;
import java.awt.event.ActionEvent;

public class NiceMenu {
	private Controller _cont;
	private JFrame _frame;
	private JTabbedPane _tabbedPane;
	private String _scale;

	public NiceMenu(Controller c,String size){
		_scale=size;
		_cont=c;
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_frame = new JFrame("Pentago");
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.add(new JPanel());
		_frame.getContentPane().setLayout(new BoxLayout(_frame.getContentPane(), BoxLayout.Y_AXIS));
		try {
			BufferedImage image = ImageIO.read(new File("src/logo.png"));
			JLabel image_pane = new JLabel(new ImageIcon(image));
			_frame.add(image_pane);
		} catch (IOException e) {
			//Carry on
		}
		_tabbedPane = new JTabbedPane();
		_frame.add(_tabbedPane);
		addComponents();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		_frame.setLocation(dim.width/5, dim.height/5);
		_frame.setSize(900,400);
		_frame.setVisible(true);
	}
	
	/**
	 * Adds components to the main JFrame
	 */
	private void addComponents(){
		 _tabbedPane.addTab("1-Player",createSinglePanel());
		 _tabbedPane.addTab("2-Player", createNameEntry());
		 _tabbedPane.addTab("Options",createOptionsTab());
		 _tabbedPane.addTab("Rules", createRuleTab());
	}
	
	/**
	 * Creates the panel for the Single Player Options
	 * @return JPanel 
	 */
	private JPanel createSinglePanel(){
		JPanel panel = new JPanel(new FlowLayout());
		String[] diff = {"Easy","Medium","Hard"};
		JComboBox<String> aiSelect = new JComboBox<String>(diff);
		JButton play = new JButton("PLAY!");
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String diff = aiSelect.getItemAt(aiSelect.getSelectedIndex());	
				_cont.createGame("You","CPU"+diff,_scale);
				_frame.dispose();	
			}
			
		});
		panel.add(aiSelect);
		panel.add(play);
		return panel;
	}
	
	/**
	 * Creates the panel for the Two Player Options
	 * @return JPanel 
	 */
	private JPanel createNameEntry(){
		JPanel panel = new JPanel(new FlowLayout());
		JTextField player1 = new JTextField("Player 1");
		player1.setColumns(20);
		player1.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				player1.selectAll();		
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(player1.getText().equals("")){
					player1.setText("Player 1");
				}
			}
	     });
		JTextField player2 = new JTextField("Player 2");
		player2.setColumns(20);
		player2.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				player2.selectAll();		
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(player2.getText().equals("")){
					player2.setText("Player 2");
				}
			}
			
		});
		JButton play = new JButton("PLAY!");
		play.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_cont.createGame(player1.getText(),player2.getText(),_scale);
				_frame.dispose();
			}
			
		});
		panel.add(player1);
		panel.add(player2);
		panel.add(play);
		
		return panel;
	}
	
	/**
	 * Creates the panel for the rule tab
	 * @return JPanel
	 */
	private JPanel createRuleTab(){
		JPanel rules = new JPanel();
		JButton button = new JButton("Rules");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(_frame, "Pshhhh you think we would tell YOU how to play");				
			}
			
		});
		rules.add(button);
		return rules;
	}
	
	/**
	 * Creates the panel for the option tab
	 * @return  JPanel
	 */
	private JPanel createOptionsTab(){
		JPanel options = new JPanel();
		options.setLayout(new FlowLayout());
		JLabel option_set= new JLabel("GUI Size");
		options.add(option_set);
		String[] sizes = {"Small","Medium","Large"};
		JComboBox<String> scale = new JComboBox<String>(sizes);
		options.add(scale);
		JButton set = new JButton("Set");
		set.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				_scale = scale.getItemAt(scale.getSelectedIndex()).toLowerCase();
				try {
					PrintWriter write = new PrintWriter("src/settings.ptg","UTF-8");
					write.println(_scale);
					write.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		options.add(set);
		
		return options;
	}
}

