package com.mybm.dao.base;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: lllxxx
 * @description:
 * @date: 2022/5/8 11:03
 */
public class JdbcUtils {

    public static Connection getConnerction() throws IOException, ClassNotFoundException, SQLException {
        InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties=new Properties();
        properties.load(is);
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String url=properties.getProperty("url");
        String diverclass=properties.getProperty("drivercalss");
        Class.forName(diverclass);
        Connection conn= DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void CloseAll(Connection conn){
        if(conn==null){
            return;
        }else {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }





}
