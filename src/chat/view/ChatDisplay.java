package chat.view;

import javax.swing.JOptionPane;
/**
 * 
 * @author rbak9218
 * @version 1.0 10/21/15
 */
public class ChatDisplay
{
	
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
		
	}
}
