package com.project.window.verification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.window.conf.ReadDataConf;

public class UserVerification {

	private String connectionURL;

	private UserVerification() {

	}

	public UserVerification(String connectionURL) {
		this.connectionURL = connectionURL;
	}

	public int isDataLoginCorrect(String user, String password) {

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
//			e.printStackTrace();
			return 0;
		}

		if (userFromDB != null && userFromDB.equals(user) && passwordFromDB.equals(password))
			return 2;

		return 1;
	}
}
