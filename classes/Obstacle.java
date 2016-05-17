import java.awt.*;
/**The purpose of this class is to simulate an obstacle in the game.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Time spent: 2 minutes
  * Date: June 3, 2014
  * Edit: Created the class.
  */
public class Obstacle extends ObjectInGrid{
  /** c Color This is a color reference, used to indicate the color of the obstacle.*/
  Color c;
  /** This is the class constructor for the obstacle class.
    * @param picSource String this is the picture source for the object.
    * @param x int This is the x coordinate for the object.
    * @param y int This is the y coordinate for the object.
    * @param c Color This is the color of the object.
    * */
  public Obstacle(String picSource, String name, int x, int y, Color c){
    super(picSource, name, x, y);
    this.c = c;
  }
  /** This method returns the color of the obstacle.
    * @return Color The color of the obstacle.*/
  public Color getColor(){
    return c;
  }
  /** This method sets the color of the obstacle.
    * @param c Color This is the new color of the obstacle.*/
  public void setColor(Color c){
    this.c = c;
  }
}