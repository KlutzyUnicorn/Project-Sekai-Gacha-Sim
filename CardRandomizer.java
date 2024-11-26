import java.util.*;
import java.io.*;

public class CardRandomizer {
  // creating objects
  Backend backEnd = new Backend();
  GUI gui = new GUI();
  Random roller = new Random();
  Scanner reader = new Scanner(System.in);

  // creates array and variable to store the rarity of the cards pulled
  private static int rolls[] = new int[10];
  private static int pull;

  // creates file objects with the file names of all the cards
  File twostars = new File("Cards/2Stars");
  File threestars = new File("Cards/3Stars");
  File fourstars = new File("Cards/4Stars");

  // returns arrays of all file names
  private final String[] twostarsList = twostars.list();
  private final String[] threestarsList = threestars.list();
  private final String[] fourstarsList = fourstars.list();

  // creates an arraylist to store the names of all the cards pulled in a ten pull
  private static ArrayList<String> tenpulllist = new ArrayList<String>();

  public void window() {
    // creates the window this is here because it needs to be opened somewhere
    gui.window();
    // System.out.println(twostarsList[0].indexOf("."));
  }// end window

  public void menuimg(String img) {
    // a passthrough so that other classes can still edit what photo is shown in the window
    gui.img(img);
  }// end menuimg

  public void tenpull() {
    // System.out.println("Character: " +
    // twostarsList[0].substring(twostarsList[0].indexOf(".") + 1,
    // twostarsList[0].length() - 4));
    /*
     * for (int i = 0; i < fourstarsList.length; i++) { cardroll(fourstarsList,
     * "4Stars", i); }
     */

    tenpulllist.clear();
    for (int i = 0; i < rolls.length; i++) {
      //rolls the rarity of card
      int num = roller.nextInt(1000);
      rolls[i] = num;
    } // end for

    if (!(936 <= rolls[9] && rolls[9] <= 1000)) {
      // guarantees a 3 star unless that spot in the array is a 4 star
      rolls[9] = 855;
    } // end if

    for (int i = 0; i < rolls.length; i++) {
      // checks each of the pulls for rarity and displays the cards
      cardrarity(rolls[i]);
    } // end for

    //shows a list of all the cards that were pulled
    gui.img("Menu Screens/TenPull.jpg");
    System.out.println("Cards:\n");
    for (int i = 0; i < tenpulllist.size(); i++) {
      System.out.println(tenpulllist.get(i));
    } // end for
    System.out.println("");
    backEnd.next();
  }// end tenpull

  public void singlepull() {
    //just rolls a single card
    pull = roller.nextInt(1000);
    cardrarity(pull);
  }// end singlepull

  private void cardrarity(int rarity) {
    //checks the rarity of the card
    if (0 <= rarity && rarity <= 850) {
      cardroll(twostarsList, "2Stars");
    } // end if
    else if (851 <= rarity && rarity <= 935) {
      cardroll(threestarsList, "3Stars");
    } // end else if
    else {
      cardroll(fourstarsList, "4Stars");
    } // end else
  }// end cardrarity

  private void cardroll(String cardlist[], String rarity/* , int cardnum */) {
    //rolls the card
    int cardnum = roller.nextInt(cardlist.length);
    String card = cardlist[cardnum];

    //creates variables for the card's name and the character
    String cardname = card.substring(0, card.indexOf("."));
    String charactername = card.substring(card.indexOf(".") + 1, card.length() - 4);

    //adds the card to the list that's displayed at the end
    tenpulllist
        .add(cardname + " - " + charactername);
    // System.out.println(card);

    gui.img("Cards/" + rarity + "/" + card);

    //prints out the rarity
    System.out.println("\t\033[36mCard\033[37m\n");
    if (rarity.equals("2Stars")) {
      System.out.println("Rarity: ★★");
    } // end if
    else if (rarity.equals("3Stars")) {
      System.out.println("Rarity: ★★★");
    } // end else if
    else if (rarity.equals("4Stars")) {
      System.out.println("Rarity: ★★★★");
    } // end else if

    //prints card name and character
    System.out.println("Card Name: " + cardname);
    System.out.println("Character: " + charactername + "\n");
    backEnd.next();
  }// end cardroll
}// end class