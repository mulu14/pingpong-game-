import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

    
public class Ball {
	Pong pong; 
	
	private Color color; 
	private int x = pong.Window_width/2; 
	private int y  = pong.Window_height/2;
	public int size = 5; 
	private int xVelocity = 2; 
	private int yVelocity = 2;
	private int playerScore ;
	private int computerScore ;
	Sound sound = new Sound(); 
	
	public void update() {
		
		x += xVelocity; 
		y += yVelocity;  
		
		if(x + size < 0){
			xVelocity +=  2; 
			this.computerScore ++;
			
		}
		else if(x + size > pong.Window_width){
			xVelocity -= 2; 
			this.playerScore ++;
		
		}
		
		if(y + size < 0){
			yVelocity += 2; 
		}
		else if(y + size> pong.Window_height){
			yVelocity -= 2; 
			
			if (this.returnPlayerScore() == 10){
				 JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
				 this.computerScore = 0; 
				 this.playerScore = 0;
			}
	           
	        else if (this.returnComputerScore() == 10){
	            JOptionPane.showMessageDialog(null, "Computer wins", "Pong", JOptionPane.PLAIN_MESSAGE);
	            this.computerScore = 0; 
				this.playerScore = 0;
	        }
		}
	} 
	
	public void paint(Graphics g){
		g.setColor(Color.WHITE);
		g.fillOval(x, y, size, size);
		g.dispose();
	}
	
	public int getBollXvalue(){
		return x;
	}
	
	public int returnPlayerScore(){
		return this.playerScore;
	}
	
	public int returnComputerScore(){
		return this.computerScore;
	}
	
	public int getBollYvalue(){
		return y; 
	}
	
	public int getbollSize(){
		return this.size; 
	}

	public void reverseDirection(){
		
		xVelocity = -xVelocity; 
	}
	
	public void checkCollision(Player player){
		if(this.x > player.getX() && this.x < player.getX() + player.getWidth()){
			if(this.y >player.getY() && this.y < player.getY() + player.getHeight()){
		     
			  reverseDirection(); 
			  sound.playMusic();
			}
		
		}
		
			
	}
	

	
	public void checkCollision(Computer cpu){
		
		if(this.x > cpu.getX() && this.x < cpu.getX() + cpu.getWidth()){
			if(this.y >cpu.getY() && this.y < cpu.getY() + cpu.getHeight()){
		     
			  reverseDirection(); 
			 sound.playMusic();
			  
			}
		}
		
	}
}
