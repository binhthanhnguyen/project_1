package views.users;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import daos.UserDAO;
import db.MySQLConnection;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;

public class UserRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTable table;
	private JButton btnSearch;
	private JComboBox cmbGender;
	private JComboBox cmbDepartment;
	private UserDAO userDAO;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRecord frame = new UserRecord();
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
	public UserRecord() {
		userDAO = new UserDAO();
		initialize();
		setLocationRelativeTo(null);
		table.setModel(DbUtils.resultSetToTableModel(userDAO.getAllUsers()));
	}
	
	private void initialize(){
		setTitle("Employees");
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		setBounds(100, 100, 900, 600);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 20));
		JLabel lblName = new JLabel("Name");
		panel.add(lblName);
		
		txtName = new JTextField();
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		panel.add(lblGender);
		
		cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		panel.add(cmbGender);
		
		JLabel lblDepartment = new JLabel("Department");
		panel.add(lblDepartment);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				table.setModel(DbUtils.resultSetToTableModel( userDAO.searchUser(name)));
			}
		});
		
		cmbDepartment = new JComboBox();
		panel.add(cmbDepartment);
		panel.add(btnSearch);
		
		JPanel buttonPanel = new JPanel();
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnAddNew = new JButton("Add new");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserForm frm = new UserForm(UserRecord.this, userDAO, false);
				frm.setVisible(true);
			}
		});
		buttonPanel.add(btnAddNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row <0){
					JOptionPane.showMessageDialog(null, "You must choose a user to update", "Error Message",JOptionPane.ERROR_MESSAGE);
					return;
				}
				UserForm frm = new UserForm(UserRecord.this, userDAO, true);
				frm.setVisible(true);
				String name = table.getValueAt(row, 1).toString();
				frm.setUserName(name);
			}
		});
		buttonPanel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row <0){
					JOptionPane.showMessageDialog(null, "You must choose a user to delete", "Error Message",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this User?","Confirm Delete",JOptionPane.YES_NO_OPTION);
				if (opt == 0){
					int id = (int) table.getValueAt(row, 0);
					userDAO.deleteUser(id);
					JOptionPane.showMessageDialog(null, "Deleted successfully!","Delete User",JOptionPane.INFORMATION_MESSAGE);
					refreshView();
				}
			}
		});
		buttonPanel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void refreshView(){
		table.setModel(DbUtils.resultSetToTableModel(userDAO.getAllUsers()));
	}

}
