package bronze.simulation;

import java.io.*;
import java.util.*;

public class MixingMilk{



    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mixmilk.out"));

        final int[] BUCKETS = new int[3];
        int[] amnt = new int[3];
        for(int i = 0; i < 3; i++) {
            BUCKETS[i] = r.nextInt();
            amnt[i] = r.nextInt();
        }

        int i = 0;
        int j = 0;
        while(i < 100){

            if(j == 2) {
               int available = BUCKETS[0] - amnt[0];
               int pour = pourAmount(available, amnt[j]);
               amnt[0] += pour;
               amnt[j] -= pour;
               j = 0;
            }else {
                int available = BUCKETS[j+1] - amnt[j+1];
                int pour = pourAmount(available, amnt[j]);
                amnt[j+1] += pour;
                amnt[j] -= pour;
                j++;
            }
            i++;
        }
        for(int milk : amnt) {
            pw.println(milk);
        }
        r.close();
        pw.close();
    }

    public static int pourAmount(int avail, int actualA) {

        if(avail >= actualA) {
            return actualA;
        }else {
            return avail;
        }

    }

}
