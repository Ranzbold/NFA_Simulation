package me.cedric.nfa;

public class Transition {


    public Transition(State from, String symbol, State to) {
        this.from = from;
        this.to = to;
        this.symbol = symbol;
    }

    State from;

    public State getFrom() {
        return from;
    }

    public State getTo() {
        return to;
    }

    public String getSymbol() {
        return symbol;
    }

    State to;
    String symbol;



}
