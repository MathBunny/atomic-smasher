/** 
 * This class acts as the level selection. This will allow the player to select a level.
 * @author Horatiu Lazu
 * @version 1 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
//import java.util.*;

public class LevelSelection extends JPanel implements MouseListener{
  /** image Image This is an image.*/
  private Image image;
  public LevelSelection(){
    //GameApp.loggedIn = true;
    initialize();
  }
  /** This method initializes the image.
    * The try catch prevents IO related errors.
    * @param e IOException This is used in case of an input output related error.
    * @throws IOException This is used for input output related errors. */
  public void initialize(){
    try{
      image = ImageIO.read(new File("../images/LevelSelectionNew.png")); 
      repaint();
      addMouse();
    }
    catch(IOException e){}
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
  
  /** This method outputs the graphics.
    * @param g Graphics This is a reference to graphics. */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null);
  }
  
  /** This method adds a mouse to the JPanel.
    * All of the if statements verify the range, then it verifies if the user can play the particular level based off of the pixel range.
    * If the user cannot play, a JOptionPane appears.
    * @param e MouseEvent This is a MouseEvent listener used to listen to mouse commands. */
  public void addMouse(){
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        System.out.println("X: " + e.getX() + "  Y: " + e.getY());
        if((e.getX() >= 0 && e.getX() <= 73 )&& (e.getY() >= 560 && e.getY() <= 620))
        {
          GameApp.levelSelectionToPlayerProfile();
        }
        else if((e.getX() >= 122 && e.getX() <= 416) && (e.getY() >= 220 && e.getY() <= 288))
        {
          if (Player.canPlayLevel(1)){
            GameApp.display("Level11", true);
          }
          else{
            JOptionPane.showMessageDialog(null, "You have not unlocked this level yet!", "Error!", JOptionPane.PLAIN_MESSAGE);
          }
        }
        else if((e.getX() >= 122 && e.getX() <= 416) && (e.getY() >= 377 && e.getY() <= 406))
        {
          if (Player.canPlayLevel(2)){
            GameApp.display("Level12", true);
          }
          else{
            JOptionPane.showMessageDialog(null, "You have not unlocked this level yet!", "Error!", JOptionPane.PLAIN_MESSAGE);
          }
        }
        else if((e.getX() >= 122 && e.getX() <= 416) && (e.getY() >= 449 && e.getY() <= 520))
        {
          if (Player.canPlayLevel(3)){
            GameApp.display("Level13", true);
          }
          else{
            JOptionPane.showMessageDialog(null, "You have not unlocked this level yet!", "Error!", JOptionPane.PLAIN_MESSAGE);
          }
        }
        else if((e.getX() >= 565 && e.getX() <= 859) && (e.getY() >= 220 && e.getY() <= 288))
        {
          if (Player.canPlayLevel(4)){
            GameApp.display("Level14", true);
          }
          else{
            JOptionPane.showMessageDialog(null, "You have not unlocked this level yet!", "Error!", JOptionPane.PLAIN_MESSAGE);
          }
        }
        else if((e.getX() >= 565 && e.getX() <= 859) && (e.getY() >= 377 && e.getY() <= 406))
        {
          if (Player.canPlayLevel(5)){
            GameApp.display("Level21", true);
          }
          else{
            JOptionPane.showMessageDialog(null, "You have not unlocked this level yet!", "Error!", JOptionPane.PLAIN_MESSAGE);
          }
        }
        else if (e.getX() >= 306 && e.getX() < 679 && e.getY() > 547 && e.getY() < 620){
          GameApp.loggedIn = false;
          GameApp.backLevelSelection();
        }
        else{
          if((e.getX() >= 565 && e.getX() <= 859) && (e.getY() >= 449 && e.getY() <= 520))
          {
            if (Player.canPlayLevel(6)){
              GameApp.display("Level22", true);
            }
            else{
              JOptionPane.showMessageDialog(null, "You have not unlocked this level yet!", "Error!", JOptionPane.PLAIN_MESSAGE);
            }
          }
        }
      }                
    });
  }
}