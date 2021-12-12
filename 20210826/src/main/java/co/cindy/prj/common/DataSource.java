package co.cindy.prj.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource { // DAO 객체
	private static DataSource dataSource;

	private DataSource() { // 외부 생성 불가하게 만듬
	}

	public static DataSource getInstance() {
		dataSource = new DataSource();
		return dataSource;
	}

	public Connection getConnection() {
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "dev";
		String password = "dev";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
