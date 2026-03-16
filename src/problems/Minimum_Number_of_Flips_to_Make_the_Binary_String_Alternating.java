package problems;

public class Minimum_Number_of_Flips_to_Make_the_Binary_String_Alternating {
    public static void main(String[] args) {
        System.out.println(minFlips("11100"));
    }

    public static int minFlips(String s) {
        int n = s.length();
        s = s + s;

        StringBuilder p1 = new StringBuilder();
        StringBuilder p2 = new StringBuilder();

        for(int i = 0; i < 2*n; i++){
            p1.append(i % 2 == 0 ? '0':'1');
            p2.append(i % 2 == 0 ? '1':'0');
        }

        int f1 = 0;
        int f2 = 0;
        int minFlips = Integer.MAX_VALUE;

        int i = 0, j = 0;
        while(j < 2*n){
            if(s.charAt(j) != p1.charAt(j)){
                f1++;
            }

            if(s.charAt(j) != p2.charAt(j)){
                f2++;
            }

            if(j-i+1 > n){
                // Shrink the window if exceeds the len of the s
                if(s.charAt(i) != p1.charAt(i)){
                    f1--;
                }
                if(s.charAt(i) != p2.charAt(i)){
                    f2--;
                }
                i++;
            }

            if(j-i+1 == n){
                minFlips = Math.min(minFlips, Math.min(f1, f2));
            }
            j++;
        }

        return minFlips;
    }
}
