package org.javacream.training.java.aufbau.heizkraftwerk.util;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.javacream.training.java.aufbau.heizkraftwerk.util.Fabrik.OfenElementParser.OfenElement;

public class Fabrik {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object create(String element) {
		OfenElement ofenElement = OfenElementParser.parse(element);
		String className = ofenElement.getClassName();
		String[] objects = ofenElement.getParameter();
		try {
			Class c = Class.forName(className);
			Constructor[] constructors = c.getConstructors();
			if (objects != null && objects.length > 0) {
				for (Constructor constructor : constructors) {
					Class[] types = constructor.getParameterTypes();
					if (types.length == objects.length) {
						Object[] params = new Object[objects.length];
						for (int i = 0; i < objects.length; i++) {
							String object = objects[i].toString();
							if (types[i] == String.class) {
								params[i] = object;
							} else if (types[i] == Integer.class || types[i] == int.class) {
								params[i] = Integer.parseInt(object);
							} else if (types[i] == Double.class || types[i] == double.class) {
								params[i] = Double.parseDouble(object);
							}
						}
						Object o = constructor.newInstance(params);
						return o;
					}
				}
			} else {
				return c.getConstructor().newInstance();
			}

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return null;

	}
	public static class DateiBeladungsplanlader{
		public static List<String> ladeplan() {
			try {
				return Files.readAllLines(Paths.get("c:/_training/workspace/org.javacream.training.java.aufbau/data/beladungsplan.txt"));

			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	public static class DatenbankBeladungsplanlader {
		public static List<String> ladeplan() {
			List<String> beladungsplan = new ArrayList<>();
			try(Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://10.28.4.1", "SA", "")){
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from beladungsplan");
				while(rs.next()) {
					String row = rs.getString(1);
					beladungsplan.add(row);
				}
				Integer numberOfDeletedRows = stmt.executeUpdate("delete from audit");
				System.out.println(numberOfDeletedRows);

			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			return beladungsplan;
		}
	}

	public static class OfenElementParser {
		public static OfenElement parse(String element) {
			String[] splitted = element.split(",");
			OfenElement result = new OfenElement(splitted);
			return result;
		}

		public static class OfenElement {
			private String className;
			private String[] parameter;

			public String getClassName() {
				return className;
			}

			public String[] getParameter() {
				return parameter;
			}

			public OfenElement(String[] element) {
				super();
				this.className = element[0];
				if (element.length > 1) {
					this.parameter = new String[element.length - 1];
					System.arraycopy(element, 1, this.parameter, 0, element.length - 1);
				}
			}
		}
	}

}
