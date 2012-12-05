package hk.edu.uic.cosns.model.dbc;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author cofthew7
 * Database Connector 
 */
public class DatabaseConnection {
		private static final String DBDRIVER = "org.gjt.mm.mysql.Driver";
		private static final String DBURL = "jdbc:mysql://localhost:3306/cosns";
		private static final String DBUSER = "root";
		private static final String DBPASSWORD = "root";
		
		private Connection conn = null;
		public DatabaseConnection() throws Exception {
			try {
				Class.forName(DBDRIVER);			// Load database driver
				this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);		// Connect database
			} catch (Exception e) {
				throw e;
			}
		}
		
		public Connection getConnection() {		// Get the connection
			return this.conn;
		}
		
		public void close() throws Exception {
			if (this.conn != null) {
				try {
					this.conn.close();			// Close database connection
				} catch (Exception e) {
					throw e;
				}
			}
		}
}
