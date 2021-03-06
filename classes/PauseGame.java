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

public class PauseGame extends JPanel implements MouseListener{
  /** image Image This is an image reference, used to store the image for the PauseGame*/
  Image image;
  /** wasRunning boolean This is a boolean used to store if the game is running in the background*/
  boolean wasRunning = false;
  
  /** This is the class constructor for PauseGame.
    * The if statements verify if the timer is null and adjust accordingly.
    * The try catch tries to output the appropriate background.
    * @param e IOException Used in case of input output related errors.
    * @throws IOException Used in case of an intput output related error.
    */
  public PauseGame(){
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
      image = ImageIO.read(new File("../images/PauseGame.png"));
      repaint();
    }
    catch(IOException e){
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
    * The if statements go through the different x & y coordinates and adjust them accordingly. 
    * @param e MouseEvent MouseEvent reference variable.
    * */
  public void addMouse(){
    addMouseListener
      (new MouseAdapter()
         {
      public void mouseReleased(MouseEvent e)
      {
        repaint();
        //System.out.println(e.getX());
        //System.out.println(e.getY());
        if (e.getX() >= 265 && e.getX() < 749){
          if (e.getY() > 247 && e.getY() < 345){
            if (wasRunning){
              GameApp.level.t.start(); 
            }
            GameApp.returnToGame();
          }
          else if (e.getY() > 373 && e.getY() < 475){
            GameApp.instructions();
          }
          else{
            if (e.getY() > 480 && e.getY() < 611){
              GameApp.mainMenu();
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
  public void mouseEntered(MouseEvent e) {
    
  }
  /**This method is triggered when a mouse exits.
    * @param e MouseEvent, used to provide information regarding where the mouse was clicked, etc.
    */
  public void mouseExited(MouseEvent e) {}
  /**This method is triggered when a mouse is released.
    * @param e MouseEvent, used to provide information regarding where the mouse was clicked, etc.
    */
  public void mouseReleased(MouseEvent e) {}
  
  
}