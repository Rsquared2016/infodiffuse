import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Utility {
	static List<Tweet> tweets = new ArrayList<>();

	public static void read(String file) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				new File(file)));
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			try {
				Tweet tweet = new Tweet();
				String[] contents = line.split(":");
				tweet.setFollowers(Integer
						.parseInt(contents[contents.length - 8].trim()));
				tweet.setFollowee(Integer
						.parseInt(contents[contents.length - 7].trim()));
				tweet.setFavourites(Integer
						.parseInt(contents[contents.length - 2].trim()));
				tweet.setStatus(Integer.parseInt(contents[contents.length - 3]
						.trim()));
				tweet.setRetweets(Integer
						.parseInt(contents[contents.length - 1].trim()));
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < contents.length - 8; i++) {
					buffer.append(contents[i]);
				}

				String[] text = buffer.toString().split(" ");
				int num_of_hashtags = 0;
				int num_of_urls = 0;
				int num_of_mentions = 0;
				for (String string : text) {
					if (string.contains("@")) {
						num_of_mentions++;
					}
					if (string.contains("#")) {
						num_of_hashtags++;
					}
					if (string.contains("http")) {
						num_of_urls++;
					}
				}
				tweet.setHashTags(num_of_hashtags);
				tweet.setMentions(num_of_mentions);
				tweet.setText(buffer.toString());
				tweet.setUrls(num_of_urls);

				tweets.add(tweet);
			}

			catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public static void dump(String file) throws IOException {
		Writer writer = null;
		File yourFile = new File(file);
		if (!yourFile.exists()) {
			yourFile.createNewFile();

		}
		writer = new BufferedWriter(new FileWriter(yourFile));
		for (Tweet tweet : tweets) {
			writer.append(tweet.toString());
			writer.append(System.lineSeparator());
		}

	}

	public static void main(String[] args) throws IOException {
		read(args[0]);
		dump(args[1]);

	}

}
