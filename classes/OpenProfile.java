import javax.swing.*;
import java.io.*;
//import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**This class opens a profile accordingly.
  * @author Horatiu Lazu
  * Time spent: 2 hours
  * Version #1.0.0.0
  * Edits: Made the class.
  */

public class OpenProfile extends JPanel{
  /** i Image This Image reference variable allows the program to load an appropriate background image.*/
  Image i;
  //ASK ABOUT OVERWRITING
  /** This is the class constructor for OpenProfile.
    * The try catch prevents input output related errors.
    * @param e IOException Used in case of an input output related error.
    * @throws IOException Used in case of an input or output related error.
    */
  public OpenProfile(){
    try{
      i = ImageIO.read(new File("../images/OpenProfile.png"));
      repaint();
    }
    catch(IOException e){
    }
  }
  /** This method asks the user for their name, which is required in opening the profile.
    * @param name String This is the user inputted String.
    * The while loop runs forever until the user says to stop.
    * The if statements verify to ensure that the appropriate action occurs. */
  public void askForName(){
    String name;
    while(true){ //Check file header!
      name = JOptionPane.showInputDialog ("Please enter your name!"); 
      if(name == null){
        GameApp.returnFromOpenProfileToMainMenu();
        return;
      }
      else if (fileExists("../profiles/" + name + ".profile")){
        openProfile(name);
        break;
      }
      else{
        JOptionPane.showMessageDialog (null, "Error! Could not find your profile. Please try again.", "Invalid Name", JOptionPane.PLAIN_MESSAGE);  
      }
      //ERROR HERE!
    }
    GameApp.openToView("../profiles/" + name + ".profile");
  }
  /**This method verifies to see if a file exists within the game folder.
    * The try catch is used to verify if the FileNotFoundException is thrown.
    * @param e FileNotFoundException Reference variable.
    * @param e IOException Reference variable.
    * @param name String Used to store the playername for the profile.
    * @return boolean If the file exists.
    * @throws FileNotFoundException In case of the file not being found.
    */
  public boolean fileExists(String name){
    try{
      new BufferedReader(new FileReader(name));
      return true;
    }
    catch(FileNotFoundException e){
      return false;
    }
  }
  
  /** This method opens the profile and loads all of the variables accordingly.
    * @param name String This is the name (proposed) by the user.
    * @param in BufferredReader This is a BufferedReader reference, used to read files.
    * @param e IOException Used to get information regarding an input output related error.
    * @param i int This is a for loop variable.
    * @param x int This is a for loop variable.
    * @throws IOException Used in case of an input output related errors.
    * The for loop variables go through the different options, and then they initialize inside an array.*/
  public void openProfile(String name){
    try{
      BufferedReader in = new BufferedReader(new FileReader("../profiles/" + name + ".profile"));
      if (in.readLine().equals("HORATIU INCORPORATED PROTECTED")){
        Player.playerName = in.readLine();
        Player.playerScore = Integer.parseInt(in.readLine());
        for(int i = 0; i < Player.scores.length; i++){
          Player.scores[i] = Integer.parseInt(in.readLine()); 
        }
      }
    }
    catch(IOException e){}
    GameApp.openToView(name);
  }
  /**This is a paintComponent method used to update the graphics within the JPanel.
    * @param g Graphics reference.
    */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(i, 0, 0, null); // see javadoc for more info on the parameters            
  }
  
}