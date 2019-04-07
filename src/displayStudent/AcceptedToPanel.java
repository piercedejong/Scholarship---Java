package displayStudent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import myJStuff.*;
import objects.Scholarship;
/**
 * This is the students applied to panel: you can change the priority here
 * @author Steve Khanna, Pierce de Jong
 *
 */
public class AcceptedToPanel extends MyPanel{
private JButton btnBack;
	/**
	 * instance variables
	 */
	private JLabel lblSuccess;
	private int y=1;
	private JLabel lblName;
	
	private int totalScholarships;
	/**
	 * class constructor
	 * @param packageListener listener for the panel
	 */
	public AcceptedToPanel(ActionListener packageListener) {
		this.packageListener = packageListener;
		contentPane.setName("AppliedToPanel");
		
		displayNorth();
		displaySouth();
		displayCenter();
	}
	
	/**
	 * displays heading of the panel
	 */
	private void displayNorth() {
		lblSuccess = new MyLabel("Scholarships you have applied to", Size.defaultLblFontSize);
		north.add(lblSuccess, "cell 0 0,center");
	}
	
	/**
	 * displays attribute names
	 */
	private void displayCenter() {
		lblName = new MyLabel("Priority", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 0 0");
		lblName = new MyLabel("Name", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 1 0");
		lblName = new MyLabel("Amount", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 2 0");
		lblName = new MyLabel("Department", Colors.grey, Size.defaultLblFontSize);
		center.add(lblName,"cell 3 0");
		
	}
	
	/**
	 * displays the back button
	 */
	private void displaySouth() {
		btnBack = new MyButton("Back", Size.defaultBtnFontSize);
		south.add(btnBack, "cell 0 0");
		btnBack.addActionListener(packageListener);
		btnBack.setName("Back_AppliedToPanel");
	}
	
	/**
	 * setter for the number of scholarships to display
	 * @param i amount of scholarships to display
	 */
	public void setTotalScholarships(int i) {
		totalScholarships = i;
	}
	
	/**
	 * remove all scholarships from the panel
	 */
	public void resetScholarships() {
		center.removeAll();
		center.repaint();
		displayCenter();
		y = 1;
	}

	/**
	 * add scholarship successfully applied to by the student to center by priority
	 * with an option to withdraw from said scholarship
	 * @param scholarship scholarship to be added
	 * @param priority priority of said scholarship
	 */
	public void addScholarship(Scholarship scholarship, int priority) {
		
	    String name = scholarship.getName();
		String money = Double.toString(scholarship.getMoney());
		String toS = scholarship.getDepartment();
		ArrayList<String> labelName = new ArrayList<String>();
		labelName.add(""+(priority+1));
		labelName.add(name);
		labelName.add(money);
		labelName.add(toS);
		JLabel lbl;
		int i = 0;
		for(String lblNm: labelName) {
			lbl = new MyLabel(lblNm,Colors.defaultTextColor,Size.defaultLblFontSize);
			String cellNum = Integer.toString(i);
			center.add(lbl, String.format("cell "+cellNum+" %d, left",y));
			i++;
		}
		JButton btnAccept = new MyButton("Accept", Size.defaultLblFontSize, Size.defaultBtnEditWidth+25);
		center.add(btnAccept,String.format("cell 6 %d, left",y));
		btnAccept.setName("Accept_AcceptedToPanel");
		btnAccept.addActionListener(packageListener);
		btnAccept.setActionCommand(scholarship.getScholarshipId()+"");
		y++;
	}
}