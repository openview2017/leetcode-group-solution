package command.editor;

public class UndoCommand implements Command{
    private History history;

    public UndoCommand(History history) {
        this.history = history;
    }

    @Override
    public void execute() {
        //history.pop().unexecute(); // If history is empty?

        if (history.size() > 0) {
            history.pop().unexecute(); // If history is empty?
        }
    }
}
