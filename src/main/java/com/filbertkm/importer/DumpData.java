package com.filbertkm.importer;

public class DumpData {
	
	public DumpData(String tempUser, String tempName, String temppass , String tempdir)
	{
		setDbUser(tempUser);
		setDbName(tempName);
		setDumpDir(tempdir);
		setDbPass(temppass);
	}
	private String dbuser;

	private String dbname;

	private String dbpass;
	
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
