package bronze;

import java.io.*;
import java.util.*;

public class SwapitySwap{

    public static void main(String[] args) throws Exception{
//        Scanner r = new Scanner(new File("/Users/kennywu/documents/USACO/src/swap.in"));
        Scanner r = new Scanner(new File("bronze/in/swap.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("swap.out"));

        int size = r.nextInt();
        int swap = r.nextInt();
        int A1 = r.nextInt();
        int A2 = r.nextInt();
        int B1 = r.nextInt();
        int B2 = r.nextInt();
        int[] cows = new int[size];
        for(int i = 1; i <= size; i++) {
            cows[i-1] = i;
        }
        for(int i = 0; i < swap; i++) {
            double proLength = (double)(A2-A1)/2;
            int len = (int) Math.round(proLength);
            for(int j = 0; j < len; j++) {
                int temp = cows[A1- 1 + j];
                cows[A1- 1 + j] = cows[A2 -1 - j];
                cows[A2 -1 - j] = temp;
            }
            proLength = (double)(B2-B1)/2;
            len = (int) Math.round(proLength);
            for(int j = 0; j < len; j++){
                int temp = cows[B1- 1 + j];
                cows[B1 - 1 + j] = cows[B2 - 1 - j];
                cows[B2 -1 - j] = temp;
            }
        }
        for(int cow : cows)
            pw.println(cow);
        pw.close();
        r.close();
    }

}

