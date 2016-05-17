/**This class is the destination template for a destination object
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * 
  * Edit #1: Made the basic outline.
  * Last edited: June 3, 2014
  * Time spent: 1 hour
  * 
  */

public class Destination extends ObjectInGrid{
  /** elementName This is the element name of the object.*/
  String elementName;
  /** direction int This is the direction of the object.*/
  int direction;
  
  /** This is the class constructor of the destination class.
    * @param picSource String this is the picture source for the Destination class.
    * @param name String This is the name of the destination.
    * @param x int This is the x coordinate of the destination.
    * @param y int This is the y coordinate of the destination.
    * @param direction int This is the direction of the destination.
    * @param elementName String This is the element name of the destination.*/
  public Destination(String picSource, String name, int x, int y, int direction, String elementName){
    super(picSource, name, x, y);
    this.direction = direction;
    this.elementName = elementName;
  }
  /**This method returns the direction of the destination.
    * @return int Returns the direction.
    */
  public int getDirection(){
    return direction;
  }
  /** This method returns the element name of the destination.
    * @return String The element name.*/
  public String getElementName(){
    return elementName; 
  }
  /** This method sets the element name of the destination.
    * @param newName String The new element name*/
  public void setElementName(String newName){
    elementName = newName; 
  }
  
}