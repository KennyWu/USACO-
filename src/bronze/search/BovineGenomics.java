//package bronze.search;

import java.io.*;
import java.util.*;

public class BovineGenomics{

    /*
     - Had to look at solution - only two tests cases were solved
      All others ran out of time
      FIX: oringally ran on complexity of about O(n^5)
      Now runs on O(n^4) - uses sets to check for duplicates through intersection

     */
    public static void main(String[] args)throws Exception {
        Scanner r = new Scanner(new File("cownomics.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cownomics.out"));
//        Scanner r = new Scanner(new File("/Users/kennywu/documents/USACO/src/bronze/in/cownomics.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("/Users/kennywu/documents/USACO/src/bronze/output/cownomics.out"));
        int cows = r.nextInt();
        int len = r.nextInt();
        char[][] genome = new char[cows*2][];
        for(int i = 0; i < cows*2; i++) {
            genome[i] = r.next().toCharArray();
        }
        int set = 0;
        for(int j = 0; j < len - 2; j++){
            for(int a = j + 1; a < len - 1; a++){
                for(int b = a + 1; b < len; b++){
                    HashSet<String> spotC = new HashSet<>();
                    HashSet<String> normC = new HashSet<>();
                    for(int i = 0; i < cows; i++) {
                        spotC.add("" + genome[i][j] + genome[i][a] + genome[i][b]);
                        normC.add("" + genome[i+cows][j] + genome[i+cows][a] + genome[i+cows][b]);
                    }
                    spotC.retainAll(normC);
                    if(spotC.size() == 0) set++;

                }
            }
        }
        pw.println(set);
        pw.close();
        r.close();

    }

}
