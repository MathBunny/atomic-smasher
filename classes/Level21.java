import java.awt.*;
import javax.swing.*;

/** The purpose of this class is to be a level. The 2 indicates diatomic, which is a new level pack apart from the 1's which were basic elements.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Time spent: 20 minutes
  * Last edit: June 2, 2014
  * Edited: made the class.
  */

public class Level21 extends Level{
  /** This is the class constructor for Level21*/
  public Level21(){
    p = new Physics(this);
  }
  /** This method initializes the World.
    * @param world World This is a World object.
    * @param goal Destination This is a destination object, which is the target for the game.
    * @param i int This is a for loop variable.
    * */
  public void initializeWorld(){
    
    
    
    new World(7, 7); //Set the size of the world.
    addParticleSource("pipestartE", "Horatiu", 0, 4, Color.blue, Controller.EAST, 1, "Oxygen");
    addParticleSource("pipestartW", "Horatiu", 6, 4, Color.blue, Controller.WEST, 1, "Oxygen");
    Destination goal = new Destination("pipeEndN", "Horatiu", 3, 6, Controller.NORTH, "../images/Oxygen2");
    DiatomicBlock b = new DiatomicBlock("diatomicCombineS", "Horatiu", 3, 4, "Oxygen", "Oxygen2");
    
    for(int i = 0; i < 7; i++)
      World.setItem(i, 3, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    
    for(int i = 0; i < 7; i++)
      World.setItem(i, 6, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    for(int i = 0; i < 3; i++)
      World.setItem(i, 5, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    for(int i = 4; i < 7; i++)
      World.setItem(i, 5, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    //Start at middle, 44!!
    World.setItem(3, 4, b);
    World.setItem(3, 6, goal);
    
    JOptionPane.showMessageDialog (null, "Horatiu is confused. He wants to see how two oxygens can combine! Show him diatomics with the diatomic block!" + 
                                   " Make sure the oxygen does not go way off the pipes!"); 
    
  }
  /** This method plays the world by calling the superclass simulate() method*/
  public void playWorld(){
    simulate();
  }
  
}