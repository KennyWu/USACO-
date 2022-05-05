//package bronze.search;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;

public class tracing{
    /*
    UNSOLVED - Brute force through every possible patient zero -
    simulate a possible patient zero and a k value all the way to T
    Farmer John is worried for the health of his cows (conveniently numbered 1…N as always)
     after an outbreak of the highly contagious bovine disease COWVID-19.
    Recently, Farmer John tested all of his cows and found some of them to be positive
    for the disease. Using video footage from inside his barn, he is able to review recent
    interactions between pairs of cows --- it turns out that when cows greet each-other,
    they shake hooves, a gesture that can unfortunately spread the infection from one cow
    to another. Farmer John assembles a time-stamped list of interacting pairs of cows,
    with entries of the form (t,x,y), meaning that at time t, cow x shook hooves with cow y.
    Farmer John also knows the following:

    (i) Exactly one cow on his farm could have started out carrying the disease
    (we'll call this cow "patient zero").

    (ii) Once a cow is infected, she passes the infection along with her next K hoof shakes
    (possibly including the same partner cow several times). After shaking hooves K times,
     she no longer passes the infection along with subsequent hoof shakes
     (since at this point she realizes she is spreading the infection and washes her hooves carefully).

    (iii) Once a cow is infected, she stays infected.

    Unfortunately, Farmer John doesn't know which of his N cows is patient zero, nor does he know the value of K! Please help him narrow down the possibilities for these unknowns based on his data. It is guaranteed that at least one possibility is valid.

    INPUT FORMAT (file tracing.in):
    The first line of the input file contains N (2≤N≤100) and T (1≤T≤250).
     The next line contains a string of length N whose entries are 0s and 1s,
      describing the current state of Farmer John's N cows --- 0 represents a healthy cow
       and 1 represents a cow presently with the disease.
       Each of the next T lines describes a record in Farmer John's list of interactions
        and consists of three integers t, x, and y, where t is a positive integer time of the interaction (t≤250)
         and x and y are distinct integers in the range 1…N,
          indicating which cows shook hands at time t.
           At most one interaction happens at each point in time.
    OUTPUT FORMAT (file tracing.out):
    Print a single line with three integers x, y, and z,
     where x is the number of possible cows who could have been patient zero,
      y is the smallest possible value of K consistent with the data,
       and z is the largest possible value of K consistent with the data
       (if there is no upper bound on K that can be deduced from the data, print "Infinity" for z).
        Note that it might be possible to have K=0.

     */
    static int[][] record = new int[250][2];
    static int cows;
    static int time;
    static String state;


    public static void main(String[] args) throws Exception{
//        Scanner r = new Scanner(new File("/Users/kennywu/documents/USACO/src/bronze/in/tracing.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("/Users/kennywu/documents/USACO/src/bronze/output/tracing.out"));
        Scanner r = new Scanner(new File("tracing.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("tracing.out"));
        cows = r.nextInt();
        time = r.nextInt();
        state = r.next();
        for(int i = 0; i < time; i++){
            int t = r.nextInt() - 1;
            record[t][0] = r.nextInt();
            record[t][1] = r.nextInt();
        }
        int minK = Integer.MAX_VALUE;
        int maxK = -1;
        int possibleX = 0;
        for(int i = 0; i < cows; i++){
            boolean x = false;
            int littleK = Integer.MAX_VALUE;
            int bigK = -1;
            if(state.charAt(i) == '1'){
                for(int j = 0; j <= time; j++){
                    if(simulate(i, j)){
                        x = true;
                        littleK = Integer.min(littleK, j);
                        bigK = Integer.max(bigK, j);
                    }
                }
            }
            if(x) {
                minK = Integer.min(minK, littleK);
                maxK = Integer.max(maxK, bigK);
                possibleX++;
            }
        }
        if(maxK == time) {
            pw.println(possibleX + " " + minK + " Infinity");
        }else {
            pw.println(possibleX + " " + minK + " " + maxK);
        }
        r.close();
        pw.close();

    }

    public static boolean simulate(int patient, int k){
        boolean[] infected = new boolean[cows];
        int[] kSet = new int[cows];
        infected[patient] = true;
        for(int j = 0; j < 250; j++){
            if(record[j][0] == 0){
                continue;
            }else{
                int x = record[j][0] - 1;
                int y = record[j][1] - 1;
                if(infected[x] && !infected[y] && kSet[x] < k){
                    kSet[x] = kSet[x] + 1;
                    infected[y] = true;
                }
                if(!infected[x] && infected[y] && kSet[y] < k){
                    kSet[y] = kSet[y] + 1;
                    infected[x] = true;
                }
            }

        }
        for(int i = 0; i < cows; i++){
            if(infected[i] && state.charAt(i) == '1' ||
            !infected[i] && state.charAt(i) == '0'){
                continue;
            }else{
                return false;
            }
        }
        return true;

    }
}
