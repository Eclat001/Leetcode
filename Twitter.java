package Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/* Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able
 * to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news 
 * feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most 
 * recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 * Example:
 * Twitter twitter = new Twitter();
// User 1 posts a new tweet (id = 5).
 * twitter.postTweet(1, 5);
// User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
// User 1 follows user 2.
 * twitter.follow(1, 2);
// User 2 posts a new tweet (id = 6).
 * twitter.postTweet(2, 6);
// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
// User 1 unfollows user 2.
 * twitter.unfollow(1, 2);
// User 1's news feed should return a list with 1 tweet id -> [5],
// since user 1 is no longer following user 2.
 * twitter.getNewsFeed(1);
 * */

public class Twitter {
	//1). 一个全局的推文计数器：postCount 用户发推文时，计数器+1
    //2). 推文Id -> 推文计数器的映射：IdMap 用来记录推文的次序
    //3). 推文Id -> 用户Id的映射：OwnerMap 用来记录推文的发送者是谁
    //4). 用户Id -> 关注对象集合的映射： followeeMap 用来记录用户的关注对象（关注/取消关注）
    
    private int postCount;
    private Map<Integer, Integer> countMap;
    private Map<Integer, List<Integer>> idMap;
    private Map<Integer, Integer> ownerMap;
    private Map<Integer, Set<Integer>> followeeMap;

    /** Initialize your data structure here. */
    public Twitter() {
        countMap = new HashMap<Integer, Integer>();
        idMap = new HashMap<Integer, List<Integer>>();
        ownerMap = new HashMap<Integer, Integer>();
        followeeMap = new HashMap<Integer, Set<Integer>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        countMap.put(tweetId, ++postCount);
        ownerMap.put(tweetId, userId);
        getTweetId(userId).add(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> followee = getFollowee(userId);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(postCount, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return countMap.get(b) - countMap.get(a);
            }
        });
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (Integer followeeId : followee) {
            List<Integer> tweetid = getTweetId(followeeId);
            int index = tweetid.size() - 1;
            if (index >= 0) {
                indexMap.put(followeeId, index - 1);
                pq.add(tweetid.get(index));
            }
        }
        while (res.size() < 10 && !pq.isEmpty()) {
            Integer topTweetId = pq.poll();
            res.add(topTweetId);
            Integer ownerId = ownerMap.get(topTweetId);
            int index = indexMap.get(ownerId);
            if (index >= 0) {
                List<Integer> tweetid = getTweetId(ownerId);
                indexMap.put(ownerId, index - 1);
                pq.add(tweetid.get(index));
            }
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        getFollowee(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            getFollowee(followerId).remove(followeeId);
        }
    }
    
    /** Get a non-empty followee set of an user. */
    public Set<Integer> getFollowee(int userId) {
        Set<Integer> followee = followeeMap.get(userId);
        if (followee == null) {
            followee = new HashSet<Integer>();
            followee.add(userId);
            followeeMap.put(userId, followee);
        }
        return followee;
    }
    
    /** Get a non-empty tweet id list of an user. */
    public List<Integer> getTweetId(int userId) {
        List<Integer> tweetid =  idMap.get(userId);
        if (tweetid == null) {
            tweetid = new ArrayList<Integer>();
            idMap.put(userId, tweetid);
        }
        return tweetid;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
