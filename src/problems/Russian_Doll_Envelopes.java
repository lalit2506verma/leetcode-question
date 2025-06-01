package problems;

import java.util.Arrays;

public class Russian_Doll_Envelopes {
    public static void main(String[] args) {
        int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};

        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] == b[0]){
                return Integer.compare(b[1], a[1]);
            }
            else{
                return Integer.compare(a[0], b[0]);
            }
        });

        for(int i = 0; i < envelopes.length; i++){
            System.out.println(Arrays.toString(envelopes[i]));
        }

        int i = 0;
        int j = 1;
        int count = 0;

        while(j < envelopes.length){
            if(envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]){
                count++;
                i = j;
            }
            j++;
        }

        return count+1;

    }
}
