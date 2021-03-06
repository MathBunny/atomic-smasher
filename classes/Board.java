import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.*;
/** This class stores all of the properties from the board, including outputting all of the particles and board pieces.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Last edited: June 3, 2014
  * Time spent: 3 hours
  * Last changes: Made the class.
  */
public class Board extends JPanel{
  /** image Image This is an image reference, used for images.*/
  Image image;
  /** shouldDraw boolean This variable stores if the images should be drawn.*/
  boolean shouldDraw = false;
  /** filePath String This is the global filePath used.*/
  String filePath = "";
  /** x int This is the x coordinate currently in visit.*/
  int x;
  /** y int This is the y coordinate currently in visit. */
  int y;
  
  //static boolean isBuild = true;
  
  /** This is the default class constructor for the Board class.*/
  public Board(){
    initializeImage();
    addMouse();
  }
  
  //34 + (44 * particleSources.get(i).getX()), 28 + (44 * particleSources.get(i).getY())
  /** This method returns the adjusted x value.
    * @param x int This is the x coordinate.
    * @return int This is the new x coordinate. */
  public static int adjustX(int x){
    return (44 * x); //Why the rest?
  }
  /** This method returns the adjusted y value.
    * @param x int This is the y coordinate.
    * @return int This is the new y coordinate. */
  public static int adjustY(int y){
    return (44 * y + 44);
  }
  
  /** This method initializes the image for the game.
    * The try catch is used to ensure that no input output related error occurs.
    * @param e IOException This is an exception that could be thrown if there could be an input or output error.
    * @throws IOException This is thrown in case of an IO related error.
    */
  public void initializeImage(){
    try{
      //image = ImageIO.read(new File("Grid" + (((int)(Math.random() * 7) + 1) + ".png")));
      image = ImageIO.read(new File("../images/Grid" + 9 + ".png")); //4
      repaint();
      //JLabel picLabel = new JLabel(new ImageIcon(image));
      //add(picLabel);
    }
    catch(IOException e){}
  }
  
  /* HOW THE STUFF IS STORED - FOLLOW THE NOTATION BY THE IMAGES!
   * dbl = down back left
   * dbr = up 
   * Etc. See filenames!
   */
  
  /** This method adds a mouse, and adds the appropriate methods and actionListeners.
    * @param x int This is the x value of the mouse click.
    * @param y int This is the y value of the mouse click.
    * @param p Pipe This is the new instantiated pipe.
    * @param xx int This is the new x value used as a for loop counter.
    * @param yy int This is the new y value used as a for loop counter.
    * @param reply int This is the reply from the JOptionPane show confirm dialog.
    * @param e MouseEvent This is the MouseEvent that can be thrown.
    * The if statement (first one) verifies if the command is null.
    * The following if statements instantiate the pipes accordingly depending on the user selection which is in Controller.command
    * The if statements following will be utilized to determine if the user wants to delete everything, and it depends on their choice from the JOptionPane dialog.
    * The if statements verify if the Pipes being created are valid.
    */
  public void addMouse(){
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        //Goes by 50 everytime!
        if (GameContainer.isBuild){
          int x = ((e.getX() / 90));
          int y = ((e.getY() / 90));
          if (Controller.command == null)
            return;
          if (Controller.command.equals("erase")){
            if (World.items[x][y] instanceof Pipe)
              World.items[x][y] = null;
            else
              if (World.items[x][y] != null)
              JOptionPane.showMessageDialog ( null, "Error: You cannot delete end / start pipes!"); 
          }
          
          else if (Controller.command.equals("x")){
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear everything?", "Are you sure?", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION){
              for(int xx = 0; xx < World.items.length; xx++){
                for(int yy = 0; yy < World.items[0].length; yy++){
                  if (World.items[xx][yy] instanceof Pipe){
                    World.items[xx][yy] = null;
                  }
                }
              }
            }
            else {
              return;
            }
          }
          else if (World.items[x][y] != null && World.items[x][y] instanceof Pipe && (World.items[x][y].getPicSource().equals(Controller.command) || World.items[x][y].getPicSource().equals(Controller.command + "b"))){
            if (World.items[x][y].getPicSource().endsWith("b")){
              World.items[x][y].setPicSource(World.items[x][y].getPicSource().substring(0, World.items[x][y].getPicSource().length() - 1));
            }
            else{
              if (((Pipe)World.items[x][y]).hasMultipleDirections())
                World.items[x][y].setPicSource(World.items[x][y].getPicSource() + "b"); 
            }
          }
          else{
            if ((World.items[x][y] != null && !(World.items[x][y] instanceof ParticleSource) && !(World.items[x][y] instanceof Destination)) && !(World.items[x][y] instanceof Obstacle) && !(World.items[x][y] instanceof DiatomicBlock) || World.items[x][y] == null)
              World.items[x][y] = PipeType.returnPipe(Controller.command, x, y);
          }
          repaint();
        }   
      }
    });
  }
  /** This method outputs the graphics for the board.
    * @param g Graphics This is the graphics used to output to.
    * @param x int This is the x value inside a for loop (acts as a counter).
    * @param y int This is the y counter inside a for loop.
    * @param e IOException This is the IOException which can be thrown.
    * @param image Image This is the image which is read from a file.
    * @param z int This is a for loop variable.
    * @throws IOException
    * The for loops cycle through the different options, and the try catches prevent from any input output related errors.
    * The if statements verify against anything null.
    */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters 
    for(int x = 0; x < World.items.length; x++){
      for(int y = 0; y < World.items[0].length; y++){
        if (World.items[x][y] != null){
          try{
            Image image = (ImageIO.read(new File("../images/" + World.items[x][y].getPicSource() + ".png")));
            g.drawImage(image, x * 90, y * 90, null); 
          }
          catch(IOException e){
          }
        }
      }
    }
    for(int x = 0 ; x < World.chemicals.length; x++){
      for(int y = 0; y < World.chemicals[0].length; y++){
        for(int z = 0; z < World.chemicals[0][0].length; z++){
          if (World.chemicals[x][y][z] != null){
            try{
              g.drawImage((ImageIO.read(new File("../images/" + World.chemicals[x][y][z].getPicSource() + ".png"))), ((Chemical)World.chemicals[x][y][z]).getXCord(),((Chemical)World.chemicals[x][y][z]).getYCord(), null);
            }
            catch(IOException e){}
          }
        }
      }
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
}