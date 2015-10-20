package views.faculty;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JTextArea;

import models.Department;
import models.Faculty;

import daos.FacultyDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacultyForm extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtLocation;
	private JTextArea txtDescription;
	
	private FacultyRecord facultyRecord;
	private FacultyDAO facultyDAO;
	private boolean updateMode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FacultyForm dialog = new FacultyForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FacultyForm() {
		initialize();
	}
	
	public FacultyForm(FacultyRecord facultyRecord, FacultyDAO facultyDAO, boolean updateMode){
		this.facultyRecord = facultyRecord;
		this.facultyDAO = facultyDAO;
		this.updateMode = updateMode;
		initialize();
	}
	
	private void initialize(){
		setBounds(100, 100, 400, 200);
		setLocationRelativeTo(null);
		String title;
		if(updateMode){
			title = "Update Faculty";
		}else{
			title = "New Faculty";
		}
		setTitle(title);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.anchor = GridBagConstraints.EAST;
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			txtName = new JTextField();
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.insets = new Insets(0, 0, 5, 0);
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.gridx = 2;
			gbc_txtName.gridy = 1;
			contentPanel.add(txtName, gbc_txtName);
			txtName.setColumns(10);
		}
		{
			JLabel lblLocation = new JLabel("Location");
			GridBagConstraints gbc_lblLocation = new GridBagConstraints();
			gbc_lblLocation.anchor = GridBagConstraints.EAST;
			gbc_lblLocation.insets = new Insets(0, 0, 5, 5);
			gbc_lblLocation.gridx = 1;
			gbc_lblLocation.gridy = 2;
			contentPanel.add(lblLocation, gbc_lblLocation);
		}
		{
			txtLocation = new JTextField();
			GridBagConstraints gbc_txtLocation = new GridBagConstraints();
			gbc_txtLocation.insets = new Insets(0, 0, 5, 0);
			gbc_txtLocation.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtLocation.gridx = 2;
			gbc_txtLocation.gridy = 2;
			contentPanel.add(txtLocation, gbc_txtLocation);
			txtLocation.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Description");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 3;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			txtDescription = new JTextArea();
			GridBagConstraints gbc_txtDescription = new GridBagConstraints();
			gbc_txtDescription.fill = GridBagConstraints.BOTH;
			gbc_txtDescription.gridx = 2;
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
					public void actionPerformed(ActionEvent e) {
						String name = txtName.getText();
						String location = txtLocation.getText();
						String description = txtDescription.getText();

						
						if(updateMode){
							
							
							JOptionPane.showMessageDialog(null, "Faculty updated successfully.","Faculty Information",JOptionPane.INFORMATION_MESSAGE);
							facultyRecord.refreshView();
						}else{
							Faculty faculty = new Faculty(name, location, description);
							facultyDAO.create(faculty);
							JOptionPane.showMessageDialog(null, "Faculty created successfully.","Faculty Information",JOptionPane.INFORMATION_MESSAGE);
							facultyRecord.refreshView();
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
					public void actionPerformed(ActionEvent arg0) {
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
