package mmartsen.oozie.actions.hive;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.Properties;

public class GetValueFromQuery {

	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws SQLException,
			ClassNotFoundException, IOException {

		HiveOptions o = new HiveOptions(args);
		Class.forName(driverName);

		Connection con = DriverManager.getConnection(o.getConnectionUrl(),
				o.getHiveUser(), o.getHivePassword());
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(o.getSql());

		Properties props = new Properties();
		if (res.next()) {
			props.setProperty(o.getOutputKeyName(), res.getString(1));
		} else {
			props.setProperty(o.getOutputKeyName(), "NA");
		}

		File file = new File(
				System.getProperty("oozie.action.output.properties"));
		OutputStream os = new FileOutputStream(file);
		props.store(os, "");
		os.close();
		System.out.println(file.getAbsolutePath());
	}
}
