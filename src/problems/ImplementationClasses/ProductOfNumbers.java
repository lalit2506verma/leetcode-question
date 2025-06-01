package problems.ImplementationClasses;

import java.util.ArrayList;

public class ProductOfNumbers {
    ArrayList<Integer> list;
    int ans;
    int n;

    public ProductOfNumbers() {
        list = new ArrayList<>();
        ans = 1;
        n = 0;
    }

    public void add(int num) {
        if(num == 0){
            list.clear();
            n = 0;
            return;
        }
        if(list.isEmpty()){
            list.add(num);
        }
        else{
            list.add(num * list.getLast());
        }
        n++;
    }

    public int getProduct(int k) {
        if(n == k){
            return list.getLast();
        }
        else if(k > n){
            return 0;
        }
        else{
            return list.getLast() / list.get(n-k-1);
        }

    }
}
