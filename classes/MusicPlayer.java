import java.io.*;
import java.util.*;
import javax.media.*;

/** This class plays music. 
  * @author Horatiu Lazu
  * @version 1.0
  * Last edit: Horatiu Lazu
  * Time spent: 1 hour
  */

public class MusicPlayer extends Thread{
  /** songs ArrayList<String> This ArrayList stores the different songs.*/
  ArrayList <String> songs = new ArrayList<String>();
  /** shouldStop boolean This boolean stores if the song has stopped, and if the game should stop or proceed to the next song.*/
  boolean shouldStop = false;
  /** filename String This string stores the fileName of the current file being processed.*/
  private String filename;
  /** player Player This is a reference to a player object.*/
  javax.media.Player player;
  /** isRunning boolean This is a volatile variable used to see if the MusicPlayer is running. */
  private volatile boolean isRunning = true;
  
  /**This method runs the music files accordingly.
    * The try catch makes sure no errors occur while loading the files.
    * The for loop goes through the songs.
    * The if statement in the nested method makes sure that the event is the ending of a song.
    * The while loop cycles through to not go to the next song unless required.
    * @param i int For loop variable, used to go through the different songs.
    * @param url URL reference, used to store the URL.
    * @param locator MediaLocation, used to store the MediaLocator.
    * @param event ControllerEvent Used to see when an event occurs to stop, and the player should stop.
    * @param e Exception Exception reference variable, used in case of an exception.
    * @throws Exception
    */
  public void run() {
    while (isRunning){
      getSongs();
      try {
        for(int i = ((int)(Math.random() * songs.size())); i < songs.size(); i++){
          filename = songs.get(i);
          File file = new File ("../sound/" + filename);
          System.out.println(file);
          javax.media.MediaLocator locator = new javax.media.MediaLocator(file.toURL());
          player = javax.media.Manager.createPlayer(locator);
          player.addControllerListener(new ControllerListener(){
            public void controllerUpdate(ControllerEvent event){
              if (event instanceof EndOfMediaEvent) {
                shouldStop = true;
                player.stop();
                player.close();
              }
            }
          });
          player.realize();
          player.start();
          while(true){
            if (shouldStop){
              shouldStop = false;
              break;
            }
            
          }
          
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  /** This method kills the thread.*/
  public void kill() {
    isRunning = false;
  }
  
  /**This method gets the songs within the file directory and then stores them in the appropriate files.
    * The if statement verifies to see if the file ends with an mp3, wav or ogg.
    * @param folders File File reference, used to store the folders.
    * @param listOfFiles File [] Used to store the list of file.
    * @param i int This file is the incrementation integer used to go through the list of files and add the appropriate files.
    * @param e Exception This is used in case of exceptions.
    * @throws Exception e This is used for exceptions.
    */
  public void getSongs(){
    File folder = new File("../sound/");
    File[] listOfFiles = folder.listFiles();
    
    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile() && (listOfFiles[i].getName().endsWith(".mp3") || (listOfFiles[i].getName().endsWith(".wav"))|| (listOfFiles[i].getName().endsWith(".ogg")))) {
        try{
          songs.add((listOfFiles[i].getName()));
        }
        catch(Exception e){
        }
      }
    }
  }
  /**This is the class constructor of the MusicPlayer.
    */
  public MusicPlayer(){
    //run();
    //getSongs();
  }
} 