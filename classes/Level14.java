import java.awt.*;
import javax.swing.*;

/** The purpose of this class is to be a level.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Time spent: 20 minutes
  * Last edit: June 2, 2014
  * Edited: made the class.
  */

public class Level14 extends Level{
  /** This is the class constructor for Level14*/
  public Level14(){
    p = new Physics(this);
  }
  /** This method initializes the World.
    * @param world World This is a World object.
    * @param goal Destination This is a destination object, which is the target for the game.
    * @param goal2 Destination This is another goal.
    * @param i int This is a for loop variable.
    * */
  public void initializeWorld(){
    
    new World(7, 7);
    addParticleSource("pipestartE", "Horatiu", 0, 5, Color.blue, Controller.EAST, 1, "Hydrogen");
    addParticleSource("pipestartW", "Horatiu", 6, 5, Color.blue, Controller.WEST, 1, "Hydrogen");
    Destination goal = new Destination("pipeEndW", "Horatiu", 3, 5, Controller.WEST, "Hydrogen");
    Destination goal2 = new Destination("pipeEndE", "Horatiu", 4, 5, Controller.EAST, "Hydrogen");
    
    //public Obstacle(String picSource, String name, int x, int y, Color c)
    World.setItem(3, 5, goal);
    World.setItem(4, 5, goal2);
    
    
    for(int i = 0; i < 7; i++)
      World.setItem(i, 4, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    
    for(int i = 0; i < 7; i++)
      World.setItem(i, 6, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    
    JOptionPane.showMessageDialog (null, "You have been hired by Jerry to make a piping system"
                                     + " to transfer hydrogen. Make sure the hydrogen atoms do not go way off the pipes!"); 
    //Start at middle, 44!!
    
  }
  /** This method plays the world by calling the superclass simulate() method*/
  public void playWorld(){
    simulate();
  }
  
}