package Observer;

public interface TrackerObserver {

    void update(TrackerObserver co);

    Integer getCount();

    Boolean getCaught();
}
