package mediator.observer;

import java.util.ArrayList;
import java.util.List;

public class UIControl {
    protected List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void unattach(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (var observer : observers) {
            observer.update();
        }
    }
}
