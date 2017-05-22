
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Pong extends JFrame {
	private JFrame frame;
	private static int instanceCounter = 0;
	Pong pong;
	GamePanel p;
    static int Window_width = 407; 
    static int Window_height  = 283;
	     
	
	   

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Pong(){
	    frame =  new JFrame();
		p = new GamePanel();
		frame.setSize(Window_width, Window_height);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(p);
		frame.setVisible(true);
		frame.setResizable(false);
	
		this.instanceCounter++;
		
		
	}
	
	
	public void setTonull(int instance){
		for(int i =1; i < instance; ++i){
			this.pong = null; 
		}
		System.gc();  
	}
	
	
	
	public int returnInstanceof(){
		return this.instanceCounter;
	}
   
	public void increaseJframesize(){
		Pong.Window_height = Pong.Window_height +20;
		Pong.Window_width = Pong.Window_width + 20;
	}
	public void decreaseJframesize(){
		Pong.Window_height = Pong.Window_height -20;
		Pong.Window_width = Pong.Window_width  -20;
	}
	
	

	public static void main(String [] args){
		
		Pong pong = new Pong(); 
		
		
	}


}
