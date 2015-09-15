package views.departments;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import daos.DepartmentDAO;

import models.Department;

import java.awt.color.CMMException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DepartmentForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JComboBox cmbFaculty;
	private JTextArea txtDescription;
	
	private DepartmentDAO departmentDAO;
	private DepartmentRecord departmentRecord;
	private boolean updateMode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DepartmentForm dialog = new DepartmentForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DepartmentForm() {
		initialize();
		
	}
	
	
	public DepartmentForm(DepartmentRecord departmentRecord, DepartmentDAO departmentDAO,
		 boolean updateMode) {
		this.departmentDAO = departmentDAO;
		this.departmentRecord = departmentRecord;
		this.updateMode = updateMode;
		initialize();
	}
	

	private void initialize(){
		String title;
		if(updateMode){
			title = "Update Department";
		}else{
			title = "New Department";
		}
		setTitle(title);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			txtName = new JTextField();
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.insets = new Insets(0, 0, 5, 0);
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.gridx = 3;
			gbc_txtName.gridy = 1;
			contentPanel.add(txtName, gbc_txtName);
			txtName.setColumns(10);
		}
		{
			JLabel lblFaculty = new JLabel("Faculty");
			GridBagConstraints gbc_lblFaculty = new GridBagConstraints();
			gbc_lblFaculty.insets = new Insets(0, 0, 5, 5);
			gbc_lblFaculty.gridx = 1;
			gbc_lblFaculty.gridy = 2;
			contentPanel.add(lblFaculty, gbc_lblFaculty);
		}
		{
			cmbFaculty = new JComboBox();
			GridBagConstraints gbc_cmbFaculty = new GridBagConstraints();
			gbc_cmbFaculty.insets = new Insets(0, 0, 5, 0);
			gbc_cmbFaculty.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmbFaculty.gridx = 3;
			gbc_cmbFaculty.gridy = 2;
			contentPanel.add(cmbFaculty, gbc_cmbFaculty);
		}
		{
			JLabel lblDescription = new JLabel("Description");
			GridBagConstraints gbc_lblDescription = new GridBagConstraints();
			gbc_lblDescription.insets = new Insets(0, 0, 0, 5);
			gbc_lblDescription.gridx = 1;
			gbc_lblDescription.gridy = 3;
			contentPanel.add(lblDescription, gbc_lblDescription);
		}
		{
			txtDescription = new JTextArea();
			GridBagConstraints gbc_txtDescription = new GridBagConstraints();
			gbc_txtDescription.fill = GridBagConstraints.BOTH;
			gbc_txtDescription.gridx = 3;
			gbc_txtDescription.gridy = 3;
			contentPanel.add(txtDescription, gbc_txtDescription);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSave = new JButton("Save");
				btnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String name = txtName.getText();
						int faculty_id = cmbFaculty.getSelectedIndex();
						String description = txtDescription.getText();

						
						if(updateMode){
							Department department = new Department();
							
							JOptionPane.showMessageDialog(null, "Department updated successfully.","Department Information",JOptionPane.INFORMATION_MESSAGE);
							departmentRecord.refreshView();
						}else{
							Department department = new Department(name, description, faculty_id);
							departmentDAO.addDepartment(department);
							JOptionPane.showMessageDialog(null, "Department created successfully.","Deparment Information",JOptionPane.INFORMATION_MESSAGE);
							departmentRecord.refreshView();
						}
						setVisible(false);
						dispose();
					}
				});
				btnSave.setActionCommand("OK");
				buttonPane.add(btnSave);
				getRootPane().setDefaultButton(btnSave);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
