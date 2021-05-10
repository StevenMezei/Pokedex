package type;

import java.util.ArrayList;
import java.util.List;

public class Weakness {
    public List<String> weaknesses;
    public List<String> resistances;
    public List<String> immunity;
    public List<String> neutral;
    public AvailableTypes availableTypes;

    public Weakness(){
        this.weaknesses = new ArrayList<>();
        this.resistances = new ArrayList<>();
        this.immunity = new ArrayList<>();
        this.neutral = new ArrayList<>();
        availableTypes = new AvailableTypes();
    }

    //REQUIRES: A list with size 18 with numbers that are either 0, 1, 2, 4, 8, 16
    //MODIFIES:this
    //EFFECTS: uses the list of integers in effectiveness to turn to readable resistances and weaknesses
    public void createReadable(List<Integer> types) {
        for(int x=0; (x<18); x++){
            convertToString(types.get(x),availableTypes.get(x));
        }
    }



    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public List<String> getResistances() {
        return resistances;
    }

    public void setResistances(List<String> resistances) {
        this.resistances = resistances;
    }

    public List<String> getImmunity() {
        return immunity;
    }

    public void setImmunity(List<String> immunity) {
        this.immunity = immunity;
    }

    public List<String> getNeutral() {
        return neutral;
    }

    public void setNeutral(List<String> neutral) {
        this.neutral = neutral;
    }


    //REQUIRES: An integer between that is one of 0,1,2,4,8,16 and a string
    //MODIFIES: resistances, weaknesses, and immunities
    //EFFECTS: Turns the number type of effectiveness into a sorted list of string
    public void convertToString(Integer n, String s){
        if (n==2){
            resistances.add(s);
        }
        if(n==8){
            weaknesses.add(s);
        }
        if(n==16){
            weaknesses.add(s+"(4x)");
        }
        if(n==1){
            resistances.add(s+"(0.25x)");
        }
        if(n==0){
            immunity.add(s);
        }
        if(n==4){
            neutral.add(s);
        }
    }

}
