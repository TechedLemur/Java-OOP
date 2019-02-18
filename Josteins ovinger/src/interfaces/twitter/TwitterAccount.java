package interfaces.twitter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwitterAccount {
	
	private String username;
	
	private int retweetCount;
	

	
	private List<Tweet> tweets = new ArrayList<>();
	
	private List<TwitterAccount> followers = new ArrayList<>();
	
	private List<TwitterAccount> following = new ArrayList<>();
	
	
	
	public TwitterAccount(String username) {
		this.username = username;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void addFollower(TwitterAccount account)	{
		followers.add(account);
	}
	public void removeFollower(TwitterAccount account) {
		followers.remove(account);
	}
	public void follow(TwitterAccount account) {
		this.following.add(account);
		account.addFollower(this);

	}
	
	public void unfollow(TwitterAccount account) {
		this.following.remove(account);
		account.removeFollower(this);
	}
	
	public boolean isFollowing(TwitterAccount account) {
		if (following.contains(account))
			return true;
		return false;
	}
	public boolean isFollowedBy(TwitterAccount account) {
		if (followers.contains(account))
			return true;
		return false;
	}
	
	public void tweet(String text) {
		tweets.add(new Tweet(this, text));
		
	}
	public void addRt() {
		this.retweetCount++;
	}
	
	public void retweet(Tweet tweet) {
		
		if (tweet.getOriginalTweet() != null) {

			tweets.add(new Tweet(this, tweet.getOriginalTweet()));
			tweet.getOriginalTweet().getOwner().addRt();
		}
		else {
			tweets.add(new Tweet(this, tweet));
			tweet.getOwner().addRt();
		}
			
	}
	public int getFollowerCount() {
		return followers.size();
	}
	public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comp){
		if (comp == null)
			return this.followers;
		if (followers.isEmpty())
			return null;
		List<TwitterAccount> sorted = this.followers;
		sorted.sort(comp);
		return sorted;
	}
	public Tweet getTweet(int i) {
		return tweets.get(tweets.size()-i);
	}
	
	public int getRetweetCount() {
		return this.retweetCount;
	}
	public int getTweetCount() {
		return tweets.size();
	}
	public static void main(String[] args) {
		TwitterAccount a1 = new TwitterAccount("Jostein");
		TwitterAccount a2 = new TwitterAccount("Jørgen");
		TwitterAccount a3 = new TwitterAccount("Thomas");
		a1.tweet("Hei");
		System.out.println(a1.getTweetCount());
		a2.retweet(a1.getTweet(1));
		System.out.println(a1.getTweet(1));
		System.out.println(a1.getRetweetCount());
		System.out.println(a2.getTweetCount());
		System.out.println(a2.getTweet(1));
		a3.retweet(a2.getTweet(1));
		System.out.println(a3.getTweet(1));
	}

}
