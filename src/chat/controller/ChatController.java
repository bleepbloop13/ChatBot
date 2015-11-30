package chat.controller;

import chat.model.Chatbot;
import chat.view.*;

/**
 * 
 * @author Rory Baker
 * @version 1.6 11/5/15 Added use to processQuestion method
 */
public class ChatController
{
	private Chatbot roryBot;
	private ChatDisplay display;
	private ChatFrame baseFrame;
	private ChatPanel basePanel;

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

	public Chatbot getRoryBot()
	{
		return roryBot;
	}

	public void setRoryBot(Chatbot roryBot)
	{
		this.roryBot = roryBot;
	}

	public ChatDisplay getDisplay()
	{
		return display;
	}

	public void setDisplay(ChatDisplay display)
	{
		this.display = display;
	}

	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}

	public void setBaseFrame(ChatFrame baseFrame)
	{
		this.baseFrame = baseFrame;
	}

	public ChatPanel getBasePanel()
	{
		return basePanel;
	}

	public void setBasePanel(ChatPanel basePanel)
	{
		this.basePanel = basePanel;
	}
}
