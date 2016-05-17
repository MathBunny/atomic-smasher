import javax.swing.*;
import java.awt.*;

/** This class outputs the splashscreen, along with the static image following it, 
  * @author Horatiu Lazu
  * @version 1.0
  * Last edit: Creation of splashscreen.
  * Time spent: 6 hours
  * Edit by: Horatiu */

public class Splashscreen extends JPanel{
  /** This is a blank constructor.
    * The try catch prevents exceptions from occuring.
    * @param image Image This is an image reference.
    * @param xIcon ImageIcon This is an ImageIcon reference.
    * @param label JLabel This is a JLabel reference.
    * @param e Exception This is an exception.
    * @throws Exception This is in case of an error.
    */
  
  public Splashscreen(){
    try{Image image =Toolkit.getDefaultToolkit().createImage("../videos/SplashScreen3.gif");
      ImageIcon xIcon = new ImageIcon(image);
      xIcon.setImageObserver(this);
      JLabel label = new JLabel (xIcon);
      add(label);
    }
    catch(Exception e){}
  }
  
}