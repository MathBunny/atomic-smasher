import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
/** 
 * This class is the runner for the whole game. The game works on the principal of moving particles from place to place, teaching the user about the program.
 * There is a main menu, which is called from the splashscreen, settings screen with an about, highscores (where you can clear highscores), in addition to
 * open / close profiles. This application then has a level selection screen. The designed age range is ~8 - 14. The game version is 5.
 * @author Andrew Nitu & Horatiu Lazu
 * @version 1.0
 * 
 * Edit: Horatiu Lazu
 * Made the class template, spent 1 hour.
 * 
 * Last edit: Andrew Nitu 
 * Made all of the JPanel add / remove methods.
 * Time spent: 5 hours
 */
public class GameApp extends JFrame{
  /** ab AboutProgram This is the reference variable for the about program class.*/
  static AboutProgram ab;
  /** s Settings This is the reference variable for the settings class.*/
  static Settings s;
  /** h Highscores This is the reference variable for the highscores class.*/
  static Highscores h;
  /** m MainMenu This is the reference variable for the main menu class.*/
  static MainMenu m;
  /** a GameApp This is the reference variable for the game app class.*/
  static GameApp a;
  /** l GameApp This is the second reference variable for another object of the game app class.*/
  static GameApp l;
  /** b Board This is the reference variable for the board class.*/
  static Board b;
  /** container GameContainer This is the reference variable for the game container class.*/
  static GameContainer container;
  /** container GameContainer This is the second reference variable for another object of the highscores class.*/
  static GameContainer c;
  /** p PlayerSelection This is the reference variable for the player selection class.*/
  static PlayerSelection p;
  /** mp MakeProfile This is the reference variable for the create profile class.*/
  static MakeProfile mp;
  /** op OpenProfile This is the reference variable for the load profile class.*/
  static OpenProfile op;
  /** pg PuaseGame This is the reference variable for the pause game class.*/
  static PauseGame pg;
  /** level Level This is the reference variable for the level class.*/
  static Level level;
  /** si Sidebar This is the reference variable for the sidebar class.*/
  static Sidebar si;
  /** ls LevelSelection This is the reference variable for the level selection class.*/
  static LevelSelection ls;
  /** mu MusicPlayer This is the reference variable for the music player class.*/
  static MusicPlayer mu;
  /** sp Splashscreen This is a reference to the splashscreen class.*/
  static Splashscreen sp;
  /** vp ViewProfile This is a reference to the ViewProfile class.*/
  static ViewProfile vp;
  /** output String This is a private variable used to store the output.*/
  private String output;
  /** intput String This is a private variable used to store the intput.*/
  private String input;
  /** playIntro String This is used to see if the intro should be played.*/
  static  String playIntro;
  /** low LostWon This is a variable used to see if LostWon is called, and access methods from within it.*/
  static LostWon lw;
  /** currentLevel String This is a variable used to store the current level.*/
  static String currentLevel = "";
  /** boolean isAtWinOrLostScreen This boolean is used to indicate the origin of the user.*/
  private static boolean isAtWinOrLostScreen = false;
  /** loggedIn boolean This boolean indicates if the user is currently logged in.*/
  static boolean loggedIn = false;
  
  
  /** in BufferedReader This is used to read input output.*/
  BufferedReader in;
  /** menuChoice int This is used to store the menu choice.*/
  int menuChoice;
  
  /** This method goes from play to level selection. */
  public static void mainMenuToLevelSelection(){
    a.remove(m);
    ls = new LevelSelection();
    a.add(ls);
    ls.revalidate();
    ls.repaint();
    a.repaint();
  }
  /** This method goes from the main menu to player profile.*/
  public static void mainMenuToPlayerProfile(){
    a.remove(m);
    vp = new ViewProfile("../profiles/" + Player.playerName + ".profile");
    a.add(vp);
    vp.revalidate();
    vp.repaint();
    a.repaint();
  }
  /** This method goes from level selection to player profile.*/
  public static void levelSelectionToPlayerProfile(){
    a.remove(ls);
    vp = new ViewProfile("../profiles/" + Player.playerName + ".profile");
    a.add(vp);
    vp.revalidate();
    vp.repaint();
    a.repaint();
  }
  
