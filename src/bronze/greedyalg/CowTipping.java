//package bronze.greedyalg;

import java.awt.*;
import java.util.*;
import java.io.*;
/*
http://www.usaco.org/index.php?page=viewproblem2&cpid=689#
- Solved
-Greedy solution
-Check x and y from bottom right
-move scan left for any tipped cows
-If none move up and scan left again
-If scan find tipped cows, flip with rectangle created from upper left and x and y coordinates
 */
public class CowTipping{
    static boolean[][] cowTipped;
    static int startY;
    static int startX;
    static int moves;
    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("cowtip.in"));
        PrintWriter pw = new PrintWriter((new FileWriter("cowtip.out")));
//        Scanner r = new Scanner(new File("/Users/kennywu/Documents/GitHub/USACO/src/bronze/in/cowtip.in"));
//        PrintWriter pw = new PrintWriter((new FileWriter("/Users/kennywu/Documents/GitHub/USACO/src/bronze/output/cowtip.out")));
        int n = r.nextInt();
        moves = 0;
        startX = n-1;
        startY = n-1;
        cowTipped = new boolean[n][n];
        for(int i = 0; i < n; i++){
            char[] a = r.next().toCharArray();
            for(int j = 0; j < n; j++){
                if(a[j] == '1'){
                    cowTipped[i][j] = true;
                }
            }
        }
        boolean finished = false;
        while(!finished) {
            finished = scan();
        }
        pw.println(moves);
        r.close();
        pw.close();
    }

    public static boolean scan() {
        yBreak:
        for(int j = startY; j >= 0; j--) {
            boolean encounterTip = false;
            for(int i = startX; i >= 0; i--){
                if(cowTipped[j][i]) {
                    encounterTip = true;
                    flip(i ,j);
                    moves++;
                    return false;
                }
            }
            if(!encounterTip) startY = j-1;
        }

        return true;
    }

    public static void flip(int xBound, int yBound) {
        for(int i = 0; i <= yBound; i++) {
            for(int j = 0; j <= xBound; j++) {
                cowTipped[i][j] = !cowTipped[i][j];
            }
        }
    }

}
