import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**This class opens a profile accordingly.
  * @author Horatiu Lazu
  * Time spent: 2 hours
  * Version #1.0.0.0
  * Edits: Made the class.
  */

public class ViewProfile extends JPanel implements MouseListener{
  /** i Image This Image reference variable allows the program to load an appropriate background image.*/
  Image i;
  String input;
  String input2;
  //ASK ABOUT OVERWRITING
  /** This is the class constructor for ViewProfile.
    * The try catch prevents input output errors.
    * The if statement ensures that the file is valid.
    * @param e IOException Used in case of an input output related error.
    * @throws IOException Used in case of an input or output related error.
    */
  public ViewProfile(String name){
    GameApp.loggedIn = true;
    setFont(new Font("TimesNewRoman", Font.BOLD, 60));
    System.out.println(name);
    try{
      i = ImageIO.read(new File("../images/PlayerProfile.png"));
      repaint();
      BufferedReader in = new BufferedReader(new FileReader(name));
      input = in.readLine(); 
      if (input == null || !input.equals("HORATIU INCORPORATED PROTECTED")){
        //ERROR!
        return;
      }
      input = in.readLine();
      input2 = in.readLine();      
    }
    catch(IOException e){System.out.println("IOException occured!");}
    repaint();
    addMouse();
  }
  
  /** This method adds a mouse to the game.
    * All of the if statements verify the ranges to ensure proper actions occur.
    * @param e MouseEvent This is a reference to the MouseEvent. */
  public void addMouse(){
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
        if (e.getX() >= 0 && e.getX() <= 98 && e.getY() >= 542 && e.getY() <= 640){
          GameApp.backViewProfile();
        }
        else{
          if (e.getX() >= 145 && e.getX() <= 245 && e.getY() >= 542 && e.getY() <= 640){
            GameApp.levelSelection();
          }
        }
      }                
    });
  }
  
  /**This is a paintComponent method used to update the graphics within the JPanel.
    * @param g Graphics reference.
    */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(i, 0, 0, null); // see javadoc for more info on the parameters   
    g.drawString(input, 240, 300);
    g.drawString(input2, 240, 425);
  }
  
  /** This method is triggered when a mouse is clicked.
    * @param e MouseEvent This is the MouseEvent reference.*/
  public void mouseClicked(MouseEvent e) {
  }
  /**This method is triggered when a mouse is pressed.
    * @param e MouseEvent, used to provide information the mouse, etc.
    */
  public void mousePressed(MouseEvent e) {}
  /**This method is triggered when a mouse is enters.
    * @param e MouseEvent, used to provide information regarding the mouse, etc.
    */
  public void mouseEntered(MouseEvent e) {}
  /**This method is triggered when a mouse exits.
    * @param e MouseEvent, used to provide information regarding the mouse, etc.
    */
  public void mouseExited(MouseEvent e) {}
  /**This method is triggered when a mouse is released.
    * @param e MouseEvent, used to provide information regarding the mouse, etc.
    */
  public void mouseReleased(MouseEvent e) {}
}