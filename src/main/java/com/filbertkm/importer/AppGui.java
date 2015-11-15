package com.filbertkm.importer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class AppGui {

	protected Shell shell;
	private Text dnName;
	private Text dbSuperUser;
	private Text dbPass;
	private Text dbDumpDir;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AppGui window = new AppGui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(654, 377);
		shell.setText("Dump Parser Settings");
		
		Label lblDatabaseName = new Label(shell, SWT.NONE);
		lblDatabaseName.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblDatabaseName.setBounds(46, 56, 123, 21);
		lblDatabaseName.setText("Database name");
		
		Label lblDatabaseMainUser = new Label(shell, SWT.NONE);
		lblDatabaseMainUser.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblDatabaseMainUser.setBounds(46, 98, 149, 38);
		lblDatabaseMainUser.setText("Database Main User");
		
		Label lblDatabasePassword = new Label(shell, SWT.NONE);
		lblDatabasePassword.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblDatabasePassword.setBounds(46, 138, 136, 31);
		lblDatabasePassword.setText("Database Password");
		
		Label lblPathToDumpfile = new Label(shell, SWT.NONE);
		lblPathToDumpfile.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblPathToDumpfile.setBounds(46, 184, 139, 38);
		lblPathToDumpfile.setText("Path to dumpfile directory");
		
		Button rbtnDRD = new Button(shell, SWT.RADIO);
		rbtnDRD.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		rbtnDRD.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		rbtnDRD.setBounds(343, 235, 192, 24);
		rbtnDRD.setText("Download recent dump");
		
		Button btnOk = new Button(shell, SWT.NONE);
		btnOk.setBounds(460, 303, 75, 25);
		btnOk.setText("Ok");
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.setBounds(553, 303, 75, 25);
		btnCancel.setText("Cancel");
		
		dnName = new Text(shell, SWT.BORDER);
		dnName.setBounds(198, 58, 337, 21);
		
		dbSuperUser = new Text(shell, SWT.BORDER);
		dbSuperUser.setBounds(198, 100, 337, 21);
		
		dbPass = new Text(shell, SWT.BORDER);
		dbPass.setBounds(198, 140, 337, 21);
		
		dbDumpDir = new Text(shell, SWT.BORDER);
		dbDumpDir.setBounds(198, 186, 337, 21);

	}
}
