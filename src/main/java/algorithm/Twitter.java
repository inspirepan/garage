package algorithm;

import java.util.*;


/**
 * 355
 */
public class Twitter {

    Map<Integer, Tweet> tweets = new HashMap<>();
    Map<Integer, Set<Integer>> followMap = new HashMap<>();
    PriorityQueue<Tweet> pq = new PriorityQueue<>((o1, o2) -> -o1.time + o2.time);
    int timestamp = 0;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        Tweet oldHead = tweets.getOrDefault(userId, null);
        // Tweet链表按顺序排列
        tweets.put(userId, new Tweet(userId, tweetId, timestamp, oldHead));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        pq.clear();
        if (tweets.containsKey(userId)) {
            pq.offer(tweets.get(userId));
        }
        Set<Integer> followSet = followMap.getOrDefault(userId, null);
        if (followSet != null) {
            for (int followee : followSet) {
                if (tweets.containsKey(followee)) {
                    pq.offer(tweets.get(followee));
                }
            }
        }
        List<Integer> feed = new ArrayList<>(10);
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet head = pq.poll();
            feed.add(head.tweetId);
            if (head.next != null) {
                pq.offer(head.next);
            }
            count++;
        }
        return feed;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        Set<Integer> r = followMap.getOrDefault(followerId, new HashSet<>());
        r.add(followeeId);
        followMap.put(followerId, r);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) {
            return;
        }
        Set<Integer> r = followMap.getOrDefault(followerId, new HashSet<>());
        r.remove(followeeId);
        followMap.put(followerId, r);
    }

    static class Tweet {
        int userId;
        int tweetId;
        int time;
        Tweet next;

        Tweet(int user, int tweet, int timestamp, Tweet nxt) {
            userId = user;
            tweetId = tweet;
            time = timestamp;
            next = nxt;
        }
    }
}