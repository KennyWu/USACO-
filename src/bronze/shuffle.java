package bronze;

import java.io.*;
import java.util.*;

public class shuffle{

    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("bronze/in/shuffle.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));

        int cows = r.nextInt();
        int[] pos = new int[cows];
        int[] cowID = new int[cows];
        int[] temp = new int[cows];
        for(int i = 0; i < cows; i++) {
            pos[i] = r.nextInt();
        }
        for(int i = 0; i < cows; i++) {
            cowID[i] = r.nextInt();
        }
        int i = 0;
        while (i < 3) {
            for(int j = 0; j < cows; j++) {
                int index = pos[j]-1;
                temp[j] = cowID[index];
            }
            cowID = Arrays.copyOf(temp, cows);
            i++;
        }
        for(int id : cowID) {
            pw.println(id);
        }
        r.close();
        pw.close();
    }

}
