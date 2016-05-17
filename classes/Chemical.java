import java.awt.*;

/** This application represents Chemicals in the game.
  * @author Horatiu Lazu
  * @version 1.0.0.0 May 15, 2014
  * 
  * Edit #1
  * -Horatiu Lazu
  * -Estimated Time Spent: 1 hour
  * 
  */
public class Chemical extends ObjectInGrid{
  
  /** Color color This variable stores the color of the Chemical.*/
  private Color color;
  /** String elementName This variable will store the name of the element.*/
  private String elementName = "";
  /** int direction This variable will store the direction of the chemical (the direction that it is going towards.*/
  private int direction;
  /** int xCord, this variable represents the xCord in terms of graphics of the chemical.*/
  private int xCord;
  /** int yCord, this variable represents the yCord in terms of graphics of the chemical.*/
  private int yCord;
  /** boolean hasShifted This variable represents if the chemical has been shifted by the Physics class into its new position*/
  private boolean hasShifted = false;
  /** int pipeExit This variable stores the pipeExit for the chemical.*/
  private int pipeExit;
  
  /** This is the class constructor of the Chemical class, which initializes all of the variables accordingly.
    * @param String picSource, which stores the colour of the picture.
    * @param String name This represents the name of the object.
    * @param int x This represents the x coordinate in the grid.
    * @param int y This represents the y coordinate in the grid.
    * @param Color c This represents the color of the object.
    * @param String elementName This represents the name of the element.
    * @param int direction This represents the direction as an integer value.
    * @param int xCord This represents the x coordinate in terms of graphics (pixels).
    * @param int yCord This represents the y coordinate in terms of graphics (pixels).
    * @param int pipeExit This represents the pipeExit for the chemical.
    */
  public Chemical(String picSource, String name, int x, int y, Color c, String elementName, int direction, int xCord, int yCord, int pipeExit){
    super(picSource, name, x, y);
    this.color = c;
    this.elementName = elementName;
    this.xCord = xCord;
    this.yCord = yCord;
    this.direction = direction;
    this.pipeExit = pipeExit;
  }
  
  /** This method returns the element name of the chemical.
    * @return String */
  public String getElementName(){
    return elementName; 
  }
  /** This method sets the element name according to a custom String.
    * @param element String This is the new element name. */
  public void setElementName(String element){
    this.elementName = element; 
  }
  /** This method returns the x coordinate.
    * @return int The x coordinate.*/
  public int getXCord(){
    return xCord;
  }
  /** This method returns the y coordinate.
    * @return int The y coordinate*/
  public int getYCord(){
    return yCord; 
  }
  /** This method if the chemical has been shifted by the physics class.
    * @return boolean Returns if the chemical was shifted.*/
  public boolean hasShifted(){
    return hasShifted; 
  }
  /** This method will set if it has been shifted by the physics class.
    * @param newValue boolean This is the new hasShifted value*/
  public void setHasShifted(boolean newValue){
    hasShifted = newValue; 
  }
  
  /** This method sets the direction of the instance variable.
    * @param int direction This value represents the directino value.
    */
  public void setDirection(int direction){
    this.direction =  direction;  //LOL 360 - here!
  }
  /** This method will return the pipe exit.
    * @return int Returns the pipe exit.*/
  public int getPipeExit(){
    return pipeExit; 
  }
  /** This method will set the pipe exit.
    * @return direction*/
  public void setPipeExit(int direction){
    this.pipeExit = direction; 
  }
  
  /** This method returns the direction.
    * @return int Returns the direction.
    */
  public int getDirection(){
    return direction; 
  }
  
  /** This method moves the coordinate of the chemical by a certain amount.
    * @param int incrementation This moves the xCord by that amount.
    */
  public void moveX(int incrementation){
    xCord = xCord + incrementation; 
  }
  
  /** This method sets the x coordinate.
    * @param newX int This is the x coordinate (new one).*/
  public void setXCord(int newX){
    xCord = newX;
  }
  /** This method sets the y coordinate.
    * @param newX int This is the y coordinate (new one).*/
  public void setYCord(int newY){
    yCord = newY; 
  }
  
  /** This method moves the coordinate of the chemical by a certain amount.
    * @param int incremention This moves the yCoordinate by that amount.
    */
  public void moveY(int incrementation){
    yCord = yCord + incrementation; 
  }
  
  /** This method acts all of the objects accordingly.
    * The if statements will apply the appropriate values to the x2 and y2 variables.
    * @param int x2 This variable stores the int value for the second x value.
    * @param int y2 This variable stores the int value for the second y value.
    */
  public void act(){
    int x2 = getX();
    int y2 = getY();
    if (direction == Controller.NORTH)
      y2++;
    else if (direction == Controller.NORTH_EAST){
      y2++;
      x2++;
    }
    else if (direction == Controller.NORTH_WEST){
      x2--;
      y2++;
    }
    else if (direction == Controller.EAST){
      x2++;
    }  
    else if (direction == Controller.SOUTH_EAST){
      y2--;
      x2++;
    }
    else if (direction == Controller.SOUTH_WEST){
      y2--;
      x2--;
    }
    else if (direction == Controller.WEST){
      x2--;
    }
    else{
      if (direction == Controller.SOUTH){
        y2--;
      }
    } //Previous if here!
    setX(x2);
    setY(y2); 
  }
  
  
}