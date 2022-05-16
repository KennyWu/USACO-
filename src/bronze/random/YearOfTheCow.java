//package bronze.random;

import java.io.*;
import java.util.*;

public class YearOfTheCow{
    /*
    http://www.usaco.org/index.php?page=viewproblem2&cpid=1107
    Solved but in rather ugly manner imo
    Used graph theory
    Each edge is directed to a node
    The edge is weighted by the number of years younger or older cow a is to cow b
    Deep search, starting at Bessie, adding number of years until we find Elsie
    Print absolute value of result
     */
    static final int OX = 1;
    static HashMap<String, HashMap<String, String>> cowNode = new HashMap<>();
    public static void main(String[] args){
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        r.nextLine();
        HashMap<String, Integer> zodiacs = new HashMap<>();
        zodiacs.put("Bessie", OX);
        for(int i = 0; i < n; i++) {
            boolean above = false;
            String a = r.nextLine();
            String[] s = a.split(" ");
            String firstCow = s[0];
            String secondCow = s[7];
            int firstCowIndex = getCowIndex(s[4]);
            int secondCowIndex = zodiacs.get(secondCow);
            zodiacs.put(firstCow, firstCowIndex);
            if(s[3].equals("next")) above = true;
            int years = 0;
            if(above){
                if(firstCowIndex > secondCowIndex) years = firstCowIndex-secondCowIndex;
                if(firstCowIndex == secondCowIndex) years = 12;
                if(firstCowIndex < secondCowIndex) years = (firstCowIndex) + (12-secondCowIndex);
            }else {
                if(firstCowIndex > secondCowIndex) years = -1*((12-firstCowIndex) + secondCowIndex);
                if(firstCowIndex == secondCowIndex) years = -12;
                if(firstCowIndex < secondCowIndex) years = -1*(secondCowIndex-firstCowIndex);
            }
            String difference = "" + years;
            if(!cowNode.containsKey(secondCow))
                cowNode.put(secondCow, new HashMap<>());
            cowNode.get(secondCow).put(firstCow, difference);
        }
        System.out.println(Math.abs(findElsie("Bessie", 0)));
    }

    public static int findElsie(String cow, int years) {
        if(cow.equals("Elsie")) {
            return years;
        }
        if(!cowNode.containsKey(cow)) {
            return 0;
        }
        HashMap<String, String> a = cowNode.get(cow);
        for(String s: a.keySet()) {
            int temp = Integer.parseInt(a.get(s));
            temp = findElsie(s, temp + years);
            if(temp != 0) {
                return temp;
            }
        }
        return 0;
    }


    public static int getCowIndex(String s) {
        switch(s) {
            case "Ox":
                return 1;
            case "Tiger":
                return 2;
            case "Rabbit":
                return 3;
            case "Dragon":
                return 4;
            case "Snake":
                return 5;
            case "Horse":
                return 6;
            case "Goat":
                return 7;
            case "Monkey":
                return 8;
            case "Rooster":
                return 9;
            case "Dog":
                return 10;
            case "Pig":
                return 11;
            case "Rat":
                return 12;

        }
        return -1;
    }
}
