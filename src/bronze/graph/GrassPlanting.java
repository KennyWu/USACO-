//package bronze.graph;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class GrassPlanting {
/*
http://www.usaco.org/index.php?page=viewproblem2&cpid=894
Was not able to solve without solution
Essentially the idea of being greedy can also be applied (This problem is basically an optimization problem)
The pattern goes as follows: Min number of different grass = the node with the greatest number of paths connected + 1;
Next time: draw out solutions, spot the algorithm type better, look for patterns - they often appear (just hard to spot)
 */
    static Stack<Integer>[] path;
    static boolean[] traversed;
    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("planting.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("planting.out"));
        int fields = r.nextInt();
        path = new Stack[fields];
        traversed = new boolean[fields];
        for(int i = 0; i < fields; i++) {
            path[i] = new Stack<>();
        }
        int uniqueGrass = -1;
        for(int i = 0; i < fields-1; i++) {
            int a, b;
            a = r.nextInt()-1;
            b = r.nextInt()-1;
            path[a].add(b);
            path[b].add(a);
            uniqueGrass = Integer.max(path[a].size(), uniqueGrass);
            uniqueGrass = Integer.max(path[b].size(), uniqueGrass);
        }
        pw.println(uniqueGrass+1);
        pw.close();
        r.close();
   }
}
