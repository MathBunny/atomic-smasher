import javax.swing.*;

/** This class regulates the movement of pieces inside the game.
  * @author Horatiu Lazu
  * @version 1.0
  * Time spent: 15 hours
  * Last edit: Implemented the act method.
  */

public class Physics{
  /** LONG_TURN int This static int maintains the amount of ticks that require for a long turn within the game.*/
  final static int LONG_TURN = 90; //113
  /** SHORT_TURN int This static int maintains the amount of ticks that require for a short turn within the game.*/
  final static int SHORT_TURN = 40; //40 
  /** cycleTurns int This static int maintains the cycle count for the number of cycle counts the game went through.*/
  static int cycleTurns = 0;
  //private Level level; WHAT DID YOU MEAN?
  /** This is the class constructor for the physics class.
    * @param level Level This is the current Level.*/
  public Physics(Level level){
    //this.level = level;
  }
  
  /** This method acts as the backbone for the entire application, simulating the piping system of the chemicals by accessing other object's properties, and
    * handling the interaction between them. The method handles pipe multidirectioning, directions, interaction between dfferent game pieces, collision detectection and more.
    * @param x int For loop variable.
    * @param y int For loop variable.
    * @param z int For loop variable.
    * @param px int Previous x coordinate.
    * @param py int Previous y coordinate.
    * @param x2 int This is the second x coordinate.
    * @param y2 int This is the second y coordinate.
    * 
    * 
    * The first if statement verifies to see if the object is not null in terms of coordinates.
    * The second if statement verifies to see if the object is at a short turn or at a long turn.
    * The else if is used in case of a long turn.
    * The following if statement will shift accordingly.
    * The following if statement will verify if the chemical has already been shifted (due to array structuring).
    * The following code will apply the value to the pipes.
    * The following code will snap the chemical accordingly.
    * The following code will set the direction.
    * The following if statement will verify to see if the particle is going out of bounds.
    * The following code will check to see if the area is null, a particleSource or an obstacle.
    * The following code will check to see if the entrance is valid, has an opening and is a pipe, along with is multidirectional to the proper entrance.
    * The following if statements will check to see if it is multidimensional, and if yes then it will switch directions.
    * The following then snapes the coordinates in place.
    * The following code then moves the coordinates by their direction to the new location.
    * The else is used in case it is a destination, in  which the chemical name will be verified and then the number of chemical will decrease. If there's no other chemicals, you win.
    * Otherwise, a failure will occur because you are hitting a wall.
    * The following code verifies to see if it's a diatomic block, and such it will check the entrance and direction.
    * If there is one chemical already, then the new particle will be instantiated.
    * Else, then they will be incremeneted.
    * Otherwise, if all else fails, the player loses.
    * 
    * If it is on a short turn, then we verify if it is a pipe in the proper direction.
    * Then we verify to see if the chemical was already shifted.
    * Then we verify to see if it is in the proper range.
    * Then we verify to see it is an instance of particle source, and if yes then it will fail because you cannot hit a particle source.
    * Then we verify to see if if the pipe is in the right direction.
    * Then we check to see if it is multidimensional, and if yes then switch the direction.
    * Then we act and move accordingly.
    * If it is a destination, we verify to see if the direction and pipe exit is valid.
    * If yes, then we will adjust the number of chemicals accordingly, and if none are left then the player becomes a winner.
    * Otherwise, the player loses.
    * If the user is from a diatomic block then the chemicals will be instantiated if the user enters from the proper place.
    * Otherwise, the level should stop because the user entered from the wrong place!
    * The following for loop (nested on 4 levels) make sure that all of the chemicals have been correctly shifted.
    * The last if statement verifies to see if the cycle turns has been correctly reset, according to the length of a LONG_TURN. */
  public void act(){
    for(int x = 0; x < World.chemicals.length; x++){
      for(int y = 0; y < World.chemicals[0].length; y++){
        for(int z = 0; z < World.chemicals[x][y].length; z++){
          if ((World.chemicals[x][y][z]) != null){
            //System.out.println(World.numOfChemicals + " CHEMICALS");
            //System.out.println("PIPE EXIT: " + World.chemicals[x][y][z].getPipeExit());
            if (cycleTurns % SHORT_TURN != 0 && cycleTurns % LONG_TURN != 0){
              World.chemicals[x][y][z].moveX(Controller.getXChange(World.chemicals[x][y][z].getDirection()));
              World.chemicals[x][y][z].moveY(Controller.getYChange(World.chemicals[x][y][z].getDirection()));
            }
            else if (cycleTurns % LONG_TURN == 0){
              //System.out.println("88 is called");
              if (World.chemicals[x][y][z].getPipeExit() == Controller.EAST){
                //World.chemicals[x][y][z].setXCord( 
              }
              if (World.chemicals[x][y][z].hasShifted() == false){
                int px = x;
                int py = y;
                
                System.out.println("PIPE EXIT: " + (World.chemicals[x][y][z].getPipeExit()));
                x = x + Controller.getXChange(World.chemicals[x][y][z].getPipeExit());
                y = y + Controller.getYChange(World.chemicals[px][y][z].getPipeExit());
                int x2 = World.chemicals[px][py][z].getX();
                int y2 = World.chemicals[px][py][z].getY();
                
                World.chemicals[px][py][z].setDirection(World.chemicals[px][py][z].getPipeExit());
                //System.out.println("X: " + x + " | Y: " + y);
                
                if (x > World.chemicals.length || x < 0 || y > World.chemicals.length || y < 0){
                  //GameApp.level.t.stop();
                  GameApp.winLoseScreen(false);
                  JOptionPane.showMessageDialog (null, "Error: You have lost! 1" ); 
                  return;
                }
                
                if (World.items[x][y] == null || World.items[x][y] instanceof ParticleSource || World.items[x][y] instanceof Obstacle){
                  //GameApp.level.t.stop();
                  GameApp.winLoseScreen(false);
                  return;
                  //JOptionPane.showMessageDialog (null, "Error: You have lost! 2" ); 
                  
                  //You have lost. 
                }
                if ((World.items[x][y] instanceof Pipe) && (((Pipe)(World.items[x][y])).hasOpening((Controller.getPipeEntrance(World.chemicals[px][py][z].getPipeExit()))))){
                  World.chemicals[px][py][z].setDirection(Controller.getDirectionForEntrance(World.items[x][y].getPicSource(), (Controller.getPipeEntrance(World.chemicals[px][py][z].getPipeExit())), World.items[x][y].getPicSource().endsWith("b")));                                                                     
                  World.chemicals[px][py][z].setHasShifted(true);
                  if (World.items[px][py] instanceof Pipe)
                    ((Pipe) (World.items[px][py])).switchDirection();
                  World.chemicals[x][y][Controller.getChemicalDepth(x, y)] = World.chemicals[px][py][z];
                  World.chemicals[x][y][Controller.getChemicalDepth(x, y)-1].act(); //Act method?
                  if (World.chemicals[px][py][z].getPipeExit() == Controller.EAST){
                    
                    //World.chemicals[x][y][Controller.getChemicalDepth(x, y)-1].setXCord(Board.adjustX((World.chemicals[x][y][Controller.getChemicalDepth(x, y)-1]).getX() * 2));
                    //World.chemicals[x][y][Controller.getChemicalDepth(x, y)-1].setYCord(Board.adjustY((World.chemicals[x][y][Controller.getChemicalDepth(x, y)-1]).getY() * 2));
                  }
                  
                  World.chemicals[px][py][z] = null;
                  //System.out.println("Entrance: " +  Controller.getPipeEntrance(World.chemicals[x][y][Controller.getChemicalDepth(x, y) - 1].getPipeExit()));
                  //System.out.println("Image: " + Controller.getPipeExit(World.items[x][y].getPicSource(), (Controller.getPipeEntrance(World.chemicals[x][y][Controller.getChemicalDepth(x, y) - 1].getPipeExit())), World.items[x][y].getPicSource().endsWith("b")));
                  World.chemicals[x][y][Controller.getChemicalDepth(x, y) - 1].setPipeExit(Controller.getPipeExit(World.items[x][y].getPicSource(), Controller.getPipeEntrance(World.chemicals[x][y][Controller.getChemicalDepth(x, y) - 1].getPipeExit()), World.items[x][y].getPicSource().endsWith("b")));
                  //System.out.println(World.items[x][y][Controller.getChemicalDepth(x, y) - 1].getPicSource());
                  //System.out.println("Exit: " + World.chemicals[x][y][Controller.getChemicalDepth(x, y) - 1].getPipeExit());
                  
                }
                else if (World.items[x][y] instanceof Destination){
                  System.out.println(World.chemicals[px][py][z].getElementName());
                  System.out.println(((((Destination)World.items[x][y]).getElementName())));
                  if ((((Destination)World.items[x][y]).getDirection()) == Controller.getPipeEntrance(World.chemicals[px][py][z].getDirection()) && (World.chemicals[px][py][z]).getElementName().equals((((Destination)World.items[x][y]).getElementName()))){
                    //Has finshed.
                    //World.chemicals[x][y][Controller.getChemicalDepth(x, y)] = World.chemicals[px][py][z];
                    World.chemicals[px][py][z] = null;
                    World.numOfChemicals--;
                    if (World.numOfChemicals == 0){
                      GameApp.winLoseScreen(true);
                      System.out.println("FINISHED!");
                    }
                  }
                  else{
                    System.out.println("DESTINATION ELSE!");
                    //GameApp.level.t.stop();
                    //GameApp.winLoseScreen(false);
                    
                    //System.out.println("Lost! 3"); 
                  }
                }
                else if (World.items[x][y] instanceof DiatomicBlock){
                  if (Controller.getPipeEntrance(World.chemicals[px][py][z].getDirection()) == Controller.EAST || Controller.getPipeEntrance(World.chemicals[px][py][z].getDirection()) == Controller.WEST){
                    if (((DiatomicBlock)World.items[x][y]).getInserted() == 1){
                      ((DiatomicBlock)(World.items[x][y])).instantiateChemical();
                      World.numOfChemicals--;
                    }
                    else
                      ((DiatomicBlock)(World.items[x][y])).incrementGained();
                  }
                  World.chemicals[px][py][z] = null;
                }
                else{ //Testing this!
                  //GameApp.level.t.stop();
                  GameApp.winLoseScreen(false);
                  return;
                  //System.out.println("Lost! NEW ONE"); 
                }
                
              }
            }
            else{
              if (World.chemicals[x][y][z].getDirection() != Controller.NORTH && World.chemicals[x][y][z].getDirection() != Controller.SOUTH && World.chemicals[x][y][z].getDirection() != Controller.EAST && World.chemicals[x][y][z].getDirection() != Controller.WEST){
                if (World.chemicals[x][y][z].hasShifted() == false){
                  //System.out.println("44 is called!");
                  int px = x;
                  int py = y;
                  
                  //getPipeExit(String fileName, int entrance, boolean isDiagonal)
                  x = x + Controller.getXChange(World.chemicals[x][y][z].getPipeExit());
                  y = y + Controller.getYChange(World.chemicals[px][y][z].getPipeExit());
                  World.chemicals[px][py][z].setDirection(World.chemicals[px][py][z].getPipeExit());
                  System.out.println("X: " + x + " | Y: " + y);
                  
                  if (x > World.chemicals.length || x < 0 || y > World.chemicals.length || y < 0){
                    GameApp.level.t.stop();
                    GameApp.winLoseScreen(false);
                    //JOptionPane.showMessageDialog (null, "Error: You have lost!" ); 
                    return;
                  }
                  if (World.items[x][y] == null || World.items[x][y] instanceof ParticleSource){
                    //GameApp.level.t.stop();
                    GameApp.winLoseScreen(false);
                    return;
                    //JOptionPane.showMessageDialog (null, "Error: You have lost!" ); 
                  }
                  if ((World.items[x][y] instanceof Pipe) && (((Pipe)(World.items[x][y])).hasOpening((Controller.getPipeEntrance(World.chemicals[px][py][z].getPipeExit()))))){
                    World.chemicals[px][py][z].setDirection(Controller.getDirectionForEntrance(World.items[x][y].getPicSource(), (Controller.getPipeEntrance(World.chemicals[px][py][z].getPipeExit())), World.items[x][y].getPicSource().endsWith("b")));                                                                     
                    World.chemicals[px][py][z].setHasShifted(true);
                    if (World.items[px][py] instanceof Pipe)
                      ((Pipe) (World.items[px][py])).switchDirection();
                    World.chemicals[x][y][Controller.getChemicalDepth(x, y)] = World.chemicals[px][py][z];
                    World.chemicals[x][y][Controller.getChemicalDepth(x, y)-1].act(); //Act method?
                    World.chemicals[px][py][z] = null;
                    World.chemicals[x][y][Controller.getChemicalDepth(x, y) - 1].setPipeExit(Controller.getPipeExit(World.items[x][y].getPicSource(), Controller.getPipeEntrance(World.chemicals[x][y][Controller.getChemicalDepth(x, y) - 1].getPipeExit()), World.items[x][y].getPicSource().endsWith("b")));
                    
                  }
                  else if (World.items[x][y] instanceof Destination){
                    
                    
                    if ((((Destination)World.items[x][y]).getDirection()) == Controller.getPipeEntrance(World.chemicals[px][py][z].getDirection()) && (World.chemicals[px][py][z]).getElementName().equals((((Destination)World.items[x][y]).getElementName()))){
                      //Has finshed.
                      //World.chemicals[x][y][Controller.getChemicalDepth(x, y)] = World.chemicals[px][py][z]; WHY THIS??
                      World.chemicals[px][py][z] = null;
                      World.numOfChemicals--;
                      if (World.numOfChemicals == 0){
                        GameApp.winLoseScreen(true); //here
                        // System.out.println("FINISHED!");
                      }
                    }
                    else{
                      //System.out.println("Lost! 4"); 
                    }
                  }
                  else if (World.items[x][y] instanceof DiatomicBlock){
                    if (Controller.getPipeEntrance(World.chemicals[px][py][z].getDirection()) == Controller.EAST || Controller.getPipeEntrance(World.chemicals[px][py][z].getDirection()) == Controller.WEST){
                      if (((DiatomicBlock)World.items[x][y]).getInserted() == 1){
                        ((DiatomicBlock)(World.items[x][y])).instantiateChemical();
                        World.numOfChemicals--;
                      }
                      else
                        ((DiatomicBlock)(World.items[x][y])).incrementGained();
                    }
                    World.chemicals[px][py][z] = null;
                  }
                  else{
                    //GameApp.level.t.stop();
                    GameApp.winLoseScreen(false);
                    //JOptionPane.showMessageDialog (null, "Error: You have lost!" ); 
                    return;
                  }
                }
              }
            }
            
            
          }
          else{
            //System.out.println("You have lost!");
          }
          
        }
      }
    }
    //cycleTurns++; DO THIS IN THE LEVEL CLASS!
    for(int x = 0; x < World.items.length; x++){
      for(int y = 0; y < World.items.length; y++){
        for(int z = 0; z < World.chemicals[x][y].length; z++){
          if (World.chemicals[x][y][z] == null)
            break;
          if (World.chemicals[x][y][z].hasShifted() == true)
            World.chemicals[x][y][z].setHasShifted(false);
        }
      }
    }
    if (Physics.cycleTurns % LONG_TURN ==0)
      Physics.cycleTurns = 0; //RESET!
    
  }
  
}    