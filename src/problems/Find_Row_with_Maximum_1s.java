package problems;

public class Find_Row_with_Maximum_1s {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 1, 1}, {0, 0, 0}, {1, 1, 1}};
        System.out.println(rowWithMax1s(arr));
    }

    public static int rowWithMax1s(int[][] mat) {
        int idx = -1;
        int max = 0;

        for(int i = 0; i < mat.length; i++){
            int ones = -1;
            int firstIdx = findIdx(mat[i]);

            ones = mat[i].length - firstIdx;

            if(ones > max){
                max = ones;
                idx = i;
            }
        }

        return idx;
    }

    public static int findIdx(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(arr[mid] > 0){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
