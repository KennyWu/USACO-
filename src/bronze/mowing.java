package bronze;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

public class mowing{

    static ArrayList<Integer> x = new ArrayList<>();
    static ArrayList<Integer> y = new ArrayList<>();
    static ArrayList<Integer> t = new ArrayList<>();
    static int minTime = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("bronze/in/mowing.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mowing.out"));
        int n = r.nextInt();
        Point2D currentPoint = new Point(0,0);
        int time = 1;
        for(int i = 0; i < n; i++) {
            char direct = r.next().charAt(0);
            int steps = r.nextInt();
            for(int a = 0; a < steps; a++) {
                switch(direct) {
                    case 'N':
                        currentPoint.setLocation(currentPoint.getX(), currentPoint.getY()+1);
                        update(currentPoint, time);
                        break;
                    case 'S':
                        currentPoint.setLocation(currentPoint.getX(), currentPoint.getY()-1);
                        update(currentPoint, time);
                        break;
                    case 'W':
                        currentPoint.setLocation(currentPoint.getX()+1, currentPoint.getY());
                        update(currentPoint, time);
                        break;
                    case 'E':
                        currentPoint.setLocation(currentPoint.getX()-1, currentPoint.getY());
                        update(currentPoint, time);
                        break;
                }
                time++;
            }
        }
        if(minTime == Integer.MAX_VALUE) {
            pw.println("-1");
        }else {
            pw.println(minTime);
        }
        pw.close();
        r.close();
    }

    private static void update(Point2D point, int time) {
        if(x.size() == 0) {
            x.add((int) point.getX());
            y.add((int) point.getY());
            t.add(time);
            return;
        }
        for(int j = 0; j < x.size(); j++) {
            if(x.get(j) == Integer.MAX_VALUE) {
                continue;
            }
            if(x.get(j) == point.getX() && y.get(j) == point.getY()) {
                minTime = Integer.min(minTime, time-t.get(j));
                x.set(j, Integer.MAX_VALUE);
                y.set(j, Integer.MAX_VALUE);
                t.set(j, Integer.MAX_VALUE);
            }
        }
        x.add((int) point.getX());
        y.add((int) point.getY());
        t.add(time);


    }


}
