package type;

import java.util.*;

public class Type {
    public List<String> types;
    public Weakness weakness;
    public Effectiveness effectiveness;

    public Type(){
        types = new ArrayList<>();
        effectiveness = new Effectiveness();
        weakness = new Weakness();
    }

    public void addType(String type){
        types.add(type);
    }

    public void setEffectiveness(){
        effectiveness.setResistances(types);
    }

    public void getStringEffectiveness(Effectiveness effectiveness){
        weakness.createReadable(effectiveness.getDefEff());
    }

    public void combinedSetEffectiveness(){
        getRidOfNoneTypes();
        getRidOfDuplicates();
        setEffectiveness();
        getStringEffectiveness(effectiveness);
    }

    public List<String> getTypes(){
        return types;
    }

    public void getRidOfNoneTypes(){
        while(types.contains("None")){
            types.remove("None");
        }
        while(types.contains(0)){
            types.remove(0);
        }
    }

    public void getRidOfDuplicates() {
        if (types.size() == 2) {
            if (types.get(0).equals(types.get(1))) {
                types.remove(1);
            }
        }
    }


}