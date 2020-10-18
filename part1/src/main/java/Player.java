//Imports
import java.lang.Math;
/*
The Player class is the superclass responsible for both players.
 */
public class Player{
    public Monster monster;

    //Constructors
    public Player(){
    }
    public Player(Monster monster){
        this.monster = monster;
    }

    /*
    The attack method is called when one monster attacks another monster.
    It is responsible for calculating misses and damage.
     */
    public void attack(Player defender, Move move){
        //Print the executed move
        System.out.println(this.getMonster().getName() + " uses " + move.getName() + "!");

        //Decide whether or not the move hit. An accuracy of 1.0 will never miss.
        if(move.getAccuracy() >= Math.random()){

            //If the move hit, calculate damage.
            int attackerAttackStat = this.getMonster().getAttack();
            int attackerMovePower = move.getPower();
            int defenderDefenceStat = defender.getMonster().getDefence();
            int damageTaken = (attackerAttackStat + attackerMovePower - defenderDefenceStat);

            //Deals damage to the defending monster.
            defender.getMonster().takeDamage(damageTaken);

            //Prints damage dealt if the move hit.
            System.out.println(defender.getMonster().getName() + " takes " + damageTaken + " damage!");
        }
        else{

            //Prints a miss if the move missed.
            System.out.println(this.getMonster().getName() + " missed!");
        }
    }

    //Checks to make sure the Monster has more than 0 hp. If it doesn't, it loses.
    public boolean hasLost(){
        if (this.monster.getHP()<=0){
            return true;
        }
        return false;
    }

    //Returns the player's monster.
    public Monster getMonster(){
        return this.monster;
    }

    //Checks to see if the player that calls the method is faster than its' enemy.
    public boolean isFasterThan(Player enemy){

        //If this player's speed is greater than the opponent's speed, it returns true.
        if (this.monster.getSpeed() > enemy.getMonster().getSpeed()){
            return true;
        }

        //If the speeds are equal, it picks one at random.
        if (this.monster.getSpeed() == enemy.getMonster().getSpeed()){
            return (((int)(Math.random() * (2 - 1 + 1) + 1)) == 2);
        }

        //If this player's speed is less than the opponent's speed, it returns false.
        return false;
    }
}