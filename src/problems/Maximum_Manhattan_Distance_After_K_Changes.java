package problems;

import java.util.HashMap;

public class Maximum_Manhattan_Distance_After_K_Changes {
    public static void main(String[] args) {
        String s = "NWSE";
        System.out.println(maxDistance(s, 1));
    }

    public static int maxDistance(String s, int k) {
        // 0 -> N, 1-> S, 2-> E, 3-> W
        int[] directionFreq = new int[4];

        for(char c : s.toCharArray()){
            if(c == 'N') directionFreq[0]++;
            if(c == 'S') directionFreq[1]++;
            if(c == 'E') directionFreq[2]++;
            if(c == 'W') directionFreq[3]++;
        }

        char changeXDir = directionFreq[1] > directionFreq[0] ? 'N' : 'S';
        char changeYDir = directionFreq[3] > directionFreq[2] ? 'E' : 'W';

        int maxDis = 0;
        int x = 0, y = 0;

        StringBuilder st = new StringBuilder();
        int i = 0;
        while(i < s.length() && k > 0){
            if(s.charAt(i) == changeXDir){
                String oppositeDir = oppositeDirec(changeXDir);
                st.append(oppositeDir);
                k--;
            }
            else if(s.charAt(i) == changeYDir){
                String oppositeDir = oppositeDirec(changeYDir);
                st.append(oppositeDir);
                k--;
            }
            else{
                st.append(s.charAt(i));
            }
            i++;
        }

        if(i < s.length()){
            st.append(s.substring(i));
        }

        for (int j = 0; j < st.length(); j++) {
            if(st.charAt(j) == 'N') y++;
            if(st.charAt(j) == 'S') y--;
            if(st.charAt(j) == 'E') x++;
            if(st.charAt(j) == 'W') x--;

            // calculate the max distancw
            maxDis = Math.max(maxDis, Math.abs(x) + Math.abs(y));
        }

        return maxDis;
    }

    private static String oppositeDirec(char dir) {
        if(dir == 'N') return "S";
        if(dir == 'S') return "N";
        if(dir == 'W') return "E";
        if(dir == 'E') return "W";
        return "";
    }
}
