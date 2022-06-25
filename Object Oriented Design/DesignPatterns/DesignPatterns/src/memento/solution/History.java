package memento.solution;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states = new ArrayList<>();

    public void push(EditorState state){
        states.add(state);
    }

    public EditorState pop(){
        var state = states.get(states.size() - 1);
        states.remove(states.size() - 1);
        return state;
    }
}
