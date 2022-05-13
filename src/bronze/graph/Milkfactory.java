//package bronze.graph;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
/*
www.usaco.org/index.php?page=viewproblem2&cpid=940
Solved
Solution: figure which node wasn't pointing to anything
HOWEVER - there is an exception, there can be more than one node that doesnt point to anything
If that is the case however, then it is impossible for a station i to exist
So find node with no pointers
If exceeds one then station doesnt exist
If there are no nodes without a pointer then station i doesnt exist
 */
public class Milkfactory {

    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("factory.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("factory.out"));

        int n = r.nextInt();
        Stack<Integer>[] graph = new Stack[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new Stack<>();
        }
        for(int i = 0; i < n-1; i++) {
            int a = r.nextInt()-1;
            int b = r.nextInt()-1;
            graph[a].add(b);
        }
        int station = -1;
        int numStations = 0;
        for(int i = 0; i < n; i ++) {
            if(graph[i].size() == 0) {
                station = i+1;
                numStations++;
            }
        }
        if(station != -1 && numStations == 1){
            pw.println(station);
        }else {
            pw.println("-1");
        }

        pw.close();
        r.close();
    }

}
