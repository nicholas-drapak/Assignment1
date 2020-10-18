import java.lang.Math;
public class Player{
    public Monster monster;
    public Player(){

    }
    public Player(Monster monster){
        this.monster = monster;
    }
    public void attack(Player defender, Move move){
        System.out.println(this.getMonster().getName() + " uses " + move.getName() + "!");
        if(move.getAccuracy() >= Math.random()){
            int attackerAttackStat = this.getMonster().getAttack();
            int attackerMovePower = move.getPower();
            int defenderDefenceStat = defender.getMonster().getDefence();
            int damageTaken = (attackerAttackStat + attackerMovePower - defenderDefenceStat);
            defender.getMonster().takeDamage(damageTaken);
            System.out.println(defender.getMonster().getName() + " takes " + damageTaken + " damage!");
        }
        else{
            System.out.println(this.getMonster().getName() + " missed!");
        }
    }
    public boolean hasLost(){
        if (this.monster.getHP()<=0){
            return true;
        }
        return false;
    }
    public Monster getMonster(){
        return this.monster;
    }
    public boolean isFasterThan(Player enemy){
        if (this.monster.getSpeed() > enemy.getMonster().getSpeed()){ //If this player's speed is greater than the opponent's speed, it returns true.
            return true;
        }
        if (this.monster.getSpeed() == enemy.getMonster().getSpeed()){ //If the speeds are equal, it picks one at random.
            return (((int)(Math.random() * (2 - 1 + 1) + 1)) == 2);
        }
        return false; //If this player's speed is less than the opponent's speed, it returns false.
    }
}