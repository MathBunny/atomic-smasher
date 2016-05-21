/**The Controller class is a utility class which stores all of the coordinates, and it will check and act as a Location class.
  * 
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Last edited: June 3, 2014
  * Time spent: 5 hours
  */

public class Controller{
  /** String command, this variable stores the current command from particular classes.*/
  public static String command;
  /** int set This variable will be used to indicate the number of sets.*/
  public static int set = 0;
  /**
   * int NORTH The North The compass direction for north.
   */
  public static final int NORTH = 0;
  /**
   * int NORTH_EAST The compass direction for northeast.
   */
  public static final int NORTH_EAST = 45;
  /**
   * int EAST The compass direction for east.
   */
  public static final int EAST = 90;
  /**
   * int SOUTH_EAST The compass direction for southeast.
   */
  public static final int SOUTH_EAST = 135;
  /**
   * int SOUTH The compass direction for south.
   */
  public static final int SOUTH = 180;
  /**
   * int SOUTH_WEST Thecompass direction for southwest.
   */
  public static final int SOUTH_WEST = 225;
  /**
   * int WEST The compass direction for west.
   */
  public static final int WEST = 270;
  /**
   * int NORTH_WEST The compass direction for northwest.
   */
  public static final int NORTH_WEST = 315;
  
  
  
  /**
   * int LEFT The turn angle for turning 90 degrees to the left.
   */
  public static final int LEFT = -90;
  /**
   * int RIGHT The turn angle for turning 90 degrees to the right.
   */
  public static final int RIGHT = 90;
  /**
   * int HALF_LEFT The turn angle for turning 45 degrees to the left.
   */
  public static final int HALF_LEFT = -45;
  /**
   * int HALF_RIGHT The turn angle for turning 45 degrees to the right.
   */
  public static final int HALF_RIGHT = 45;
  /**
   * int FULL_CIRCLE The turn angle for turning a full circle.
   */
  public static final int FULL_CIRCLE = 360;
  /**
   * int HALF_CIRCLE The turn angle for turning a half circle.
   */
  public static final int HALF_CIRCLE = 180;
  /**
   * int AHEAD The turn angle for making no turn.
   */
  public static final int AHEAD = 0;
  
  /**This is a blank Controller constructor.*/
  public Controller(){
    
  }
  
  /** This method will get the X change for a particular direction.
    * The if statements will return the appopriate files.
    * @param int direction Stores the direction.
    * @return int The new xChange.
    */
  
  public static int getXChange(int direction){
    if (direction > NORTH && direction < SOUTH)
      return 1;
    else if (direction == NORTH || direction == SOUTH)
      return 0;
    else
      return -1;
  }
  
  /** This method will get the Y change for a particular direction.
    * The if statements will return the appopriate files.
    * @param int direction Stores the direction.
    * @return int The new y change.
    */
  public static int getYChange(int direction){
    if (direction == NORTH || direction == NORTH_WEST || direction == NORTH_EAST)
      return -1;
    else if (direction == EAST || direction == WEST)
      return 0;
    else
      return 1;
  }
  
  /**This method finds the depth of the chemical field, meaning the amount of chemicals and available spots within the three dimensional World based chemical array.
    * @param x int This is the x coordinate of the chemical.
    * @param y int This is the y coordinate of the chemical.
    * @param i int This is a for loop variable.
    * @return int The chemical depth.
    * The for loop goes through the options until a null is presented.
    * If no nulls are found, then the MAX_DEPTH from World is returned.
    * */
  public static int getChemicalDepth(int x, int y){
    for(int i = 0; i < World.chemicals[0][0].length; i++){
      if (World.chemicals[x][y][i] ==  null){
        return i;
      }
    }
    return World.MAX_DEPTH;
  }
  
  /**This method will find the neccessary pipe entrance depending based off of the exit point.
    * @param direction int This is the direction.
    * All of the if statements will find the opposite direction.
    * @return int The pipe entrance.
    */
  public static int getPipeEntrance(int direction){
    if (direction == NORTH){
      return SOUTH; 
    }
    if (direction == EAST){
      return WEST;
    }
    if (direction == SOUTH){
      return NORTH;
    }
    if (direction == WEST){
      return EAST; 
    }
    return -1;
  }
  
