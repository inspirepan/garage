package algorithm.c3;

import java.util.*;

public class S355 {
    class Twitter {

        Map<Integer, Set<Integer>> followMap = new HashMap<>();
        Map<Integer, List<Tweet>> tweets = new HashMap<>();

        public Twitter() {

        }

        public void postTweet(int userId, int tweetId) {
            var list = tweets.getOrDefault(userId, new ArrayList<>());
            list.add(new Tweet(userId, tweetId));
            tweets.put(userId, list);
        }

        public List<Integer> getNewsFeed(int userId) {
            // 最近的10条
            Set<Integer> fset = followMap.getOrDefault(userId, new HashSet<>());
            fset.add(userId);

            PriorityQueue<Tweet> pq = new PriorityQueue<>();
            for (int user : fset) {
                if (tweets.containsKey(user)) {
                    for (Tweet t : tweets.get(user)) {
                        pq.offer(t);
                    }
                }
            }

            List<Integer> tweetList = new LinkedList<>();

            while (tweetList.size() < 10 && !pq.isEmpty()) {
                tweetList.add(pq.poll().tweetId);
            }
            return tweetList;
        }

        public void follow(int followerId, int followeeId) {
            Set<Integer> followingSet = followMap.getOrDefault(followerId, new HashSet<>());
            followingSet.add(followeeId);
            followMap.put(followerId, followingSet);
        }

        public void unfollow(int followerId, int followeeId) {
            Set<Integer> followingSet = followMap.getOrDefault(followerId, new HashSet<>());
            followingSet.remove(followeeId);
            followMap.put(followerId, followingSet);
        }
    }

    class Tweet implements Comparable<Tweet> {
        static int timeStamp = 0;
        int userId;
        int tweetId;
        int time;

        Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = timeStamp;
            Tweet.timeStamp++;
        }

        public int compareTo(Tweet o) {
            return -this.time + o.time;
        }

        public String toString() {
            return String.format("{uId %d tId %d time %d}", userId, tweetId, time);
        }
    }
}
