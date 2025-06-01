package problems;

public class Push_Dominoes {
    public static void main(String[] args) {
        String s = ".L.R...LR..L..";
        System.out.println(pushDominoes(s));
    }

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();

        int[] rightClosestL = new int[n];
        int[] leftClosestR = new int[n];
        
        // traversing from left to right seeking for right force
        for (int i = 0; i < n; i++) {
            if(dominoes.charAt(i) == 'R'){
                leftClosestR[i] = i;
            }
            else if(dominoes.charAt(i) == '.'){
                leftClosestR[i] = i > 0 ? leftClosestR[i-1] : -1;
            }
            else{
                leftClosestR[i] = -1;
            }
        }

        // traversing from right to left seeking left force
        for (int i = n-1; i >= 0; i--) {
            if(dominoes.charAt(i) == 'L'){
                rightClosestL[i] = i;
            }
            else if(dominoes.charAt(i) == '.'){
                rightClosestL[i] = i < n-1 ? rightClosestL[i+1] : -1;
            }
            else{
                rightClosestL[i] = -1;
            }
        }

        StringBuilder st = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int disLeftR = Math.abs(i - leftClosestR[i]);
            int disRightL = Math.abs(i - rightClosestL[i]);

            // distance is equal
            if(rightClosestL[i] == leftClosestR[i]){
                st.append('.');
            }
            else if(rightClosestL[i] == -1){
                st.append('R');
            }
            else if(leftClosestR[i] == -1){
                st.append('L');
            }
            else if(disLeftR == disRightL) {
                st.append('.');
            }
            else{
                char dir = disLeftR > disRightL ? 'L' : 'R';
                st.append(dir);
            }
        }
        return st.toString();
    }
}
