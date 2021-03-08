public class Cat {
    private String name;
    private int mood;
    private int hungry;
    private int energy;
    private int exp;
    private int lvl;

    public Cat(int mood, int hungry, int energy){
        this.mood = mood;
        this.hungry = hungry;
        this.energy = energy;
        this.exp = 0;
        this.lvl = 1;
    }
    public Cat(){
    }
    public String getName(){return this.name;}

    public int getMood(){
        return this.mood;
    }

    public int getHungry(){
        return this.hungry;
    }

    public int getEnergy(){
        return this.energy;
    }

    public void setName(String name){
        this.name = name;
    }
    //public int setMood(){}
    //public int setHungry(){}
    //public int setEnergy(){}

    private boolean checkLogicUp(String state, int var){
        if (var+1 > 10) {
            System.out.println("Cat is at maximum " + state);
            return false;
        }
        else return true;
    }

    private boolean checkLogicDown(String state, int var){
        if (var-1 < 0) {
            System.out.println("Cat is at minimum " + state);
            return false;
        }
        else return true;
    }


    public String stateOfCat(){
        return "Name: " + name + "\nlvl: " + lvl + "\nMood: " + mood + ". Hunger: " + hungry + ". Energy: " + energy + ".";
    }

    private void meow(){
        System.out.println("Meow!");
    }

    // Sleep
    public void sleep(){
    if (checkLogicUp("energy", this.energy)){
        this.energy++;
    }
    if (checkLogicUp("hunger", this.hungry)) {
        this.hungry++;
    }
    }

//Play
    public void play(){

        if(energy > 0) {
            if (checkLogicUp("mood", this.mood)) {
                this.mood++;
            }
            if (checkLogicDown("energy", this.energy)) {
                this.energy--;
            }
        } else{

            System.out.println("im too tired! to play!");
        }

        meow();

        increaseExp();
    }

//Feed
    public void feed() {
        if (checkLogicDown("hunger", this.hungry)) {
            this.hungry--;
        }
        if (checkLogicUp("mood", this.mood)) {
            this.mood++;
        }
        meow();
    }


    private void setExp(int exp) {
        this.exp = exp;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    // Lvl up
    private void increaseExp() {

        if (exp < 9 && energy > 0) {

            this.exp++;
            System.out.println("your cats XP is " + exp + "/10");
        } else if (energy == 0) {

            System.out.println("no XP without Energy!");
        } else {

            setExp(0);
            this.lvl++;
            System.out.println("Your cat is now lvl " + lvl + "!");
        }
    }


    }



/*
Notice: •Fields/attributes are private•Feed, sleep, play methods are public
•meow method is private and prints “Meow
 */