  /** This is the splashscreen method. Makes the splashcreen / outputs it.*/
  public void splashscreen(){
    sp = new Splashscreen();
    add(sp);
    //System.out.println("Getting there!");
    //sp.initialize();
    setVisible(true);
    setSize(960, 660);
    //sp.outputImage();
    sp.revalidate();
    sp.repaint();
    repaint();
  }
  
  /** This method closes the application.
    * In the future a credits screen will be implemented. */
  public static void credits(){
    
    /*a.remove(m);
     System.out.println(a);
     Credits c = new Credits();
     a.add(c);
     
     c.repaint();
     c.revalidate();
     a.repaint();
     c.requestFocusInWindow();
     try{
     Thread.sleep(10000);
     }
     catch(InterruptedException e){}*/
    System.exit(0);
  }
  
  /** This method outputs the winLoseScreen.
    * @param hasWon boolean This indicates if the user has won.*/
  public static void winLoseScreen(boolean hasWon){
    lw = new LostWon(hasWon);
    isAtWinOrLostScreen = true;
    a.remove(container);
    a.remove(c);
    //a.removeAll();
    
    a.add(lw);
    lw.repaint();
    lw.revalidate();
    a.repaint();
    //a.revalidate();
  }
  
  /** This method will cause the game.*/
  static public void pauseGame(){
    pg = new PauseGame();
    a.remove(container);
    a.remove(c);
    a.add(pg);
    pg.repaint();
    pg.revalidate();
    a.repaint();
  }
  
  /** This method will go to the win player profile to the profile. */
  public static void lostWonToPlayerProfile(){
    vp = new ViewProfile("../profiles/" + Player.playerName + ".profile");
    a.remove(lw);
    a.add(vp);
    a.repaint();
    vp.repaint();
    vp.revalidate();
    
  }
  
  /** This is the class constructor for GameApp.
    * The first try catch prevents any delay errors.
    * The following code makes the main menu.
    * The following try catch loads the setting images.
    * The following if statements handle the configuration file, and will output an introduction to chemistry if they are found.
    * It will then play the video, else it will act accordingly with the music as the game has been set before.
    * @param i InterruptedException This is a variable used in case the try catch is thrown.
    * @param x int This is a for loop variable.
    * @param e IOException This is used in case of an input output exception.
    * @param ee InterruptedException This is used in case of a Thread.sleep() related error.
    * @param out PrintWriter This is used for file outputs.
    * @param ci ChemistryIntroduction This is used for the chem intro.
    * @throws IOException This is for IO related errors.
    * @throws InterruptedException In case of a threading issue.
    */
  
  public GameApp(){
    // instantiates the frame, creates mainmenu instance, adds it to the frame and sets the size
    super ("Atomic Smasher");
    
    splashscreen();
    try{
      Thread.sleep(8000);
    }
    catch (InterruptedException i){}
    
    remove(sp);
    
    
    try{
      for (int x = 0; x < 14; x++)
      {
        Settings.settingsImage[x] = ImageIO.read(new File("../images/" + "Settings" + x + ".jpg")); 
      }
    }
    catch(IOException e){}
    
    try{
      in = new BufferedReader (new FileReader ("../profiles/config.ini"));
      input = in.readLine();
    }
    catch(IOException e){
      try{
      PrintWriter out = new PrintWriter(new FileWriter("../profiles/config.ini"));
      out.println("HORATIU INCORPORATED PROTECTED\ntrhe\nfalse");
      out.close();
      in = new BufferedReader (new FileReader ("../profiles/config.ini"));
      }
      catch(IOException eee){
        
      }
    }
    
    if (input != null){
      if (!input.equals("HORATIU INCORPORATED PROTECTED")){
        output = "true";
      }
    }
    try{
      input = in.readLine();
      playIntro = in.readLine();
    }
    catch(IOException e){}
    if  (input.equals("true"))
    {
      output = "true"; 
    }
    else{
      if (input.equals("false")){
        output = "false"; 
      }
    }
    
    if (playIntro.equals("true"))
    {
      //play the intro!
      ChemistryIntroduction ci = new ChemistryIntroduction();
      add(ci);
      ci.revalidate();
      ci.repaint();
      repaint();
      try{
        Thread.sleep(17000);
        remove(ci);
        repaint();
        //revalidate();
        playIntro = "false";
        
        PrintWriter out = new PrintWriter(new FileWriter("../profiles/config.ini"));
        out.println("HORATIU INCORPORATED PROTECTED");
        out.println(input);
        out.println(playIntro);
        out.close();
      }
      catch(IOException e){}
      catch(InterruptedException ee){}
    }
    
    if (output != null){ //hdbr
      if (output.equals("false")){
        mu = new MusicPlayer();
        mu.start();
      }
    }
    
    m = new MainMenu();
    add(m);
    m.revalidate();
    m.repaint();
    repaint();
    
    setVisible(true);
    setSize(960, 665); //make sure to change this according to OS and visual theme!
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    m.requestFocusInWindow();
    
  }
  
