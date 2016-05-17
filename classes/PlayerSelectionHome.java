import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

/** The purpose of this class is to permit the user to select what they want to do regarding the profiles.
  * @author Andrew Nitu and Horatiu Lazu
  * @version 1.0.0.0
  * Last edit: May 25, 2014
  * Horatiu Lazu & Andrew Nitu made the profile selection for the game.
  */

public class PlayerSelectionHome extends JPanel implements MouseListener{
  Image image;
  
  /** This is the class constructor for PlayerSelectionHome.
    * The try catch is used in case of an input output related error.
    * @param e IOException
    * @throws IOException
    * */
  
  public PlayerSelectionHome(){
    try{
      image = ImageIO.read(new File("../images/PlayerProfile.png"));
      repaint();
    }
    catch(IOException e){}
    addMouse();
  }
  
  /** This method adds a mouse to the JPanel.
    * @param e MouseEvent
    * The if statements verify the range of the x & y on the mouse.
    */
  public void addMouse(){
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());
        if (e.getY() >= 530 && e.getY() <= 615){
          if (e.getX() > 28 && e.getX() < 434){
            GameApp.openProfile();
          }
          else{
            if (e.getX() > 529 && e.getX() <  936){
              
              GameApp.makeProfile();
            }
          }
        }
      }                
    });
  }
  /** This method repaints all the graphics accordingly.
    * @param g Graphics This is a reference to the graphics class.*/
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
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