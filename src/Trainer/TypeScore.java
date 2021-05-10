package Trainer;

public class TypeScore  {

    public String type;
    public Integer score;

    public TypeScore(String s, Integer i){
        this.type = s;
        this.score = i;
    }

    public String printTypeScore(){
        return type + " " + Integer.toString(score);
    }
}
