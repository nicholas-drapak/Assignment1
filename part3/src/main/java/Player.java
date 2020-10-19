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
            int preMitigatedDamage = (attackerAttackStat + attackerMovePower - defenderDefenceStat);
            double damageMultiplier = getTypeVulnerability(move, defender.getMonster());
            double damageTakenDouble = preMitigatedDamage*damageMultiplier;
            int damageTaken = (int)damageTakenDouble;

            //Deals damage to the defending monster.
            defender.getMonster().takeDamage(damageTaken);

            //Prints damage dealt if the move hit.
            System.out.println(defender.getMonster().getName() + " takes " + damageTaken + " damage!");

            //Prints of the hit was super effective, or not very effective, which reference a 2x damage multiplier and a 0.5 damage multiplier respectively.
            switch ((int)(damageMultiplier*2)){
                case 1:
                    System.out.println("It wasn't very effective...");
                    break;
                case 4:
                    System.out.println("It was super effective!");
                    break;
            }
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

    //This type chart stores all the resistances and vulnerabilities of each type, with rows representing moves and columns representing monsters.
    public double[][] typeChart = {
            {2,2,2,2,2,2,2,2,2,2,2,2,1,0,2,2,1,2},//NOR
            {2,1,1,2,4,4,2,2,2,2,2,4,1,2,1,2,4,2},//FIR
            {2,4,1,2,1,2,2,2,4,2,2,2,4,2,1,2,2,2},//WAR
            {2,2,4,1,1,2,2,2,0,4,2,2,2,2,1,2,2,2},//ELE
            {2,1,4,2,1,2,2,1,4,1,2,1,4,2,1,2,1,2},//GRA
            {2,1,1,2,4,1,2,2,4,4,2,2,2,2,4,2,1,2},//ICE
            {4,2,2,2,2,4,2,1,2,1,1,1,4,0,2,4,4,1},//FIG
            {2,2,2,2,4,2,2,1,1,2,2,2,1,1,2,2,0,4},//POI
            {2,4,2,4,1,2,2,4,2,0,2,1,4,2,2,2,4,2},//GRO
            {2,2,2,1,4,2,4,2,2,2,2,4,1,2,2,2,1,2},//FLY
            {2,2,2,2,2,2,4,4,2,2,1,2,2,2,2,0,1,2},//PSY
            {2,1,2,2,4,2,1,1,2,1,4,2,2,1,2,4,1,1},//BUG
            {2,4,2,2,2,4,1,2,1,4,2,4,2,2,2,2,1,2},//ROC
            {0,2,2,2,2,2,2,2,2,2,4,2,2,4,2,1,2,2},//GHO
            {2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,2,1,0},//DRA
            {2,2,2,2,2,2,1,2,2,2,4,2,2,4,2,1,2,1},//DAR
            {2,1,1,1,2,4,2,2,2,2,2,2,4,2,2,2,1,4},//STE
            {2,1,2,2,2,2,4,1,2,2,2,2,2,2,4,4,1,2},//FAI
    };
    public double getTypeVulnerability(Move moveAttack, Monster monster){
        String attackType = moveAttack.getType();
        String monsterType = monster.getType();
        int[] index = new int[2];
        int monsterVulnerability = 0;
        String indexAllocator;
        for (int i = 0; i < 2; i++) {
            if (i==0) indexAllocator = attackType;
            else indexAllocator = monsterType;
            switch (indexAllocator){
                case "Normal":
                    index[i] = 0;
                    break;
                case "Fire":
                    index[i] = 1;
                    break;
                case "Water":
                    index[i] = 2;
                    break;
                case "Electric":
                    index[i] = 3;
                    break;
                case "Grass":
                    index[i] = 4;
                    break;
                case "Ice":
                    index[i] = 5;
                    break;
                case "Fighting":
                    index[i] = 6;
                    break;
                case "Posion":
                    index[i] = 7;
                    break;
                case "Ground":
                    index[i] = 8;
                    break;
                case "Fly":
                    index[i] = 9;
                    break;
                case "Psychic":
                    index[i] = 10;
                    break;
                case "Bug":
                    index[i] = 11;
                    break;
                case "Rock":
                    index[i] = 12;
                    break;
                case "Ghost":
                    index[i] = 13;
                    break;
                case "Dragon":
                    index[i] = 14;
                    break;
                case "Dark":
                    index[i] = 15;
                    break;
                case "Steel":
                    index[i] = 16;
                    break;
                case "Fairy":
                    index[i] = 17;
                    break;

            }
        }
        return typeChart[index[0]][index[1]]/2;
    }
}