package problems;

public class Compare_Version_Numbers {
    public static void main(String[] args) {

    }

    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;

        while(i < arr1.length && i < arr2.length){
            int a = Integer.parseInt(arr1[i]);
            int b = Integer.parseInt(arr2[i]);
            if(a > b){
                return 1;
            }
            else if(a < b){
                return -1;
            }

            i++;
        }

        // if all the reversions are same till here and still any array length left
        if(i < arr1.length){
            return 1;
        }

        if(i < arr2.length){
            return -1;
        }

        return 0;
    }
}
