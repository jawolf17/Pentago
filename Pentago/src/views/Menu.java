package views;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

import controller.Controller;

import java.awt.event.ActionEvent;

public class Menu {
	private Controller con;
	public Menu(Controller c){
	  con = c;
      ButtonFrame frame = new ButtonFrame(con);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}

class ButtonFrame extends JFrame {

   private JTextField PlayerOne;// !! Make field private
   private JTextField PlayerTwo;
   private ButtonGroup cpu;
   private JRadioButton cpuEasy;
   private JRadioButton cpuMed;
   private JRadioButton cpuHard;
   
   public ButtonFrame(Controller con) {

      setTitle("Pentago");
      setSize(1500,200);
      
      ButtonPanel panel = new ButtonPanel(this,con);
      panel.add(new JLabel("Player 1:"));
      
      PlayerOne = new JTextField(40);
      cpu = new ButtonGroup();
      PlayerTwo = new JTextField(40);
      cpuEasy = new JRadioButton("CPU:Easy");
      cpuMed = new JRadioButton("CPU:Medium");
      cpuHard = new JRadioButton("CPU:Hard");
      cpu.add(cpuEasy);
      cpu.add(cpuMed);
      cpu.add(cpuHard);
      panel.add(PlayerOne);
      panel.add(new JLabel("Player 2:"));
      panel.add(PlayerTwo);
      panel.add(cpuEasy);
      panel.add(cpuMed);
      panel.add(cpuHard);
      cpuEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PlayerTwo.setText("CPU:Easy");
            }
      });
      cpuMed.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          	PlayerTwo.setText("CPU:Medium");
          }
    });
      cpuHard.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          	PlayerTwo.setText("CPU:Hard");
          }
    });
      add(panel, BorderLayout.CENTER);
   }

   // !! create a public method to get JTextField's text
   // !! without exposing the JTextField itself.
   public String getPlayerOneName() {
      return PlayerOne.getText();
   }
   public String getPlayerTwoName(){
	   return PlayerTwo.getText();
   }

   class ButtonPanel extends JPanel implements ActionListener {

      public ButtonPanel(Frame f, Controller con) {

         final JButton b2 = new JButton("Submit");
         add(b2, BorderLayout.SOUTH);
         b2.setActionCommand("Submit");
         b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // !! ButtonFrame bf = new ButtonFrame();
               if ("Submit".equals(e.getActionCommand())) {
            	   con.createGame(getPlayerOneName(),getPlayerTwoName());
            	   f.dispose();
                  
               }
            }

         });

      }

      @Override
      public void actionPerformed(ActionEvent ae) {
         throw new UnsupportedOperationException("Not supported yet.");
      }

   }
}
