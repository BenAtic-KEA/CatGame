public class Game {

    private static boolean gameRunning;
    private static boolean programRunning;
    private boolean winConditionMet;




    public static void startTheGame(){
        programRunning = true;
        Menu menu = new Menu();

        while (programRunning){
            menu.initiateMainMenu();
        }
    }

    public static void playTheGame(int catToPlayWith){

        System.out.println(CatFarm.Cats[catToPlayWith].stateOfCat());
        gameRunning = true;
        while(gameRunning){
            System.out.println("press 1 to play");
            System.out.println("press 2 to feed");
            System.out.println("press 3 to sleep");
            System.out.println("press 10 to exit game to menu");
            System.out.println();

            switch (Menu.fetchUserInt()){

                case 1:
                    CatFarm.Cats[catToPlayWith].play();
                    System.out.println(CatFarm.Cats[catToPlayWith].stateOfCat());
                    break;

                case 2:
                    CatFarm.Cats[catToPlayWith].feed();
                    System.out.println(CatFarm.Cats[catToPlayWith].stateOfCat());
                    break;

                case 3:
                    CatFarm.Cats[catToPlayWith].sleep();
                    System.out.println(CatFarm.Cats[catToPlayWith].stateOfCat());
                    break;

                case 10:
                    gameRunning = false;
                    break;
            }



        }

    }

}
