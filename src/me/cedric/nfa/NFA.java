package me.cedric.nfa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NFA {
    public Set<State> getStates() {
        return states;
    }

    public Set<Transition> getTransitions() {
        return transitions;
    }

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
    public void addTransition(Transition tr) {
        transitions.add(tr);
    }

    public Set<State> simulate(int q, char[] word) {
        State stateQ = getState(q);
        Set<State> possibleStates = new HashSet<State>();
        Set<State> possibleNext = new HashSet<State>();
        possibleStates.add(stateQ);
        int counter = 1;
        for(char symbol: word) {
            if(counter % 10000 == 0) {
                System.out.println("Der Zähler ist bei Symbol Nummer: " + counter);
            }
            possibleNext = calculateNextStates(possibleStates, Character.toString(symbol));
            possibleStates = possibleNext;
            counter++;
        }
        return possibleStates;
    }
    public Set<State> calculateNextStates(Set<State> currentStates, String delta) {
        Set<State> nextStates = new HashSet<State>();
        for(State current : currentStates) {
            for(Transition tr: transitions) {
                if ((tr.getFrom().equals(current)) && (tr.getSymbol().equals(delta))) {
                    nextStates.add(tr.getTo());
                }
            }
        }
        return nextStates;

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
    public void readTransitions(String path) {
        try {
            File input = new File(path);
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String tr = scanner.nextLine();
                String[] properties = tr.split(" ");
                State from = getState(Integer.parseInt(properties[0]));
                State to = getState(Integer.parseInt(properties[2]));
                Transition transition = new Transition(from,properties[1],to);
                transitions.add(transition);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
