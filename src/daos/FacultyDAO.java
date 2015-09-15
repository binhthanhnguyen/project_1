package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Department;
import models.Faculty;
import db.MySQLConnection;

public class FacultyDAO {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public FacultyDAO() {
		// TODO Auto-generated constructor stub
		conn = MySQLConnection.getConnection();
	}
	
	public ResultSet getAllFaculties(){
		String sql = "SELECT * FROM faculties";
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void create(Faculty faculty){
		String sql = "INSERT INTO faculties" +
					 "(name,location,description)" +
					 "VALUE(?,?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, faculty.getName());
			pstm.setString(2, faculty.getlocation());
			pstm.setString(3, faculty.getDescription());
			pstm.execute();
			
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void update(Faculty faculty){

		String sql = "UPDATE faculties SET name = ?, location = ?, description = ? " +
					 "WHERE id = ?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, faculty.getName());
			pstm.setString(2, faculty.getlocation());
			pstm.setString(3, faculty.getDescription());	
			pstm.setInt(4, faculty.getId());
			pstm.executeUpdate();
			
			pstm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void delete(int id){
		String sql = "DELETE FROM faculties WHERE id = ?";
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
	
	public ResultSet searchFaculty(String name){
		name +="%";
		try {
			pstm = conn.prepareStatement("SELECT * FROM faculties WHERE name LIKE ? ORDER BY name");
			pstm.setString(1, name);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
