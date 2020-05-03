package me.cedric.nfa;

import java.util.Set;

public class State {
    private int id;
    private boolean accept;
    public int getId() {
        return id;
    }

    public boolean isAccept() {
        return accept;
    }

    public State(int id, boolean accept) {
        this.id = id;
        this.accept = accept;
    }

    public State(int id) {
        this.id = id;
        this.accept = false;
    }
}
