package observer.pull;

public class SpreadSheet implements Observer {
    private Datasource dataSource;

    public SpreadSheet(Datasource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update() {
        var value = dataSource.getValue();
        System.out.println("SpreadSheet got notified: " + value);
    }
}
