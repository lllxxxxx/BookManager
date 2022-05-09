package com.mybm.dao;

import com.github.drinkjava2.dbutilspro.DbPro;
import com.mybm.pojo.Users;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/9 18:38
 */
public class UserDAO {

    private static Connection conn;

    public static Boolean login(String name,String psw) throws Exception {
        conn=JdbcUtils.getConnerction();
        QueryRunner queryRunner=new QueryRunner();
        String sql="SELECT * FROM users WHERE `name`=?";
        Users users = queryRunner.query(conn,sql, new BeanHandler<Users>(Users.class), name);
        if(users.getPassword().equals(psw)){
            return true;
        }else {
            return false;
        }
    }

}
