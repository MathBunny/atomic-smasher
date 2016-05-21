import java.awt.*;
import javax.swing.*;

/** The purpose of this class is to be a level.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Time spent: 20 minutes
  * Last edit: June 2, 2014
  * Edited: made the class.
  */

public class Level12 extends Level{
  /** This is the class constructor for Level12*/
  public Level12(){
    p = new Physics(this);
  }
  /** This method initializes the World.
    * @param world World This is a World object.
    * @param goal Destination This is a destination object, which is the target for the game.
    * */
  public void initializeWorld(){
    
    new World(7, 7); //Set the size of the world.
    addParticleSource("pipestartE", "Horatiu", 1, 5, Color.blue, Controller.EAST, 1, "Oxygen");
    Destination goal = new Destination("pipeEndW", "Horatiu", 5, 2, Controller.WEST, "Oxygen");
    
    World.setItem(5, 3, goal);
    World.setItem(0, 1, new Obstacle("Rock", "Rock_OBSTACLE", 0, 1, Color.blue));
    World.setItem(2, 0, new Obstacle("Rock", "Rock_OBSTACLE", 2, 0, Color.blue));
    World.setItem(3, 1, new Obstacle("Rock", "Rock_OBSTACLE", 3, 1, Color.blue));
    World.setItem(4, 2, new Obstacle("Rock", "Rock_OBSTACLE", 4, 2, Color.blue));
    World.setItem(6, 2, new Obstacle("Rock", "Rock_OBSTACLE", 6, 2, Color.blue));
    World.setItem(0, 3, new Obstacle("Rock", "Rock_OBSTACLE", 0, 3, Color.blue));
    World.setItem(1, 3, new Obstacle("Rock", "Rock_OBSTACLE", 1, 3, Color.blue));
    World.setItem(3, 3, new Obstacle("Rock", "Rock_OBSTACLE", 3, 3, Color.blue));
    World.setItem(3, 4, new Obstacle("Rock", "Rock_OBSTACLE", 3, 4, Color.blue));
    World.setItem(5, 4, new Obstacle("Rock", "Rock_OBSTACLE", 5, 4, Color.blue));
    World.setItem(5, 5, new Obstacle("Rock", "Rock_OBSTACLE", 5, 5, Color.blue));
    World.setItem(1, 6, new Obstacle("Rock", "Rock_OBSTACLE", 1, 6, Color.blue));
    World.setItem(6, 6, new Obstacle("Rock", "Rock_OBSTACLE", 6, 6, Color.blue));
    
    World.setItem(2, 6, new Obstacle("Rock", "Rock_OBSTACLE", 2, 6, Color.blue));
    World.setItem(2, 4, new Obstacle("Rock", "Rock_OBSTACLE", 2, 4, Color.blue));
    
    JOptionPane.showMessageDialog (null, "You have been hired by Katya to make a piping system"
                                     + " to transfer oxygen. Make sure the oxygen does not go way off the pipes!"); 
    
  }
  /** This method plays the world by calling the superclass simulate() method*/
  public void playWorld(){
    simulate();
  }
  
}