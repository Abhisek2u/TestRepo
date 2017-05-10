package com.ab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DemoPMD {
	private static final Logger LOGGER = Logger.getLogger(DemoPMD.class.getName());
	private static Connection connection = null;

	public static void main(String args[]) {

		try {

			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://IN-AIR-BIMAP124.corp.capgemini.com:5432/pgnlp",
					"postgres", "admin");
			if (!connection.isClosed() && connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			LOGGER.warning(e.getClass() + ": " + e.getMessage());
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				// e1.printStackTrace();
				LOGGER.warning(e.getMessage());
			}
			// e.printStackTrace();

		}
		catch(ClassNotFoundException classNotFoundException)
		{
			LOGGER.warning(classNotFoundException.getMessage());
		}
		LOGGER.info("Opened database successfully");
	}
}
