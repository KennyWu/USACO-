package bronze;

import java.io.*;
import java.util.*;

public class ConcertTickets{

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());
        }
        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }
        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
        }
    }
    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static TreeMap<Integer, Integer> tickets = new TreeMap<>();

    public static void main(String[] args){
        int custmrs, ticks;
        ticks = r.nextInt();
        custmrs = r.nextInt();
        for (int i = 0; i < ticks; i++) {
            int price = r.nextInt();
            if(tickets.containsKey(price)) {
                tickets.put(price, tickets.get(price) + 1);
            }else {
                tickets.put(price, 1);
            }

        }
        for(int i = 0; i < custmrs; i++) {
            if(tickets.size() == 0) {
                pw.println("-1");
            }
            int mxPrice = r.nextInt();
            if(tickets.containsKey(mxPrice)) {
                pw.println(mxPrice);
                remove(mxPrice);
                continue;
            }
            try {
                int lowest = tickets.lowerKey(mxPrice);
                if (mxPrice >= lowest){
                    pw.println(lowest);
                    remove(lowest);
                }else {
                    pw.println("-1");
                }

            } catch(Exception e){
                pw.println("-1");
            }
        }
        pw.close();
    }

    static void remove(int value) {
        if(tickets.get(value) > 1) {
            tickets.put(value, tickets.get(value)-1);
        }else {
            tickets.remove(value);
        }
    }

}
