package bronze.search;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

public class Triangles{

    public static void main(String[] args) throws Exception{
        Scanner r = new Scanner(new File("bronze/in/triangles.in"));
//        Scanner r = new Scanner(new File("/Users/kennywu/documents/USACO/src/triangles.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("triangles.out"));
        int points = r.nextInt();
        Point2D[] p = new Point2D[points];
        for(int i = 0; i < points; i++) {
            p[i] = new Point(r.nextInt(), r.nextInt());
        }
        int area = 0;
        for(int i = 0; i < points-2; i++) {
            for(int j = 0; j < points; j++) {
                if((p[j].getY() - p[i].getY()) == 0) {
                    int dist = (int) Math.abs(p[j].getX() - p[i].getX());
                    for(int a = 0; a < points; a++) {
                        if(a == j || a == i) {
                            continue;
                        }
                        if(p[i].getX() == p[a].getX() || p[j].getX() == p[a].getX()) {
                            int h = (int) Math.abs(p[i].getY() - p[a].getY());
                            area = Integer.max(area, h*dist);
                        }
                    }
                }
            }
        }
        pw.println(area);
        pw.close();
        r.close();


    }

}
