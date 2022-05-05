package bronze.simulation;

import java.io.*;
import java.util.*;

public class PromotionCounting{



    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("promote.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("promote.out"));

        int[] diff = {(-r.nextInt())+r.nextInt(), (-r.nextInt())+r.nextInt(),
        (-r.nextInt())+r.nextInt(), (-r.nextInt())+r.nextInt()};

        int[] change = new int[3];
        change[2] = diff[3];
        for(int i = 1; i >= 0; i--) {
            change[i] = diff[i+1] + change[i+1];
        }
        for(int i : change) {
            pw.println(i);
        }
        r.close();
        pw.close();

    }

}
