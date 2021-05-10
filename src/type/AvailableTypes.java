package type;

import java.nio.file.attribute.AttributeView;
import java.util.ArrayList;
import java.util.List;

public class AvailableTypes {
    public List<String> availableTypes;

    public AvailableTypes(){
        availableTypes = new ArrayList<>();
        availableTypes.add("Normal");
        availableTypes.add("Fire");
        availableTypes.add("Water");
        availableTypes.add("Grass");
        availableTypes.add("Electric");
        availableTypes.add("Ice");
        availableTypes.add("Fighting");
        availableTypes.add("Poison");
        availableTypes.add("Ground");
        availableTypes.add("Flying");
        availableTypes.add("Psychic");
        availableTypes.add("Bug");
        availableTypes.add("Rock");
        availableTypes.add("Ghost");
        availableTypes.add("Dragon");
        availableTypes.add("Dark");
        availableTypes.add("Steel");
        availableTypes.add("Fairy");
    }

    public void add(String s){
        availableTypes.add(s);
    }

    public boolean contains(String s){
        if (availableTypes.contains(s)) {
            return true;
        }
        else
            return false;
    }

    public List<String> getAvailableTypes(){
        return availableTypes;
    }

    public String get(Integer x){
        String answer = availableTypes.get(x);

        return answer;}
}
