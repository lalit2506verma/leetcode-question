package problems;

public class Minimum_recolor_to_get_K_blackBox {
    public static void main(String[] args) {
        String blocks = "WBWBBBW";
        System.out.println(minimumRecolors(blocks, 2));
    }

    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int ans = 0;

        for (int i = 0; i < k; i++) {
            if(blocks.charAt(i) == 'W'){
                ans++;
            }
        }

        int s = 0, e = k, flip = ans;

        while(e < n){
            if(blocks.charAt(e) == 'W'){
                flip++;
            }

            if(blocks.charAt(s) == 'W'){
                flip--;
            }

            ans = Math.min(ans, flip);

            s++;
            e++;
        }

        return ans;
    }
}
