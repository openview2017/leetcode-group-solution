package observer.solution;

public class Datasource extends Subject{
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    }
}

// We don't know the relationship between Datasource and others
// If we add more charts and SpreadSheets at runtime,
// we don't know how many user added and depending on the current source.
