/** Tihs class stores the direction of a particlar object.
  * @author Horatiu Lazu
  * @version 1.0
  * Edited: May 30, 2014
  * Added the basic framework for it.
  * Time spent: 5 minutes
  */

public class Direction{
  /** start int This is the starting degree of it.*/
  private int start;
  /** end int This is the ending degree of the direction.*/
  private int end; 
  /** This is the default class constructor
    * @param start int This is the starting degree of the direction.
    * @param end int This is the ending degree of the direction.
    */
  public Direction(int start, int end){
    this.start = start;
    this.end = end;
  }
  /** This method returns the sarting degree.
    * @return int The start.*/
  public int getStart(){
    return start; 
  }
  /** This method returns the ending degree.
    * @return int The end.*/
  public int getEnd(){
    return end; 
  }
  
}