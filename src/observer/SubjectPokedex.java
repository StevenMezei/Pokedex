package Observer;

import java.util.ArrayList;
import java.util.List;

public class SubjectPokedex {

    public List<Observer.TrackerObserver> counterList;

    public SubjectPokedex(){
        counterList = new ArrayList<>();
    }

    public void addObserver(Observer.TrackerObserver co){
        if(!counterList.contains(co)){
            counterList.add(co);
        }

    }

    public void notifyObservers(){
        for(Observer.TrackerObserver counter: counterList){
            counter.update(counter);
        }
    }

    public void notifySeenObservers(){
        for(Observer.TrackerObserver counter: counterList){
            if(!counter.getCaught()){
                counter.update(counter);
            }
        }

    }

    public void printPokemonCaught(){
        for(Observer.TrackerObserver c:counterList){
            String s = " Pokemon seen";
            if(c.getCaught()){
                s = " Pokemon caught";
            }
            System.out.println(Integer.toString(c.getCount()) + s);
        }
    }
}

