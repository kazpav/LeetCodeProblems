package leetcode.medium.design_twitter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * This problem is solved and was approved by leetcode
 *
 * @author Pavel Kazarin
 * @see <a href="https://leetcode.com/problems/design-twitter/description/">Design Twitter</a>
 * @see leetcode.medium.design_twitter.Tweet
 */
class DesignTwitter {

    // Stores userID(follower) as key and userID(folowee) as value
    private ConcurrentMap<Integer, Set<Integer>> followingMap;

    // Stores userID as key and list of {@code Tweet} objects as value
    private ConcurrentMap<Integer, List<Tweet>> tweetMap;

    /**
     * Constructor that initializes data structure
     */
    DesignTwitter() {
        this.followingMap = new ConcurrentHashMap<>();
        this.tweetMap = new ConcurrentHashMap<>();
    }

    /**
     * This method composes a new tweet.
     *
     * @param userId  User's id
     * @param tweetId Tweet's id
     */
    void postTweet(int userId, int tweetId) {
        List<Tweet> userTweetsList = tweetMap.computeIfAbsent(userId, k -> new CopyOnWriteArrayList<>());
        userTweetsList.add(new Tweet(tweetId, System.nanoTime()));
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed is posted by user or who the user followed or by the user herself
     *
     * @param userId User's id
     * @return List of 10 most recent tweet
     */
    List<Integer> getNewsFeed(int userId) {

        // List to store all tweets related to this user
        List<Tweet> listOfTweets = new ArrayList<>();

        // Getting all tweets by current user
        List<Tweet> usersTweets = tweetMap.get(userId);

        // Adding all user's tweets to Treemap
        if (usersTweets != null) {
            listOfTweets.addAll(usersTweets);
        }
        // Getting user's folowees
        Set<Integer> usersFolowees = followingMap.get(userId);

        // Adding all folowee's tweets to TreeMap
        if (usersFolowees != null && usersFolowees.size() != 0) {
            for (int foloweeId : usersFolowees) {
                List<Tweet> tweets = tweetMap.get(foloweeId);
                if(tweets!=null){
                    listOfTweets.addAll(tweets);
                }
            }
        }

        // Sorting tweets by priority value
        // New implementation, that has worse runtime
        listOfTweets.sort(Comparator.comparingLong(Tweet::getTweetPriority).reversed());

        // Old implementation with better runtime
//        listOfTweets.sort((Tweet o1, Tweet o2) -> Long.compare(o2.getTweetPriority(), o1.getTweetPriority()));

        // Adding tweetsID to listToReturn
        List<Integer> listToReturn = new ArrayList<>();
        for (int i = 0; i < 10 && i < listOfTweets.size(); i++) {
            listToReturn.add(listOfTweets.get(i).getTweetId());
        }
        return listToReturn;
    }

    /**
     * This method makes follower following followee
     *
     * @param followerId Follower's id
     * @param followeeId Followee's id
     */
    void follow(int followerId, int followeeId) {
        Set<Integer> followeeSet = followingMap.computeIfAbsent(followerId, k -> new CopyOnWriteArraySet<>());
        if (followeeId == followerId)
            return;
        followeeSet.add(followeeId);
    }

    /**
     * This method makes follower unfollowing folowee
     *
     * @param followerId follower's id
     * @param followeeId folowee's id
     */
    void unfollow(int followerId, int followeeId) {
        Set<Integer> followeeSet = followingMap.get(followerId);
        if (followeeSet == null) {
            return;
        }
        followeeSet.remove(followeeId);
    }
}
