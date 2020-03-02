package JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class jdbcTest {
	public static void main(String[] args) throws ParseException, SQLException {
//		Connection con = DButils.getConnection();
//		String sql = "insert into user (id, username, password, role, createDate) values (?,?,?,?,?);";
//		// method 1 manual
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setInt(1, 2);
//		ps.setString(2, "wuhe");
//		ps.setString(3, "wuhe");
//		ps.setString(4, "USER");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//		java.util.Date d = sdf.parse("2020-03-02");
//		ps.setDate(5, new Date(d.getTime()));
//		ps.execute();
//		DButils.closeRessource(con, ps);

		// method 2 query runner
		// query runner can remplace dao 
		Connection conn = DButils.getConnection();
		MapListHandler beanListHandler = new MapListHandler();
		QueryRunner runner = new QueryRunner();
		List<Map<String, Object>> list = runner.query(conn, "SELECT * FROM user where id = ? ;", beanListHandler, 1);
		list.forEach(System.out::println);
		DbUtils.close(conn);
	}
}
