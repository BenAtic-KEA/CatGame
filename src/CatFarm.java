import java.util.Random;
import java.util.Scanner;

public class CatFarm {
    private static Random startValue = new Random();
    public static Cat[] Cats = new Cat[11];
    private static int count; // feature så kan implementeres.

    public static Cat catCreation(){
        System.out.println("Please input a number between 0-10 (inclusive).");

        System.out.println("Mood: ");
        int mood = takeInput();

        System.out.println("Hungry: ");
        int hunger = takeInput();

        System.out.println("Energy: ");
        int energy = takeInput();

        count++;

        return new Cat(mood, hunger, energy);
    }

    public static Cat catRandom(){

        int mood = startValue.nextInt(10 )+ 1;
        int hunger = startValue.nextInt(10) + 1;
        int energy = startValue.nextInt(10) + 1;
        count++;

        return new Cat(mood, hunger, energy);
    }

    public static void nameCat(int saveSlot){
        System.out.println("What do you want to call the cat?:");
        CatFarm.Cats[saveSlot].setName(Menu.fetchUserString());
    }

    public static int takeInput(){
        int var;
        String error = "Not an integer or out of bounds. Try Again!";
        Scanner userInput = new Scanner(System.in);

        do{
            if (userInput.hasNextInt())
                var = userInput.nextInt();
            else {
                var = -1;
            }
            if(var < 0 || var > 10) {
                System.out.println(error);
            }
            userInput.nextLine();
        }while((var < 0 || var > 10));
        return var;
    }
}
