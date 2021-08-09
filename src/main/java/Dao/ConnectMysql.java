package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMysql {
    public static Connection getConnect(){
        String jdbcURL = "jdbc:mysql://localhost:3306/baithithuchanh";
        String jdbcUsername = "root";
        String jsbcPassword = "hungdaik98";
        Connection connection = null;
        try{
            Class.forName(("com.mysql.jdbc.Driver"));
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jsbcPassword);
        }catch (SQLException | ClassNotFoundException exception){
            exception.printStackTrace();
        }
        return connection;
    }
}
