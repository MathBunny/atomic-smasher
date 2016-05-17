import java.awt.*;

/**
 * @author Horatiu Lazu
 * @version 1
 * Last edit: Horatiu Lazu
 * Changes: Made the class.
 */

public class DiatomicBlock extends ObjectInGrid{
  /** compoundNames String This is the name of the compound.*/
  private String compoundNames;
  /** output String This is the output particle.*/
  private String output;
  /** inserted int This is an integer representing the number of inserted particles into the diatomic block.*/
  int inserted = 0;
  
  /** This is the class constructor of DiatomicBlock.
    * @param picSource String This is an image link to the picture of a diatomic block.
    * @param name String This is the name.
    * @param x int This is the x coordinate.
    * @param y int This is the y coordinate.
    * @param compoundNames String This is the name of the compounds.
    * @param output String This is the output chemical name. */
  public DiatomicBlock(String picSource, String name, int x, int y, String compoundNames, String output){
    super(picSource, name, x, y);
    this.compoundNames = compoundNames;
    this.output = "../images/" + output;
    
  }
  
  /** This method returns the inserted elements.
    * @return int This is the number of inserted elements. */
  public int getInserted(){
    return inserted; 
  }
  
  /** This method increments the diatomic elements.*/
  public void incrementGained(){
    inserted++;
  }
  /** This method returns the compound names.
    * @return String This is the compound name.*/
  public String getCompoundNames(){
    return compoundNames; 
  }
  /** This method returns the output.
    * @return String This is the output.*/
  public String getOutput(){
    return output; 
  }
  /** This method instantiates the chemicals.*/
  public void instantiateChemical(){
    World.chemicals[getX()][getY()][Controller.getChemicalDepth(getX(), getY()) + 1] = (new Chemical(output,"Chemical", getX(), getY(), Color.red, output, Controller.SOUTH, 34 + (88 * getX()), 34 + (88 * getY()), Controller.SOUTH));
    //System.out.println("Direction: " + particleSources.get(i).getDirection());
    //World.numOfChemicals--;
    inserted = 0;
  }
}