//import java.awt.BorderLayout;
//import java.awt.Component;
//import javax.imageio.ImageIO;
//import java.net.*;
//import javax.media.*;
import javax.swing.*;
//import java.io.*;
import java.awt.*;

/** This class outputs the credits..
  * @author Horatiu Lazu
  * @version 1.0
  * Last edit: Creation of ChemistryIntroduction.
  * Time spent: 6 hours
  * Edit by: Horatiu */

public class Credits extends JPanel{
  /** This is a blank constructor.
    * The try catch prevents exceptions from occuring.
    * @param image Image This is an image reference.
    * @param xIcon ImageIcon This is an ImageIcon reference.
    * @param label JLabel This is a JLabel reference.
    * @param e Exception This is an exception.
    * @throws Exception This is in case of an error.
    */
  
  public Credits(){
    try{
      Image image =Toolkit.getDefaultToolkit().createImage("../videos/Credits.gif");
      ImageIcon xIcon = new ImageIcon(image);
      xIcon.setImageObserver(this);
      JLabel label = new JLabel (xIcon);
      add(label);
    }
    catch(Exception e){}
  }
  
}