package chat.model;

import java.util.ArrayList;
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
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		return true;
	}
}
