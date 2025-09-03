package problems;

public class Find_the_Number_of_Ways_to_Place_People_I {
    public static void main(String[] args) {
        int[][] points = {{6,2},{4,4},{2,6}};

        System.out.println(numberOfPairs(points));
    }

    public static int numberOfPairs(int[][] points) {
        int n = points.length;
        int res = 0;

        for(int i = 0; i < n; i++){
            // point A
            int x1 = points[i][0];
            int y1 = points[i][1];

            // point B
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }

                int x2 = points[j][0];
                int y2 = points[j][1];

                if( x1 <= x2 && y1 >= y2){
                    boolean flag = false;
                    for(int k = 0; k < n; k++){
                        if ( k == i || k == j)  continue;

                        int x3 = points[k][0];
                        int y3 = points[k][1];

                        if(x3 >= x1 && x3 <= x2 && y3 >= y2 && y3 <= y1){
                            flag = true;
                            break;
                        }
                    }

                    if(!flag){
                        res++;
                    }

                }
            }
        }

        return res;
    }
}
