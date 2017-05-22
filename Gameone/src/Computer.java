import java.awt.Color;
import java.awt.Graphics;
import java.time.Year;
 

public class Computer {
    Pong pong; 
    GamePanel field; 
    private int y = pong.Window_height/2; 
    private int yVelocity = 2; 
    private int width = 10;  
    private int height = 40;
    private int x = 55; 
    private int computerScore;
    
    
    public Computer(GamePanel game){
	this.field = game; 
	
    }
    
    public void updatePlayer(){
	
	
	
	if(field.returnBall().getBollYvalue() < this.y + 5){
	    if (this.y > 0){
		yVelocity = -2;
	    }
	    else {
		yVelocity = 0;
	    }
	}
	else if(field.returnBall().getBollYvalue()> this.y + (this.height -5)){
	    
	    if (this.y + this.height < pong.Window_height){
		yVelocity = +2; 
	    }
	    else {
		yVelocity = 0;
	    }
	}
	y = y + yVelocity;
    }
    
    public void paint(Graphics g){
	g.setColor(Color.white);
	g.fillRect(pong.Window_width - (x- width), y, width, height);

	if (this.yVelocity < 0){
	    g.setColor(Color.lightGray);
	    g.fillRect(pong.Window_width - (x-width), y + height, width, 4);
	    g.setColor(Color.gray);
	    g.fillRect(pong.Window_width - (x-width), y + height + 4, width, 3);
	    g.setColor(Color.darkGray);
	    g.fillRect(pong.Window_width - (x-width), y + height + 7, width, 2);

	}
	
	else if (this.yVelocity > 0){
	    g.setColor(Color.lightGray);
	    g.fillRect(pong.Window_width - (x-width), y - 4, width, 4);
	    g.setColor(Color.gray);
	    g.fillRect(pong.Window_width - (x-width), y - 7, width, 3);
	    g.setColor(Color.darkGray);
	    g.fillRect(pong.Window_width - (x-width), y - 9, width, 2);

	}
    }
    
    public void increaseComputerSpeed(){
    if(this.yVelocity <=3){
    	this.yVelocity +=1;
    	System.out.println("speed");
    	System.out.println(this.yVelocity);
    }
	
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