  /** This method removes the game panel.*/
  public static void removeGame(){
    a.remove(c);
    a.remove(container);
  }
  
  /** The main method.
    * @param args String[] An array of command-line arguments sent in when the class is run.
    */
  public static void main (String [] args){
    a = new GameApp();
    //System.out.println(a);
  }
  
  /** This method creates the basic gameplay window and sets up components such as the sidebar and buttons.
    * The first if removes the main menu JPanel if the user came to the game from the main menu.
    * The first try attempts to load the game frame images into the GameContainer objects.
    * The large if statement that follows is to decide which Level class to initialize.
    * All of the remaining if statements change the value of the current level to match the level that it is in.
    * @param level String Stores the level ID that is to be set up.
    * @param e IOException This is against user input output error.
    * @param comesFromMenu boolean Distinguishes between coming to the game from the pause menu versus the main menu.
    * @throws IOException This prevents user input output errors.
    */
  static public void display(String level, boolean comesFromMenu){
    GameContainer.isBuild = true;
    currentLevel = level;
    //System.out.println(a);
    a.setSize(960, 652);
    //System.out.println("Working?");
    if (comesFromMenu)
      a.remove(ls);
    
    else{
      if (lw != null){
        isAtWinOrLostScreen = false;
        a.remove(lw);
      }
    }
    try{
      //c = new GameContainer(ImageIO.read(new File("GameBackground.png")), ImageIO.read(new File("PauseButtonMenu.png")));
      container = new GameContainer(ImageIO.read(new File("../images/GameBackground2.png")));
      c = new GameContainer(ImageIO.read(new File("../images/GameBackground2.png")), ImageIO.read(new File("../images/pause.png")), ImageIO.read(new File("../images/run.png")), ImageIO.read(new File("../images/STOP.png")), ImageIO.read(new File("../images/Hammer.png")), ImageIO.read(new File("../images/base.png")));
    }
    catch(IOException e){
    }
    container.setLayout(new BorderLayout(145, 0));
    //container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
    
    //addItemsToGame();
    
    //Why not addItemsToGame()?
    
    si = new Sidebar();
    
    container.repaint();
    
    b = new Board();
    si.setPreferredSize(new Dimension(41, 640));
    b.setPreferredSize(new Dimension(601, 600));
    container.add(b, BorderLayout.CENTER);
    container.add(si, BorderLayout.WEST);
    container.repaint();
    b.setPreferredSize(new Dimension(601, 600));
    si.repaint();
    si.revalidate();
    b.repaint();
    container.revalidate();
    container.repaint();
    
    //panel1.set[Preferred/Maximum/Minimum]Size()
    
    //container.add(si);
    //container.add(b);
    
    //a.add(container);
    //a.add(si);
    //a.add(b);
    //a.add(container);
    a.repaint();
    container.revalidate();
    container.repaint();
    container.setPreferredSize(new Dimension(815, 640));
    container.repaint();
    c.setLayout(new BorderLayout(0, 0));
    c.add(container, BorderLayout.WEST);
    a.add(c);
    c.repaint();
    c.revalidate();    
    c.repaint();
    
    new World(7, 7);
    if (level.equals("Level11")){
      //Level11 l = new Level11();
      //JOptionPane.showMessageDialog (null, "You have been hired to make a piping system for a hydrogen atom. You are to deliver hydrogen atoms from one source to another!\n Be careful! If you miss, the atoms may go off the pipes and not get to the destination!");
      a.level = new Level11();
      ((Level11)(a.level)).initializeWorld(); //CALL INSIDE PLAY METHOD!
    }
    else if (level.equals("Level12")){
      //Level12 l = new Level12();
      a.level = new Level12();
      ((Level12)(a.level)).initializeWorld();
    }
    else if (level.equals("Level13")){
      //Level13 l = new Level13();
      a.level = new Level13();
      ((Level13)a.level).initializeWorld();
    }
    else if (level.equals("Level14")){
      //Level14 l = new Level14();
      a.level = new Level14();
      ((Level14)(a.level)).initializeWorld();
    }
    
    else if (level.equals("Level21")){
      //Level21 l = new Level21();
      a.level = new Level21();
      //l.initializeWorld();
      ((Level21)(a.level)).initializeWorld();
    }
    else {
      if (level.equals("Level22")){
        //Level22 l = new Level22();
        a.level = new Level22();
        ((Level22)a.level).initializeWorld();
      }
    }
    
    //pauseGame();
  }
  
  
  /** This method adds the items to the game.
    * @param si SideBar This is a sidebar reference.
    * All of the code segments make panels and generate them accordingly.*/
  static public void addItemsToGame(){
    Sidebar si = new Sidebar();
    si.setPreferredSize(new Dimension(41, 640));
    b.setPreferredSize(new Dimension(602, 600)); //601
    container.add(b, BorderLayout.CENTER);
    container.add(si, BorderLayout.WEST);
    container.repaint();
    b.setPreferredSize(new Dimension(601, 600));
    si.repaint();
    si.revalidate();
    b.repaint();
    container.revalidate();
    container.repaint();
    
    //panel1.set[Preferred/Maximum/Minimum]Size()
    
    //container.add(si);
    //container.add(b);
    
    //a.add(container);
    //a.add(si);
    //a.add(b);
    //a.add(container);
    a.repaint();
    container.revalidate();
    container.repaint();
    container.setPreferredSize(new Dimension(815, 640));
    container.repaint();
    c.setLayout(new BorderLayout(0, 0));
    c.add(container, BorderLayout.WEST);
    a.add(c);
    c.repaint();
    c.revalidate();
  }
  /** This method returns to the game.*/
  
