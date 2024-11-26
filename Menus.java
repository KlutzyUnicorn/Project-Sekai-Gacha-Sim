import java.util.*;

public class Menus {
  // creates objects
  Backend backEnd = new Backend();
  CardRandomizer randomizer = new CardRandomizer();
  Scanner reader = new Scanner(System.in);

  public void startup() {
    // creates the window using the method from the randomizer, it's like this cause
    // it acts weird and also sets up the startscreen
    randomizer.window();
    startscreen();
  }// end startup

  private void startscreen() {
    backEnd.clear();

    while (true) {
      // main menu
      randomizer.menuimg("Menu Screens/StartScreen.jpg");

      // prints welcome message
      System.out.println("\tWelcome to the \033[36mProject Sekai\033[37m Gacha Simulator!");
      System.out.println("\033[32mPress Enter After Every Prompt to Continue");
      System.out.println("Images and menus may take a bit of time to load\033[37m\n");
      // main menu text
      System.out.println("1. Start");
      System.out.println("2. Information");
      System.out.println("3. Quit\n");
      System.out.print("\033[34mEnter Number:\033[37m\t");
      int input = reader.nextInt();

      // main menu switch
      switch (input) {
        case 1:
          // gacha
          backEnd.clear();
          gachamenu();
          break;
          
        case 2:
          // information
          backEnd.clear();
          info();
          break;
          
        case 3:
          // quit
          backEnd.clear();
          System.out.println("\tThank you for playing!");
          backEnd.quit();
          break;
          
        default:
          // error
          backEnd.inputerror();
          continue;
      }// end switch
    } // end while
  }// end startscreen

  private void gachamenu() {
    while (true) {
      // gacha menu
      randomizer.menuimg("Menu Screens/GachaScreen.jpg");

      // gacha menu text
      System.out.println("\t\033[35mGacha Menu\033[37m\n");
      System.out.println("1. Single Pull");
      System.out.println("2. Ten Pull");
      System.out.println("3. Back to Start Menu\n");
      System.out.print("\033[34mEnter Number:\033[37m\t");
      int input = reader.nextInt();

      // gacha menu switch
      switch (input) {
        case 1:
          // single pull
          backEnd.clear();
          randomizer.singlepull();
          break;
          
        case 2:
          // ten pull
          backEnd.clear();
          randomizer.tenpull();
          break;
          
        case 3:
          // back to main menu
          startscreen();
          break;
          
        default:
          backEnd.inputerror();
          continue;
      }// end switch
    } // end while
  }// end gacha menu

  private void info() {
    while (true) {
      //info menu
      randomizer.menuimg("Menu Screens/InfoScreen.png");

      //info menu text
      System.out.println("\t\033[36mInfo Menu\033[37m\n");
      System.out.println("1. Tutorial");
      System.out.println("2. Gacha Information");
      System.out.println("3. Back to Start Menu\n");
      System.out.print("\033[34mEnter Number:\033[37m\t");
      int input = reader.nextInt();

      //info menu swithc
      switch (input) {
        case 1:
          //tutorial on how the gacha system works
          backEnd.clear();
          System.out.println("\t\033[34mTutorial\033[37m\n");
          System.out.println("There are 3 rarities of cards: \033[34m2 Stars\033[37m, \033[0;33m3 Stars\033[37m and \033[35m4 Stars\033[37m. \033[34m2 Stars\033[37m are the most common and \033[35m4 Stars\033[37m are the rarest.\n");
          
          System.out.println("There is also two types of pulls: Single pulls and ten pulls.\n"); 
          
          System.out.println("Ten pulls will always have a guaranteed \033[0;33m3 Star\033[37m unless there is a \033[35m4 Star\033[37m in which case there may not be a \033[0;33m3 Star\033[37m\n");
          backEnd.next();
          break;
          
        case 2:
          backEnd.clear();
          //gacha info tells user what cards are available and about the rates
          System.out.println("\t\033[35mGacha Information\033[37m\n");
          System.out.println(
              "All cards from before and released during the \033[35mNocturne Interlude\033[37m Event are included");
          System.out
              .println("\nThere are \033[31mno\033[37m boosted rates for cards and rates are as close to in game rates as possible\n");
          backEnd.next();
          break;
          
        case 3:
          // back to main menu
          startscreen();
          break;
          
        default:
          // error
          backEnd.inputerror();
          continue;
      }// end switch
    } // end while
  }// end info
}// end menus class