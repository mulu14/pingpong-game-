import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	
	public Sound(){ 
		
	}
	
	public void playMusic() {
		 File file = new File("../ping.wav");
		    if(file.exists()) {
		        try {
		            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);

		            AudioFormat audioFormat = audioInputStream.getFormat();

		            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);

		            SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(info);
		            sourceLine.open(audioFormat);

		            sourceLine.start();

		            int nBytesRead = 0;
		            byte[] abData = new byte[128000];
		            while (nBytesRead != -1) {
		                try {
		                    nBytesRead = audioInputStream.read(abData, 0, abData.length);
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		                if (nBytesRead >= 0) {
		                    sourceLine.write(abData, 0, nBytesRead);
		                }
		            }

		            sourceLine.drain();
		            sourceLine.close();

		        } catch ( IOException e) {
		            e.printStackTrace();
		        } catch (LineUnavailableException e) {
		            e.printStackTrace();
		        } catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    } else {
		        System.err.println("The selected file doesn't exist!");
		    }
	


}
	
}
