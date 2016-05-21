import java.awt.*;
import javax.swing.*;
/** The purpose of this class is to be a level.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Time spent: 20 minutes
  * Last edit: June 2, 2014
  * Edited: made the class.
  */

public class Level13 extends Level{
  /** This is the class constructor for Level13*/
  public Level13(){
    p = new Physics(this);
    
  }
  /** This method initializes the World.
    * @param world World This is a World object.
    * @param goal Destination This is a destination object, which is the target for the game.
    * @param goal2 Destination This is a destination object, used as the second target.
    * @param i int This is a for loop variable.
    * */
  public void initializeWorld(){
    
    new World(7, 7); //Set the size of the world.
    addParticleSource("pipestartS", "Horatiu", 1, 0, Color.blue, Controller.SOUTH, 1, "Oxygen");
    addParticleSource("pipestartS", "Horatiu", 5, 0, Color.blue, Controller.SOUTH, 1, "Hydrogen");
    Destination goal = new Destination("pipeEndN", "Horatiu", 1, 6, Controller.NORTH, "Oxygen");
    Destination goal2 = new Destination("pipeEndN", "Horatiu", 5, 6, Controller.NORTH, "Hydrogen");
    
    World.setItem(1, 6, goal);
    World.setItem(5, 6, goal2);
    
    
    for(int i = 0; i < 7; i++)
      World.setItem(0, i, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    for(int i = 0; i < 7; i++)
      World.setItem(2, i, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    
    for(int i = 0; i < 7; i++)
      World.setItem(4, i, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    for(int i = 0; i < 7; i++)
      World.setItem(6, i, new Obstacle("Rock", "Rock", 2, i, Color.blue));
    //Start at middle, 44!!
    
    JOptionPane.showMessageDialog (null, "You have been hired by Steven to make a piping system"
                                     + " to transfer Oxygen and Hydrogen to their closest destination. Make sure the atoms do not go way off the pipes!");
    
  }
  /** This method plays the world by calling the superclass simulate() method*/
  public void playWorld(){
    simulate();
  }
  
}