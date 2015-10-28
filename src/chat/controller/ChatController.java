package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatDisplay;

/**
 * 
 * @author rbak9218
 * @version 1.3 10/23/15 Added chat() method
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
				
			textFromUser = display.getUserInput(textFromUser);
		
		}
		
	}
}
