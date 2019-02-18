package interfaces.twitter;

public class Tweet {
	
	private String text;
	private TwitterAccount owner;
	private Tweet original;
	private int retweetCount;
	
	public Tweet(TwitterAccount account, String text) {
		this.owner = account;
		this.text = text;
		
	}
	
	public Tweet(TwitterAccount account, Tweet tweet) {
		if (tweet.getOwner() == account)
			throw new IllegalArgumentException();
		this.text = tweet.getText();
		this.original = tweet;
		this.owner = account;
		tweet.addRT();
	}
	
	public int getRetweetCount() {
		return retweetCount;
	}
	
	public void addRT() {
		retweetCount++;
	}
	public String getText() {
		return text;
	}
	public TwitterAccount getOwner() {
		return this.owner;
	}
	
	public Tweet getOriginalTweet() {
		return original;
	}
	
	
	@Override
	public String toString() {
		return "Tweet [text=" + text + ", owner=" + owner.getUserName() + ", original=" + original + ", retweetCount=" + retweetCount
				+ "]";
	}

	public static void main(String[] args) {
		TwitterAccount a1 = new TwitterAccount("Jostein");
		TwitterAccount a2 = new TwitterAccount("Jørgen");
		Tweet t1 = new Tweet(a1, "Hello");
		Tweet t2 = new Tweet(a2, t1);
		System.out.println(t1);
		System.out.println(t2);

	}

}
