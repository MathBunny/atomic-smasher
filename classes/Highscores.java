import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.image.*;

/**This class outputs a Highscores window.
  * @author Horatiu Lazu
  * @version 1.0.0.0 May 15, 2014
  * 
  * Edit #1
  * -Horatiu Lazu
  * -Estimated Time Spent: 1 hour
  */

public class Highscores extends JPanel implements MouseListener{ //Since you need to add the highscore class!
  
  /**This is the class constructor that sets the fonts accordingly for the class.
    */
  public Highscores(){
    addMouse();
    setFont(new Font("TimesNewRoman", Font.BOLD, 32));
    updateHighscores();
    repaint(); 
  }
  
  /** This method adds a mouse listener to the game.
    * The if statements verify the range of the x & y position.
    * The following try catch ensures no IO related errors occur.
    * The if statements verify to see if the input is null. 
    * @param e MouseEvent This is an event reference to get the X & Y position of the mouse.
    * @param pr Print This is a Print reference used to print.
    * @param temp String This is a temporary variable used to read input.
    * @param temp2 String This is a temporary variable used to read input.
    * @param head String This is a temporary variable used to read the header.
    * @param i int This is a for loop variable.
    * @param io IOException This is used in case of an input output related error.
    * @param in BufferedReader This is a reference to the BufferedReader class.
    * @throws IOException */
  public void addMouse(){
    addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e) {
        //System.out.println(e.getX() + " " + e.getY());
        if (e.getX() >= 0 && e.getX() <= 60 && e.getY() >= 567 && e.getY() <= 640){
          GameApp.backHighscores();
          System.out.println("Backhighscores");
        }
        else{
          if (e.getX() >= 815 && e.getX() <= 905 && e.getY() >= 558 && e.getY() <= 631){
            Print pr = new Print();
            String temp;
            String temp2;
            String header;
            pr.println("", "Atomic Smasher Highscores", "");
            pr.println("", "Horatiu Incorporated", "");
            pr.println();
            try{
              BufferedReader in = new BufferedReader(new FileReader("../profiles/Highscores.dat"));
              header = in.readLine();
              pr.println("Name", "Score", "");
              for (int i = 0; i < 10; i++)
              {
                temp = in.readLine();
                if (temp == null)
                {break;}
                temp2 = in.readLine();
                pr.println((i + 1) + ") " + temp, temp2, "");
              }
              BufferedImage image2 = ImageIO.read(new File("../images/Logo.png"));
              pr.printImage(image2, new Point (380, 500));
            }
            catch(IOException io){System.out.println("HIGHSCORES IO PROBLEM");}
            pr.printUsingDialog();
          }
        }
      }                
    });
  }
  
  /** This method is triggered when a mouse is clicked.
    * @param e MouseEvent This is the MouseEvent reference.*/
  public void mouseClicked(MouseEvent e) {
  }
  /**This method is triggered when a mouse is pressed.
    * @param e MouseEvent, used to provide information the mouse, etc.
    */
  public void mousePressed(MouseEvent e) {}
  /**This method is triggered when a mouse is enters.
    * @param e MouseEvent, used to provide information regarding the mouse, etc.
    */
  public void mouseEntered(MouseEvent e) {}
  /**This method is triggered when a mouse exits.
    * @param e MouseEvent, used to provide information regarding the mouse, etc.
    */
  public void mouseExited(MouseEvent e) {}
  /**This method is triggered when a mouse is released.
    * @param e MouseEvent, used to provide information regarding the mouse, etc.
    */
  public void mouseReleased(MouseEvent e) {}
  
  /** This method will output the appropriate graphics for the class.
    * The try catch prevents any input output related errors.
    * The if statement will return if the file input is null.
    * The for loop will go through the top 10 scores.
    * The following if statement will ensure that the input is not null.
    * @param g Graphics This is a reference to the Graphics class to output the appropriate graphics.
    * @param image Image This is the image used to store the image.
    * @param i int This is a for loop variable used to increment through the different options.
    * @param input2 String This is a String used to store the secondary input.
    * @param y int This is the y value.
    * @param e IOException variable, used in the try-catch.
    * @throws IOException
    */
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    try{
      Image image = ImageIO.read(new File("../images/Highscores.png"));
      g.drawImage(image, 0, 0, null);
      BufferedReader in = new BufferedReader(new FileReader("../profiles/Highscores.dat"));
      String input = in.readLine();
      if (input == null || !input.equals("Atomic Smasher")){
        return;
      }
      int y = 145;
      for(int i = 0; i < 10; i++){ //Add only top 10 in a global static variable.
        String input2 = in.readLine();
        if (input2 != null){
          g.drawString(input2, 380, 115 + y);
          g.drawString(in.readLine(), 290, 115 + y);
          y += 40;
        }
        else{
          break;
        }
      }
    }
    catch(IOException e){}
  }
  
  /**This method updates the highscores.
    * The first for loop goes through the different folders.
    * The following if statement verifies if the file ends with a .profile
    * The try catch then works in case of a file input output related error.
    * @param String path This is a String which indicates the path for the highscores.
    * @param File folder This is a storage for all of the folders within the given path.
    * @param listOfFolders This is an arrayList for all of the folders.
    * @param ArrayList<String> players This is an ArrayList for all of the players in the game.
    * @param ArrayList<Integer> scores This is an ArrayList for the scores of all the players.
    * @param e IOException reference variable, used in case of an input or output related error.
    * @param i int For loop variable, used to cycle through the different options.
    * @param j int For loop variable, used to go through the different ones.
    * @param header String This is the header.
    * @param BufferedReader in A bufferedreader reference used to read from files.
    * @param PrintWriter out A PrintWriter used to output 
    * @throws IOException
    */
  public static void updateHighscores(){
    String path = "../profiles/"; 
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles(); 
    ArrayList<String> players = new ArrayList<String>();
    ArrayList<Integer> scores = new ArrayList<Integer>();
    PrintWriter out = null;
    try{
      out = new PrintWriter(new FileWriter("../profiles/Highscores.dat"));
      out.println("Atomic Smasher");
      
      for(int i = 0; i < listOfFiles.length; i++){
        if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".profile")){
          BufferedReader in = new BufferedReader(new FileReader("../profiles/" + listOfFiles[i].getName()));
          String header = in.readLine();
          if (!header.equals("HORATIU INCORPORATED PROTECTED") || header == null){
            JOptionPane.showMessageDialog(null, "A highscores file has been tampered with!\nPlease use the clear profiles button from the settings screen to fix this.");
            return;
          }
          String temp = in.readLine();
          players.add(temp);
          temp = in.readLine();
          scores.add(Integer.parseInt(temp));
        }
      }
      
      for (int i = 0; i < scores.size() - 1; i++)
      {
        int index = i;
        for (int j = i + 1; j < scores.size(); j++){
          if (scores.get(j) > scores.get(index)){ //Finds smallest number
            index = j;
          }
        }
        int smallerNumber = scores.get(index);  //Swap
        scores.set(index, scores.get(i));
        scores.set(i, smallerNumber);
        String changeName = players.get(index);
        players.set(index, players.get(i));
        players.set(i, changeName);       
        
      }
      
      for(int i = 0; i < players.size(); i++){
        out.println(players.get(i));
        out.println(scores.get(i));
      }
      out.close();
    }
    catch(IOException io){}
  }
}
