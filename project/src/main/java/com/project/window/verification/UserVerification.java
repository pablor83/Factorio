package com.project.window.verification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserVerification {

	private String connectionURL;

	private UserVerification() {

	}

	public UserVerification(String connectionURL) {
		this.connectionURL = connectionURL;
	}

	public boolean isDataLoginCorrect(String user, String password) {

		ResultSet resultSet;
		String userFromDB = null;
		String passwordFromDB = null;

		try (Connection connectionSQLBase = DriverManager.getConnection(connectionURL);
				PreparedStatement preparedStatement = connectionSQLBase
						.prepareStatement("select LOGIN, HASLO from USERS WHERE LOGIN = (?)");) {
			preparedStatement.setString(1, user);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				userFromDB = resultSet.getString("LOGIN");
				passwordFromDB = resultSet.getString("HASLO");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (userFromDB != null && userFromDB.equals(user) && passwordFromDB.equals(password))
			return true;

		return false;
	}
}