  /**This method will find the pipe exit for the new pipe depending on the entrance point WITHIN the pipe itself!
    * @param fileName2 String This is the filename for the pipe (used in the identification of the pipe type).
    * @param fileName2 String This is the filename for the pipe (used in the identification of the pipe type).
    * @param entrance int This is the entrance of the pipe.
    * @param isDiagonal boolean This is the boolean if the pipe is on a diagonal.
    * @return int The pipe exit.
    * All of the if statements go through every possible type of pipe, and then return accordingly.
    */
  public static int getPipeExit(String fileName2, int entrance, boolean isDiagonal){
    String fileName = fileName2;
    if (fileName.endsWith("b")){
      fileName = fileName.substring(0, fileName.length() - 1); 
    }
    
    if (fileName.equals("dbl")){
      if (entrance == Controller.WEST)
        return SOUTH;
      else
        return WEST; //WHAT ABOUT COMING IN FROM A DIAGONAL?
    }
    else if (fileName.equals("dbr")){
      if (entrance == SOUTH)
        return EAST;
      else
        return SOUTH;
    }
    else if (fileName.equals("dul")){
      if (entrance == NORTH)
        return WEST;
      else
        return NORTH;
    }
    else if (fileName.equals("dur")){
      if (entrance == NORTH)
        return EAST;
      else
        return NORTH;
    }
    else if (fileName.equals("h")){
      if (entrance == WEST){
        return EAST; 
      }
      else
        return WEST;
    }
    else if (fileName.equals("hdbl")){
      if (entrance == EAST)
        return WEST;
      if (entrance == WEST && isDiagonal)
        return SOUTH;
      if (entrance == SOUTH)
        return WEST;
      return EAST;
    }
    else if (fileName.equals("hdbr")){
      if (entrance == EAST && isDiagonal){
        return SOUTH;
      }
      if (entrance == EAST)
        return WEST;
      if (entrance == SOUTH)
        return EAST;
      return EAST;
    }
    else if (fileName.equals("hdul")){
      if (entrance == EAST){
        return WEST; 
      }
      if (entrance == WEST && isDiagonal)
        return NORTH;
      if (entrance == NORTH)
        return WEST;
      return EAST;
    }
    else if (fileName.equals("hdur")){
      if (entrance == WEST)
        return EAST;
      if (entrance == EAST && isDiagonal){
        return NORTH; 
      }
      if (entrance == NORTH)
        return EAST;
      return WEST;
    }
    else if (fileName.equals("plus")){
      if (entrance == WEST)
        return EAST;
      if (entrance == EAST)
        return WEST;
      if (entrance == NORTH)
        return SOUTH;
      return NORTH;
    }
    else if (fileName.equals("vdbl")){
      if (entrance == NORTH){
        return SOUTH; 
      }
      if (entrance == SOUTH && isDiagonal)
        return WEST;
      if (entrance == WEST)
        return SOUTH;
      return NORTH;
    }
    else if (fileName.equals("vdbr")){
      if (entrance == NORTH)
        return SOUTH;
      if (entrance == SOUTH && isDiagonal)
        return EAST;
      if (entrance == EAST)
        return SOUTH;
      return NORTH;
    }
    else if (fileName.equals("vdul")){
      if (entrance == SOUTH)
        return NORTH;
      if (entrance == NORTH && isDiagonal)
        return WEST;
      if (entrance == WEST)
        return NORTH;
      return SOUTH;
    }
    else if (fileName.equals("vdur")){
      if (entrance == SOUTH)
        return NORTH;
      if (entrance == NORTH && isDiagonal)
        return EAST;
      if (entrance == EAST)
        return NORTH;
      return SOUTH;
    }
    else{
      if (fileName.equals("v")){
        if (entrance == NORTH)
          return SOUTH;
        else
          return NORTH;
      }
    }
    return -1;
  }
  
