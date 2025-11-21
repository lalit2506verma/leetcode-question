package problems;

import java.util.Arrays;

public class Maximum_the_Minimum_Powered_City {
    public static void main(String[] args) {

    }

    // we have to check for each station pawer after at-most k additional power>= target
    public boolean isValid(long[] powers, int r, int k, long target){
        int n = powers.length;
        long[] diff = new long[n+1];
        long currAdd = 0, rem = k;

        for(int i = 0; i < n; i++){
            currAdd += diff[i];
            long total = powers[i] + currAdd;
            if(total < target){
                long need = target - total;
                if(need > rem) return false;

                currAdd += need;
                rem -= k;

                int pos = Math.min(n-1, i+r);
                int end = pos * r + 1;

                if( end <= n){
                    diff[end] -= need;
                }
            }
        }

        return true;

    }

    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] prefixSum = new long[n];

        prefixSum[0] = stations[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i-1] + stations[i];
        }

        long[] powers = new long[n];

        for(int i = 0; i < n; i++){
            int start = Math.max(0, i - r);
            int end = Math.min(n-1, i+r);

            powers[i] = prefixSum[end] - (start > 0 ? prefixSum[start - 1] : 0L);
        }

        // binary Search on answer
        long low = 0;
        long high = prefixSum[n-1] + k;
        long ans = 0L;
        while(low <= high){
            long mid = low + (high - low) / 2;
            if(isValid(powers, r, k, mid)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}
