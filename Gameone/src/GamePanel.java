import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	Pong pong;
	private int score = 0; 
	Ball ball = new Ball(); 
	Player player = new Player();
	Computer cpu = new Computer(this);
	private Timer timer; 
	private int delay = 30; 
	private int gameststus = 0; 
	
	public GamePanel(){
		timer = new Timer(delay, this); 
		timer.start();
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
	private void update(){
		player.updatePlayer();
		cpu.updatePlayer(); 
		ball.update(); 
		ball.checkCollision(player); 
		ball.checkCollision(cpu); 
		
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2   = (Graphics2D)g; 
		g2.setColor(Color.black);
		g2.fillRect(0, 0, pong.Window_width, pong.Window_height);
		g2.setColor(Color.WHITE);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (ball.returnPlayerScore() == 10){
			
			ball.setPlayerScore(0);
			ball.setComputerScore(0);
			this.gameststus = 3;
			
		}
          
       else if (ball.returnComputerScore() == 10){
    	    ball.setPlayerScore(0);
			ball.setComputerScore(0);
			this.gameststus = 3;
       }
		       
		if(this.gameststus == 0){ 
			g2.setColor(Color.white);
			g2.setFont(new Font ("Areal", 1, 20));
			g2.drawString("Pong: game instruction", pong.Window_width/2 -100, 30); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Press space to play", pong.Window_width/2 -100, 50); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("You can pause the game by  pressing space ", pong.Window_width/2 -100, 70); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("You can continue  the game by  pressing space ", pong.Window_width/2 -100, 90); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("One play session is 10 points, first to 10 wins ", pong.Window_width/2 -100, 110);
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Increase the size of the player by pressing F1 ", pong.Window_width/2 -100, 130);
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Decrease the size of the player by pressing F2 ", pong.Window_width/2 -100, 150);
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Increase the size of the playing field by pressing F4 ", pong.Window_width/2 -100, 170);
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Decrease the size of the playing field by pressing F5 ", pong.Window_width/2 -100, 190);
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Increase the speed of computer by pressing F6 ", pong.Window_width/2 -100, 210);
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Go back to the instruction page by pressing Esc ", pong.Window_width/2 -100, 230);
			
		}
		
		if(this.gameststus ==1){
			g2.setColor(Color.white);
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Pause", pong.Window_width/2 -30, 80); 
		}
		if(this.gameststus == 2){
			g2.drawString(ball.returnPlayerScore() + " : " + ball.returnComputerScore() , pong.Window_width / 2  -15, 10);
			g2.drawLine(0, 30, pong.Window_width, 30);
			g2.drawLine(pong.Window_width/2, 30, pong.Window_width/2, pong.Window_height);
			cpu.paint(g2);
			player.paint(g2);
		    ball.paint(g2);
		}
		
		if(this.gameststus ==3){
			g2.drawString("Press enter to play again", pong.Window_width/2 -100, 50); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Press Esc to game instruction ", pong.Window_width/2 -100, 70); 
			g2.setFont(new Font ("Areal", 1, 10));
		}
		
		
	
		
	}

	public void actionPerformed(ActionEvent e) {
			if(this.gameststus == 2){
				update();
			}
			this.repaint();
	}
	
	
	
	public Ball returnBall(){
		return this.ball; 
	}

	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_UP){
			player.setvelocity(-4);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			player.setvelocity(+4);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			
			if(this.gameststus == 0){
				
				this.gameststus = 2;
				
				
			}
			else if(this.gameststus == 1){
				
				this.gameststus = 2;
				
			}
			else if(this.gameststus == 2){
				
				this.gameststus = 1;
				
			}
			else if(this.gameststus == 3){
				this.gameststus = 0; 
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_F1){
			player.increasePlayerHight();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_F2){
			player.decreasePlayerheight();
		}
	
		
		if(e.getKeyCode() == KeyEvent.VK_F4){
			Pong pong = new Pong();
			pong.increaseJframesize(); 
			
			
		
			
		}
		if(e.getKeyCode() == KeyEvent.VK_F5){
			Pong pong = new Pong();
			pong.decreaseJframesize(); 
			System.out.print(pong.returnInstanceof());
			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_F6){
			
			cpu.increaseComputerSpeed();
			
			
		}
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			
			this.gameststus = 0;
			
			
		}
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE && this.gameststus ==3 ){
			
			this.gameststus = 0;
			
			
		}
        if(e.getKeyCode() == KeyEvent.VK_ENTER && this.gameststus ==3){
        	this.gameststus = 2;
        }
	}

	
	
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode() ;
		
		if(keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_DOWN){
			player.setvelocity(0);
		}
		
		
	}

	public void keyTyped(KeyEvent e) {
	
		
	}

}
