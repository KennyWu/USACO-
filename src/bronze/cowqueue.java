package bronze;

import java.io.*;
import java.util.*;

public class cowqueue{

    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("cowqueue.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cowqueue.out"));

        int cows = r.nextInt();
        TreeMap<Integer, Integer> line = new TreeMap<Integer, Integer>();
        for(int i = 0; i < cows; i++) {
            line.put(r.nextInt(), r.nextInt());
        }
        int addedTime = 0;
        for(int i = 0; i < cows; i++) {
            int time = (line.firstKey()) + line.get(line.firstKey()) +  addedTime;
            if(i == cows-1) {
                pw.println(time);
                break;
            }
            if(time > line.higherKey(line.firstKey())) {
                addedTime = time - line.higherKey(line.firstKey());
            }else {
                addedTime = 0;
            }
            line.remove(line.firstKey());
        }
        pw.close();
        r.close();
    }

}
