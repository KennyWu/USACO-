package bronze;

import java.io.*;
import java.util.*;

public class measurement{

    public static void main(String[] args)throws Exception{
        Scanner r = new Scanner(new File("bronze/in/measurement.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));
        int[] current = {7,7,7};
        boolean[] greatest = {true, true, true};
        int changes = 0;
        int record = r.nextInt();
        TreeMap<Integer, String> days = new TreeMap<>();
        for(int i = 0; i < record; i++) {
            days.put(r.nextInt(), r.next()+ " " + r.next());
        }
        for(int i = 0; i < record; i++) {
            String[] s = days.firstEntry().getValue().split(" ");
            String name = s[0];
            char operation = s[1].charAt(0);
            int value = Integer.parseInt(s[1].substring(1));
            switch(name) {
                case "Bessie":
                    if(operation == '+'){
                        current[0] += value;
                    }else if(operation == '-'){
                        current[0] -= value;
                    }
                    break;
                case "Elsie":
                    if(operation == '+'){
                        current[1] += value;
                    }else if(operation == '-'){
                        current[1] -= value;
                    }
                    break;
                case "Mildred":
                    if(operation == '+'){
                        current[2] += value;
                    }else if(operation == '-'){
                        current[2] -= value;
                    }
                    break;
            }
            if(changeDisplay(greatest, current)) {
                changes += 1;
            }
            greatest = checkGreatest(current);
            days.remove(days.firstKey());
        }
        pw.println(changes);
        pw.close();
        r.close();
    }

    public static boolean changeDisplay(boolean[]greatest, int[]curr) {
        boolean[] currentGreatest = checkGreatest(curr);
        for(int i = 0; i < curr.length; i++) {
            if(!currentGreatest[i] && greatest[i] || currentGreatest[i] && !greatest[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean[] checkGreatest(int[] produce) {
        boolean[] greatest = {true, true, true};
        for(int i = 0; i < produce.length; i++) {
            switch(i) {
                case 0:
                    greatest[i] = produce[i] < produce[i+1] || produce[i] < produce[i+2]? false:true;
                    break;
                case 1:
                    greatest[i] = produce[i] < produce[i-1] || produce[i] < produce[i+1]? false:true;
                    break;
                case 2:
                    greatest[i] = produce[i] < produce[i-1] || produce[i] < produce[i-2]? false:true;
                    break;
            }
        }
        return greatest;
    }

}
