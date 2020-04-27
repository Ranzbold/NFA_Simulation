package me.cedric.nfa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyNFA {
    public static void main(String[] args) {
        List<String> words = new ArrayList<String>();
        words = ReadUtils.readWords("D:/Download/2020_H09_input");


        NFA M = new NFA();
        for (int i=1;i<=34;i++) {
            M.addState(i);
        }
        M.readTransitions("D:/Download/2020_H09.trans");



        List<char[]> input = new ArrayList<char[]>();
        for(String w: words) {
            input.add(w.toCharArray());
        }
        System.out.println("Wortlänge: " + words.get(0).length() + " Wörter");
        //Set<State> start = new HashSet<State>();
        Set<State> reachable = new HashSet<State>();
        //start.add(M.getState(7));
        //reachable = M.calulateNextStates(start, "b");
        reachable = M.simulate(7,input.get(0));
        for(State s: reachable) {
            System.out.println(s.getId());
        }


    }
}
