import java.util.*;
import java.awt.*;
import java.awt.event.*;


/**This class is the Level template used for all the different levels.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * 
  * Edit #1:
  * Horatiu Lazu, approprimately 2 hour
  * Made the class.
  */
public class Level implements ActionListener{
  /** @param ArrayList<ParticleSource> particleSources This variable stores the number of particleSources*/
  ArrayList <ParticleSource> particleSources = new ArrayList<ParticleSource>();
  /** Physics p This is a reference to the physics class.*/
  Physics p;
  /** javax.swing.Timer t This is a timer used in the application to coordinate the impulses of chemical turns.*/
  javax.swing.Timer t;
  /** int DELAY_TIME This indicates the delay time in the timer.*/
  private static final int DELAY_TIME = 0;
  
  /** This method overrides ActionPerformed.
    * @param e ActionEvent reference */
  public void actionPerformed(ActionEvent e){}
  
  /** This method simulates the graphics.
    * The while loop goes forever until there's no more chemicals.
    * The if statements initalize / stop the loop accordingly.*/
  public void simulate(){
    Physics.cycleTurns = 44; //67
    System.out.println("RESETS!!!");
    t = new javax.swing.Timer(DELAY_TIME, new ActionListener() {
      public void actionPerformed(ActionEvent e){
        //System.out.println("Here: " + particleSources.size());
        //System.out.println("Being called!");
        if (Physics.cycleTurns % 44 == 0){
          initializeChemicals();
        }
        Physics.cycleTurns++;
        p.act();
        GameApp.b.repaint(); //TAKE IT OUT!
        
        if (World.numOfChemicals <= 0 && particleSources.size() == 0){
          System.out.println("STOP!");
          t.stop();
        }
        //System.out.println(particleSources.size());
      }
    });
    t.start();
    System.out.println("STOPPED!!!!!!!!!!!!!!!!!!!!!!!!!!");
    /*
     while(true){
     t.start();
     if (Physics.cycleTurns % 44 == 0){
     initializeChemicals();
     }
     Physics.cycleTurns++;
     p.act();
     GameApp.b.repaint();
     
     if (World.numOfChemicals == 0 && particleSources.size() == 0){
     break;
     }
     }
     */
    
  }
  /** A blank Level() constructor*/
  public Level(){
  }
  
  /** This is a method which adds a Particle source accordingly, and adds it to the ArrayList
    * @param String filePath This String would store the filePath for the image.
    * @param String name This String would store the name of the object.
    * @param int x This value will store the x position in the grid.
    * @param int y This value will store the y position in the grid.
    * @param Color c This value stores the color of the ParticleSource.
    * @param int numOfColors This value stores the number of colours.
    * @param int direction This value stores the direction of the particle source.
    * @param String elementName This value stores the name of the elementName in a string.
    * @param ParticleSource ps This value would store the ParticleSOurce reference which would be added to the ArrayList.
    */
  public void addParticleSource(String filePath, String name, int x, int y, Color c, int direction, int numOfColors,  String elementName){ //Add required parameters.
    ParticleSource ps = new ParticleSource(filePath, name, x, y, c, numOfColors, direction, elementName);  
    particleSources.add(ps); //Color & direction are flipped! Potential error?
    World.items[x][y] = ps;
  }
  /** This is a method which adds a Particle source accordingly, and adds it to the ArrayList
    * @param String filePath This String would store the filePath for the image.
    * @param String name This String would store the name of the object.
    * @param int x This value will store the x position in the grid.
    * @param int y This value will store the y position in the grid.
    * @param Color c This value stores the color of the ParticleSource.
    * @param int numOfColors This value stores the number of colours.
    * @param int direction This value stores the direction of the particle source.
    * @param Color [] colors This value would store the mutliple different colour types.
    * @param ParticleSource ps This value would store the ParticleSOurce reference which would be added to the ArrayList.
    */
  public void addParticleSource(String picSource, String name, int x, int y, Color c, int direction,  int numOfColors, Color [] colors){
    ParticleSource ps = new ParticleSource (picSource, name, x, y, c, numOfColors, direction, colors); //Flipped around?? Weird..
    particleSources.add(ps);
    World.items[x][y] = ps;
    //Add it? Lol
  }
  /**This method initializes all the chemicals.
    * The for loop goes through all of the particles.
    * The if statements assign colours.
    * The last if statement removes a chemical if it is deemed as not required.
    * @param ParticleSource p This is a for each loop variable.
    * @param String fileName, used to store the fileName for the rendering image.
    * @param i int For loop variable.
    */
  public void initializeChemicals(){
    //System.out.println(particleSources.get(0).getElementName());
    //System.out.println(particleSources.get(1).getElementName());
    for(int i = 0; i < particleSources.size(); i++){
      //System.out.println(particleSources.size());
      String fileName = "";
      //System.out.println(particleSources.get(i).getElementName());
      if (particleSources.get(i).getElementName().equals("Hydrogen")){ //CANNOT DO OTHERWISE IN CASE OF FOREIGN IMAGE SOURCE!!! THIS IS KISSSsssSS!!
        fileName = "../images/Hydrogen";
        //System.out.println("Hydrogen!"); //KISSSSSS ...wish I could do otherwise.
      }
      else if (particleSources.get(i).getElementName().equals("Oxygen")){
        fileName = "../images/Oxygen";
        //System.out.println("Oxygen!");
      }
      else{
        if (particleSources.get(i).getElementName().equals("Oxygen2")){
          fileName = "../images/Oxygen2";
        }
      }
      //particleSources.get(i).decrementNumOfColors();//DOWN ONE FOR MULTIPLE SIZES!
      
      //String picSource, String name, int x, int y, Color c, String elementName, int direction, int xCord, int yCord, int pipeExit
      
      
      
      World.chemicals[particleSources.get(i).getX()][particleSources.get(i).getY()][Controller.getChemicalDepth(particleSources.get(i).getX(), particleSources.get(i).getY()) + 1] = (new Chemical(fileName,"Chemical", particleSources.get(i).getX(), particleSources.get(i).getY(), particleSources.get(i).getColor(), particleSources.get(i).getElementName(), particleSources.get(i).getDirection(), 34 + (88 * particleSources.get(i).getX()), 34 + (88 * particleSources.get(i).getY()), particleSources.get(i).getDirection()));
      //System.out.println("Direction: " + particleSources.get(i).getDirection());
      World.numOfChemicals++;
      particleSources.remove(particleSources.get(i));
      i--;
      //System.out.println(particleSources.size());
    }
  }
  // public ParticleSource(String picSource, String name, int x, int y, Color c, int numOfColors, Color [] colors)
  
}