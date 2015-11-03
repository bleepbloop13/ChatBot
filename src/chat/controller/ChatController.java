package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatDisplay;

/**
 * 
 * @author Rory Baker
 * @version 1.5 11/3/15 Modified chat() method to add use of politicalTopicChecker().
 */
public class ChatController
{
	private Chatbot roryBot;
	private ChatDisplay display;

	public ChatController()
	{
		display = new ChatDisplay();
		String user = display.getUserInput("What is your name?");
		roryBot = new Chatbot(user);
	}

	public void start()
	{
		display.displayText("Hello " + roryBot.getUserName());
		chat();
	}

	private void chat()
	{
		String textFromUser = display.getUserInput("Talk to the chatbot");

		while (roryBot.lengthChecker(textFromUser))
		{
			if (roryBot.contentChecker(textFromUser))
			{
				display.displayText("Wow, I had no idea you loved " + roryBot.getContent());
			}

			else if (roryBot.memeChecker(textFromUser))
			{
				display.displayText("Oh boy, " + roryBot.getUserName() + ", these are my favorite memes: " + roryBot.getMemesList());
			}

			else if (roryBot.politicalTopicChecker(textFromUser))
			{
				display.displayText("You sure seem excited for the election " + roryBot.getUserName() + 
						". Me too!");
			}
			textFromUser = display.getUserInput("wow " + textFromUser);

		}

	}
}
