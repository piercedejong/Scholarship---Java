package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import displayAdmin.*;
import objects.*;
import myJStuff.MyController;

/**
 * Controller used to manage what the admin can do when logged in
 * @author pierce
 *
 */
public class AdminController extends MyController {
	
	// All of the panels that the controller 
	private AdminPanel ap;
	private AllStudentsPanel asp;
	private ViewStudentPanel vsp;
	
	// Current User
	private Admin currentAdmin;
	// List of all of the scholarships
	private HashMap <Integer, Scholarship> scMap;
	
	// Create a JPanel to reference the AdminPanel class
	private JPanel adminPanel;
	private JPanel allStudentsPanel;
	private JPanel viewStudentPanel;
	
	
	/**
	 * Constructor
	 * @param frame - JFrame
	 * @param globalListener - ActionListener
	 */
	public AdminController(ActionListener globalListener, JFrame frame) {
		super(globalListener, frame);
	}
	
	/**
	 * Method used to switch to this controller
	 * @param currentAdmin - Admin - current user
	 * @param scMap - HashMap<Integer, Scholarship> - list of scholarships
	 */
	public void start(Admin currentAdmin, HashMap<Integer, Scholarship> scMap) {
		this.scMap = scMap;
		this.currentAdmin = currentAdmin;
		ap = new AdminPanel(this, globalListener);
		asp = new AllStudentsPanel(this);
		vsp = new ViewStudentPanel(this);
		
		adminPanel = ap.getContentPane();
		allStudentsPanel = asp.getContentPane();
		viewStudentPanel = vsp.getContentPane();
		
		switchToAdminPanel();
	}
	
	public void switchToAdminPanel() {
		ap.setName(currentAdmin.getName());
		ap.setEmail(currentAdmin.getEmail());
		switchPanel(adminPanel);
	}
	
	@Override
	/**
	 * ActionListener for when a button is pressed that is assigned to the packageController
	 */
	public void actionPerformed(ActionEvent e) {
		JButton source = (JButton)e.getSource();
		String name = source.getName();
		switch(name) {
		case "AllStudents_AdminPanel":
			switchPanel(allStudentsPanel);
			break;
			
		case "Back_AllStudentsPanel":
			switchPanel(adminPanel);
			break;
		default:
			break;
		}
	}
	

}
