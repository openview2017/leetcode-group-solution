package mediator.solution;

public class UIControl {
    // Can remove DialogBox with observer pattern. No awareness of DialogBox
    protected DialogBox owner;

    public UIControl(DialogBox owner) {
        this.owner = owner;
    }
}
