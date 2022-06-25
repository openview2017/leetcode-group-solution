package observer.pull;

public class Chart implements Observer {
    private Datasource datasource;

    public Chart(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void update() {
        var value = datasource.getValue();
        System.out.println("Update Chart: " + value);
    }
}