  static public void returnToGame(){
    a.remove(pg);
    addItemsToGame();
    //display("Level11", false); //Adjust level accordingly!
    
    //a.revalidate();
  }
  /** This method returns from the open profile to the main menu.*/
  static public void returnFromOpenProfileToMainMenu(){
    //Check if you can just remove all existing fields!
    a.remove(op);
    m = new MainMenu();
    a.add(m);
    m.revalidate();
    m.repaint();
    m.requestFocusInWindow();
  }
  
  /** This method returns from make profile.*/
  static public void returnFromMakeProfileToMainMenu(){
    a.remove(mp);
    m = new MainMenu();
    a.add(m);
    m.revalidate();
    m.repaint();
    m.requestFocusInWindow();
  }
  
  /** This method opens the profile.*/
  static public void openProfile(){
    a.remove(p);
    op = new OpenProfile();
    a.add(op);
    op.revalidate();
    op.repaint();
    a.repaint();
    op.askForName();
  }
  /** This method makes the profile.*/
  static public void makeProfile(){
    a.remove(p);
    mp = new MakeProfile();
    a.add(mp);
    mp.revalidate();
    mp.repaint();
    a.repaint();
    mp.askForName();
  }
  
  /** This method does back to the view profile.*/
  static public void backViewProfile(){
    a.remove(vp);
    m = new MainMenu();
    a.add(m);
    m.revalidate();
    m.repaint();
    a.repaint();
    m.requestFocusInWindow();
  }
  
