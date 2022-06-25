package observer.solution;

public class Main {
    public static void main(String[] args) {
        var dataSource = new Datasource();
        var sheet1 = new SpreadSheet();
        var sheet2 = new SpreadSheet();
        var sheet3 = new SpreadSheet();
        var chart = new Chart();

        dataSource.addObserver(sheet1);
        dataSource.addObserver(sheet2);
        dataSource.addObserver(chart);
        dataSource.setValue(1);
    }
}
