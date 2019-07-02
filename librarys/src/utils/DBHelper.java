/**
 * 
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author wben 
 *
 */
public class DBHelper {

	public String url = "jdbc:mysql://localhost:3306/hua?useUnicode=true&characterEncoding=UTF-8";
	public String username = "root";
	public String password = "123456";
	public static DBHelper instance = null;

	// 閫氳繃闈欐�佷唬鐮佸潡娉ㄥ唽鏁版嵁搴撻┍鍔紝淇濊瘉娉ㄥ唽鍙墽琛屼竴娆�
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private DBHelper() {
	}

	/**
	 * 鑾峰緱绫诲疄渚�
	 * 
	 * @return
	 */
	public static DBHelper getInstance() {
		// 缁欑被鍔犻攣,闃叉绾跨▼骞跺彂
		synchronized (DBHelper.class) {
			if (instance == null) {
				instance = new DBHelper();
			}
		}
		return instance;
	}

	/**
	 * 鑾峰緱杩炴帴
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	/**
	 * 鍏抽棴杩炴帴
	 * 
	 * @param conn
	 * @param st
	 * @param rs
	 */
	public static void closeConnection(Connection conn, Statement st,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
