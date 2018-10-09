import java.util.*;

class Twitter {

    //stores userID(follower) as key and userID(folowee) as value
    HashMap<Integer, HashSet<Integer>> followingMap;

    //stores userID as key and hashmap of priorities(key) and tweetID(value) as value
    HashMap<Integer, HashMap<Integer, Integer>> tweetMap;

    int priorityCounter;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        followingMap = new HashMap<>();
        tweetMap = new HashMap<>();
        priorityCounter = 0;
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        HashMap<Integer, Integer> usersTweetsMap = tweetMap.get(userId);
        if (usersTweetsMap == null) {
            usersTweetsMap = new HashMap<>();
            tweetMap.put(userId, usersTweetsMap);
        }
        usersTweetsMap.put(priorityCounter, tweetId);
        priorityCounter++;
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {

        //tree to store and sort all tweets we will need
        TreeMap<Integer, Integer> tweetsToReturnTreeMap = new TreeMap();

        //list to return
        List<Integer> listToReturn = new ArrayList<>();

        //getting all tweets by current user
        HashMap<Integer, Integer> usersTweets = tweetMap.get(userId);

        //adding all user's tweets to Treemap
        if (usersTweets != null) {
            tweetsToReturnTreeMap.putAll(usersTweets);
        }
        //geting user's folowees
        HashSet<Integer> usersFolowees = followingMap.get(userId);

        //adding all folowee's tweets to TreeMap
       if (usersFolowees != null && usersFolowees.size()!=0) {
            for (int foloweeId : usersFolowees) {
                if (tweetMap.get(foloweeId) != null) {
                    tweetsToReturnTreeMap.putAll(tweetMap.get(foloweeId));
                }
            }
        }

        // for (int i = tweetsToReturnTreeMap.keySet().size() - 1; i >= 0; i--) {
        //     listToReturn.add(tweetsToReturnTreeMap.get(i));
        //     if (listToReturn.size() >= 10) {
        //         break;
        //     }
        // }
        NavigableSet<Integer> descKeys = tweetsToReturnTreeMap.descendingKeySet();

        int counter = 0;
        for(int i : descKeys){
            if(counter>=10){
                return listToReturn;
            }
            listToReturn.add(tweetsToReturnTreeMap.get(i));
            counter++;
        }


        return listToReturn;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        HashSet<Integer> followeeSet = followingMap.get(followerId);
        if (followeeSet == null) {
            followeeSet = new HashSet<>();
            followingMap.put(followerId, followeeSet);
        }
        followeeSet.add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> followeeSet = followingMap.get(followerId);
        if(followeeSet == null){
            return;
        }
        
        followeeSet.remove(followeeId);
    }
}
