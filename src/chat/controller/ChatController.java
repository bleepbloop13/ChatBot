package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatDisplay;

/**
 * 
 * @author Rory Baker
 * @version 1.6 11/5/15 Added use to processQuestion method
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
				display.displayText(roryBot.processQuestion(textFromUser));
			}

			else if (roryBot.memeChecker(textFromUser))
			{
				display.displayText("Oh boy, " + roryBot.getUserName() + ", these are my favorite memes: " + roryBot.getMemesList());
				display.displayText(roryBot.processQuestion(textFromUser));
			}

			else if (roryBot.politicalTopicChecker(textFromUser))
			{
				display.displayText("You sure seem excited for the election " + roryBot.getUserName() + ". Me too!");
				display.displayText(roryBot.processQuestion(textFromUser));
			}
			
			textFromUser = display.getUserInput("wow " + textFromUser);
			
		}

	}
}
