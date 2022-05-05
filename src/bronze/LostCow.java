package bronze;

import java.io.*;
import java.util.*;

public class LostCow{

    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("lostcow.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("lostcow.out"));
        final int X = r.nextInt();
        final int Y = r.nextInt();
        int inc = 1;
        int pos = X;
        int dist = 0;
        boolean odd = true;
        int currPos = X;
        do {
            if(odd) {
                pos = X + inc;
                odd = false;
            }else {
                pos = X - inc;
                odd = true;
            }
            dist += Math.abs(currPos-pos);
            currPos = pos;
            inc *= 2;
        } while (!(check(X, Y, pos)));
        dist -= Math.abs(pos - Y);
        pw.println(dist);
        r.close();
        pw.close();

    }

    public static boolean check(int x, int y, int pos) {
        if(x > y) {
            if (pos <= y) {
                return true;
            }
        }else {
            if (pos >= y) {
                return true;
            }
        }
        return false;
    }

}
