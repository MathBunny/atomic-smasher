/** 
 * @author Horatiu Lazu
 * Incomplete class.*/
import javax.swing.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
//import javax.swing.*;

public class MainMenuRunner extends JFrame{
  public static void main (String [] args){
    new MainMenuRunner(); 
  }
  
  public MainMenuRunner(){
    setSize(960, 661);
    MainMenu m = new MainMenu();
    add(m);
    setVisible(true);
    
    //For music:
    try {
      // Open an audio input stream.
      URL url = this.getClass().getClassLoader().getResource("gameover.wav");
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
      // Get a sound clip resource.
      Clip clip = AudioSystem.getClip();
      // Open audio clip and load samples from the audio input stream.
      clip.open(audioIn);
      clip.start();
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }
    
    
  }
  
}