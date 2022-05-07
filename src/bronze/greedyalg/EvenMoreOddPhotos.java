package bronze.greedyalg;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
http://www.usaco.org/index.php?page=viewproblem2&cpid=1084
Solved
-counted number of evens and odds
-Since I want maximun number of groups I want to priortize one number groups
-So for every even there is one even until only even or odd is left
-Whatever excess may be it, it always starts looking for an even
-if excess even then just add one more to group and print out groups
-if odd then for every even there is two odd and for every odd there is one odd
-if no more odd left, end program
-if one odd left and on the even spot then you have to subtract a group
-if one odd left and on the odd spot you can add one more to group
 */
public class EvenMoreOddPhotos {

    public static void main(String[] args) throws Exception {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int evens = 0;
        int odds = 0;
        for (int i = 0; i < n; i++) {
            int cowId = r.nextInt();
            if (cowId % 2 == 0) {
                evens++;
            } else odds++;
        }
        int groups = 0;
        int temp = Integer.min(evens, odds);
        evens -= temp;
        odds -= temp;
        boolean finished = false;
        if(evens == 0 && odds == 0) {
            finished = true;
        }
        groups = temp*2;
        while (!finished) {
            if(evens > 0) {
                finished = true;
                groups++;
            }else if(odds == 1){
                if(groups%2 == 0) {
                    groups--;
                    finished = true;
                }else{
                    groups++;
                    finished = true;
                }
            }else if(odds > 1){
                if(groups%2 == 0) {
                    odds -= 2;
                    groups++;
                }else {
                    odds -= 1;git stat
                    groups++;
                }
            }else if(odds == 0) {
                finished = true;
            }
        }
        System.out.println(groups);
        r.close();
    }




}