  /** This method goes to the view.
    * @param name String This is the player name. */
  static public void makeToView(String name){
    a.remove(mp); 
    vp = new ViewProfile(name);
    a.add(vp);
    vp.revalidate();
    vp.repaint();
    a.repaint();
  }
  
  /** This method goes from open to the view.
    * @param name String This is the player name */
  static public void openToView(String name){
    a.remove(op); 
    vp = new ViewProfile(name);
    a.add(vp);
    vp.revalidate();
    vp.repaint();
    a.repaint();
  }
  
  /** This method is the level selection.*/
  public static void levelSelection(){
    a.remove(vp);
    ls = new LevelSelection();
    a.add(ls);
    ls.repaint();
    ls.revalidate();
    a.repaint();
    //a.revalidate();
  }
  /** This method goes to the player selection.*/
  static public void play(){
    a.remove(m);
    p = new PlayerSelection();
    a.add(p);
    p.revalidate();
    p.repaint(); 
    a.repaint();
  }
  
  /** This method goes to the settings.*/
  static public void settings (){
    // remove mainmenu from frame, instantiate settings, refresh everything
    a.remove(m);
    s = new Settings();
    a.add(s);
    s.revalidate();
    a.repaint();
  }
  
  /** This method shows the highscores.*/
  static public void highscores (){
    a.remove(m);
    h = new Highscores();
    a.add(h);
    h.revalidate();
    a.repaint();
  }
  
  /** This method shows the main menu.
    //* @param backFrom String This indicates where the user is coming from.
    */
  public static void mainMenu(){
    //if (backFrom.equals("Game")){ //HORATIU DO YOU NEED THIS??
      /*a.remove(container);
       a.remove(c);
       a.remove(b);*/
      a.remove(pg);
      //System.out.println(a);
      m = new MainMenu();
      m.revalidate();
      m.repaint();
      a.add(m);
      m.repaint();
      m.revalidate();
      a.repaint();
      a.setSize(960, 665);
      //a.revalidate();
      //revalidate();
      m.requestFocusInWindow();
    //}
  }
  
  /** This method shows the instructions.
    * The try catch prevents input output related errors.
    * @param e IOException This is used in case of an input output related error.
    * @throws IOException Prevents IO exceptions*/
  static public void instructions (){
    try{
      Runtime.getRuntime().exec("hh.exe ../help/AtomicSmasher.chm");
    }
    catch(IOException e){
      JOptionPane.showMessageDialog(null, "Error: Could not open help file! Make sure you are running this on Windows!", "Error: Cannot load help file.", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  /** This method shows the about program. */
  static public void about(){
    a.remove(s);
    ab = new AboutProgram();
    a.add(ab);
    ab.revalidate();
    a.repaint();
  }
  
  /** This method goes back from the about. */
  static public void backAbout (){
    a.remove(ab);
    s = new Settings();
    a.add(s);
    s.revalidate();
    a.repaint();
  }
  
  /*static public void backGame(){
   a.remove(c);
   m = new MainMenu();
   a.add(m);
   a.repaint();
   }*/
  
  /** This method goes back from the settings. */
  static public void backSettings (){
    // separate back methods are required for each screen because removeAll() method does not work as intended
    a.remove(s);
    m = new MainMenu();
    a.add(m);
    m.revalidate();
    a.repaint();
    m.requestFocusInWindow();
  }
  
  /** This method goes back from the level selection. */
  static public void backLevelSelection (){
    // separate back methods are required for each screen because removeAll() method does not work as intended
    a.remove(ls);
    m = new MainMenu();
    a.add(m);
    m.revalidate();
    a.repaint();
    m.requestFocusInWindow();
  }
  /** This method goes back to the highscores. */
  static public void backHighscores (){
    // separate back methods are required for each screen because removeAll() method does not work as intended
    a.remove(h);
    m = new MainMenu();
    a.add(m);
    m.revalidate();
    a.repaint();
    m.requestFocusInWindow();
  }
}