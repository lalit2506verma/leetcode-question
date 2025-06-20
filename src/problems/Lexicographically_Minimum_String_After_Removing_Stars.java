package problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Lexicographically_Minimum_String_After_Removing_Stars {

    public static void main(String[] args) {
        String s ="aaba*";
        System.out.println(clearStars(s));
    }

    public static String clearStars(String s) {
        PriorityQueue<Pair> q = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.c == o2.c){
                    return o2.idx - o1.idx;
                }
                else{
                    return o1.c - o2.c;
                }
            }
        });

        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*'){
                // do something
                Pair p = q.poll();
                str.replace(p.idx, p.idx+1, "*");
            }
            else{
                // add it in priority queue
                q.add(new Pair(s.charAt(i), i));
            }
        }

        System.out.println(q);

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '*'){
                str.deleteCharAt(i);
                i--;
            }
        }

        return str.toString();

    }

    static class Pair{
        char c;
        int idx;

        public Pair() {
        }

        public Pair(char c, int idx) {
            this.c = c;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "c=" + c +
                    ", idx=" + idx +
                    '}';
        }
    }
}

