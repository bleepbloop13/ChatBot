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
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLabel, -30, SpringLayout.NORTH, inputTextField);
		baseLayout.putConstraint(SpringLayout.EAST, promptLabel, -190, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, inputTextField, -43, SpringLayout.NORTH, readTextButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, readTextButton, -28, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, readTextButton, -40, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, inputTextField, 0, SpringLayout.EAST, textViewArea);
		baseLayout.putConstraint(SpringLayout.NORTH, textViewArea, 64, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, textViewArea, -165, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{
		readTextButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{

			}
		});
	}

	public ChatController getBaseController()
	{
		return baseController;
	}

	public void setBaseController(ChatController baseController)
	{
		this.baseController = baseController;
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

	public JButton getReadTextButton()
	{
		return readTextButton;
	}

	public void setReadTextButton(JButton readTextButton)
	{
		this.readTextButton = readTextButton;
	}

}
