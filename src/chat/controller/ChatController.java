package chat.controller;

import chat.model.Chatbot;
import chat.view.*;

/**
 * 
 * @author Rory Baker
 * @version 1.7 12/4/15 Final polishing
 */
public class ChatController
{
	private Chatbot roryBot;
	private ChatDisplay display;
	private ChatFrame baseFrame;
	private ChatPanel basePanel;

	/*
	 * 
	 */
	public ChatController()
	{
		display = new ChatDisplay();
		String user = display.getUserInput("What is your name?");
		roryBot = new Chatbot(user);
		baseFrame = new ChatFrame(this);
	}

	public void start()
	{
		display.displayText("Hello " + roryBot.getUserName());
		// chat();
	}

	/*
	 * 
	 */
	private void chat()
	{
		String conversation = display.getUserInput("What would you like to talk about today?");
		while (roryBot.lengthChecker(conversation))
		{
			conversation = roryBot.processQuestion(conversation);
			conversation = display.getUserInput(conversation);
		}

	}

	/*
	 * 
	 */
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";

		if (roryBot.quitChecker(conversation))
		{
			shutDown();
		}
		botResponse = roryBot.processQuestion(conversation);

		return botResponse;
	}

	/*
	 * 
	 */
	private void shutDown()
	{
		display.displayText("Goodbye, " + roryBot.getUserName() + " it has been my pleasure to talk with you");
		System.exit(0);
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
