import java.io.*;

/**This class stores the credientials for the Player, including all player information.
  * @author Horatiu Lazu
  * @version 1.0.0.0
  * Edit #1: May 25, 2014
  * Time spent: 1 minute
  */
public class Player{
  /** playerName String This is the player name.*/
  public static String playerName = "";
  /** playerScore int This is the player score.*/
  public static int playerScore = 0;
  /** scores int[] This is the scores.*/
  public static int scores[] = new int[6];
  
  /** This method returns if someone can play a specific level.
    * The if statement verifies to see if the user can play.
    * @param level int This is the level to verify.
    * @return boolean Returns if the user can play a particular level.*/
  public static boolean canPlayLevel(int level){
    if (scores[level - 1] == 1 || scores[level - 1] == 0)
    {
      return true;
    }
    return false;
  }
  
  /** This method will update the highscores file.
    * The if statement verifies to see if the level was completed, and then increases the score.
    * The other if statement verifies and sets the score accordingly.
    * The try catch prevents input output related errors, and then the for loop goes through the player properties.
    * @param levelCompleted int This int is used to store which level is completed.
    * @param out PrintWriter This is used for file output.
    * @param e IOException This is used in case of an input output error. 
    * @throws IOException This is used for IO related errors.
    */
  public static void updateHighscores(int levelCompleted){
    if (scores[levelCompleted - 1] != 1){
      scores[levelCompleted - 1] = 1;
      playerScore++;
    }
    if (levelCompleted != 6 && scores[levelCompleted] == -1){
      scores[levelCompleted] = 0;
    }
    
    try{
      PrintWriter out = new PrintWriter(new FileWriter("../profiles/" + playerName + ".profile"));
      
      out.println("HORATIU INCORPORATED PROTECTED");
      out.println(playerName);
      out.println(playerScore);
      for (int i = 0; i < 6; i++){
        out.println(scores[i]); 
      }
      
      out.close();
    }
    catch(IOException e){}
  }
}