package bronze.graph;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GrassPlanting {

    static ArrayList<Integer>[] path;
    static boolean[] traversed;
    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("planting.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("planting.out"));
        int fields = r.nextInt();
        path = new ArrayList[];
        traversed = new boolean[fields];
        for(int i = 0; i < fields; i++) {
            path[i] = new ArrayList<>();
        }
        for(int i = 0; i < fields-1; i++) {
            int a, b;
            a = r.nextInt()-1;
            b = r.nextInt()-1;
            path[a].add(b);
            path[b].add(a);
        }

    }
}
