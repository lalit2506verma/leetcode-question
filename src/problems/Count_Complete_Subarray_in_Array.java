package problems;

public class Count_Complete_Subarray_in_Array {
    public static void main(String[] args) {
        int[] arr = {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(arr));
    }

    public static int countCompleteSubarrays(int[] nums){
        int n = nums.length;
        int count = 0;
        int[] visited = new int[2001];
        int k = 0;

        for(int num : nums){
            if(visited[num] == 0){
                k++;
            }
            visited[num]++;
        }

        int i = 0, j = 0;
        visited = new int[2001];
        int kSub = 0;
        while(j < n){
            if (visited[nums[j]] == 0){
                kSub++;
            }
            visited[nums[j]]++;

            while(kSub >= k){
                count += (n-j);
                visited[nums[i]]--;
                if(visited[nums[i]] == 0){
                    kSub--;
                }
                i++;
            }

            j++;
        }

        return count;
    }
}