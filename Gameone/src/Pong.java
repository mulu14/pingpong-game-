
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pong extends JFrame implements ActionListener {
	private JFrame frame;
	GamePanel p;
	Ball ball; 
	Player player = new Player(); 
	Computer computer; 
	private JMenuBar menuBar;
	private  JMenu help;
	private JMenu sizeMenu ;
	private JMenu ColorMenu; 
    final static int Window_width = 407; 
	final static int Window_height  = 283;
	private JRadioButtonMenuItem red ;
	private JRadioButtonMenuItem  black;
	private JRadioButtonMenuItem  blue;
	private JRadioButtonMenuItem  sizePanel;
	private ButtonGroup colorButton;  
	private ButtonGroup sizeButton;  
	private JComboBox playersize; 
	private JComboBox height; 
	private JComboBox width; 
	
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Pong(){
	    frame =  new JFrame();
		p = new GamePanel();
		menuBar = new JMenuBar();
		help = new JMenu("Help");
		help.setMnemonic('H');
		sizeMenu = new JMenu("Size");
		sizeMenu.setMnemonic('S');
		ColorMenu = new JMenu("BColor");
		ColorMenu.setMnemonic('C');
		String [] playalternative  = {"20", "30", "40"};
		playersize = new JComboBox(playalternative);
		playersize.setEditable(true); 
		playersize.getRegisteredKeyStrokes();
		menuBar.add(ColorMenu);
		menuBar.add(help);
		menuBar.add(playersize);
		String [] heightOption  = {"200", "250", "300", "350", "400", "450", "500", "550", "600"};
		height = new JComboBox(heightOption);
		height.setEditable(true);
		//menuBar.add(height);
		String [] widthtOption  = {"200", "250", "300", "350", "400", "450", "500", "550", "600"};
		width = new JComboBox(widthtOption); 
		width.setEditable(true);
		//menuBar.add(width);
		red = new JRadioButtonMenuItem("Red");
		black = new JRadioButtonMenuItem("Black");
	    blue = new JRadioButtonMenuItem("Blue");
	    sizePanel = new JRadioButtonMenuItem("SizePanel");
	    sizeMenu.add(sizePanel);
	    sizeButton = new ButtonGroup(); 
	    sizeButton.add(sizePanel);
		ColorMenu.add(red);
		ColorMenu.add(black);
		ColorMenu.add(blue);
		colorButton = new ButtonGroup(); 
		colorButton.add(red);
		colorButton.add(black);
		colorButton.add(blue);
		sizePanel.addActionListener(this); 
		frame.setJMenuBar(menuBar); 
		frame.setSize(Window_width, Window_height);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(p);
		frame.setVisible(true);
		//frame.setResizable(false);
		
	}
	

	public void actionPerformed() {
		
		red.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if(e.getSource()==red){
	     			p.setColor(Color.red);
	     			
	     		}
	         }
	      });
		blue.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if(e.getSource()==blue){
	     			p.setColor(Color.blue);
	     			
	     		}
	         }
	      });
		black.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 if(e.getSource()==black){
	     			p.setColor(Color.black);
	     			
	     		}
	         }
	      });
			
	
	playersize.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
        	
        	JComboBox comboBox = (JComboBox) event.getSource();
        	 String selected = (String) comboBox.getSelectedItem();
        	 int result = Integer.parseInt(selected);
        	 System.out.println(result); 
        	 player.setHight(result); 

        }
	});
	
	};

	
	
	
	
	public static void main(String [] args){
		
		Pong pong = new Pong(); 
		pong.actionPerformed();
		
	}


	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}




}
