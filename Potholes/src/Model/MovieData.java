package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Annotation.DBAnnotation;

/**
 * The Class MovieData.
 */
public class MovieData {
	
	/** The id. */
	protected Integer id;
	
	/** The data. */
	protected String data;
	
	/**
	 * Instantiates a new movie data.
	 *
	 * @param id the id
	 * @param data the data
	 */
	public MovieData(Integer id, String data) {
		super();
		this.id = id;
		this.data = data;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public String getData() {
		return data;
	}
	
	

	public void updateLocation(int IDnumber){
		try {

			Connection conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/simpletest",
					"root", "boyang");
			
		
			DBAnnotation.annoate("IDnumber","card","id",true);


			assert(IDnumber > 16000);
			int location = 2;
			DBAnnotation.annoate("location","card","location_id",false);


			String updateS = "UPDATE PERSON SET location_id = ?  WHERE IDnumber = ?";

			PreparedStatement preparedStmt =  (PreparedStatement) conn.prepareStatement(updateS);
			preparedStmt.setDouble(1, location);
			preparedStmt.setInt(2, IDnumber);

			preparedStmt.executeUpdate();
			//DBAnnotation.annoate("bonus","PERSON","BONUS",false);

			conn.close();

		}
		catch (Exception e) {
			System.out.println("exception");
		}
	}
	
	
	

	/**
	 * Sets the data.
	 *
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final MovieData other = (MovieData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovieData \n{\nid=" + id + ", \ndata=" + data + "\n}";
	}
	

	
	
	public void updateRenttime(int IDnumber){
		try {

			Connection conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/simpletest",
					"root", "boyang");
			
			
			Statement stmt = (Statement) conn.createStatement();
			String query = "select movie_type FROM mock_data where id = " + IDnumber;	
			ResultSet rs = stmt.executeQuery(query);
			int type = rs.getInt("movie_type");
			DBAnnotation.annoate("type","card","movie_type",true);

			int times = type + 2;  
			
			DBAnnotation.annoate("times","card","renttimes",false);


			String updateS = "UPDATE PERSON SET renttimes = ?  WHERE IDnumber = ?";

			PreparedStatement preparedStmt =  (PreparedStatement) conn.prepareStatement(updateS);
			preparedStmt.setDouble(1, times);
			preparedStmt.setInt(2, IDnumber);

			preparedStmt.executeUpdate();
			//DBAnnotation.annoate("bonus","PERSON","BONUS",false);

			conn.close();

		}
		catch (Exception e) {
			System.out.println("exception");
		}
	}
	
	
	
	
	
}
