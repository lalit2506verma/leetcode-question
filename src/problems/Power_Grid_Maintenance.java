package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Power_Grid_Maintenance {
    static int[] parent;
    static TreeSet<Integer>[] online;
    public static void main(String[] args) {
        int[][] connection = {{1,2},{2,3},{3,4},{4,5}};
        int[][] queries = {{1,3},{2,1},{1,1},{2,2},{1,2}};

        System.out.println(Arrays.toString(processQueries(5, connection, queries)));
    }

    public static int find(int a){
        if(parent[a] == a){
            // found
            return a;
        }

        return find(parent[a]);
    }

    public static void union(int a, int b){
        int pa = find(a), pb = find(b);

        if(pa == pb) return; // parent is same
        if(online[pb].size() > online[pa].size()){
            parent[pa] = pb;
            online[pb].addAll(online[pa]);
        }
        else{
            parent[pb] = pa;
            online[pa].addAll(online[pb]);
        }
    }

    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c];
        online = new TreeSet[c];

        for(int i = 0; i < c; i++){
            parent[i] = i;
            online[i] = new TreeSet<>();
            online[i].add(i);
        }

        // iteration over connection
        for(int[] conn : connections){
            int u = conn[0] - 1, v = conn[1] - 1;
            union(u, v);
        }

        List<Integer> res = new ArrayList<>();
        boolean[] isOnline = new boolean[c];
        // All stations are online

        Arrays.fill(isOnline, true);
        for(int[] query: queries){
            int type = query[0];
            int x = query[1]-1;
            int root = find(x);

            // making the station offline
            if(type == 2){
                if(isOnline[x]){
                    online[root].remove(x);
                    isOnline[x] = false;
                }
            }
            // type = 1
            else{
                if(isOnline[x]){
                    res.add(x+1);
                }
                else if(online[x].isEmpty()){
                    res.add(-1);
                }
                else{
                    res.add(online[root].first()+1);
                }
            }
        }

        // convertinh arraylist into array
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }

        return ans;

    }
}
