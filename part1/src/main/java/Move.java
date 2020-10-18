public class Move{
    private String name;
    private String type;
    private int power;
    private float accuracy;
    public Move(){
    }
    public Move(String name, String type, int power, float accuracy){
        this.name = name;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
    }
    public int getPower(){
        return this.power;
    }
    public float getAccuracy(){
        return this.accuracy;
    }
    public String getName(){
        return this.name;
    }
}