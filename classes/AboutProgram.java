import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;

/** This application outputs an AboutProgram which allows the user to see more about the program.
  * @author Horatiu Lazu
  * @version 1.0.0.0 May 15, 2014
  * 
  * Edit #1
  * -Horatiu Lazu
  * -Estimated Time Spent: 1 hour
  */

public class AboutProgram extends JPanel implements MouseListener{ //ActionListener?
  /** Image image This image stores the background for the AboutProgram.*/
  Image image;
  
  /** This is the class constructor for AboutProgram, which initializes the background image.*/
  public AboutProgram(){
    initializeImage();
    addMouse();
  }
  /** This method initializes an image.
    * This try catch prevents an input output error.
    * @param e IOException, used in the try-catch.
    */
  public void initializeImage(){
    try{
      image = ImageIO.read(new File("../images/AboutGame.png"));
      //JLabel picLabel = new JLabel(new ImageIcon(image));
      //add(picLabel);
    }
    catch(IOException e){
    }
  }
  /** This method adds a mouse.
    * The if statement first verifies the x axis, and then the inner if statements verify the ranges for output.
    * @param e MouseEvent reference variable.
    * @param ee IOException reference variable, used in case of an input output related error.
    * @throws IOException
    * 
    */
  public void addMouse(){
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        GameApp.backAbout();
      }                
    });
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) { //Add proposed helper method!
        
      }
    });
  }
  /** This method override the paintComponent. It outputs the background.
    * @param g Graphics, used to output the graphics.
    */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters            
  }
  /** This is a method that is used in case of a mouse is clicked
    * @param MouseEvent e Used to record a MouseEvent. */
  public void mouseClicked(MouseEvent e) {
  }
  /** This is a method that is used in case of a mouse is pressed
    * @param MouseEvent e Used to record a MouseEvent. */
  public void mousePressed(MouseEvent e) {}
  /** This is a method that is used in case of a mouse is entered
    * @param MouseEvent e Used to record a MouseEvent. */
  public void mouseEntered(MouseEvent e) {}
  /** This is a method that is used in case of a mouse is exited
    * @param MouseEvent e Used to record a MouseEvent. */
  public void mouseExited(MouseEvent e) {}
  /** This is a method that is used in case of a mouse is released
    * @param MouseEvent e Used to record a MouseEvent. */
  public void mouseReleased(MouseEvent e) {}
  
}