package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import Model.BEAN.Tour;


public class functionDAO {
	 private static final String DB_URL = "jdbc:mysql://localhost:3307/data";
	    private static final String DB_USERNAME = "root";
	    private static final String DB_PASSWORD = "123456789";
	    boolean isExist = false;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
	    public boolean addTour(String location, String description, String number_day, String filepath) {
	        

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	            String sql = "INSERT INTO tour_detail(location, description, number_day, image) VALUES (?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, location);
	            stmt.setString(2, description);
	            stmt.setString(3, number_day);
	            stmt.setString(4, filepath);
	            int rowsAffected = stmt.executeUpdate();

	            if (rowsAffected > 0) {
	                isExist = true;
	            }
	        } catch (ClassNotFoundException ex) {
	            System.out.println("MySQL JDBC driver not found.");
	            ex.printStackTrace();
	        } catch (SQLException ex) {
	            System.out.println("An error occurred while connecting to the database.");
	            ex.printStackTrace();
	        } catch (Exception ex) {
	            System.out.println("An unexpected error occurred.");
	            ex.printStackTrace();
	        }

	        return isExist;
	    }
	    
	    public ArrayList<Tour> getAllTours() {
			ArrayList<Tour> result = new ArrayList<Tour>();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
	            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				Statement stm = conn.createStatement();
				String query = "select * from tour_detail";
				ResultSet rs = stm.executeQuery(query);
				
				while (rs.next()) {
					Tour tour = new Tour();
					tour.setLocation(rs.getString(2));
					tour.setDescription(rs.getString(3));
					tour.setNumber_day(rs.getString(4));
					tour.setImage(rs.getString(5));
					result.add(tour);
				}
				
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return result;
		}
		
}