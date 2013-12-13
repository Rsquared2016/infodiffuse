public class Tweet {
	private Integer retweets;
	private String text;
	private Integer hashTags;
	private Integer followers;
	private Integer followee;
	private Integer favourites;
	private Integer urls;
	private Integer mentions;
	private Integer isViral = 0;
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsViral() {
		return isViral;
	}

	public void setIsViral(Integer isViral) {
		this.isViral = isViral;
	}

	public Integer getMentions() {
		return mentions;
	}

	public void setMentions(Integer mentions) {
		this.mentions = mentions;
	}

	public Integer getRetweets() {
		return retweets;
	}

	public void setRetweets(Integer retweets) {
		this.retweets = retweets;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getHashTags() {
		return hashTags;
	}

	public void setHashTags(Integer hashTags) {
		this.hashTags = hashTags;
	}

	public Integer getFollowers() {
		return followers;
	}

	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	public Integer getFollowee() {
		return followee;
	}

	public void setFollowee(Integer followee) {
		this.followee = followee;
	}

	public Integer getFavourites() {
		return favourites;
	}

	public void setFavourites(Integer favourites) {
		this.favourites = favourites;
	}

	public Integer getUrls() {
		return urls;
	}

	public void setUrls(Integer urls) {
		this.urls = urls;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return hashTags.toString() + "," + urls.toString() + ","
				+ mentions.toString() + "," + followers + "," + followee + ","
				+ favourites + "," + status + "," + retweets + "," + isViral;
	}

}
