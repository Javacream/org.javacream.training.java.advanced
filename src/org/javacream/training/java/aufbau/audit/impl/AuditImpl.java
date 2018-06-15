package org.javacream.training.java.aufbau.audit.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.javacream.training.java.aufbau.audit.api.Audit;

public class AuditImpl implements Audit {
	private String url;
	private String user;
	private String password;
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void log(String message) {
		try(Connection con = DriverManager.getConnection(url, user, password)){
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into heizungsaudit values('" + message + "')");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
