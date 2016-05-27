package mmartsen.oozie.actions.hive;

public class HiveOptions {


	private String connectionUrl;
	private String hiveUser;
	private String hivePassword;
	private String sql;
	private String outputKeyName;

	public HiveOptions(String[] args) {
		connectionUrl = args[0];
		hiveUser = args[1];
		hivePassword = args[2];
		sql = args[3];
		if (args[4] == null) {
			outputKeyName = "out";
		} else {
			outputKeyName = args[4];
		}

		System.out.println("Hive JDBC connection string: " + connectionUrl);
		System.out.println("Hive user name: " + hiveUser);
		System.out.println("SQL to run: " + sql);
		System.out.println("Output key name: " + outputKeyName);
	}

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public String getHiveUser() {
		return hiveUser;
	}

	public String getHivePassword() {
		return hivePassword;
	}

	public String getSql() {
		return sql;
	}

	public String getOutputKeyName() {
		return outputKeyName;
	}
}
