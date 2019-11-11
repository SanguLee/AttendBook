package SQL;

import java.sql.*;
import java.util.ArrayList;

public class SQLite {
	String DBlink = "jdbc:sqlite:C:\\Users\\User\\Downloads\\DB.Browser.for.SQLite-3.11.2-win32\\src\\AttendBook\\AttendBook.db";

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public SQLite() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void query(String sql, boolean get) throws SQLException {
		con = DriverManager.getConnection(DBlink);
		st = con.createStatement();
		if(get)
			rs = st.executeQuery(sql);
		if(!get)
			st.executeUpdate(sql);
	}

	private void close() throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
	}

	public static void printSet(String[][] sa) {
		for (String[] sb : sa) {
			for (String sc : sb) {
				System.out.print(sc + "\t");
			}
			System.out.println();
		}
	}

	public static String ArraytoString(String[] a) {
		String r = "";
		for(int i=0; i<a.length; i++) {
			if (i == 0) {
				r += "\"" + a[i] + "\"";
			} else
				r += ", \"" + a[i] + "\"";
		}
		return r;
	}
	
	public String[][] Select(String table, String[] cols) {
		String col = ArraytoString(cols);

		String sql = "select " + col + " from " + table;

		ArrayList<String[]> result = new ArrayList<>();

		try {
			query(sql,true);
			while (rs.next()) {
				String[] tmp = new String[cols.length];
				for (int i = 0; i < cols.length; i++) {
					tmp[i] = rs.getString(cols[i]);
				}
				result.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result.toArray(new String[result.size()][cols.length]);
	}

	public String[][] Select(String table, String[] cols, String whereCol, String whereVal) {
		String col = ArraytoString(cols);
		String sql = "select " + col + " from " + table + " where " + "\"" + whereCol + "\"" + "=" + "\"" + whereVal
				+ "\"";

		ArrayList<String[]> result = new ArrayList<>();

		try {
			query(sql,true);
			while (rs.next()) {
				String[] tmp = new String[cols.length];
				for (int i = 0; i < cols.length; i++) {
					tmp[i] = rs.getString(cols[i]);
				}
				result.add(tmp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result.toArray(new String[result.size()][cols.length]);
	}

	public void Upsert(String table, String[] cols, String[] data) {
		String col = ArraytoString(cols);
		col = "( " + col + " )";
		
		String dat = ArraytoString(data);
		dat = "( " + dat + " )";
		
		String sql= "insert or replace into people " + col + " values "+ dat;
		try {
			query(sql,false);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void Delete(String table, String whereCol, String whereVal) {
		String sql = "delete from " + table + " where " + "\"" + whereCol + "\"" + "=" + "\"" + whereVal
				+ "\"";
		
		try {
			query(sql,false);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
