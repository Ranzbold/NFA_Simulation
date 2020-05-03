package me.cedric.nfa;

public class Transition {

    private State from;
    private State to;
    private String symbol;
    public Transition(State from, String symbol, State to) {
        this.from = from;
        this.to = to;
        this.symbol = symbol;
    }



    public State getFrom() {
        return from;
    }

    public State getTo() {
        return to;
    }

    public String getSymbol() {
        return symbol;
    }





}
