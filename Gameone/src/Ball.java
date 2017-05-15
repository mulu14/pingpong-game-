import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {
	Pong pong; 
	private Color color; 
	private int x = pong.Window_width/2; 
	private int y  = pong.Window_height/2;
	public int size = 5; 
	private int playerScore ; 
	private int Computerscore; 
	private int xVelocity = 2; 
	private int yVelocity = 2;
	Sound sound; 
	
	public void update() {
		
		x += xVelocity; 
		y += yVelocity;  
		
		if(x + size < 0){
			xVelocity +=  2; 
		}
		else if(x + size > pong.Window_width){
			xVelocity -= 2; 
		}
		
		if(y + size < 0){
			yVelocity += 2; 
		}
		else if(y + size> pong.Window_height){
			yVelocity -= 2; 
		}
	} 
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillOval(x, y, size, size);
		g.dispose();
	}
	
	public int getBollXvalue(){
		return x;
	}
	
	public void setBallColor(Color c){
		this.color = c; 
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
		
		if(this.x < player.getX() && (this.x + this.size < 0) ){
			 
			 System.out.println(this.Computerscore++);
			}
		
			
	}
	
	public int playerScore(Computer cpu){
		playerScore  = 0;
		
		while(this.x > cpu.getX() && (this.x + this.size > pong.Window_width) ){
			playerScore = playerScore +1;
			System.out.println(this.playerScore++);
			}
		return playerScore;
	}
	
	
	public int ComputerScore(Player player){
		 Computerscore = 0;
		while(this.x > player.getX() && (this.x + this.size < 0) ){
			Computerscore  = Computerscore +1;
			System.out.println(this.Computerscore++);
			}
		return Computerscore; 
	}
	
	
	public void checkCollision(Computer cpu){
		
		if(this.x > cpu.getX() && this.x < cpu.getX() + cpu.getWidth()){
			if(this.y >cpu.getY() && this.y < cpu.getY() + cpu.getHeight()){
		     
			  reverseDirection(); 
			  sound.playMusic();
			  
			}
		}
		
		if(this.x > cpu.getX() && (this.x + this.size > pong.Window_width) ){
		     
			  //System.out.println("Playerone score");
			
			//System.out.println(this.playerScore++);
			}
			
	}
}
