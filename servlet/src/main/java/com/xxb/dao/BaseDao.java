package com.xxb.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库操作的公共类
 * @author HP
 */
public class BaseDao {

    private static String url;
    private static String username;
    private static String password;
    private static String driver;



    static {
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        username = properties.getProperty("username");
        password = properties.getProperty("password");
    }


    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static ResultSet execute(Connection connection, String sql, Object[] params, PreparedStatement preparedStatement, ResultSet resultSet) throws SQLException {
        //预编译的SQL
        preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < params.length; i++){
            preparedStatement.setObject(i + 1, params[i]);
        }
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    /**
     * 关闭资源
     * @param connection
     * @param resultSet
     * @param preparedStatement
     * @return
     */
    public static Boolean close(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement){
        boolean flag = true;
        try {
            if (null != resultSet){
                resultSet.close();
                resultSet = null;
            }
        } catch (SQLException throwables) {
            flag = false;
            throwables.printStackTrace();
        }

        try {
            if (null != preparedStatement){
                preparedStatement.close();
                preparedStatement = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag = false;
        }

        try {
            if (null != connection){
                connection.close();
                connection = null;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            flag = false;
        }

        return flag;

    }


}
