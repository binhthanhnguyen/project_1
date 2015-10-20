package views.users;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import models.User;

import daos.UserDAO;

public class UserForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtOffice;
	private JTextField txtPosition;
	private JTextField txtSalaryGrade;
	private JTextField txtPositionAllowance;
	private JTextField txtTeachingAllowance;
	private JTextField txtTaxId;
	private JTextField txtAccountNumber;
	private JComboBox cmbGender;
	private JComboBox cmbDepartment;
	
	private boolean updateMode;
	private UserRecord userRecord;
	private UserDAO userDAO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserForm frame = new UserForm();
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
	public UserForm() {
		initialize();
		
	}
	public UserForm(UserRecord userRecord, UserDAO userDao, boolean updateMode) {
		this.userRecord = userRecord;
		this.userDAO = userDao;
		this.updateMode = updateMode;
		initialize();
		setLocationRelativeTo(null);

	}
	private void initialize(){
		String title;
		if(updateMode){
			title = "Update User";
		}else{
			title = "New User";
		}
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel buttonPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(56, Short.MAX_VALUE))
		);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				String name = getUserName();
				String gender = getGender();
				String email = getEmail();
				String phone = getPhone();
				String address = getAddress();
				
				if(updateMode){
					User user = new User();
					userDAO.update(user);
					JOptionPane.showMessageDialog(null, "User updated successfully.","Users",JOptionPane.INFORMATION_MESSAGE);
					userRecord.refreshView();
				}else{
					User user = new User(name, gender, phone, email, address);
					userDAO.addUser(user);
					JOptionPane.showMessageDialog(null, "User created successfully.","Users",JOptionPane.INFORMATION_MESSAGE);
					userRecord.refreshView();
				}
			}
		});
		buttonPanel.add(btnSave);
		
		JButton btnSaveAndAddAnother = new JButton("Save and add another");
		btnSaveAndAddAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pack();
				setVisible(true);
			}
		});
		buttonPanel.add(btnSaveAndAddAnother);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		buttonPanel.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Name");
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		
		cmbGender = new JComboBox();
		cmbGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		
		JLabel lblAddress = new JLabel("Address");
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		
		cmbDepartment = new JComboBox();
		
		JLabel lblOffice = new JLabel("Office");
		
		txtOffice = new JTextField();
		txtOffice.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position");
		
		txtPosition = new JTextField();
		txtPosition.setColumns(10);
		
		JLabel lblSalaryGrade = new JLabel("Salary Grade");
		
		txtSalaryGrade = new JTextField();
		txtSalaryGrade.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Position Allowance");
		
		txtPositionAllowance = new JTextField();
		txtPositionAllowance.setColumns(10);
		
		JLabel lblTeachingAllowance = new JLabel("Teaching Allowance");
		
		txtTeachingAllowance = new JTextField();
		txtTeachingAllowance.setColumns(10);
		
		JLabel lblTax = new JLabel("Tax");
		
		txtTaxId = new JTextField();
		txtTaxId.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("Account number");
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setColumns(10);
		
		JLabel lblUni = new JLabel("Union member");
		
		JCheckBox cbxUnion = new JCheckBox("");
		
		JLabel lblPartyMember = new JLabel("Party member");
		
		JCheckBox chckbxCbxpartymember = new JCheckBox("");
		
		JLabel lblTrade = new JLabel("Trade unionist");
		
		JCheckBox cbxTradeUnionist = new JCheckBox("");
		
		JLabel lblAchievement = new JLabel("Achievement");
		
		JTextArea txtAchievement = new JTextArea();
		
		JLabel lblOtherInfo = new JLabel("Other Info");
		
		JTextArea txtOtherInfo = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGender)
								.addComponent(lblNewLabel)
								.addComponent(lblEmail)
								.addComponent(lblPhone))
							.addGap(50)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblAddress)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDepartment)
								.addComponent(lblOffice)
								.addComponent(lblPosition))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOffice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAchievement)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtAchievement)))
					.addGap(78)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUni)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSalaryGrade)
								.addComponent(lblTax)
								.addComponent(lblPartyMember)
								.addComponent(lblTrade)
								.addComponent(lblAccountNumber)
								.addComponent(lblNewLabel_1)
								.addComponent(lblTeachingAllowance)
								.addComponent(lblOtherInfo))
							.addGap(36)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtOtherInfo, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(cbxUnion)
								.addComponent(chckbxCbxpartymember)
								.addComponent(cbxTradeUnionist)
								.addComponent(txtSalaryGrade, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtPositionAllowance, Alignment.LEADING)
									.addComponent(txtTeachingAllowance, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
								.addComponent(txtTaxId, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtAccountNumber, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSalaryGrade)
						.addComponent(txtSalaryGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGender)
								.addComponent(cmbGender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAddress)
								.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPhone)
								.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDepartment)
								.addComponent(cmbDepartment, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOffice)
								.addComponent(txtOffice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPosition)
								.addComponent(txtPosition, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(txtPositionAllowance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTeachingAllowance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTeachingAllowance))
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTax)
								.addComponent(txtTaxId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(16)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAccountNumber)
								.addComponent(txtAccountNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblUni)
									.addGap(14)
									.addComponent(lblPartyMember)
									.addGap(14)
									.addComponent(lblTrade))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(cbxUnion)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(chckbxCbxpartymember)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cbxTradeUnionist)))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAchievement)
							.addComponent(txtAchievement, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblOtherInfo)
							.addComponent(txtOtherInfo, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	public void setUserName(String name){
		txtName.setText(name);
	}

	public String getUserName() {
		return txtName.getText();
	}

	public String getAddress() {
		return txtAddress.getText();
	}

	public void setAddress(String address) {
		this.txtAddress.setText(address);
	}

	public String getEmail() {
		return txtEmail.getText();
	}

	public void setEmail(String email) {
		this.txtEmail.setText(email);
	}

	public String getPhone() {
		return txtPhone.getText();
	}

	public void setPhone(String phone) {
		this.txtPhone.setText(phone);
	}

	public String getOffice() {
		return txtOffice.getText();
	}

	public void setOffice(String office) {
		this.txtOffice.setText(office);
	}

	public String getTxtPosition() {
		return txtPosition.getText();
	}

	public void setPosition(String position) {
		this.txtPosition.setText(position);
	}

	public double getSalaryGrade() {
		return Double.parseDouble(txtSalaryGrade.getText());
	}

	public void setTxtSalaryGrade(JTextField txtSalaryGrade) {
		this.txtSalaryGrade = txtSalaryGrade;
	}

	public Double getPositionAllowance() {
		return Double.parseDouble(txtPositionAllowance.getText());
	}

	public void setPositionAllowance(Double positionAllowance) {
		this.txtPositionAllowance.setText(String.valueOf(positionAllowance));
	}

	public String getTxtTeachingAllowance() {
		return txtTeachingAllowance.getText();
	}

	public void setTeachingAllowance(Double teachingAllowance) {
		this.txtTeachingAllowance.setText(String.valueOf(teachingAllowance));
	}

	public int getTaxId() {
		return Integer.parseInt(txtTaxId.getText());
	}

	public void setTaxId(int taxId) {
		this.txtTaxId.setText(String.valueOf(taxId));
	}

	public String getAccountNumber() {
		return txtAccountNumber.getText();
	}

	public String getGender() {
		return cmbGender.getSelectedItem().toString();
	}

	public void setGender(String gender) {
		this.cmbGender.setSelectedItem(new String(gender));
	}

	public String getDepartment() {
		return cmbDepartment.getSelectedItem().toString();
	}

	public void setDepartment(String department) {
		this.cmbDepartment.setSelectedItem(new String(department));
	}

	public void setAccountNumber(String accountNumber) {
		this.txtAccountNumber.setText(accountNumber);
	}
}
