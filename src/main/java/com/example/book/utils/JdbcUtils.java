package com.example.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();

            //读取properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //流中加载数据
            properties.load(inputStream);

            //创建数据库连接
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource.getConnection());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接
     * @param conn
     */
    public static void close(Connection conn){

    }
}
