package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word_Square {
    public static void main(String[] args) {

    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            String top = words[i];
            for(int j = 0; j < 4; j++){
                if(j == i) continue;
                String left = words[j];
                for(int k = 0; k < 4; k++){
                    if(k == i || k == j) continue;
                    String right = words[k];
                    for(int l = 0; l < 4; l++){
                        if(l == i || l == j || l == k) continue;
                        String bottom = words[l];

                        if (top.charAt(0) == left.charAt(0) &&
                                top.charAt(3) == right.charAt(0) &&
                                bottom.charAt(0) == left.charAt(3) &&
                                bottom.charAt(3) == right.charAt(3)) {
                            List<String> square = Arrays.asList(top, left, right, bottom);
                            result.add(square);
                        }
                    }
                }
            }
        }

        result.sort((a, b) -> {
            for (int idx = 0; idx < 4; idx++) {
                int cmp = a.get(idx).compareTo(b.get(idx));
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return result;
    }
}
