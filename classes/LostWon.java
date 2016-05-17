import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

/** 
 * This class outputs a PauseGame to the user, and he/she is presented with various different options.
 * @author Horatiu Lazu
 * @version 1.0.0.0
 * June 2, 2014
 * Last edit: Made class.
 * Time spent: 3 hours
 */

public class LostWon extends JPanel implements MouseListener{
  /** image Image This is an image reference, used to store the image for the PauseGame*/
  Image image;
  /** wasRunning boolean This is a boolean used to store if the game is running in the background*/
  boolean wasRunning = false;
  /** hasWon boolean This boolean is thrown when a user loses.*/
  boolean hasWon;
  
  /** This is the class constructor for PauseGame.
    * @param e IOException Used in case of input output related errors.
    * @throws IOException Used in case of an intput output related error.
    * The if statements verify if the timer is null and adjust accordingly.
    * The if statements verify to see and load the levels accordingly.
    * The try catch tries to output the appropriate background.
    */
  public LostWon(boolean hasWon){
    World.numOfChemicals = 0;
    this.hasWon = hasWon;
    if (GameApp.level.t != null){
      if (GameApp.level.t.isRunning()){
        GameApp.level.t.stop();
        wasRunning = true;
      }
      else{
        wasRunning = false; 
      }
    }
    addMouse();
    try{
      image = ImageIO.read(new File("../images/" + ((hasWon) ? ("WinnerScreen.png") : ("LostScreen.png"))));
      repaint();
    }
    catch(IOException e){
      System.out.println("Could not find!");
    }
    
    if (GameApp.currentLevel.equals("Level11")){
      Player.updateHighscores(1);
    }
    else if (GameApp.currentLevel.equals("Level12")){
      Player.updateHighscores(2);
    }
    else if (GameApp.currentLevel.equals("Level13")){
      Player.updateHighscores(3);
    }
    else if (GameApp.currentLevel.equals("Level14")){
      Player.updateHighscores(4);
    }
    else if (GameApp.currentLevel.equals("Level21")){
      Player.updateHighscores(5);
    }
    else{
      if (GameApp.currentLevel.equals("Level22")){
        Player.updateHighscores(6);
      }
    }
  }
  
  /** This method outputs all of the appropriate graphics for the class.
    * @param g Graphics This is a Graphics reference.
    */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
  }
  
  /** This method adds a mouse, and then tracks the movement / clicks accordingly.
    * @param e MouseEvent MouseEvent reference variable.
    * The if statements go through the different x & y coordinates and adjust them accordingly. */
  public void addMouse(){
    addMouseListener
      (new MouseAdapter()
         {
      public void mouseReleased(MouseEvent e)
      {
        repaint();
        System.out.println(e.getX());
        System.out.println(e.getY());
        if (e.getX() >= 250 && e.getX() < 749){
          if (hasWon){
            if (e.getY()  >= 249 && e.getY() < 331){
              //NExt level
              if (GameApp.currentLevel.equals(("Level14")))
                GameApp.display("Level21", false);
              else if (GameApp.currentLevel.equals("Level22")) //MAX!!
                JOptionPane.showMessageDialog (null, "Error: No more levels exist!");
              else {
                //System.out.println("Level" + Integer.parseInt(GameApp.currentLevel.substring(GameApp.currentLevel.length() - 2)) + 1);
                GameApp.display("Level" + ((Integer.parseInt(GameApp.currentLevel.substring(GameApp.currentLevel.length() - 2))) + 1), false);
              }
            }
            else if (e.getY() >= 356 && e.getY() < 441){
              GameApp.display(GameApp.currentLevel, false);
            }
            else{
              if (e.getY() >= 466 && e.getY() < 546){
                GameApp.lostWonToPlayerProfile();
              }
            }
          }
          else{
            if (e.getY() >= 313 && e.getY() <= 400){
              GameApp.display(GameApp.currentLevel, false);
            }
            else{
              if (e.getY() >= 464 && e.getY() <= 600){
                GameApp.lostWonToPlayerProfile();
              }
            }
          }
        } 
      }
    }
    );
  }
  /**This method is triggered when a mouse is clicked.
    * @param e MouseEvent, used to provide information regarding where the mouse was clicked, etc.
    */
  public void mouseClicked(MouseEvent e) {}
  /**This method is triggered when a mouse is pressed.
    * @param e MouseEvent, used to provide information regarding where the mouse was clicked, etc.
    */
  public void mousePressed(MouseEvent e) {}
  /**This method is triggered when a mouse is enters.
    * @param e MouseEvent, used to provide information regarding where the mouse was clicked, etc.
    */
  public void mouseEntered(MouseEvent e) {}
  /**This method is triggered when a mouse exits.
    * @param e MouseEvent, used to provide information regarding where the mouse was clicked, etc.
    */
  public void mouseExited(MouseEvent e) {}
  /**This method is triggered when a mouse is released.
    * @param e MouseEvent, used to provide information regarding where the mouse was clicked, etc.
    */
  public void mouseReleased(MouseEvent e) {} 
}