/*
The Move class is responsible for the moves of the Monsters.
 */
public class Move{

    //Object attributes
    private String name;
    private String type;
    private int power;
    private float accuracy;

    //Constructors
    public Move(){
    }
    public Move(String name, String type, int power, float accuracy){
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
    }

    //Returns the attack power of the move.
    public int getPower(){
        return this.power;
    }

    //Returns the accuracy or the move.
    public float getAccuracy(){
        return this.accuracy;
    }

    //Returns the name of the move.
    public String getName(){
        return this.name;
    }
}