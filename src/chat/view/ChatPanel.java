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
	private JButton readTextButton;
	private JLabel promptLabel;

	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		inputTextField = new JTextField("Type stuff here");
		textViewArea = new JTextArea("Text appears here");
		readTextButton = new JButton("Talk to chatbot");
		promptLabel = new JLabel("Talk to me");

		setupLayout();
		setupPanel();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.RED);
		this.add(textViewArea);
		this.add(inputTextField);
		this.add(readTextButton);
		this.add(promptLabel);
		inputTextField.setToolTipText("Type here for chatbot");
		textViewArea.setEnabled(false);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.EAST, promptLabel, -190, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, readTextButton, -28, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, readTextButton, -40, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, textViewArea, 64, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textViewArea, -165, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -158, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, inputTextField, 30, SpringLayout.SOUTH, promptLabel);
		baseLayout.putConstraint(SpringLayout.WEST, inputTextField, 0, SpringLayout.WEST, textViewArea);
		baseLayout.putConstraint(SpringLayout.EAST, inputTextField, 0, SpringLayout.EAST, textViewArea);
	}

	private void setupListeners()
	{
		readTextButton.addActionListener(new ActionListener()
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
	}

	public ChatController getBaseController()
	{
		return baseController;
	}

	public JButton getReadTextButton()
	{
		return readTextButton;
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
		this.readTextButton = readTextButton;
	}

}
