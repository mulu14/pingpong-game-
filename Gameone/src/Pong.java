
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pong extends JFrame implements ActionListener {
	private JFrame frame;
	GamePanel p;
	Sound sound;
	Ball ball; 
	Player player = new Player(); 
	Computer computer; 
	
    final static int Window_width = 407; 
	final static int Window_height  = 283;
	   
	
	   

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Pong(){
	    frame =  new JFrame();
		p = new GamePanel();
		//JButton start = new JButton("Start game");
		frame.setSize(Window_width, Window_height);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(p);
		//frame.add(start);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	


		
		

	
	
	
	
	public static void main(String [] args){
		
		Pong pong = new Pong(); 
		
		
	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}




}
