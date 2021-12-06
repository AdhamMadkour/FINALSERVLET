package com.doma;

import java.sql.*;

public class MySqlClass {
    public static String getChat(String roomId) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abogbl", "root", "1234");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE roomId=" + roomId);
        StringBuilder data = new StringBuilder();
        while (resultSet.next()) {
            data.append(resultSet.getString("userId"));
            data.append(" : ");
            data.append(resultSet.getString("message"));
            data.append('\n');
        }
        return data.toString();
    }

    public static void witeData(String roomID, String msg, String userID) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abogbl", "root", "1234");
        Statement statement = connection.createStatement();
        String command = "INSERT INTO users (roomId,userId,message) values (";
        command += "'" + roomID + "'" + ',';
        command += "'" + userID + "'" + ',';
        command += "'" + msg + "'" + ")";
        statement.executeUpdate(command);
    }
}
