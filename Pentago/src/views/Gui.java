package views;

import controller.Controller;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javax.swing.JButton;
import javax.swing.JTextField;

@SuppressWarnings("unused")
public class Gui extends Frame{
		private Controller _cont;
	
		public Gui(Controller c) {
			     //Title our frame.
			    super("Pentago");
			    _cont =c;
			    setSize(400,300);
			    setVisible(true);
			    addWindowListener(new WindowAdapter()
			    		      {public void windowClosing(WindowEvent e)
			    		          {dispose(); System.exit(0);}
			    		       }
			    		     );
		}
		public void paint(Graphics g) {
			/*g.setColor(Color.red);
			g.drawRect(50,50,200,200);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setColor(Color.blue);
			g2d.drawRect(75,75,300,200);*/
			JTextField onePlayer = new JTextField("One Player");
			JTextField twoPlayer = new JTextField("Two Players");
			onePlayer.addActionListener(new ActionListener() { 
			    public void actionPerformed(ActionEvent e) { 
			    	
			    } 
			});
			twoPlayer.addActionListener(new ActionListener() { 
			    public void actionPerformed(ActionEvent e) { 
			        
			    } 
			});
		}
}
