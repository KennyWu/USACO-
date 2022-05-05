package bronze;

import java.io.*;
import java.util.*;

public class Apartments{

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

    public static void main(String[] args){
        int n = r.nextInt();
        int m = r.nextInt();
        int k = r.nextInt();
        int buyers = 0;
        int[] desiredSizes = new int[n];
        for(int i = 0; i < n; i++) {
            desiredSizes[i] = r.nextInt();
        }
        Stack<Integer> aptSizes = new Stack<>();
        for(int i = 0; i < m; i++) {
            aptSizes.add(r.nextInt());
        }
        while(aptSizes.size() != 0) {
            for(int i = 0; i < n; i++){
                if(aptSizes.size() == 0) {
                    break;
                }
                if(desiredSizes[i]== 0){
                    continue;
                }
                int size = desiredSizes[i];
                if(aptSizes.peek() > size-k && aptSizes.peek() < size+k) {
                    buyers++;
                    desiredSizes[i] = 0;
                    aptSizes.pop();
                    break;
                }
                if(i+1 == n)
                    aptSizes.pop();
            }

        }
        pw.println(buyers);
        pw.close();


    }
}
