//Imports
import java.lang.Math;

/*
The CPU Player class is responsible for the computer player's actions.
It is a subclass of the Player superclass.
 */
public class CPUPlayer extends Player{

    //Object Atributes
    public Monster monster;

    //Constructors
    public CPUPlayer(){
    }
    public CPUPlayer(Monster monster){
        super(monster);
    }

    //Choses a move at random from the monsters known moves.
    public Move chooseMove(){
        return this.getMonster().getMove((int)(Math.random() * (4 - 1 + 1) + 1));
    }
}