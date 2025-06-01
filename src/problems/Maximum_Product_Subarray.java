package problems;

public class Maximum_Product_Subarray {
    public static void main(String[] args) {
        int[] arr = {0, 2};
        System.out.println(maxProduct(arr));
    }

    public static int maxProduct(int[] nums){
        int maxProduct = Integer.MIN_VALUE;

        int i = 0;
        int j = i;
        int product = 1;
        while(i <= j && j < nums.length){
            if(nums[j] == 0){
                product = 1;
                i++;
                j++;
            }
            product *= nums[j];
            if(maxProduct < product){
                maxProduct = product;
            }
            else{
                product = 1;
                i++;
            }
            j++;
        }

        return maxProduct;
    }
}
