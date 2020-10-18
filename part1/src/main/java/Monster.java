import java.util.Random;

public class Monster {
    public String name;
    private String type;
    private int hp;
    private int speed;
    private int attack;
    private int defence;
    private Move move1;
    private Move move2;
    private Move move3;
    private Move move4;

    public Monster() {
    }

    public Monster(String name, String type, int hp, int speed, int attack, int defence, Move move1, Move move2, Move move3, Move move4) {
        this.name = name;
        this.type = type;
        this.hp = hp;
        this.speed = speed;
        this.attack = attack;
        this.defence = defence;
        this.move1 = move1;
        this.move2 = move2;
        this.move3 = move3;
        this.move4 = move4;
    }

    public Move getMove(int moveNumber) {
        switch (moveNumber) {
            case 1:
                return move1;
            case 2:
                return move2;
            case 3:
                return move3;
            case 4:
                return move4;
            default:
                return null;
        }
    }
    public String getName(){
        return this.name;
    }
    public int getHP(){
        return this.hp;
    }
    public int getSpeed(){
        return this.speed;
    }
    public int getAttack(){
        return this.attack;
    }
    public int getDefence(){
        return this.defence;
    }
    public void takeDamage(int damageTaken){
            this.hp -= damageTaken;
    }
}