  /**This method essentially identifies the direction for the entrance based off of the previous point.
    * @param fileName String This is the filename for the type of pipe.
    * @param entrance int This is the entrance to the the type of pipe.
    * @param isDiagonal boolean This indicates if the path is from a diagonal or not.
    * @return int The direction for the entrance.
    * All of the if statements verify for the different possibilities.
    */
  public static int getDirectionForEntrance(String fileName2, int entrance, boolean isDiagonal){
    String fileName = fileName2;
    if (fileName.endsWith("b")){
      fileName = fileName.substring(0, fileName.length() - 1); 
    }
    
    
    if(fileName.equals("dbl")){
      if (entrance == WEST)
        return SOUTH_EAST; //Woah...major problem perhaps? It should be based off of goal!
      else
        return NORTH_WEST;
    }
    if(fileName.equals("dbr")){
      if (entrance == SOUTH)
        return NORTH_EAST;
      else
        return SOUTH_WEST;
    }
    if(fileName.equals("dul")){
      if (entrance == WEST)
        return NORTH_EAST;
      else
        return SOUTH_WEST;
    }
    if(fileName.equals("dur")){
      if (entrance == NORTH)
        return SOUTH_EAST;
      else
        return NORTH_WEST;
    }
    if(fileName.equals("h")){
      return (entrance == WEST) ? (EAST) : (WEST); //entrance
    }
    if(fileName.equals("hdbl")){ //Shit
      if (entrance == WEST)
        return (isDiagonal) ? (SOUTH_EAST) : (EAST);
      else
        return WEST;
    }
    if(fileName.equals("hdbl")){ //Shit
      if (entrance == EAST)
        return (isDiagonal) ? (SOUTH_WEST) : (WEST);
      else
        return EAST;
    }
    if(fileName.equals("hdbr")){ //Shit
      if (entrance == EAST)
        return (isDiagonal) ? (SOUTH_WEST) : (WEST);
      else
        return EAST;
    }
    if(fileName.equals("hdul")){ //Shit
      if (entrance == WEST)
        return (isDiagonal) ? (NORTH_EAST) : (EAST);
      else
        return EAST;
    }
    if(fileName.equals("hdur")){ //Shit Extra shit
      if (entrance == EAST)
        return (isDiagonal) ? (NORTH_WEST) : (WEST);
      else
        return EAST;
    }
    
    if (fileName.equals("plus")){
      if (entrance == SOUTH)
        return NORTH;
      if (entrance == NORTH)
        return SOUTH;
      if (entrance == EAST)
        return WEST;
      if (entrance == WEST)
        return EAST;
    }
    
    if (fileName.equals("v")){
      if (entrance == NORTH)
        return SOUTH;
      else
        return NORTH;
    }
    
    if(fileName.equals("vdbl")){ //Shit
      if (entrance == NORTH){
        return SOUTH; 
      }
      else if (entrance == WEST){
        return SOUTH_EAST;
      }
      else if (entrance == SOUTH && isDiagonal)
        return NORTH_WEST;
      else
        return NORTH;
    }
    if(fileName.equals("vdbr")){ //Shit
      if (entrance == SOUTH)
        return (isDiagonal) ? (NORTH_EAST) : (NORTH);
      else
        return SOUTH;
    }
    
    if(fileName.equals("vdul")){ //Shit
      if (entrance == NORTH)
        return (isDiagonal) ? (SOUTH_WEST) : (SOUTH);
      else
        return NORTH;
    }
    
    if(fileName.equals("vdur")){ //Shit
      if (entrance == NORTH)
        return (isDiagonal) ? (SOUTH_EAST) : (SOUTH);
      else
        return NORTH;
    }
    return -1;
  }
  
  /*
   public static boolean isValidRailLocation(int x1, int y1, int x2, int y2){
   try{
   if ((((Pipe)World.items[x1][y1]).getPipeDirection()) == NORTH && x1 == x2 && y2 > y1)
   return true;
   else if ((((Pipe)World.items[x1][y1]).getPipeDirection()) == NORTH_EAST && x2 > x1 && y2 > y1)
   return true;
   else if ((((Pipe)World.items[x1][y1]).getPipeDirection()) == EAST && x2 > x1 && x2 == x1)
   return true;
   else if ((((Pipe)World.items[x1][y1]).getPipeDirection()) == SOUTH_EAST && x2 > x1 && y1 > y2)
   return true;
   else if ((((Pipe)World.items[x1][y1]).getPipeDirection()) == SOUTH && x2 == x1 && y1 > y2)
   return true;
   else if ((((Pipe)World.items[x1][y1]).getPipeDirection()) == SOUTH_WEST && x2 < x1 && y1 > y2)
   return true;
   else if ((((Pipe)World.items[x1][y1]).getPipeDirection()) == WEST && x2 < x1 && y1 == y2)
   return true;
   else 
   if ((((Pipe)World.items[x1][y1]).getPipeDirection()) == NORTH_WEST && x2 < x1 && y1 < y2)
   return true;
   return false;
   }
   catch(ClassCastException e){
   return false;
   }
   }*/
  
  
}