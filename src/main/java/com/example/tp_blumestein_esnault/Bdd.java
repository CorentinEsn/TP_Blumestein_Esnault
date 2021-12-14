package com.example.tp_blumestein_esnault;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Bdd {

	public static Connection conn;
	private static Statement stmt;

	public static void initConnection() {

		Properties userInfo = new Properties();
		userInfo.setProperty("user", "root");
		userInfo.setProperty("password", "root");

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp_blumstein-esnault", "root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}