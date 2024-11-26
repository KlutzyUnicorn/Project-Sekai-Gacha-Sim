class Main {
  public static void main(String[] args) {
    // creates objects
    Backend backEnd = new Backend();
    Menus menus = new Menus();

    // clears console of start up text
    backEnd.clear();

    // questions.tester();
    // randomizer.tenpull();
    // randomizer.tenpull();
    // randomizer.singlepull();

    // starts the entire program
    menus.startup();

  }// end main method
}// end main class