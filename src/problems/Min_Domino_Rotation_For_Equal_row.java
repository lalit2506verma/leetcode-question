package problems;

public class Min_Domino_Rotation_For_Equal_row {
    public static void main(String[] args) {
        int[] tops = {2,1,2,4,2,2};
        int[] bottoms = {5,2,6,2,3,2};

        System.out.println(minDominoRotations(tops, bottoms));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        // as value starts from 1 to 6
        for (int i = 1; i <= 6; i++) {
            boolean valid = true;

            int topSwaps = 0;
            int bottomSwaps = 0;

            for (int j = 0; j < tops.length; j++) {
                if(tops[j] != i && bottoms[j] != i){
                    valid = false;
                    break;
                }

                if(tops[j] != i)  topSwaps++;
                if(bottoms[j] != i) bottomSwaps++;
            }

            if(valid){
                res = Math.min(res, Math.min(topSwaps, bottomSwaps));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
