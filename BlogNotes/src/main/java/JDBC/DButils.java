package JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbutils.DbUtils;

public class DButils {
	public static Connection getConnection() {
		InputStream is;
		try {
			System.out.println("Connecting to database...");
			is = new FileInputStream(
					"C:\\Users\\he.wu\\eclipse-workspace\\AlgorithmeSource\\BlogNotes\\src\\main\\java\\JDBC\\jdbc.properties");
			Properties pros = new Properties();
			if (is != null) {
				pros.load(is);
			}
			String driver = pros.getProperty("DB_DRIVER");
			String url = pros.getProperty("DB_URL");
			String user = pros.getProperty("DB_LOGIN");
			String pwd = pros.getProperty("DB_PASSWORD");
			is.close();
			System.out.println("connect successfully");
			DbUtils.loadDriver(driver);
			Connection con = DriverManager.getConnection(url, user, pwd);
			return con;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void closeRessource(Connection con, PreparedStatement ps) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
