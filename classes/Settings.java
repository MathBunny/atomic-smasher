import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;

/** This class acts as the settings for the game.
  * @author Horatiu Lazu, Andrew Nitu
  * @version 2
  * Edit #1: Horatiu Lazu
  * Made the foundation for the app (May 20, 2014)
  * Time spent: 2 hours
  * Edit #2: Andrew Nitu
  * Completed the class (June 9, 2014)
  * Time spent: 4 hours
  */

public class Settings extends JPanel implements MouseListener{
  /** settingsImage [] Image This is an array of images used to store the different scrolling mechanism positions.*/
  static Image settingsImage[] = new Image [14];
  /** current Image This stores the current Image.*/
  Image current;
  /** musicValue int This stores the current music value.*/
  int musicValue = 0;
  /** t javax.swing.Timer This stores the timer for the delay.*/
  javax.swing.Timer t;
  /** input String This is the input String. */
  String input;
  /** output String This is the output String. */
  String output;
  /** in BufferedReader This is the BufferedReader used for input. */
  BufferedReader in;
  
  /** This method is used to get / load the settings.
    * The try catches prevent input output related errors.
    * The if statemebts verify if the saved settings and output accordingly.
    * @e IOException Used in case of an input output related error.
    */
  public Settings(){    
    try{
      in = new BufferedReader (new FileReader ("../profiles/config.ini"));
      input = in.readLine();
    }
    catch(IOException e){System.out.println("SETTINGSIOEXCEPTION1");}
    if (!input.equals("HORATIU INCORPORATED PROTECTED")){
      output = "true";
    }
    try{
      input = in.readLine();
    }
    catch (IOException e){System.out.println("SETTINGSIOEXCEPTION");}
    if (input.equals("true"))
    {
      output = "true"; 
    }
    else{
      if (input.equals("false")){
        output = "false"; 
      }
    }
    System.out.println(input + " " + output);
    if (output.equals("false")){
      current = settingsImage[0];
    }
    else{
      current = settingsImage[13];
    }
    
    
    repaint();
    addMouse();
  }
  
  /** This method clears profiles.
    *  @param s String This is the user input.
    * @param f File This is the file.
    * The if statement verifies if the file was deleted successfully.
    */
  public void clearProfile(){
    String s = JOptionPane.showInputDialog ("Please enter the profile name to delete." ); 
    File f = new File("../profiles/" + s + ".profile");
    if (!f.delete()){
      JOptionPane.showMessageDialog (null, "Error: Invalid player name! Could not delete file." ); 
    }
    else{
      JOptionPane.showMessageDialog (null, "Profile " + "\"" + s + "\" deleted!"); 
    }
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
  
  
  /** This method outputs the graphics.
    * @param g Graphics This is for the graphics. */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(current, 0, 0, null); //see javadoc for more info on the parameters            
  }
  
  /** This method adds the mouse to the JPanel.
    * The if statement verifies to see if the configuration file exists and outputs accordingly.
    * The else will output accordingly, and will animate the images.
    * All of the try catches go through the images through the array, and update it in real time.
    * All of the animations simulate a switch moving.
    * @param io IOException Used in case of an input output related error.
    * @param e ActionEvent This is used in case of an action being performed. 
    * @param a ArrayIndexOutOfBoundsException This is in case of the array going out of bounds.
    * @param number int This is a number used to store the maximum images. 
    * @throws ArrayIndexOutOfBoundsException To prevent going out of bounds.
    * @throws IOException To prevent IO related errors.
    */
  public void addMouse(){
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        System.out.println(e.getX() + " " + e.getY());
        if (e.getX() >= 0 && e.getX() <= 60 && e.getY() >= 587 && e.getY() <= 640)
        {
          try{
            PrintWriter out = new PrintWriter(new FileWriter("../profiles/config.ini"));
            out.println("HORATIU INCORPORATED PROTECTED");
            out.println(output);
            out.println(GameApp.playIntro);
            out.close();
          }
          catch (IOException io){}
          GameApp.backSettings();
        }
        else if (e.getX() >= 531 && e.getX() <= 675 && e.getY() >= 296 && e.getY() <= 363){
          clearProfile();
        }
        else if (e.getX() >= 534 && e.getX() <= 678 && e.getY() >= 183 && e.getY() <= 253){
          if (output.equals("false"))
          {
            output = "true";
            //t.stop();
            t = new javax.swing.Timer(20, new ActionListener() {
              int number = 0;
              public void actionPerformed(ActionEvent e) {
                try{
                  number++;
                  if (number == 13)
                  {
                    t.stop();
                  }
                  current = settingsImage [number];
                  removeAll(); //refresh! 
                  repaint(); 
                  revalidate(); 
                  updateUI(); 
                }
                catch (ArrayIndexOutOfBoundsException a) {}             
              }
            });
            GameApp.mu.kill();
            GameApp.mu.player.getGainControl().setLevel((float)0.0);
            t.start();
          }
          else 
          {
            output = "false";
            //t.stop();
            t = new javax.swing.Timer(20, new ActionListener() {
              int number = 13;
              public void actionPerformed(ActionEvent e) {
                try{
                  number--;
                  if (number == 0)
                  {
                    t.stop();
                  }
                  current = settingsImage [number];
                  removeAll(); //refresh! 
                  repaint(); 
                  revalidate(); 
                  updateUI(); 
                }
                catch (ArrayIndexOutOfBoundsException a) {}
              }
            });
            GameApp.mu = new MusicPlayer();
            GameApp.mu.start();
            t.start();
          }
        }
        else{
          if (e.getX() >= 1 && e.getX() <= 625 && e.getY() >= 505 && e.getY() <= 585)
          {
            try{
              PrintWriter out = new PrintWriter(new FileWriter("../profiles/config.ini"));
              out.println("HORATIU INCORPORATED PROTECTED");
              out.println(output);
              out.close();
            }
            catch (IOException io){}
            GameApp.about(); 
          }
        }
        
      }                      
    });
  }
}