package com.xxb.dao;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.Statement;

public class DruidTest {


    public static void main(String[] args) throws Exception {
        DruidDataSource novaSource = new DruidDataSource();
        novaSource.setUrl("jdbc:mysql://192.168.100.50:3306/cinder?serverTimezone=UTC");
        novaSource.setUsername("root");
        novaSource.setPassword("123456");
        novaSource.setValidationQuery("select 1 ");
        novaSource.setLoginTimeout(3);
        novaSource.setTimeBetweenEvictionRunsMillis(1000);
        novaSource.setMaxActive(2);
        novaSource.setTestOnReturn(true);
        novaSource.setTestWhileIdle(true);
        novaSource.setTestOnBorrow(true);
        System.out.println(".........................");
        Connection conn = null;
        Statement stat;
        while (true) {
            try {
                conn = novaSource.getConnection(1000);
                System.out.println("========");
                stat = conn.createStatement();
                boolean execute = stat.execute("SELECT 1");
                System.out.println(execute);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("异常了");
            }finally {

                conn.close();

            }
            Thread.sleep(1000);
        }
//        try {
//            DruidPooledConnection connection = novaSource.getConnection();
//            if (connection == null){
//                novaSource.setUrl("jdbc:mysql://127.0.0.1:3306/cinder?serverTimezone=UTC");
//            }
//        } catch (SQLException throwables) {
//            System.out.println("=========");
//            novaSource.setUrl("jdbc:mysql://127.0.0.1:3306/cinder?serverTimezone=UTC");
//        }
//        System.out.println(novaSource);
    }
}
