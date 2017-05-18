import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	boolean play = false; 
	Pong pong; 
	private int score = 0; 
	private Color color; 
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
		
		       
		if(this.gameststus == 0){ 
			g2.setColor(Color.white);
			g2.setFont(new Font ("Areal", 1, 20));
			g2.drawString("Pong: game instruction", pong.Window_width/2 -100, 30); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Press space to play", pong.Window_width/2 -100, 80); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("You can pause the game by  pressing space ", pong.Window_width/2 -100, 95); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("You can continue  the game by  pressing space ", pong.Window_width/2 -100, 120); 
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("One play session is 10 point, score 10 will be winer ", pong.Window_width/2 -100, 150);
		}
		
		if(this.gameststus ==1){
			g2.setColor(Color.white);
			g2.setFont(new Font ("Areal", 1, 10));
			g2.drawString("Pause", pong.Window_width/2 -30, 80); 
		}
		if(this.gameststus == 2){
			g2.drawString(ball.returnPlayerScore() + " : " + ball.returnComputerScore(), pong.Window_width / 2  -15, 10);
			g2.drawLine(0, 30, pong.Window_width, 30);
			g2.drawLine(pong.Window_width/2, 30, pong.Window_width/2, pong.Window_height);
			cpu.paint(g2);
			player.paint(g2);
		    ball.paint(g2);
		}
		
		
		
		
		
	    
		
	}

	public void actionPerformed(ActionEvent e) {
			if(this.gameststus == 2){
				update();
			}
			this.repaint();
	}
	
	public void setColor(Color c){
		this.color = c; 
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
