package com.filbertkm.importer;

import org.kohsuke.args4j.Option;

public class Configuration {

	@Option(name = "-dbhost", usage = "database host", required = true)
	private String dbhost;
	
	@Option(name = "-dbport", usage = "database connection port", required = true)
	private String dbport;

	@Option(name = "-dbuser", usage = "database user", required = true)
	private String dbuser;

	@Option(name = "-dbname", usage = "database name", required = true)
	private String dbname;

	@Option(name = "-dbpass", usage = "database password", required = true)
	private String dbpass;

	@Option(name = "-dumpdir", usage = "dump directory", required = true)
	private String dumpdir;

	public String getDBHost() {
		return dbhost;
	}
	
	public String getDBPort() {
		return dbport;
	}

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
	
	public void setDumpData(String db_host, String db_port, String db_name, String db_user, String db_pass, String dump_dir){
		dbhost=db_host;
		dbport=db_port;
		dbuser=db_user;
		dbname=db_name;
		dbpass=db_pass;
		dumpdir=dump_dir;		
	}
	

}
