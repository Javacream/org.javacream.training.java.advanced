package org.javacream.training.java.aufbau.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcDemo {

	public static void main(String[] args) throws Exception{
		Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://10.28.4.1", "SA", "");
		con.createStatement().execute("insert into audit values('Hello')");
		con.close();
	}

}
