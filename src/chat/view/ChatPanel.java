package chat.view;

import javax.swing.*;
import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextField inputTextField;
	private JTextArea textViewArea;
	private JButton readTextButton;
	
	public ChatPanel()
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		inputTextField = new JTextField("Type stuff here");
		textViewArea = new JTextArea("Text appears here");
		readTextButton = new JButton("Talk to chatbot");
		
	}
	
	private void setupPanel()
	{
		
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListneners()
	{
		
	}
}
