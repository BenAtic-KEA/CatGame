import java.util.Scanner;

public class Menu {
    private static final Scanner choice = new Scanner(System.in);

    //mainChoices
    // print welcome and option 1.. until last option which is exit
    private void presentMainChoices() {
        System.out.println();
        System.out.println("Press 1 to play with a cat");
        System.out.println("press 2 to create a cat");
        System.out.println("Press 3 to create a cat with random values");
        System.out.println("Press 4 to list cat saves");
        System.out.println("Press 5 to rename a cat");
        System.out.println("Press 6 to exit the program");
    }
    public static int fetchUserInt() {
        int userInput = choice.nextInt();
        choice.nextLine();
        return userInput;
    }
    public static String fetchUserString(){
        return choice.nextLine();
    }
    public static boolean fetchUserYesNo(){
        String answer = choice.nextLine().toLowerCase();
        if (answer.equals("yes"))
            return true;
        if (answer.equals("no"))
            return false;
        else {
            System.out.println("Please type Yes/No");
            return fetchUserYesNo();
        }
    }

    public void initiateMainMenu() {
        boolean didUserWantToExit = false;
        int saveSlot;
        int var;
        System.out.println("Welcome To Catmagotchi");
        presentMainChoices();
        while (!didUserWantToExit) {
            int userInput = fetchUserInt();
            switch (userInput) {

                case 1:
                    System.out.println("Choose a cat and play");
                    System.out.println("Enter save slot to play with: ");
                    for(int i = 0; i < CatFarm.Cats.length; i++){
                        if (CatFarm.Cats[i] != null) {
                            System.out.println("[Slot " + i + "]\n" + CatFarm.Cats[i].stateOfCat());
                        }
                    }
                    System.out.println("Select a slot");
                    Game.playTheGame(fetchUserInt());
                    break;


                case 2:
                    System.out.println("Make your own start values: ");
                    saveSlot = CatFarm.takeInput();
                    CatFarm.Cats[saveSlot] = CatFarm.catCreation();
                    CatFarm.nameCat(saveSlot);

                    break;

                case 3:
                    System.out.println("Which slot do you want to save in? enter 0-10 (inclusive)");
                    saveSlot = CatFarm.takeInput();
                    CatFarm.Cats[saveSlot] = CatFarm.catRandom();
                    CatFarm.nameCat(saveSlot);
                    System.out.println("Your cat spawned with: \n" + CatFarm.Cats[saveSlot].stateOfCat());
                    break;

                case 4:
                    System.out.println("List empty saves? yes/no");
                    boolean showEmpty = fetchUserYesNo();
                    for (int catSave = 0; catSave < CatFarm.Cats.length; catSave++){
                        if (CatFarm.Cats[catSave] == null && showEmpty)
                            System.out.println("[Slot: " + catSave +"]" + "\nContains EMPTY");
                        if (CatFarm.Cats[catSave] != null)
                            System.out.println("[Slot: " + catSave + "]"+ "\nContains " + CatFarm.Cats[catSave].stateOfCat());
                    }
                    break;

                case 5:
                    System.out.println("Just rename the cat with the same name, if you didn't want to rename.\n" +
                            "Enter save slot to modify: ");
                    var = CatFarm.takeInput();
                    if (CatFarm.Cats[var] != null)
                        CatFarm.nameCat(var);
                    else{
                        System.out.println("No cat saved on that Slot!\n" +
                                "press 3 in main menu to see saved cats");
                    }
                    break;
                case 6:
                    System.out.println("You chose to exit the program - goodbye");
                    didUserWantToExit = true;
                    break;
            }
            if(!didUserWantToExit)
                presentMainChoices();
        }
    }
}
