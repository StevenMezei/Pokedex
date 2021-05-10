package Trainer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TypeScoreList {

    public List<TypeScore> typeScores = new ArrayList<>();

    public TypeScoreList() {
    }

    public void add(TypeScore t) {
        typeScores.add(t);
    }

    public void sortTypeScores() {
        typeScores.sort((o1, o2) -> {
            if (o1.score == o2.score) {
                return 0;
            }
            return o1.score > o2.score ? -1 : 1;
        });
    }

    public List<String> getSortedList(){
        List<String> typeList = new ArrayList<>();
        sortTypeScores();
        for(TypeScore ts: typeScores){
            typeList.add(ts.printTypeScore());
        }

        return typeList;}
}


