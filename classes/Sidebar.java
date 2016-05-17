import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import javax.imageio.ImageIO;
import java.io.*;

/** The purpose of this class is to make a side bar for the game and register the user inputs.
  * @author Andrew Nitu
  * @version 1.0
  * Time spent: 5 hours
  * Last edit: made the class.
  */

public class Sidebar extends JPanel implements ActionListener, MouseListener{ //ActionListener?
  /** background Image This is the background image for the Sidebar.*/
  private Image background;
  /** pipes[] Image This is the array of images for the pipes.*/
  private Image pipes[] = new Image [21];
  /** border [] Image This is the array for the borders.*/
  private Image border[] = new Image [2];
  
  /** This is the constructor for the sidebar that calls the methods appropriately.*/
  public Sidebar(){
    initializeImage();
    addMouse();
  }
  
  /** This method initializes all of the images accordingly.
    * The try catch prevents input output related errors. The for loops go through the different types of pipes / borders.
    * @param x int This is the cycling through variable.
    * @param e IOException This is thrown when an input output related error occurs.
    * @throws IOException
    * */
  public void initializeImage(){
    try{
      background = ImageIO.read(new File("../images/Sidebar2.png"));
      for (int x = 0; x < 21; x++)
      {
        pipes[x] = ImageIO.read(new File("../images/pipe" + x + ".png")); 
      }
      for (int x = 0; x < 2; x++)
      {
        border[x] = ImageIO.read(new File("../images/border" + x + ".png")); 
      }
    }
    catch(IOException e){}
  }
  
  /** This method adds a mouse.
    * All of the if statements repaint accordindly, and set the Controller.command to the valid value.
    * @param e MouseEvent This is a MouseEvent reference.
    * */
  public void addMouse(){
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        if (e.getX() >= 8 && e.getX() <= 33)
        {
          if (e.getY() >= 6 && e.getY() <= 31)
          {
            //GameApp.c.repaint();
            Controller.command = "plus";
          }         
          else if (e.getY() >= 35 && e.getY() <= 60)
          {
            //GameApp.c.repaint();
            Controller.command = "v";
          }   
          else if (e.getY() >= 64 && e.getY() <= 89)
          {
            // GameApp.c.repaint();
            Controller.command = "h";
          }   
          else if (e.getY() >= 93 && e.getY() <= 118)
          {
            //GameApp.c.repaint();
            Controller.command = "vdbl";
          }
          else if (e.getY() >= 122 && e.getY() <= 147)
          {
            //GameApp.c.repaint();
            Controller.command = "vdbr";
          }
          else if (e.getY() >= 151 && e.getY() <= 176)
          {
            //GameApp.c.repaint();
            Controller.command = "vdul";
          }
          else if (e.getY() >= 180 && e.getY() <= 205)
          {
            //GameApp.c.repaint();
            Controller.command = "vdur";
          }
          else if (e.getY() >= 209 && e.getY() <= 234)
          {
            //GameApp.c.repaint();
            Controller.command = "hdbr";
          }
          else if (e.getY() >= 238 && e.getY() <= 263)
          {
            //GameApp.c.repaint();
            Controller.command = "hdul";
          }
          else if (e.getY() >= 267 && e.getY() <= 292)
          {
            //GameApp.c.repaint();
            Controller.command = "hdur";
          }
          else if (e.getY() >= 296 && e.getY() <= 321)
          {
            //GameApp.c.repaint();
            Controller.command = "hdbl";
          }
          else if (e.getY() >= 325 && e.getY() <= 350)
          {
            //GameApp.c.repaint();
            Controller.command = "dbr";
          }
          else if (e.getY() >= 354 && e.getY() <= 379)
          {
            //GameApp.c.repaint();
            Controller.command = "dur";
          }
          else if (e.getY() >= 383 && e.getY() <= 408)
          {
            //GameApp.c.repaint();
            Controller.command = "dul";
          }
          else if (e.getY() >= 412 && e.getY() <= 437)
          {
            //GameApp.c.repaint();
            Controller.command = "dbl";
          }
          else if (e.getY() >= 441 && e.getY() <= 466)
          {
            //GameApp.c.repaint();
            //Controller.command = "merge0";
            JOptionPane.showMessageDialog ( null, "Error: This piece is not available in this level!" ); 
          }
          else if (e.getY() >= 470 && e.getY() <= 495)
          {
            //GameApp.c.repaint();
            JOptionPane.showMessageDialog ( null, "Error: This piece is not available in this level!" ); 
          }
          else if (e.getY() >= 499 && e.getY() <= 524)
          {
            //GameApp.c.repaint();
            JOptionPane.showMessageDialog ( null, "Error: This piece is not available in this level!" ); 
          }
          else if (e.getY() >= 528 && e.getY() <= 553)
          {
            //GameApp.c.repaint();
            JOptionPane.showMessageDialog ( null, "Error: This piece is not available in this level!" ); 
          }
          else if (e.getY() >= 557 && e.getY() <= 582)
          {
            //GameApp.c.repaint();
            JOptionPane.showMessageDialog ( null, "Error: This piece is not available in this level!" ); 
          }
          else
          {
            if (e.getY() >= 586 && e.getY() <= 611)
            {
              //GameApp.c.repaint();
              Controller.command = "x";
            }
          }
          GameApp.c.repaint(); //NEW!
          //System.out.println(e.getY());
        }
      }                
    });
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) { //Add proposed helper method!
      }
    });
  }
  
  /** This method paints the graphics accordingly.
    * @param g Graphics This is the Graphics class reference.
    * @param x int This is the current cycled x value in the for loop.*/
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(background, 0, 0, null); // see javadoc for more info on the parameters
    
    for (int x = 0; x < 21; x++)
    {
      g.drawImage(pipes[x], 8, 6 + x*29, null);
    }
  }
  /** This method overrides actionPerformed.
    * @param e ActionEvent */
  public void actionPerformed(ActionEvent e){}
  
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