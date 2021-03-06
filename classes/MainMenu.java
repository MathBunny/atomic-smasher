import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

/** This class acts as the main menu for the game.
  * @author Horatiu Lazu
  * @version 5 */

public class MainMenu extends JPanel implements MouseListener, KeyListener{ //ActionListener?
  /** image Image This is an image used to store the background.*/
  Image image;
  /** loc int This is an integer to store the loction.*/
  int loc = 0;
  
  /** This is the class constructor for MainMenu.
    * The if statement sets the size accordingly due to Windows restrictions.*/
  public MainMenu(){
    if (GameApp.a != null)
      GameApp.a.setSize(960, 665);
    setFocusable(true);
    requestFocusInWindow();
    initializeImage();
    addMouse();
    addKey();
    requestFocusInWindow();
  }
  
  /** This method initializes the image for the game.
    * The try catch ensures that no file input output error occurs.
    * @param e IOException, used in case of an input output related issue.
    * @throws IOException
    */
  public void initializeImage(){
    try{
      image = ImageIO.read(new File("../images/MainMenu2.png"));
      //JLabel picLabel = new JLabel(new ImageIcon(image));
      //add(picLabel);
    }
    catch(IOException e){
      //System.out.println("main menu image not found");
    }
  }
  /**This methid will return the location.
    * @return int
    */
  public int getLoc()
  {
    return loc; 
  }
  
  /**This method will add a mouse to the JPanel, along with checking so see the coordinate and initiate particular events.
    * The method mouseReleased is used / triggered when a mouse is released.
    * The if statements verify the x & y range of the mouse, and call the appropriate methods.
    * @param e MouseEvent This is a parameter pass used to indiciate what the X & the Y value is.
    */
  
  public void addMouse(){
    addMouseListener
      (new MouseAdapter()
         {
      public void mouseReleased(MouseEvent e)
      {
        if (GameApp.a != null){
          if (e.getX() >= 200 && e.getX() <= 800){
            if (e.getY() >= 245 && e.getY() <= 309){
              //System.out.println("Play");
              if (!GameApp.loggedIn)
                GameApp.play();
              else
                GameApp.mainMenuToPlayerProfile();
              

             //ANDREW: Here you can work / change it...I need it on display and you need it on play. :P yeah i know xD
              //GameApp.display("Level11", true);
            }
            else if (e.getY() >= 325 && e.getY() <= 388){
              //System.out.println("Instructions");
              GameApp.instructions();
            }
            else if (e.getY() >= 407 && e.getY() <= 470){
              GameApp.highscores();
            }
            else if (e.getY() >= 485 && e.getY() <= 550){
              GameApp.settings();
            }
            else{
              if (e.getY() >= 565 && e.getY() <= 630){
                GameApp.credits();
              }
            }
          }
        }            
      }
    }
    );
  }
  
  public void addKey() {
    addKeyListener(new KeyAdapter()
                     {
      public void keyReleased(KeyEvent k) {
        if (GameApp.a != null){
          if (k.getKeyCode() == k.VK_P)
          {
            GameApp.play();
          }
          else if (k.getKeyCode() == k.VK_I)
          {
            GameApp.instructions();
          }
          else if (k.getKeyCode() == k.VK_H)
          {
            GameApp.highscores();
          }
          else if (k.getKeyCode() == k.VK_S)
          {
            GameApp.settings();
          }
          else
          {
            if (k.getKeyCode() == k.VK_E)
            {
              GameApp.credits();
            }
          }
        }
      }
    }
    );
  }
  
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
  
  public void keyTyped(KeyEvent k) {}
  
  public void keyPressed(KeyEvent k) {}
  
  public void keyReleased(KeyEvent k) {}
}