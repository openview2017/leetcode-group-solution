package memento.solution;

public class Main {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();

        editor.setContent("a");
        history.push(editor.CreateState());

        editor.setContent("b");
        history.push(editor.CreateState());

        editor.setContent("c");
        history.push(editor.CreateState());

        editor.restore(history.pop());
        System.out.println(editor.getContent());
        editor.restore(history.pop());
        System.out.println(editor.getContent());
    }
}
