package views.departments;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import daos.DepartmentDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartmentRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTable table;
	private JButton btnSearch;
	private DepartmentDAO departmentDAO;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DepartmentRecord frame = new DepartmentRecord();
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
	public DepartmentRecord() {
		departmentDAO = new DepartmentDAO();
		initialize();
	}
	
	private void initialize(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setTitle("Departments");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("Name");
		panel.add(lblName);
		
		txtName = new JTextField();
		panel.add(txtName);
		txtName.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				table.setModel(DbUtils.resultSetToTableModel(departmentDAO.searchDepartment(name)));
			}
		});
		panel.add(btnSearch);
		
		JPanel buttonPane = new JPanel();
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnAddNew = new JButton("Add new");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentForm frm = new DepartmentForm(DepartmentRecord.this, departmentDAO, false);
				frm.setVisible(true);
				refreshView();
			}
		});
		buttonPane.add(btnAddNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepartmentForm frm = new DepartmentForm(DepartmentRecord.this, departmentDAO, true);
				frm.setVisible(true);
			}
		});
		buttonPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row <0){
					JOptionPane.showMessageDialog(null, "You must choose a Deparment to delete", "Error Message",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Department?","Confirm Delete",JOptionPane.YES_NO_OPTION);
				if (opt == 0){
					int id = (int) table.getValueAt(row, 0);
					departmentDAO.deleteDepartment(id);
					JOptionPane.showMessageDialog(null, "Deleted successfully!","Delete Department",JOptionPane.INFORMATION_MESSAGE);
					refreshView();
				}
			}
		});
		buttonPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(DbUtils.resultSetToTableModel(departmentDAO.getAllDepartments()));
		scrollPane.setViewportView(table);
	}
	
	public void refreshView(){
		table.setModel(DbUtils.resultSetToTableModel(departmentDAO.getAllDepartments()));
	}

}
