package com.filbertkm.importer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.wikidata.wdtk.dumpfiles.DumpProcessingController;

public class Importer {

	private Connection conn;

	private String dbHost;
	
	private String dbPort;

	private String dbUser;

	private String dbName;

	private String dbPass;

	public static void main(String[] args) {
		Configuration config = new Configuration();
		
		CmdLineParser parser = new CmdLineParser(config);
		try {
			parser.parseArgument(args);
			//config.setDumpData("cloud01.prakinf.tu-ilmenau.de", "wikidata", "wikidata", "wikidata.dbIS#15", "F:\\rcse\\research_project\\");
			//System.out.println(Arrays.deepToString(args));
			Importer importer = new Importer(config.getDBHost(), config.getDBPort(), config.getDbUser(), config.getDbName(), config.getDbPass());
			importer.process("wikidatawiki", config.getDumpDir());
		} catch (CmdLineException e) {
			 //omg!
			e.printStackTrace();
		}
		System.out.println("done");
	}

	public Importer(String dbHost, String dbPort, String dbUser, String dbName, String dbPass) {
		this.dbHost = dbHost;
		this.dbPort = dbPort;
		this.dbUser = dbUser;
		this.dbName = dbName;
		this.dbPass = dbPass;
	}

	public void process(String wikiId, String dumpDirectory) {
		JsonDumpProcessor jsonDumpProcessor = new JsonDumpProcessor(getConnection());
		JsonDumpProcessor.configureLogging();

		DumpProcessingController dumpProcessingController = new DumpProcessingController(wikiId);
		dumpProcessingController.setOfflineMode(true);

		try {
			dumpProcessingController.setDownloadDirectory(dumpDirectory);
			dumpProcessingController.registerEntityDocumentProcessor(jsonDumpProcessor, null, true);
			dumpProcessingController.processMostRecentJsonDump();
			jsonDumpProcessor.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		if (this.conn == null) {
			//String dbProps= "jdbc:postgresql://" + this.dbHost + ":5433/" +" " + this.dbName +" " + this.dbUser + " " +this.dbPass;
			//System.out.println(dbProps);
			try {
				this.conn = DriverManager.getConnection(
					"jdbc:postgresql://" + this.dbHost + ":"+ this.dbPort +"/" + this.dbName,
					this.dbUser,
					this.dbPass
				);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		return this.conn;
	}
}
