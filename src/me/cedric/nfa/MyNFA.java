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

        Set<State> reachable = new HashSet<State>();
        List<Set<State>> outputs = new ArrayList<Set<State>>();
        long[] times = new long[4];
        for(int i=0 ;i<=3;i++) {
            System.out.println("Wortlänge: " + input.get(i).length + " Wörter");
            long starttime = System.currentTimeMillis();
            reachable = M.simulate(7,input.get(i));
            for(State s: reachable) {
                System.out.println(s.getId());
            }
            long endtime = System.currentTimeMillis();
            long timeElapsed = endtime - starttime;
            System.out.println("Vergangene Zeit um das Wort zu simulieren: " + timeElapsed / 1000+ " Sekunden");
            times[i] = timeElapsed;
            outputs.add(reachable);
        }
        System.out.println("Übersicht");
        System.out.println("----------------------------------------------------------------------------------------");
        for(int i=0;i<=3;i++) {
            System.out.println("Vergangene Zeit um das Wort " + (i+1) +" zu simulieren: " + times[i]/1000 + " Sekunden");
        }
        System.out.println("----------------------------------------------------------------------------------------");
        for(int i=0;i<=3;i++) {
            Set<Integer> outputstate = new HashSet<Integer>();
            Set<State> states = outputs.get(i);
            for (State s: states) {
                outputstate.add(s.getId());
            }
            System.out.println("Ergebnismenge für das Wort " + (i+1) +" ist: ");
            System.out.println(outputstate.toString());
        }




        }
}
