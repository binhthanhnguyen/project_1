package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.MySQLConnection;

import models.Department;
import models.Research;

public class DepartmentDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public DepartmentDAO() {
		conn = MySQLConnection.getConnection();
	}
	
	public ResultSet getAllDepartments(){
		String sql = "SELECT * FROM departments";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void addDepartment(Department department){
		String sql = "INSERT INTO departments" +
					 "(name,faculty_id,description)" +
					 "VALUE(?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, department.getName());
			pstm.setInt(2, department.getFacultyId());
			pstm.setString(3, department.getDescription());
			pstm.execute();
			
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void update(Department department){

		String sql = "UPDATE departments SET name = ?, department_id = ?, description = ? " +
					 "where id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, department.getName());
			pstm.setInt(2, department.getFacultyId());
			pstm.setString(3, department.getDescription());	
			pstm.setInt(4, department.getId());
			pstm.executeUpdate();
			
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void deleteDepartment(int id){
		String sql = "DELETE FROM departments WHERE id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet searchDepartment(String name){
		name +="%";
		try {
			pstm = conn.prepareStatement("SELECT * FROM departments WHERE name LIKE ? ORDER BY name");
			pstm.setString(1, name);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
