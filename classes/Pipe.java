import java.util.*;

/** This class acts the database for a Pipe object.
  * @author Horatiu Lazu
  * @version 1.1
  * Edit date: Thursday, May 30 2014
  * Changes:
  * -Added the Direction Class
  * Edit date (version 1.1): Friday May 31, 2014
  * Changes:
  * -Implemented all of the methods correctly.
  */

public class Pipe extends ObjectInGrid{
  /*private String filePath;
   private int x;
   private int y;*/
  
  /** directions ArrayList<Direction> This variable stores all of the directions of the pipe.*/
  private ArrayList<Direction> directions;
  /** currentDirection int This variable stores the current direction*/
  private int currentDirection = 0;
  /** hasMultipleDirections boolean This variable stores the multiple directions.*/
  private boolean hasMultipleDirections;
  
  
  /**This is a class constructor for the Pipe class.
    * @param x int This is the x coordinate.
    * @param y int This is the y coordinate.
    *@param filePath String This is the filePath for the image.
    *@param name String This is the name of the object, as viewed internally.
    *@param directions ArrayList<Direction> This is the list of possible directions.
    */
  public Pipe(String filePath, String name, int x, int y, ArrayList <Direction> directions){
    super(filePath, name, x, y);
    /*this.filePath = filePath;
     this.x = x;
     this.y = y;*/
    this.directions = directions;
    this.hasMultipleDirections = (directions.size() > 2 && filePath != "plus"); //2?
  }
  
  /** This method will switch the direction of the pipe.
    * The if statements verify if the pipe is multidirectional, and if so then it should add b / remove accordinfly.*/
  public void switchDirection(){
    if (hasMultipleDirections()){
      if (getPicSource().endsWith("b"))
        setPicSource(getPicSource().substring(0, getPicSource().length() - 1));
      else
        setPicSource(getPicSource() + "b");
    }
  }
  
  
  
  /** This method returns if the pipe has multiple directions.
    * @return boolean If it has multiple directions.
    */
  public boolean hasMultipleDirections(){
    return hasMultipleDirections; 
  }
  /**This is a class constructor for the Pipe class.
    *@param filePath String This is the filePath for the image.
    *@param name String This is the name of the object, as viewed internally.
    *@param directions ArrayList<Direction> This is the list of possible directions.
    *@param isCross boolean This boolean indicates if the pipe is a cross.
    */
  public Pipe(String filePath, String name, int x, int y, ArrayList <Direction> directions, boolean isCross){
    super(filePath, name, x, y);
    /*this.filePath = filePath;
     this.x = x;
     this.y = y;*/
    this.directions = directions;
    this.hasMultipleDirections = false;
  }
  
  /** This method will return if there is an opening in that particular location.
    * The if statements cycle through the different possibilities.
    * @param loc int This is the location.
    * @param i int This is a for loop variable.
    * @return boolean If it has an opening.
    * */
  public boolean hasOpening(int loc){
    for(int i = 0; i < directions.size(); i++){
      if (directions.get(i).getStart() == loc)
        return true;
      if (directions.get(i).getEnd() == loc)
        return true;
    }
    return false; //Here!
  }
  
  /** This method returns the current direction, and increments it accordingly.
    * The first if statement verifies to see if there are multiple directions. If yes, it will increment and return accordingly.
    * Else, the first possible direction is returned.
    * @return Direction The different directions.
    */
  
  public Direction getDirection(){
    if (hasMultipleDirections){
      if (currentDirection == 0){
        currentDirection++; //ADJUST IMAGE!!
        return directions.get(0);
      }
      else{
        currentDirection = 0;
        return directions.get(1);
      }
    }
    return directions.get(0);
  }
  
  
  
}