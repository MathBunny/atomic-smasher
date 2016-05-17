/** The purpose of this class is to act as an Object template within the World class.
  * @author Horatiu Lazu
  * @version 1.0
  * Edited: May 30 2014
  * This class makes the basic template for any object inside the World class.
  * Time spent: 1 hour
  */
public class ObjectInGrid{
  /** picSource String This string stores the source for the Object's image.*/
  private String picSource;
  /** name String This String stores the name of the object.*/
  private String name;
  /** x int This integer stores the x coordinate in the plane.*/
  private int x;
  /** y int This integer stores the y coordinate in the plane.*/
  private int y;
  
  /** This is the class constructor for the ObjectInGrid class.
    * @param picSource String This is the String path for the image of the object.
    * @param name String This is the name of the object.
    * @param x int This is the x coordinate of the object.
    * @param y int This is the y coordinate of the object.*/
  public ObjectInGrid(String picSource, String name, int x, int y){
    this.picSource = picSource;
    this.name = name;
    this.x = x;
    this.y = y;
  }
  /** This method will set the picture source.
    * @param picSource
    */
  public void setPicSource(String picSource){
    this.picSource = picSource;
  }
  
  /** This method returns the name of the object.
    * @return String
    */
  public String getName(){
    return name; 
  }
  /** This method returns the picture source of the object.
    * @return String The pic source.*/
  public String getPicSource(){
    return picSource;
  }
  /** This method returns the x value of the object.
    * @return int The x coordinate.*/
  public int getX(){
    return x; 
  }
  /** This method sets the x value of the object.
    * @param x int This method sets the x value of the object*/
  public void setX(int x){
    this.x = x; 
  }
  /** This method sets the y value of the object.
    * @param y int This method sets the y value of the object.*/
  public void setY(int y){
    this.y = y; 
  }
  /** This method gets the y value of the object.
    * @return int The y coordinate. */
  public int getY(){
    return y; 
  }
}