package me.cedric.nfa;

import java.io.*;
import java.util.*;

public class ReadUtils {
    public static List<String> readWords(String path) {
        List<String> output = new ArrayList<>();

        try {
            File input = new File(path);
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextLine()) {
                output.add(scanner.nextLine());
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

}
