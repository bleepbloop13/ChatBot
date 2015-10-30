package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatDisplay;

/**
 * 
 * @author rbak9218
 * @version 1.4 10/30/15 Modified chat() method to add use of contentChecker and memeChecker
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
			if(roryBot.contentChecker(textFromUser))
			{
				display.displayText("Wow, I had no idea you loved " + roryBot.getContent());
			}
			if(roryBot.memeChecker(textFromUser))
			{
				display.displayText("Oh boy, " + roryBot.getUserName() + ", that sure is a dank meme.");
			}
			textFromUser = display.getUserInput("wow, " + textFromUser);
		
		}
		
	}
}
