package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MySQLConnection;
import models.User;

public class UserDAO {	
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
		
	public UserDAO() {
		conn = MySQLConnection.getConnection();
	}
	
	public ResultSet getAllUsers() {
		try {
			pstm = conn.prepareStatement("SELECT * FROM users");
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public void addUser(User u) {
		String sql = "INSERT INTO users" +
					 "(name,gender,address,phone,email)" +
					 "VALUES(?, ?, ?, ?, ?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getName());
			pstm.setString(2, u.getGender());
			pstm.setString(3, u.getAddress());
			pstm.setString(4, u.getPhone());
			pstm.setString(5, u.getEmail());
			
			pstm.execute();
			
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(User u) {
		
		String sql = "UPDATE users SET name = ?, gender = ?, address = ?, phone = ?," +
					"email = ?, position = ?, department_id = ?, tax_id = ?, salary_grade = ?," +
					"teaching_allowance = ?, position_allowance =?, achievement=?, other_info = ? " +
					"where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getName());
			pstm.setString(2, u.getGender());
			pstm.setString(3, u.getAddress());
			pstm.setString(5, u.getPhone());
			pstm.setString(6, u.getEmail());
			pstm.setString(9, u.getPosition());
			pstm.setInt(4, u.getDeparmentId());
			pstm.setInt(10, u.getTaxId());
			pstm.setInt(11, u.getSalaryGrade());
			pstm.setDouble(12, u.getTeachingAllowance());
			pstm.setDouble(15, u.getPositionAllowance());
			pstm.setBoolean(12, u.isPartyMember());
			pstm.setBoolean(13, u.isTradeUnionist());
			pstm.setBoolean(14, u.isUnionMember());
			pstm.setString(7, u.getAchievement());
			pstm.setString(8, u.getOtherInfo());

			
			pstm.executeUpdate();
			
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteUser(int id) {
		try {
			pstm = conn.prepareStatement("DELETE FROM users WHERE id =?");
			pstm.setInt(1, id);
			pstm.executeUpdate();
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ResultSet searchUser(String name) {
		name +="%";
		try {
			pstm = conn.prepareStatement("SELECT * FROM users WHERE name LIKE ? ORDER BY name");
			pstm.setString(1, name);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
