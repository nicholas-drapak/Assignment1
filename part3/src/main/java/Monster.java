/*
The Monster class is responsible for all player monsters.
 */
public class Monster {

    //Object Atributes.
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


    //Constructors
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

    //Returns one designated move the monster has.
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

    //Returns the name of the monster.
    public String getName(){
        return this.name;
    }

    //Returns the type of the monster.
    public String getType(){
        return this.type;
    }

    //Returns the hitpoints of the monster.
    public int getHP(){
        return this.hp;
    }

    //Returns the speed of the monster.
    public int getSpeed(){
        return this.speed;
    }

    //Returns the attack power of the monster.
    public int getAttack(){
        return this.attack;
    }

    //Returns the defence of the monster.
    public int getDefence(){
        return this.defence;
    }

    //takeDamage is responsible for dealing damage to the monster.
    public void takeDamage(int damageTaken){
            this.hp -= damageTaken;
    }
}