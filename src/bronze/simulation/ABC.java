package bronze.simulation;

import java.io.*;
import java.util.*;

public class ABC{
    static TreeMap<Integer, Integer> a = new TreeMap<>();
    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);



        for(int i = 0; i < 7; i++) {
            int val = r.nextInt();
            add(val);
        }
        int greatest = remove(a.lastKey());
        remove(a.lastKey());
        remove(a.lastKey());
        int A = remove(a.firstKey());

        if(a.containsKey(a.firstKey() + A)) {
            remove(a.firstKey() + A);
        }else {
            remove(a.firstKey());
        }
        int B = remove(a.firstKey());
        int C = remove(a.firstKey());
        System.out.print(A + " " + B + " " + C);
        r.close();
        pw.close();

    }

    public static int remove(int val) {
        if(a.get(val) != 0) {
            a.put(val, a.get(val)-1);
            return val;
        }else {
            a.remove(val);
            return val;
        }

    }
    public static void add(int val) {
        if(a.containsKey(val)){
            a.put(val, a.get(val) + 1);
        }else{
            a.put(val, 0);
        }
    }


}
