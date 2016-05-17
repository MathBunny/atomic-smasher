import java.util.*;
/**This class identifies the different PipeTypes accordingly.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Time spent: 3 hours
  * Version edit: Made the class
  * Date: June 2, 2014
  */
public class PipeType{
  
  /** This method goes through every possible type of pipe, and then returns it accordingly.
    * All of the different if statements go through the different possibilities of pipes.
    * @param x int This is the x coordinate of the pipe.
    * @param y int This is the y coordinate of the pipe.
    * @param type String This is the type (in a String) of the pipe.
    * @param ArrayList<Direction> direction This is an ArrayList to store the different types of directions.
    * @return Pipe The pipe with the appropriate properties.
    * */
  public static Pipe returnPipe(String type, int x, int y){
    ArrayList <Direction> direction = new ArrayList<Direction>();
    if (type.equals("dbl")){
      direction.add(new Direction(Controller.WEST, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.WEST));
    }
    else if (type.equals("dbr")){
      direction.add(new Direction(Controller.EAST, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.EAST));
    }
    else if (type.equals("dul")){
      direction.add(new Direction(Controller.WEST, Controller.NORTH));
      direction.add(new Direction(Controller.NORTH, Controller.WEST));
    }
    else if (type.equals("dur")){
      direction.add(new Direction(Controller.NORTH, Controller.EAST));
      direction.add(new Direction(Controller.EAST, Controller.NORTH));
    }
    else if (type.equals("h")){
      direction.add(new Direction(Controller.WEST, Controller.EAST));
      direction.add(new Direction(Controller.EAST, Controller.WEST));
    }
    else if (type.equals("hdbl")){
      direction.add(new Direction(Controller.WEST, Controller.EAST));
      direction.add(new Direction(Controller.WEST, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.WEST));
      direction.add(new Direction(Controller.EAST, Controller.WEST));
    }
    else if (type.equals("hdbr")){
      direction.add(new Direction(Controller.WEST, Controller.EAST));
      direction.add(new Direction(Controller.EAST, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.EAST));
      direction.add(new Direction(Controller.EAST, Controller.WEST));
    }
    else if (type.equals("hdbl")){
      direction.add(new Direction(Controller.WEST, Controller.EAST));
      direction.add(new Direction(Controller.WEST, Controller.NORTH));
      direction.add(new Direction(Controller.NORTH, Controller.WEST));
      direction.add(new Direction(Controller.EAST, Controller.WEST));
    }
    else if (type.equals("plus")){
      direction.add(new Direction(Controller.WEST, Controller.EAST));
      direction.add(new Direction(Controller.EAST, Controller.WEST));
      direction.add(new Direction(Controller.NORTH, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.NORTH));
    }
    else if (type.equals("v")){
      direction.add(new Direction(Controller.NORTH, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.NORTH));
    }
    else if (type.equals("vdbl")){
      direction.add(new Direction(Controller.NORTH, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.NORTH));
      direction.add(new Direction(Controller.WEST, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.WEST));
    }
    else if (type.equals("vdbr")){
      direction.add(new Direction(Controller.NORTH, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.NORTH));
      direction.add(new Direction(Controller.EAST, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.EAST));
    }
    else if (type.equals("vdul")){
      direction.add(new Direction(Controller.NORTH, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.NORTH));
      direction.add(new Direction(Controller.WEST, Controller.NORTH));
      direction.add(new Direction(Controller.NORTH, Controller.WEST));
    }
    else if (type.equals("vdur")){
      direction.add(new Direction(Controller.NORTH, Controller.SOUTH));
      direction.add(new Direction(Controller.SOUTH, Controller.NORTH));
      direction.add(new Direction(Controller.NORTH, Controller.WEST));
      direction.add(new Direction(Controller.WEST, Controller.NORTH));
    }
    else{
      System.out.println("Could not find the image!"); 
    }
    return new Pipe(type, "Pipe", x, y, direction);
  }
  
}