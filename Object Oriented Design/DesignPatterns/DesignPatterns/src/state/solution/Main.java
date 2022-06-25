package state.solution;

public class Main {
    public static void main (String[] arg) {
        var canvas = new Canvas();
        canvas.setCurrentTool(new SelectionTool());
        canvas.mouseUp();
        canvas.mouseDown();
        canvas.setCurrentTool(new EraserTool());
        canvas.mouseUp();
        canvas.mouseDown();
    }
}
