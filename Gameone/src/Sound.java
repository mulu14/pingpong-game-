import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.*;
import sun.audio.*;
public class Sound {
	
	
	public Sound(){
		
		
	}
	
	
	public void playMusic() {
		AudioPlayer playmusic = AudioPlayer.player;
		AudioStream stream; 
		AudioData data; 
		
		ContinuousAudioDataStream loop = null;
		try{
			
	    stream = new AudioStream(new FileInputStream("ping.wav"));
	    data = stream.getData();
	    loop = new ContinuousAudioDataStream(data);
		}catch(IOException error){
			System.out.println(error);
		}
		
		playmusic.start(loop);
	}
	


}
