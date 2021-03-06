import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
/**This class acts as a container for game related objects.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Last edit: June 3, 2014
  * Horatiu made the class.
  * Time spent: 4 hours
  */

public class GameContainer extends JPanel implements MouseListener{
  /** o Image This variable stores the main image for the GameContainer.*/
  Image o;
  /** pause Image This variable stores the image for the pause button*/
  Image pause;
  /** shouldDrawPause boolean This variable stores if the user should draw pause*/
  //boolean shouldDrawPause = false;
  /** z Image This variable store an image used when pausing.*/
  Image z;
  /** run Image This variable stores the run icon*/
  Image run;
  /** stop Image This variable stores the stop icon.*/
  Image stop;
  /** isBuild boolean This variable represents if the current status is on a build.*/
  static boolean isBuild = true;
  /** build Image This variable represents the build image.*/
  Image build;
  /** stage Image This is the image for the stage / background*/
  Image stage;
  
  /** This method overloads the repaint() method, which passes a Graphics variable.
    * @param g Graphics This provide access to the graphics.
    * @param e IOException This prevents any input output related errors.
    * @throws IOException
    * The if statements verify to see if the Controller command is null, and if not then it will update the currently chosen item.
    * The try catch prevents any input output related errors.
    */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    g.drawImage(o, 0, 0, null); // see javadoc for more info on the parameters   
    if (pause != null){
      g.drawImage(pause, 840, 20, null);
      g.drawImage(((!isBuild) ? (build) : (run)), 840, 150, null);
      g.drawImage(stop, 840, 300, null);      
      g.drawImage(stage, 840, 500, null);
      try{
        if (Controller.command != null){
          g.drawImage(ImageIO.read(new File("../images/" + Controller.command + ".png")), 844, 502, null);
        }
        g.drawImage(ImageIO.read(new File("../images/selection.png")), 817, 470, null);
      }
      catch(IOException e){}
      //g.drawImage(pause, 860, 200, null);
    }
    
    
  }
  /** This is the class constructor for the GameContainer.
    * @param o Image This is the image. */
  public GameContainer(Image o){
    this.o = o;
  }
  /** This is the class constructor for the GameContainer.
    * @param o Image This is the background image.
    * @param run Image This is the run icon.
    * @param stop Image This is the stop icon. */
  public GameContainer(Image o, Image pause, Image run, Image stop, Image build, Image stage){
    this.o = o;
    this.pause = pause;
    this.run = run;
    this.stop = stop;
    this.build = build;
    this.stage = stage;
    addMouse();
  }
  /** This method draws an image.
    * @param zz Image This is the image. */
  public void drawImage(Image zz){
    //shouldDrawPause = true;
    z = zz;
    repaint();
    //shouldDrawPause = false;
  }
  
  /** This method adds a mouse to the JPanel
    * @param e MouseEvent This is a MouseEvent reference variable.
    * The if statements verify the x and y postiion, and verify accordingly to ensure that the proper icon is chosen.
    */
  public void addMouse(){
    addMouseListener
      (new MouseAdapter()
         {
      public void mouseReleased(MouseEvent e)
      {
        repaint();
        if (e.getX() >= 846 && e.getX() <= 934){
          if (e.getY() >= 25 && e.getY() <= 115){
            //shouldDrawPause = true;
            //isOnPause = true;
            repaint();
            GameApp.pauseGame();
            //System.out.println("Valid!");
          }
          else if (e.getY() >= 154 && e.getY() <= 260){
            //BUild / plah 
            if (!isBuild)
              GameApp.level.t.stop();
            else{
              GameApp.level.simulate();
              GameApp.level.t.start();
            }
            isBuild = !isBuild; 
          }
          else{
            if (e.getY() >= 283 && e.getY() < 404){
              GameApp.instructions();
              // STOP
              //GameApp.removeGame();
              // GameApp.display(GameApp.currentLevel, false);
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
    * @param e MouseEvent, used to provide information the mouse, etc.
    */
  public void mousePressed(MouseEvent e) {}
  /**This method is triggered when a mouse is enters.
    * @param e MouseEvent, used to provide information the mouse, etc.
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