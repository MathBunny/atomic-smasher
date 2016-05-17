/** This class makes the basic template for the entire world object, composed of all of the map objects.
  * @author Horatiu Lazu
  * @version 1.0.0.0 May 15, 2014
  * 
  * Edit #1
  * -Horatiu Lazu
  * -Estimated Time Spent: 30 minutes
  * -Edits: Made the class.
  * 
  */
//import java.util.*;

public class World{
  /** ObjectInGrid[][] items This object stores the objects in the grid.*/
  public static ObjectInGrid [] [] items; //Should this be static?
  /** Chemical[][] [] chemicals This array stores the Chemical's in the grid.*/
  public static Chemical [] [] [] chemicals;
  /** MAX_DEPTH static final int This is a static final int used to indicate the maximum number of particles on one pipe at once.*/
  public static final int MAX_DEPTH = 3;
  /* int numOfChemicals This static variable stores the Chemical's in the grid.*/
  public static int numOfChemicals = 0;
  
  /** World constructor, used to specify the size of the grid.
    * @param int row This variable stores the number of rows.
    * @param int col This variable stores the number of columns.
    */
  //@SuppressWarnings("unchecked") 
  public World(int rows, int cols){
    items = new ObjectInGrid[cols][rows];
    chemicals = new Chemical[cols][rows][MAX_DEPTH];
    //chemicals = new ArrayList<Chemical> [cols][rows]; //ObjectInGrid
    //ArrayList  <Integer> hi = new ArrayList<Integer>();
  }
  
  /** This method returns the ObjectInGrid[][] variable.
    * @return ObjectInGrid[][]
    */
  public static ObjectInGrid[][] getItems(){
    return items; 
  }
  /** This method returns a specific item in the ObjectInGrid variable.
    * @param int x Used to represent the column.
    * @param int y Used to represent the row.
    * @return ObjectInGrid
    */
  public static ObjectInGrid getItem(int x, int y){
    return items[x][y]; 
  }
  
  /** This method returns a boolean if the ObjectInGrid variable is empty.
    * @param int x Used to represent the column.
    * @param int y Used to represent the row.
    * @return boolean
    * The ternary operator returns true / false accordingly.
    */
  public static boolean isEmpty(int x, int y){
    return ((items[x][y] == null) ? (true) : (false));
  }
  /** This method will set an item to a specific value.
    * @param ObjectInGrid o This is the object that the specific position will be change to.
    * @param int x This is the col that the object will be changed to in.
    * @param int y This is the row that the object will be changed to in.
    */
  public static void setItem(int x, int y, ObjectInGrid o){
    items[x][y] = o;
  }
  
  
}