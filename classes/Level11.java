import java.awt.*;
import javax.swing.*;

/** The purpose of this class is to be a level.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Time spent: 20 minutes
  * Last edit: June 2, 2014
  * Edited: made the class.
  */

public class Level11 extends Level{
  /** This is the class constructor for Level11*/
  public Level11(){
    p = new Physics(this);
  }
  /** This method initializes the World.
    * @param world World This is a World object.
    * @param goal Destination This is a destination object, which is the target for the game.
    * @param i int This is a for loop varibale.
    * */
  public void initializeWorld(){
    
    
    new World(7, 7); //Set the size of the world.
    //You now need to add pipes!.
    //Pipe ppp = new Pipe("PipeLeft.png", "1", 3, 2, Controller.WEST);
    //world.items[0][0] = ppp;
    //World.item.set(0, 0, new 
    addParticleSource("pipestartN", "Horatiu", 3, 5, Color.blue, Controller.NORTH, 1, "Hydrogen");
    //addParticleSource("pipestartW", "Horatiu", 5, 2, Color.blue, Controller.WEST, 1, "Hydrogen");
    //Destination(String picSource, String name, int x, int y, int direction, String elementName
    Destination goal = new Destination("pipeEndS", "Horatiu", 3, 1, Controller.SOUTH, "Hydrogen");
    
    //public Obstacle(String picSource, String name, int x, int y, Color c)
    World.setItem(3, 1, goal);
    for(int i = 0; i < 7; i++)
      World.setItem(2, i, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    for(int i = 0; i < 7; i++)
      World.setItem(4, i, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    //Start at middle, 44!!
    
    JOptionPane.showMessageDialog (null, "You have been hired to make a piping system for a hydrogen atom. You are to deliver hydrogen atoms from one source to another!\n Be careful! If you miss, the atoms may go off the pipes and not get to the destination!");
    
  }
  /** This method plays the world by calling the superclass simulate() method*/
  public void playWorld(){
    
    simulate();
  }
  
}