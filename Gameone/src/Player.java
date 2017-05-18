import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ItemListener;


public class Player {
	private int y = Pong.Window_height/2; 
	private int yVelocity = 0; 
	private int width = 10;  
	private int height = 40;
	private int x = 35; 
	private int score;
	
	
	  
	public Player(){  
		
	} 
	
	public void updatePlayer(){
		
		y = y + yVelocity;
		
		
		if(y + height <=0){
			
			yVelocity += 1; 
		}
		else if(y + height >= Pong.Window_height){
			yVelocity -= 1; 
		}
	}
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	
	}
	
	public void setvelocity(int speed){
		this.yVelocity = speed; 
	}
	
   public int getX(){
	   return x; 
   }
   public int getY(){
	   return y; 
   }

   	public void playerHeight(int height){
   		this.height = height; 
   	}
   
   public int getWidth(){
	   return this.width; 
   }
   
   public int getHeight(){
	   return this.height; 
   }
   
   public void setHight(int height){
	   this.height = height; 
   }
   
   public int returnscore(){
	   return this.score;
   }

   }


