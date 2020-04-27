package me.cedric.nfa;

import java.util.*;

public class NFA {
    State initialState;
    private final Set<State> states;
    private final Set<State> acceptingStates;
    private final Set<Transition> transitions;


    public NFA() {
        states = new HashSet<State>();
        acceptingStates = new HashSet<State>();
        transitions = new HashSet<Transition>();
    }

    public void addTransition(int q, String c, int p) {
        State stateQ = getState(q);
        State StateP = getState(p);
        Transition tr = new Transition(stateQ,c,StateP);
        transitions.add(tr);
    }
    public Set<State> simulate(int q, List<String> word) {
        State stateQ = getState(q);
        Set<State> possibleStates = new HashSet<State>();
        possibleStates.add(stateQ);
        for(String symbol: word) {
            for(State possible: possibleStates) {
                for (Transition tr : transitions) {
                    if ((tr.getFrom().equals(possible)) && (tr.getSymbol().equals(symbol))) {
                        possibleStates.add(tr.to);
                    }
                }
            }
        }
        return possibleStates;
    }
    public boolean wordAccepted(Set<State> states) {
        for(State state: states) {
            if(acceptingStates.contains(state)) {
                return true;
            }
        }
        return false;
    }

    public void addState(int id, boolean accept) {
        State state = new State(id,accept);
        states.add(state);
        if(accept) {
            acceptingStates.add(state);
        }
    }
    public void addState(int id) {
        State state = new State(id);
        states.add(state);
    }
    public void setInitialState(int id) {
        State state = getState(id);
        if(!(states.contains(state))) {
            return;
        }
        initialState = state;
    }





    public State getState(int id) {
        for(State s: states) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }


}
