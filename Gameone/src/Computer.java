import java.awt.Color;
import java.awt.Graphics;
import java.time.Year;
 

public class Computer {
	Pong pong; 
	GamePanel field; 
	private int y = pong.Window_height/2; 
	private int yVelocity = 0; 
	private int width = 10;  
	private int height = 40;
	private int x = 55; 
	private int computerScore;
   
	
	public Computer(GamePanel game){
		this.field = game; 
		
	}
	
	public void updatePlayer(){
		
		
		
		if(field.returnBall().getBollYvalue() < this.y){
			yVelocity = -1; 
		}
		else if(field.returnBall().getBollYvalue()> this.y){
			yVelocity = +1; 
			
		}
		y = y + yVelocity;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.white);
		g.fillRect(pong.Window_width - (x- width), y, width, height);
	
	}
	
	
	
   public int getX(){
	   return pong.Window_width-(x-width) ; 
   }
   public int getY(){
	   return y; 
   }

   
   public int getWidth(){
	   return this.width; 
   }
   
   public int getHeight(){
	   return this.height; 
   }
   public int returnComputerScore(){
	   return computerScore;
   }

}
