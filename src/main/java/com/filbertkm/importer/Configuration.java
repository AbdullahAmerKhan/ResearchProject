package com.filbertkm.importer;

import org.kohsuke.args4j.Option;

public class Configuration {

	@Option(name = "-dbuser", usage = "database user", required = true)
	private String dbuser;

	@Option(name = "-dbname", usage = "database name", required = true)
	private String dbname;

	@Option(name = "-dbpass", usage = "database password", required = true)
	private String dbpass;

	@Option(name = "-dumpdir", usage = "dump directory", required = true)
	private String dumpdir;

	public String getDbUser() {
		return dbuser;
	}
	
	public String getDbName() {
		return dbname;
	}

	public String getDbPass() {
		return dbpass;
	}

	public String getDumpDir() {
		return dumpdir;
	}
	
	public void setDbUser(String db_user) {
		dbuser= db_user;
	}
	
	public void setDbName(String db_name) {
		dbname = db_name;
	}

	public void setDbPass(String db_pass) {
		dbpass = db_pass;
	}

	public void setDumpDir(String db_dmp_dir) {
		dumpdir= db_dmp_dir;
	}

}
