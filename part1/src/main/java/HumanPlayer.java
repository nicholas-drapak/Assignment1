import java.util.Scanner;
public class HumanPlayer extends Player{
    public Monster monster;
    Scanner scanner = new Scanner(System.in);

    boolean selectingMove;
    public HumanPlayer(){

    }
    public HumanPlayer(Monster monster){
        super(monster);
    }
    public Move chooseMove() {
        do {
            selectingMove = true;
            int inputMove = 0;
            System.out.println("Please enter the number corresponding to the move you want to use.");
            for (int i = 1; i < 5; i++) {
                System.out.println(i + ": " + this.getMonster().getMove(i).getName());
            }
            inputMove = scanner.nextInt();
            if (inputMove >= 1 && inputMove <= 4) {
                selectingMove = false;
                return this.getMonster().getMove(inputMove);
            }
            System.out.println("Please enter a number between 1 and 4.");
        }while(selectingMove);
        return null;
    }
}