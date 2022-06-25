package observer.solution;

public class SpreadSheet implements Observer{
    @Override
    public void update() {
        System.out.println("Spreadsheet got notified.");
    }
}
