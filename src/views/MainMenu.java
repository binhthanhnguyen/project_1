package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;

import views.departments.DepartmentRecord;
import views.faculty.FacultyRecord;
import views.users.LoginForm;
import views.users.UserRecord;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private boolean loggedIn = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setTitle("Employee Management System");
		setResizable(false);
		setLocationRelativeTo(null);
		initialize();
		
	}
	private void initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 660);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEmployees = new JMenu("Employees");
		menuBar.add(mnEmployees);
		
		JMenuItem mntmManageEmployees = new JMenuItem("Manage Employees");
		mntmManageEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserRecord frm = new UserRecord();
				frm.setVisible(true);
			}
		});
		mnEmployees.add(mntmManageEmployees);
		
		JMenuItem mntmSalaryReport = new JMenuItem("Salary Report");
		mnEmployees.add(mntmSalaryReport);
		
		JMenu mnDepartments = new JMenu("Departments");
		menuBar.add(mnDepartments);
		
		JMenuItem mntmDepatmentRecord = new JMenuItem("Department Record");
		mntmDepatmentRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentRecord frm = new DepartmentRecord();
				frm.setVisible(true);
				
			}
		});
		mnDepartments.add(mntmDepatmentRecord);
		
		JMenu mnFaculties = new JMenu("Faculties");
		menuBar.add(mnFaculties);
		
		JMenuItem mntmFacultyRecord = new JMenuItem("Faculty Record");
		mntmFacultyRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyRecord frm = new FacultyRecord();
				frm.setVisible(true);
			}
		});
		mnFaculties.add(mntmFacultyRecord);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "        Employee Management System\n" +
													"Verion: 1.0.0\n" +
													"Assignment: Project 1\n" +
													"Group: 1\n" +
													"Team Leader: Binh Thanh Nguyen",
													"About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnHelp.add(mntmAbout);
		menuBar.add(Box.createHorizontalGlue());
		
		JMenu mnUser = new JMenu("User");

		menuBar.add(mnUser);
		
		if (!loggedIn){
			mnUser.setVisible(false);
		}
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Profile");
		mnUser.add(mntmNewMenuItem);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mnUser.add(mntmSettings);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnUser.add(mntmLogOut);
		
		JMenu mnLogIn = new JMenu("Log In");
		mnLogIn.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent arg0) {
			}
			public void menuDeselected(MenuEvent arg0) {
			}
			public void menuSelected(MenuEvent arg0) {
				LoginForm frm = new LoginForm();
				frm.setVisible(true);
			}
		});
		menuBar.add(mnLogIn);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MainMenu.class.getResource("/images/background.png")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}
}
