//package bronze.random;

import java.util.Scanner;
import java.util.TreeMap;

public class AcowdemiaOne {
    /*
    www.usaco.org/index.php?page=viewproblem2&cpid=1131
    partial solved (one case wrong)
    Mix of analyzing the problem and brute force
    Cannot entirely brute force due to data being up to N^5
    From what I saw: h cannot increase more than one
    We need to find h first so sorting the data is needed
    if l will only add to the h citations, if there is excess, ignore
    Recheck if h+1 is viable in this situation
     */
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int l = r.nextInt();
        TreeMap<Integer, Integer> papers = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int citation = r.nextInt();
            if(papers.containsKey(citation)) {
                papers.put(citation, papers.get(citation) + 1);
            }else {
                papers.put(citation, 1);
            }
        }
        int currPapers = 0;
        int citations = papers.lastKey();
        int numCitations = 0;
        for(int i = papers.size(); i > 0; i--) {
            currPapers += papers.get(citations);
            if(citations <= currPapers) {
                numCitations = papers.get(citations);
                currPapers -= papers.get(citations);
                break;
            }
            citations = papers.lowerKey(citations);
        }
        if(l <= numCitations) numCitations = l;
        currPapers += numCitations;
        if(citations+1 <= currPapers) {
            System.out.println(citations+1);
        }else{
            System.out.println(citations);
        }
    }

}
