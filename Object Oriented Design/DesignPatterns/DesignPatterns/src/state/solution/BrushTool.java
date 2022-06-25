package state.solution;

public class BrushTool implements Tool {
    @Override
    public void mouseUp() {
        System.out.println("Brush icon");
    }

    @Override
    public void mouseDown() {
        System.out.println("Draw a line");
    }
}
