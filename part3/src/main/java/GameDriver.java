//Imports
import java.lang.Math;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/*
The Game Driver is responsible for running the game.
 */
public class GameDriver {

    //The main class. This is where the code starts.
	public static void main(String[] args) {

        ArrayList<Monster> monsterList = new ArrayList<>();

	    try{
	        File file = new File("src/main/java/MonsterList.txt");
	        Scanner fileScanner = new Scanner(file);
	        while(fileScanner.hasNextLine()){
	            String monsterPlaceHolder = fileScanner.nextLine();
	            Move move1 = toMove(fileScanner.nextLine());
	            Move move2 = toMove(fileScanner.nextLine());
	            Move move3 = toMove(fileScanner.nextLine());
	            Move move4 = toMove(fileScanner.nextLine());
	            monsterList.add(toMonster(monsterPlaceHolder, move1, move2, move3, move4));
            }

        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred while attempting to read the file.");
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select your monster from the following list by entering the corresponding number. Enter 0 for a random selection.");
            for (int i = 0; i < monsterList.size(); i++) {
                System.out.println(i+1 + ": " + monsterList.get(i).getName());
            }
            int input;
            boolean selectingMonster = true;
            do {
                input = scanner.nextInt()-1;
                if (input == 0){
                    selectingMonster = false;
                    input = (int)(Math.random()*monsterList.size())+1;
                    System.out.println("You have randomly selected " + monsterList.get(input).getName() + ".");
                }
                else if (input>=1 && input<=monsterList.size()){
                    System.out.println("Your have selected " + monsterList.get(input).getName() + ".");
                    selectingMonster = false;
                }
                else System.out.println("Please enter a valid number from the list. You can choose from 1 to " + monsterList.size()+1 + ".");
            }while(selectingMonster);
        HumanPlayer player = new HumanPlayer(monsterList.get(input));

        System.out.println("Please select the opponent's monster from the following list by entering the corresponding number. Enter 0 for a random selection.");
        for (int i = 0; i < monsterList.size(); i++) {
            System.out.println(i+1 + ": " + monsterList.get(i).getName());
        }
        selectingMonster = true;
        do {
            input = scanner.nextInt()-1;
            if (input == 0){
                selectingMonster = false;
                input = (int)(Math.random()*monsterList.size())+1;
                System.out.println("Your opponent has been randomly given " + monsterList.get(input).getName() + ".");
            }
            else if (input>=1 && input<=monsterList.size()){
                System.out.println("Your opponent has been given " + monsterList.get(input).getName() + ".");
                selectingMonster = false;
            }
            else System.out.println("Please enter a valid number from the list. You can choose from 1 to " + monsterList.size()+1 + ".");
        }while(selectingMonster);
        CPUPlayer enemy = new CPUPlayer(monsterList.get(input));

		while ((!player.hasLost()) && (!enemy.hasLost())) {
			// print both monsters' HP
			System.out.println("");
			System.out.printf("%s has %d HP\n", player.getMonster().getName(), player.getMonster().getHP());
			System.out.printf("%s has %d HP\n", enemy.getMonster().getName(), enemy.getMonster().getHP());

			// decide the next move
			Move playerMove = player.chooseMove();
			Move enemyMove = enemy.chooseMove();

			// execute the next move
			if (player.isFasterThan(enemy)) {
				player.attack(enemy, playerMove);
				if (!enemy.hasLost()) {
					enemy.attack(player, enemyMove);
				}
			}
			else {
				enemy.attack(player, enemyMove);
				if (!player.hasLost()) {
					player.attack(enemy, playerMove);
				}
			}
		}
        System.out.println();

		//Print the outcome of the battle.
		if (player.hasLost()) {
			System.out.printf("You and %s have lost the battle. %s has %d health left.\n", player.getMonster().getName(),enemy.getMonster().getName(),enemy.getMonster().getHP());
		} else {
			System.out.printf("You and %s are victorious! %s has %d health left.\n", player.getMonster().getName(),player.getMonster().getName(),player.getMonster().getHP());
		}
	}
    public static Move toMove(String input){
        String[] moveAtributes = input.split(",");
        Move move = new Move(moveAtributes[0], moveAtributes[1], Integer.parseInt(moveAtributes[2]), Float.parseFloat(moveAtributes[3]));
        return move;
    }
    public static Monster toMonster(String input, Move move1, Move move2, Move move3, Move move4){
        String[] monsterAtributes = input.split(",");
        Monster monster = new Monster(monsterAtributes[0],monsterAtributes[1],Integer.parseInt(monsterAtributes[2]),
                Integer.parseInt(monsterAtributes[3]),Integer.parseInt(monsterAtributes[4]),Integer.parseInt(monsterAtributes[5]),
                move1, move2, move3, move4);
        return monster;
    }
}
