import java.awt.*;
import javax.swing.*;

/** The purpose of this class is to be a level.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Time spent: 20 minutes
  * Last edit: June 2, 2014
  * Edited: made the class.
  */

public class Level22 extends Level{
  /** This is the class constructor for Level22 */
  public Level22(){
    p = new Physics(this);
    //initializeWorld();
    //initializePhysics();
  }
  /** This method initializes the World.
    * @param world World This is a World object.
    * @param goal Destination This is a destination object, which is the target for the game.
    * @param goal2 Destination This is a destination object, which is another target for the game.
    * @param b DiatomicBlock This is a DiatomicBlock.
    * @param b2 DiatomiBlock This is another DiatomicBlock.
    * @param i int This is a for loop variable.
    * @param goal3 Destination This is a destination block.
    * */
  public void initializeWorld(){
    
    new World(7, 7); //Set the size of the world.
    addParticleSource("pipestartE", "Horatiu", 0, 1, Color.blue, Controller.EAST, 1, "Oxygen");
    addParticleSource("pipestartW", "Horatiu", 2, 1, Color.blue, Controller.WEST, 1, "Oxygen");
    
    
    addParticleSource("pipestartE", "Horatiu", 3, 4, Color.blue, Controller.EAST, 1, "Oxygen");
    addParticleSource("pipestartW", "Horatiu", 5, 4, Color.blue, Controller.WEST, 1, "Oxygen");

    Destination goal = new Destination("pipeEndN", "Horatiu", 1, 3, Controller.NORTH, "../images/Oxygen2");
    Destination goal2 = new Destination("pipeEndN", "Horatiu", 4, 6, Controller.NORTH, "../images/Oxygen2");
    DiatomicBlock b = new DiatomicBlock("diatomicCombineS", "Horatiu", 1, 1, "Oxygen", "Oxygen2");
    DiatomicBlock b2 = new DiatomicBlock("diatomicCombineS", "Horatiu", 4, 4, "Oxygen", "Oxygen2");
    
    for(int i = 0; i < 7; i++)
      World.setItem(i, 3, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    
    for(int i = 0; i < 7; i++)
      World.setItem(i, 6, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    //Start at middle, 44!!
    World.setItem(1, 1, b);
    World.setItem(4, 4, b2);
    World.setItem(1, 3, goal);
    World.setItem(4, 6, goal2);
    
    JOptionPane.showMessageDialog (null, "You have been hired by Andrew to make a piping system"
                                     + " to transfer two oxygen atoms and combine them. Make sure the oxygen does not go way off the pipes!"); 
    
  }
  /** This method plays the world by calling the superclass simulate() method*/
  public void playWorld(){
    simulate();
  }
  
}