package displayStudent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import myJStuff.*;

public class AppliedPanel extends MyPanel{
	/**
	 * instance variables
	 */
	private JButton btnBack;
	
	private JLabel lblSuccess;

	/**
	 * class constructor
	 * @param packageListener listener for the panel
	 */
	public AppliedPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * displays whether or not applying for a scholarship was successful
	 */
	private void displayNorth() {
		lblSuccess = new MyLabel("Fill", Size.defaultLblFontSize);
		north.add(lblSuccess, "cell 0 0,center");
	}
	
	private void displayCenter() {
		
	}
	
	/**
	 * displays the back button
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AppliedPanel");
	}
	
	//empty method
	public void displayScholarship() {	
	}
	
	/**
	 * set display string based on success of application
	 * @param success whether the application was successfully applied for 
	 */
	public void success(boolean success) {
		if(success) {
			lblSuccess.setText("Success: You have applied to this scholarship");
		}else {
			lblSuccess.setText("Fail: You have either already applied or are not allowed to apply to this scholarship");
		}
	}
}
