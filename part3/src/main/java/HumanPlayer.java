//Imports
import java.util.Scanner;
/*
The Human Player class is responsible for the human player's actions
It is a subclass of the Player Class.
 */
public class HumanPlayer extends Player{

    //Object Atributes
    public Monster monster;

    //Object instantiations
    Scanner scanner = new Scanner(System.in);
    boolean selectingMove;

    //Constructors
    public HumanPlayer(){
    }
    public HumanPlayer(Monster monster){
        super(monster);
    }

    //The choose move class is responsible for handing the human player selecting a move from the monster's listed known moves.
    public Move chooseMove() {
        //Loops the method until the user selects a move from the list.
        do {
            selectingMove = true;
            int inputMove = 0;

            //Asks the user to select a move from the list generated further on.
            System.out.println("Please enter the number corresponding to the move you want to use.");

            //Lists all the moves the monster knows.
            for (int i = 1; i < 5; i++) {
                System.out.println(i + ": " + this.getMonster().getMove(i).getName());
            }

            //Waits for the user to select a move by entering a number between 1 and 4.
            inputMove = scanner.nextInt();

            //Checks to see if the input is between 1 and 4
            if (inputMove >= 1 && inputMove <= 4) {

                //If so, it returns the corresponding move.
                selectingMove = false;
                return this.getMonster().getMove(inputMove);
            }

            //If not, asks the user to choose a number that corresponds to one of the listed known moves.
            System.out.println("Please enter a number between 1 and 4.");

        //Jumps to the start of the loop if the user has not made an appropriate selection
        }while(selectingMove);
        return null;
    }
}