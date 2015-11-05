package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * 
 * @author Rory Baker
 * @version 1.2 11/5/15 Added icon to the input window.
 */
public class ChatDisplay
{
	private String windowMessage;
	private ImageIcon chatIcon;

	public ChatDisplay()
	{
		windowMessage = "Thank you for choosing chatbot! :D";
		chatIcon = new ImageIcon(getClass().getResource("images/vaultboy.png"));
	}

	/**
	 * Takes the users input from a pop-up.
	 * 
	 * @param input
	 *            The users input
	 * @return Returns the input.
	 */
	public String getUserInput(String input)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, input, windowMessage, JOptionPane.INFORMATION_MESSAGE, chatIcon, null, "Type here please").toString();
		return answer;
	}

	/**
	 * 
	 * @param displayText
	 */
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText, windowMessage, JOptionPane.PLAIN_MESSAGE, chatIcon);
	}
}
