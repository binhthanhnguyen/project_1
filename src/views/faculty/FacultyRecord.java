package views.faculty;

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

import daos.FacultyDAO;

import net.proteanit.sql.DbUtils;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class FacultyRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTable table;
	
	private FacultyDAO facultyDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyRecord frame = new FacultyRecord();
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
	public FacultyRecord() {
		initialize();
		facultyDAO = new FacultyDAO();
		table.setModel(DbUtils.resultSetToTableModel(facultyDAO.getAllFaculties()));
	}

	private void initialize(){
		setTitle("Faculties");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblName = new JLabel("Name");
		panel.add(lblName);
		
		txtName = new JTextField();
		panel.add(txtName);
		txtName.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				ResultSet rs = facultyDAO.searchFaculty(name);
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
		});
		panel.add(btnSearch);
		
		JPanel buttonPane = new JPanel();
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		
		JButton btnAddNew = new JButton("Add new");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FacultyForm frm = new FacultyForm(FacultyRecord.this, facultyDAO, false);
				frm.setVisible(true);
				
			}
		});
		buttonPane.add(btnAddNew);
		
		JButton btnUpdate = new JButton("Update");
		buttonPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row <0){
					JOptionPane.showMessageDialog(null, "You must choose a Faculty to delete", "Error Message",JOptionPane.ERROR_MESSAGE);
					return;
				}
				int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Faculty?","Confirm Delete",JOptionPane.YES_NO_OPTION);
				if (opt == 0){
					int id = (int) table.getValueAt(row, 0);
					facultyDAO.delete(id);
					JOptionPane.showMessageDialog(null, "Deleted successfully!","Delete Faculty",JOptionPane.INFORMATION_MESSAGE);
					refreshView();
				}
			}
		});
		buttonPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
	
	public void refreshView(){
		table.setModel(DbUtils.resultSetToTableModel(facultyDAO.getAllFaculties()));
	}
	
	
}
