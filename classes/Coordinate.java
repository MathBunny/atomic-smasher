/** This is the coordinate class used in the application.
  * @author Horatiu Lazu
  * @version 1.0
  * Last edited: May 30, 2014
  * Time spent: 10 minutes.
  */
public class Coordinate{
  /** x int This is the x coordinate.*/
  private int x;
  /** y int This is the y coordinate.*/
  private int y;
  /** This is the class constructor of the coordinate class.
    * @param x int This is the x value.
    * @param y int This is the y value.
    */
  public Coordinate(int x, int y){
    this.x = x;
    this.y = y;
  }
  /** This method changes the x value.
    * @param x int This is the new x value.
    */
  public void changeX(int x){
    this.x = x;
  }
  /** This is the method that changes the y value.
    * @param y int This is the y value.
    */
  public void changeY(int y){
    this.y = y; 
  }
  /** This method returns the x value in the coordinate.
    * @return int The x coordinate.
    */
  public int getX(){
    return x; 
  }
  /** This method returns the y value in the coordinate.
    * @return int The y coordinate.
    */
  public int getY(){
    return y; 
  }
  
}