import javax.swing.*;
import java.io.*;
//import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**This class makes a profile accordingly.
  * @author Horatiu Lazu
  * Time spent: 30 minutes
  * Version #1.0.0.0
  */

public class MakeProfile extends JPanel{
  /** i Image This Image reference variable allows the program to load an appropriate background image.*/
  Image i;
  //ASK ABOUT OVERWRITING
  
  /** Class constructor
    * The try catch ensures that no IO related errors occur when reading for the Image.
    * The while loop goes through prompting the user several times regarding getting the fileName for the player profile.
    * The if statements verify to see if the file is valid.
    * @param e IOException variable, used in case of an input output related error.
    * @param name String reference, used to store the player name.
    * @throws IOException
    */
  public MakeProfile(){
    try{
      i = ImageIO.read(new File("../images/New Profile.png"));
      repaint();
    }
    catch(IOException e){
    }
    
  }
  
  /** This method asks the user for their name, which is required in opening the profile.
    * The while loop runs forever until the user says to stop. 
    * The if statements verify to ensure that the appropriate action occurs for example overriding or not depending on the choice within the JOptionPane, and then return accordingly. 
    * @param name String This is the user inputted String.
    * @param n int This is the n from the override dialog.
    * */
  
  public void askForName(){
    boolean shouldReturnMenu = false;
    String name;
    while(true){
      name = JOptionPane.showInputDialog ("Please enter your name!"); 
      if(name == null){
        GameApp.returnFromMakeProfileToMainMenu();
        return;
      }
      else if (name.length() == 0){
        JOptionPane.showMessageDialog (null, "Error! Please enter a proper name.", "Invalid Name", JOptionPane.PLAIN_MESSAGE);  
      }
      else if (name.length() > 14)
      {
        JOptionPane.showMessageDialog (null, "Error! The name you have entered is too long. The name must not exceed 14 characters.", "Invalid Name", JOptionPane.PLAIN_MESSAGE); 
      }
      else if (fileExists(name)){
        int n = JOptionPane.showConfirmDialog(null,"This profile already exists. Do you want to override the file?","Do you want to override the file?",JOptionPane.YES_NO_OPTION);
        System.out.println("HERE: " + n);
        if (n == 0){
          //shouldReturnMenu = true;
          //break;
          makeProfile(name);
        }
        else if (n == 1){
          shouldReturnMenu = true;
          break;
        }
        else if (n == -1){
          shouldReturnMenu = true;
          break;
        }
        else{
          makeProfile(name);
        }
        //ASK DYKE
        break;
      }
      else{
        makeProfile(name);
        //shouldReturnMenu = false;
        break;
        
      }
    }
    if(shouldReturnMenu)
      GameApp.returnFromMakeProfileToMainMenu();
    else{
      System.out.println("Working!");
      GameApp.makeToView("../profiles/" + name + ".profile");
    }
  }
  //VERIFY IF THIS REPEATED METHOD SHOULD BE IN A UTILITY CLASS!
  /**This method verifies to see if a file exists within the game folder.
    * The try catch is used to verify if the FileNotFoundException is thrown.
    * @param e FileNotFoundException Reference variable.
    * @param e IOException Reference variable.
    * @param name String Used to store the playername for the profile.
    * @throws IOException
    * @return boolean Returns if the file exists.
    */
  public boolean fileExists(String name){
    try{
      new BufferedReader(new FileReader("../profiles/" + name + ".profile"));
      return true;
    }
    catch(FileNotFoundException e){
      return false;
    }
  }
  
  /** This method makes the profile and loads all of the variables accordingly.
    * The for loop variables go through the different options, and then they initialize inside an array.
    * @param name String This is the name (proposed) by the user.
    * @param output PrintWriter This is a PrintWriter reference, used to output files.
    * @param e IOException Used to get information regarding an input output related error.
    * @param i int This is a for loop variable.
    * @param x int This is a for loop variable.
    * @throws IOException Used in case of an input output related errors.
    * */
  
  public void makeProfile(String name){
    try{
      PrintWriter out = new PrintWriter(new FileWriter("../profiles/" + name + ".profile"));
      out.println("HORATIU INCORPORATED PROTECTED"); //Header
      out.println(name); //Player name
      out.println(0);  //Score
      
      //UNLOCK CODES
      //-1 if not unlocked
      //0 if unlocked but not completed
      //1 if completed
      out.println(0); //Initial level is unlocked by default
      for(int i = 0; i < 5; i++){
        out.println(-1); //
      }
      out.close();
    }
    catch(IOException e){
    }
    Player.playerName = name;
    Player.playerScore = 0; //Score
    Player.scores[0] = 0;
    for(int i = 1; i < 6; i++){ //1 to 6 so it does not overwrite the first 0
      Player.scores[i] = -1;
    }
    GameApp.makeToView(name);
  }
  /**This is a paintComponent method used to update the graphics within the JPanel.
    * @param g Graphics reference.
    */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(i, 0, 0, null); // see javadoc for more info on the parameters            
  }
  
}