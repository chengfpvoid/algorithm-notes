package org.cheng.lc355;

import java.util.*;

/**
 * 355. 设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 */
public class Twitter {
    /**
     * 推文顺序
     */
    private  int order;
    /**
     * 用户和关注者集合的映射关系
     */
    private Map<Integer, HashSet<Integer>> userFollowerMap;
    /**
     * 用户和其推文链表的映射关系
     */
    private Map<Integer,Tweet>  userTweetsMap;


    /** Initialize your data structure here. */
    public Twitter() {
        order = 0;
        userFollowerMap = new HashMap<>();
        userTweetsMap = new HashMap<>();

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        // 时间顺序 + 1 ，头插法 插入用户关联的tweet链表中
        order++;
        Tweet newTweet = new Tweet(tweetId,order);
        if (userTweetsMap.containsKey(userId)) {
            Tweet tweets = userTweetsMap.get(userId);
            newTweet.next = tweets;
        }
        userTweetsMap.put(userId,newTweet);

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        // 把用户和他关注的用户的链表都取出来，弄个大顶堆 维护 top 10
        // k个链表 求最大的10个序号
        // 建大顶堆
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>((o1,o2) -> {
            return o2.order - o1.order;
        } );
        Tweet userTweets = userTweetsMap.get(userId);
        if (userTweets != null) {
            // 用户的推文入队
            priorityQueue.offer(userTweets);
        }
        HashSet<Integer> followeeIds = userFollowerMap.get(userId);
        if (followeeIds != null) {
            for (Integer followeeId : followeeIds) {
                Tweet tweets = userTweetsMap.get(followeeId);
                if (tweets != null) {
                    priorityQueue.offer(tweets);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int k = 0;
        // 出队，出队元素取出表头的值，然后再将剩下的链表重新入队
        while ( !priorityQueue.isEmpty() && k < 10) {
            Tweet tweets = priorityQueue.poll();
            ans.add(tweets.tweetId);
            if (tweets.next != null) {
                priorityQueue.offer(tweets.next);
            }
            k++;
        }
        return ans;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            // 自己不能关注自己
            return;
        }
        HashSet<Integer> followeeIds = userFollowerMap.get(followerId);
        if (followeeIds == null) {
            followeeIds = new HashSet<>();
            followeeIds.add(followeeId);
            userFollowerMap.put(followerId,followeeIds);
        } else {
            // 已经在关注列表里面了 就不需要维护了
            if (!followeeIds.contains(followeeId)) {
                followeeIds.add(followeeId);
            }
        }

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followeeIds = userFollowerMap.get(followerId);
        if (followeeIds == null) {
            return;
        }
        if(followeeIds.contains(followeeId)) {
            followeeIds.remove(followeeId);
        }

    }

    /**
     * 推特内容节点
     * 链表形式
     */
    private static class Tweet {
        /**
         * 推特文章id
          */
        private int tweetId;
        /**
         * 推特的发布全局顺序
         */
        private int order;
        /**
         * 下一个节点
         */
        private Tweet next;

        public Tweet(int tweetId, int order) {
            this.tweetId = tweetId;
            this.order = order;
        }
    }
}
