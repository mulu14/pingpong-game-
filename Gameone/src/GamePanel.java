import java.awt.Color;
import java.awt.Graphics;
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
		g.setColor(color);
		g.fillRect(0, 0, pong.Window_width, pong.Window_height);
		cpu.paint(g);
		player.paint(g);
	    ball.paint(g);
	    
	    
	    g.setColor(Color.WHITE);
	    g.drawLine(pong.Window_width/2,30, pong.Window_width/2, pong.Window_height); // problem here 
		
	}

	public void actionPerformed(ActionEvent e) {
          update();
          repaint();
          timer.start();
		
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
