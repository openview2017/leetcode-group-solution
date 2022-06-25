package observer.push;

public class Chart implements Observer {
    @Override
    public void update(int value) {
        System.out.println("Update Chart: " + value);
    }
}
