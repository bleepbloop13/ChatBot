package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part of the project.
 * 
 * @author Rory Baker
 * @version 1.4 11/3/15 Completed the politicalTopicChecker method.
 */
public class Chatbot
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * 
	 * @param userName
	 *            The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.userName = userName;
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.content = "Super Smash Bros Melee";
		buildMemesList();
		buildPoliticalTopicsList();
	}

	private void buildMemesList()
	{
		this.memesList.add("Cute Animals");
		this.memesList.add("Doge");
		this.memesList.add("Just walk up and down smash?");
		this.memesList.add("Wombo Combo");
		this.memesList.add("Just Do It");
		this.memesList.add("200% Mad");
		this.memesList.add("one does not simply");
		this.memesList.add("Spiderman memes");
		this.memesList.add("It was me, Dio!");
		this.memesList.add("MLG Game Covers");
	}

	private void buildPoliticalTopicsList()
	{
		this.politicalTopicList.add("Donald Trump");
		this.politicalTopicList.add("Bernie Sanders");
		this.politicalTopicList.add("Hillary Clinton");
		this.politicalTopicList.add("Joe Biden");
		this.politicalTopicList.add("election");
		this.politicalTopicList.add("democrat");
		this.politicalTopicList.add("republican");
		this.politicalTopicList.add("liberal");
		this.politicalTopicList.add("conservative");
		this.politicalTopicList.add("Ben Carson");
		this.politicalTopicList.add("Marco Rubio");
		this.politicalTopicList.add("Carly Fiorina");
		this.politicalTopicList.add("vote");
		this.politicalTopicList.add("11/8/2016");
	}

	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null, otherwise returns true.
	 * 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;

		if (currentInput != null)
		{
			if (currentInput.length() > 0)
			{
				hasLength = true;
			}
		}

		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}

		return hasLength;
	}

	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;

		if (currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent = true;
		}
		return hasContent;
	}

	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns true if it does find a match and false if it does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean hasPolitics = false;

		for (String politics : politicalTopicList)
		{
			if (currentInput.toLowerCase().contains(politics.toLowerCase()))
			{
				hasPolitics = true;
			}
		}

		return hasPolitics;
	}

	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMeme = false;

		for (String meme : memesList)
		{
			if (currentInput.toLowerCase().contains(meme.toLowerCase()))
			{
				hasMeme = true;
			}
		}

		return hasMeme;
	}

	public String processQuestion(String currentInput)
	{
		String answer;
		answer = "oh, what else uld you like to talk about?";
		int newTopic = (int) (Math.random() * 5); // Generates a number between 0 and 4

		switch (newTopic)
		{
		case 0:
			if (contentChecker(currentInput))
			{
				answer = "That's my favorite topic! What else do you like?";
			}
			break;
		case 1:
			if (memeChecker(currentInput))
			{
				answer = "That meme is the dankest of all! Wowzaz! Where do you get your clothes?";
			}
			break;
		case 2:
			if (politicalTopicChecker(currentInput))
			{
				answer = "You seem very interested in politics. Do you like ice cream?";
			}
			break;
		case 3:
			if (currentInput.length() > 24)
			{
				answer = "You are quite fluent in speech! How often do you shower?";
			}
			break;
		case 4:
			// Random topic
			answer = "Wow. Where do you live? Just wondering, teehee ;)";
			break;
		default:
			// Should never happen
			answer = "I'M GONNA EAT YOUR SOUL!!!!1!!!";
			break;
		}

		return answer;
	}

	/**
	 * Returns the username of this Chatbot instance.
	 * 
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * Returns the content area for this Chatbot instance.
	 * 
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Getter method for the memesList object.
	 * 
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * Getter method for the politicalTopicList object.
	 * 
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * Updates the content area for this Chatbot instance.
	 * 
	 * @param content
	 *            The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
