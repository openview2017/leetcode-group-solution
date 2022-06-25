package state.problem;

public class Main {
    public static void main(String[] arg){
        drawUIControl(new TextBox());
    }

    private static void drawUIControl(UIControl control) {
        control.draw();
    }
}
