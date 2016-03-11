package chat.view;

import javax.swing.*;
import chat.controller.ChatController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextField inputTextField;
	private JTextArea textViewArea;
	private JButton chatButton;
	private JButton saveButton;
	private JButton tweetButton;
	private JButton openButton;
	private JButton checkTwitterButton;
	private JLabel promptLabel;
	private JScrollPane textPane;

	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		inputTextField = new JTextField("Type stuff here");
		textViewArea = new JTextArea("Text appears here");
		chatButton = new JButton("Talk to chatbot");
		saveButton = new JButton("Save your progress");
		tweetButton = new JButton("Send this as a tweet");
		openButton = new JButton("Open a saved chat");
		promptLabel = new JLabel("Talk to me");
		checkTwitterButton = new JButton("Find this on twitter");

		setupChatPane();
		setupLayout();
		setupPanel();
		setupListeners();
	}

	private void setupChatPane()
	{
		textViewArea.setLineWrap(true);
		textViewArea.setWrapStyleWord(true);
		textViewArea.setEnabled(false);
		textViewArea.setEditable(false);
		textViewArea.setBackground(Color.DARK_GRAY);
		textPane = new JScrollPane(textViewArea);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.RED);
		this.add(textPane);
		this.add(inputTextField);
		this.add(chatButton);
		this.add(saveButton);
		this.add(openButton);
		this.add(tweetButton);
		this.add(checkTwitterButton);
		this.add(promptLabel);
		inputTextField.setToolTipText("Type here for chatbot");
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, inputTextField, 317, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 59, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, -65, SpringLayout.WEST, inputTextField);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -6, SpringLayout.NORTH, promptLabel);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, 169, SpringLayout.WEST, inputTextField);
		baseLayout.putConstraint(SpringLayout.NORTH, checkTwitterButton, 6, SpringLayout.SOUTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.EAST, checkTwitterButton, 0, SpringLayout.EAST, tweetButton);
		baseLayout.putConstraint(SpringLayout.WEST, promptLabel, 338, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -44, SpringLayout.NORTH, inputTextField);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -6, SpringLayout.WEST, openButton);
		baseLayout.putConstraint(SpringLayout.NORTH, openButton, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, openButton, -6, SpringLayout.WEST, saveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputTextField, -19, SpringLayout.NORTH, saveButton);
		baseLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, chatButton);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, -6, SpringLayout.WEST, chatButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -97, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -123, SpringLayout.EAST, this);

	}

	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

				// Grab user text
				String userText = inputTextField.getText();
				// send the text to the controller
				// give text to chatbot to process
				// get chatbots answer
				String response = baseController.fromUserToChatbot(userText);
				// display users text
				textViewArea.append("\nUser: " + userText);
				// display answer
				textViewArea.append("\nChatbot: " + response);
				// clear user field
				inputTextField.setText("");
			}
		});
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("I, Rory, just tweeted from my Java Chatbot program! #APCSRocks #Memelord @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
			}
		});
		checkTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String user = inputTextField.getText();
				String results = baseController.analyze(user);
				textViewArea.setText(results);
			}

		});

	}

	public ChatController getBaseController()
	{
		return baseController;
	}

	public JButton getReadTextButton()
	{
		return chatButton;
	}

	public SpringLayout getBaseLayout()
	{
		return baseLayout;
	}

	public void setBaseLayout(SpringLayout baseLayout)
	{
		this.baseLayout = baseLayout;
	}

	public JTextField getInputTextField()
	{
		return inputTextField;
	}

	public void setInputTextField(JTextField inputTextField)
	{
		this.inputTextField = inputTextField;
	}

	public JTextArea getTextViewArea()
	{
		return textViewArea;
	}

	public void setTextViewArea(JTextArea textViewArea)
	{
		this.textViewArea = textViewArea;
	}

	public JLabel getPromptLabel()
	{
		return promptLabel;
	}

	public void setPromptLabel(JLabel promptLabel)
	{
		this.promptLabel = promptLabel;
	}

	public void setBaseController(ChatController baseController)
	{
		this.baseController = baseController;
	}

	public void setReadTextButton(JButton readTextButton)
	{
		this.chatButton = readTextButton;
	}

}
