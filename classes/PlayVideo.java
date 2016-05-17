
import java.awt.BorderLayout;
import java.awt.Component;
//import javax.imageio.ImageIO;
import java.net.*;
import javax.media.*;
import javax.swing.*;
import java.io.*;
import java.awt.*; //MAKE PLAY VIDEO CLASS

/** This class outputs the appropriate introduction. 
  * @author Horatiu Lazu
  * @version 1.0
  * Last edit: Creation of ChemistryIntroduction.
  * Time spent: 1 hours
  * Edit by: Horatiu */

public class PlayVideo extends JPanel{
  /** image Image This is the image used for the background.*/
  Image image;
  /** filePath String This is the filepath to the video.*/
  String filePath = "";
  
  /** This is the class constructor.
    * @param filePath String This is the filepath.*/
  public PlayVideo(String filePath) {
    this.filePath = filePath;
  }
  /** This is the PlayVideo helper methods.
    * mediaPlayer javax.media.Player This is a player reference used to reference the game player.
    * The if statement verifies to see if the game is null.
    * The try catch goes against any possible errors.
    * @param mediauURL This is a URl reference.
    * @param e Exception This is an Exception variable used in case of an error when running the video.
    * @throws Exception e
    * */
  public void playVideo(URL mediauUrl){
    setLayout(new BorderLayout());
    try {
      javax.media.Player mediaPlayer=Manager.createRealizedPlayer(new javax.media.MediaLocator(mediauUrl));
      Component video=mediaPlayer.getVisualComponent();
      if (video!=null) {
        add(video, BorderLayout.CENTER);          // place the video component in the panel
      }
      mediaPlayer.start();
    } catch (Exception e) {}
  }
  
  /** Credit to: Lyle Z
    * http://stackoverflow.com/questions/8323760/java-get-uri-from-filepath
    * The purpose of this method is to convert a relative String filename to a URL.
    * @param filename String This is a String for the filename.
    * @param path String This is the path for the video.
    * @param retVal String This is the return value.
    * @return String The updated converted file.
    * The if statement verifies for a / line.
    * The second if statement verifies for a starting of /
    */
  private static String convertToFileURL ( String filename )
  {
    // On JDK 1.2 and later, simplify this to:
    // "path = file.toURL().toString()".
    String path = new File ( filename ).getAbsolutePath ();
    if ( File.separatorChar != '/' ){
      path = path.replace ( File.separatorChar, '/' );
    }
    if ( !path.startsWith ( "/" ) ){
      path = "/" + path;
    }
    String retVal =  "file:" + path;
    
    return retVal;
  }
  
  
  /** This method initializes all of the fields with the proper file names.
    * @param e MalformedURLException This is thrown in case of an URL exception.
    * @throws MalformedURLException
    * The try catch goes against a potential URL error.
    */
  public void initialize() {
    ///mediaTest.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    try{
      playVideo(new URL(convertToFileURL(filePath)));
    }
    catch(MalformedURLException e){}
  }
}