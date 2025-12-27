package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Meeting_Room_III {
    public static void main(String[] args) {
        int[][] meetings = {{16,962},{85,695},{6,706},{53,716},{21,82},{58,634},{51,617},{87,442},{15,84},{19,265},{72,1064},{90,731},{57,689},{30,317},{69,955},{54,227},{56,357},{11,369},{99,800},{9,114},{36,314},{96,435},{41,839},{28,664},{34,364},{95,518},{77,971},{75,781},{32,335},{2,664},{66,1005},{83,989},{37,452},{88,189},{42,700},{97,197},{76,931},{84,203},{60,776},{45,930},{93,740},{61,111},{55,906},{43,343},{29,184},{92,140},{25,474},{18,462},{86,449},{44,315},{94,216},{3,440},{26,289},{47,177},{78,659},{91,1026},{65,968},{50,1042},{12,256},{49,180},{10,72},{73,1033},{17,745},{4,341},{71,968},{31,933},{40,834},{5,475},{80,928},{8,124},{22,767},{81,421},{24,164},{20,948},{89,282},{27,274},{7,473},{59,541},{13,717},{82,386},{46,403},{1,483},{38,720},{23,387},{62,830},{70,315},{48,449},{79,424},{68,949},{52,977},{14,832},{39,479},{64,1002},{63,277},{33,690},{35,434},{74,262},{98,466},{67,450}}
                ;
        System.out.println(mostBooked(2, meetings));
    }

    public static int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];

        // sorting
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++) freeRooms.offer(i);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );

        for(int[] meeting: meetings){
            long start = meeting[0];

            long end = meeting[1];
            long duration = end - start;

            while(!pq.isEmpty() && pq.peek()[0] <= start){
                freeRooms.offer((int) pq.poll()[1] );
            }

            if(!freeRooms.isEmpty()){
                // freeRoom available
                int room = freeRooms.poll();
                pq.offer(new long[]{end, room});
                meetingCount[room]++;
            }
            else{
                // All rooms are occupied
                long[] top = pq.poll();
                pq.offer(new long[]{top[0] + duration, top[1]});
                meetingCount[(int) top[1]]++;
            }
        }

        int maxMeetingCount = Integer.MIN_VALUE;
        int room = -1;

        for(int i=0;i<n;i++){
            if(meetingCount[i]>maxMeetingCount){
                maxMeetingCount=meetingCount[i];
                room=i;
            }
        }

        return room;

    }
}
