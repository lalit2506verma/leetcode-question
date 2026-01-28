package problems;

public class Time_Needed_to_Buy_Tickets {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        System.out.println(timeRequiredToBuy(arr, 2));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int removed = 0;
        int n = tickets.length;

        while(tickets[k] > 0){
            time += (n - removed);

            for(int i = 0; i < n; i++){
                tickets[i]--;

                if(tickets[i] == 0){
                    removed++;
                }
            }


        }

        return time;
    }
}
