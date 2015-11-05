package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * 
 * @author rbak9218
 * @version 1.0 10/21/15
 */
public class ChatDisplay
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatDisplay()
	{
		windowMessage = "This message is brought to you by NPR stations from North America. Thank you always.";
		chatIcon = new ImageIcon(getClass().getResource("images/vaultboy.png"));
	}
	
	/**
	 * Takes the users input from a pop-up.
	 * @param input The users input
	 * @return Returns the input.
	 */
	public String getUserInput(String input)
	{
		String answer = "";
		answer = JOptionPane.showInputDialog(null, input);
		return answer;
	}
	
	/**
	 * 
	 * @param displayText
	 */
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText);
	}
}
