package bronze.graph;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LivestockLineup {

    public static void main(String[] args) throws Exception {
        Scanner r = new Scanner(new File("lineup.in"))
        PrintWriter pw = new PrintWriter(new FileWriter("lineup.out"));
        HashMap<String, ArrayList<String>> nodes = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            nodes.put(find(i), new ArrayList<>());
        }
        int n = r.nextInt();
        for (int i = 0; i < n; i++) {
            String[] s = r.next().split(" must be milked beside ");
            nodes.get(s[0]).add(s[1]);
        }

        
    }

    public static String find(int cow) {
        switch(cow) {
            case 0:
                return "Beatrice";
            case 1:
                return "Bessie";
            case 2:
                return "Buttercup";
            case 3:
                return "Belinda";
            case 4:
                return "Bella";
            case 5:
                return "Blue";
            case 6:
                return "Betsy";
            case 7:
                return "Sue";
        }
        return "";
    }
}
