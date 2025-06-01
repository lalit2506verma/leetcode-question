package problems.ImplementationClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/design-twitter/
public class Twitter {

    private HashMap<Integer, ArrayList<Integer>> map;
    private HashMap<Integer, PriorityQueue<Integer>> feed;

    public Twitter() {
        this.map = new HashMap<>();
        this.feed = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        
    }

//    public List<Integer> getNewsFeed(int userId) {
//
//    }

    public void follow(int followerId, int followeeId) {
        if(map.containsKey(followeeId)){
            ArrayList<Integer> followerList = map.get(followeeId);
            followerList.add(followerId);
            map.replace(followeeId, followerList);
        }
        else{
            map.put(followeeId, new ArrayList<>(List.of(followerId)));
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if(map.containsKey(followeeId)){
            ArrayList<Integer> followerList = map.get(followeeId);

            for (int i = 0; i < followerList.size(); i++) {
                if(followerList.get(i) == followerId){
                    followerList.remove(i);
                }
            }

            if(followerList.isEmpty()){
                map.remove(followeeId);
            }
        }

    }

    public void displayFollowerList(){
        for (Map.Entry<Integer, ArrayList<Integer>> m : map.entrySet()){
            System.out.println(m.getKey() + " -> " + m.getValue());
        }
    }
}
