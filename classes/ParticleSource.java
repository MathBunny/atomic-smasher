

import java.awt.*;
/** The purpose of this class is to act as a template for sourcing particles along in the grid.
 * @author Horatiu Lazu
 * @version 1.0.0.0
 * June 2, 2014
 * Last edit: Made the class.
 * Time spent: 5 hours
 */

public class ParticleSource extends ObjectInGrid{
  
  /** int numOfColors This variable stores the number of colours*/
  private int numOfColors;
  /** c Color This variable stores the Color of the particle source.*/
  private Color c;
  /** hasColors boolean This variable stores if the ParticleSource has colors.*/
  private boolean hasColors = false;
  /** colors Color [] This variable stores the different colours if it is a high capacity particle source.*/
  private Color [] colors; 
  /** colorsDelivered boolean [] This variable stores the different delivered colors.*/
  private boolean [] colorsDelivered;
  /** direction int This variable stores the direction.*/
  private int direction;
  /** elementType String This variable stores the elementType in a String.*/
  private String elementType;
  
  /** This method will return the element name.
    * @return String */
  public String getElementName(){
    return elementType; 
  }
  /** This is the class constructor for the ParticleSource class.
    * @param picSource String This is the picture source for the ParticleSource.
    * @param x int This is the x coordinate of the particle source.
    * @param y int This is the y coordinate of the particle source.
    * @param c Color This is the color for the particle source.
    * @param int numbOfColors This is an integer with the number of colours inside the ParticleSource.
    * @param direction int This is the direction of the ParticleSource.
    * @param elementType String This is the name of the element / type*/
  
  public ParticleSource(String picSource, String name, int x, int y, Color c, int numOfColors, int direction, String elementType){
    super(picSource, name, x, y);
    this.c = c;
    this.numOfColors = numOfColors;
    this.direction = direction;
    this.elementType = elementType;
  }
  /** This is a method that returns the direction of the object.
    * @return int */
  public int getDirection(){
    return direction; 
  }
  /** This is the class constructor for the ParticleSource class.
    * @param picSource String This is the picture source for the ParticleSource.
    * @param x int This is the x coordinate of the particle source.
    * @param y int This is the y coordinate of the particle source.
    * @param c Color This is the color for the particle source.
    * @param int numbOfColors This is an integer with the number of colours inside the ParticleSource.
    * @param direction int This is the direction of the ParticleSource.
    * @param Color [] colors This is an array of colours.
    * @param i int This is the for loop variable used to cycle through the global / instance array.
    */
  public ParticleSource(String picSource, String name, int x, int y, Color c, int numOfColors, int direction, Color [] colors){
    super(picSource, name, x, y);
    this.c = c;
    this.numOfColors = numOfColors;
    this.hasColors = true;
    this.colors = colors;
    colorsDelivered = new boolean[colors.length];
    //this.elementType = elementType; //READ THIS!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    for(int i =0; i < colorsDelivered.length; i++){
      colorsDelivered[i] = false;
    }
  }
  /** This method will return the colour of the ParticleSource
    * @return Color The color.*/
  public Color getColor(){
    return c; 
  }
  /** This method will return if it is done all of the colours.
    * @return boolean If it finished all colours.*/
  public boolean finishAllColors(){
    return false;//Finish!
  }
  /** This method will return the next colour in the ParticleSource
    * @return Color The next color.*/
  public Color getNextColor(){
    return Color.blue; //Finish! 
  }
  
  /** This method will decrement the number of colours if there are multiple.*/
  public void decrementNumOfColors(){
    numOfColors--;
  }
  
  
  /** This method will return the colours.
    * @return Color [] Returns all of the colors.*/
  public Color [] getColors(){
    return colors;
  }
  /**This method will return the number of colours.
    * @return int The number of colours.
    */
  public int getNumOfColors(){
    return numOfColors;
  }
  
}