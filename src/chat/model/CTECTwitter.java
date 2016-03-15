package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import twitter4j.*;
import chat.controller.ChatController;

/**
 * 
 * @author Rory Baker
 * @version v1.0 Added ArrayLists and sendTweet method.
 */
public class CTECTwitter
{
	private List<Status> statusList;
	private List<String> wordsList;
	private Twitter chatbotTwitter;
	private ChatController baseController;

	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
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

	private String[] importWordsToArray()
	{
		String[] boringWords;
		int wordCount = 0;
		try
		{
			Scanner wordFile = new Scanner(new File("commonWords.txt"));
			while (wordFile.hasNext())
			{
				wordCount++;
				wordFile.next();
			}
			wordFile.reset();
			boringWords = new String[wordCount];
			int boringWordCount = 0;
			while (wordFile.hasNext())
			{
				boringWords[boringWordCount] = wordFile.next();
				boringWordCount++;
			}
			wordFile.close();
		}
		catch (FileNotFoundException e)
		{
			baseController.handleErrors(e.getMessage());
			return new String[0];
		}
		return boringWords;
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
		for (int spot = 0; spot < wordsList.size(); spot++)
		{
			if (wordsList.get(spot).equals(""))
			{
				wordsList.remove(spot);
				spot--;
			}
		}
	}

	private String removePunctuation(String currentString)
	{
		String punctuation = ".,'?!:;\"(){}^[]<>-";
		String scrubbedString = "";
		for (int i = 0; i < currentString.length(); i++)
		{
			if (punctuation.indexOf(currentString.charAt(i)) == -1)
			{
				scrubbedString += currentString.charAt(i);
			}
		}
		return scrubbedString;
	}

	@SuppressWarnings("unchecked")
	private List<String> removeCommonEnglishWords(List<String> wordList)
	{
		String[] boringWords = importWordsToArray();
		for (int count = 0; count < wordList.size(); count++)
		{
			for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
			{
				if (wordList.get(count).equalsIgnoreCase(boringWords[removeSpot]))
				{
					wordList.remove(count);
					count--;
					removeSpot = boringWords.length;
				}
			}
		}
		return wordList;
	}
}
