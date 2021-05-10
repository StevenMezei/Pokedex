package Observer;

public class PokedexTracker implements Observer.TrackerObserver {

    private Integer count;
    private Boolean caught;

    public PokedexTracker(Boolean caught){
        count = 0;
        this.caught = caught;

    }
    @Override
    public void update(Observer.TrackerObserver co){
        count ++;
    }

    public Integer getCount(){
        return count;
    }

    public Boolean getCaught(){
        return caught;
    }


}
