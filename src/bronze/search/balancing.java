package bronze.search;

import java.io.*;
import java.util.*;
/*
    - Finished 10/10 test cases
Farmer John's N cows are each standing at distinct locations (x1,y1)…(xn,yn)
on his two-dimensional farm (1≤N≤100, and the xi's and yi's are positive odd
integers of size at most B). FJ wants to partition his field by building a long
(effectively infinite-length) north-south fence with equation x=a (a will be
an even integer, thus ensuring that he does not build the fence through the
position of any cow). He also wants to build a long (effectively infinite-length)
east-west fence with equation y=b, where b is an even integer. These two fences cross at the
point (a,b), and together they partition his field into four regions.
FJ wants to choose a and b so that the cows appearing in the four resulting
regions are reasonably "balanced", with no region containing too many cows.
Letting M be the maximum number of cows appearing in one of the four regions,
FJ wants to make M as small as possible. Please help him determine this smallest
possible value for M.

For the first five test cases, B is guaranteed to be at most 100. In all test
cases, B is guaranteed to be at most 1,000,000.

INPUT FORMAT (file balancing.in):
The first line of the input contains two integers, N and B. The next n lines each contain the location of a single cow, specifying its x and y coordinates.
OUTPUT FORMAT (file balancing.out):
You should output the smallest possible value of M that FJ can achieve by positioning his fences optimally.

 */
public class balancing{
    static int[] ptX;
    static int[] ptY;
    static int cows;
    /*
        Strategy - Not to search every x and y - too long
        - Implement a sweep for every x-1, x+1, y-1, y+1 for every cow
        Changes only occur at those points
     */
    public static void main(String[] args) throws Exception{
//        Scanner r = new Scanner(new File("/Users/kennywu/documents/USACO/src/bronze/in/balancing.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("/Users/kennywu/documents/USACO/src/bronze/output/balancing.out"));
        Scanner r = new Scanner(new File("balancing.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("balancing.out"));
        cows = r.nextInt();
        int maxLoc = r.nextInt()-1;
        int maxMinCows = Integer.MAX_VALUE;
        ptX = new int[cows];
        ptY = new int[cows];
        for(int i = 0; i < cows; i++) {
            ptX[i] = r.nextInt();
            ptY[i] = r.nextInt();
        }
        for(int i = 0; i < cows; i++) {
            int x = ptX[i]-1;
            for(int j =0; j < cows; j++) {
                int y = ptY[j]-1;
                maxMinCows = Integer.min(sweep(x, y), maxMinCows);
                y = ptY[j]+1;
                maxMinCows = Integer.min(sweep(x, y), maxMinCows);
            }
            x = ptX[i]+1;
            for(int j =0; j < cows; j++) {
                int y = ptY[j]-1;
                maxMinCows = Integer.min(sweep(x, y), maxMinCows);
                y = ptY[j]+1;
                maxMinCows = Integer.min(sweep(x, y), maxMinCows);
            }
        }
        pw.println(maxMinCows);
        pw.close();
        r.close();
    }

    public static int sweep(int x, int y) {
        int max = -1;
        int numCows = 0;
        for(int i = 0; i < cows; i++) {
            if(ptX[i] < x && ptY[i] > y) {
                numCows++;
            }
        }
        max = Integer.max(max, numCows);
        numCows = 0;
        for(int i = 0; i < cows; i++) {
            if(ptX[i] < x && ptY[i] < y) {
                numCows++;
            }
        }
        max = Integer.max(max, numCows);
        numCows = 0;
        for(int i = 0; i < cows; i++) {
            if(ptX[i] > x && ptY[i] > y) {
                numCows++;
            }
        }
        max = Integer.max(max, numCows);
        numCows = 0;
        for(int i = 0; i < cows; i++) {
            if(ptX[i] > x && ptY[i] < y) {
                numCows++;
            }
        }
        max = Integer.max(max, numCows);
        return max;
    }

}
