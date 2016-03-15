package chat.model;

import java.util.ArrayList;
import java.util.List;
import twitter4j.*;
import chat.controller.ChatController;

/**
 * 
 * @author Rory Baker
 * @version v1.0 Added ArrayLists and sendTweet method.
 */
public class CTECTwitter
{
	private ArrayList<Status> statusList;
	private ArrayList<String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		this.statusList = new ArrayList<Status>();
		this.wordsList = new ArrayList<String>();
		this.chatbotTwitter = TwitterFactory.getSingleton();
	}

	public boolean sendTweet(String tweet)
	{
		try
		{
			chatbotTwitter.updateStatus(tweet);
		}
		catch (TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		return true;
	}

	public void loadTweets(String twitterHandle) throws TwitterException
	{
		Paging statusPage = new Paging(1, 200);
		int page = 1;
		while (page <= 10)
		{
			statusPage.setPage(page);
			statusList.addAll(chatbotTwitter.getUserTimeline(twitterHandle, statusPage));
			page++;
		}
		for (Status currentStatus : statusList)
		{
			String[] tweetText = currentStatus.getText().split(" ");
			for (String word : tweetText)
			{
				wordsList.add(removePunctuation(word).toLowerCase());
			}
		}
		removeCommonEnglishWords(wordsList);
		removeEmptyText();
	}
	
	private void removeEmptyText()
	{
		
	}
	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";
		String scrubbedString = "";
		for (int i = 0; i < currentString.length();i++)
		{
			if(punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}
	private List removeCommonEnglishWords(List<String> wordList)
	{
		return null;
	}
}
