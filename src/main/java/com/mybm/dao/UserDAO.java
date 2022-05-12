package com.mybm.dao;

import com.github.drinkjava2.dbutilspro.DbPro;
import com.mybm.pojo.Users;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
        JdbcUtils.CloseAll(conn);
        if(users.getPassword().equals(psw)){
            return true;
        }else {
            return false;
        }
    }

    public static List<Object[]> selectAll() throws Exception {
        QueryRunner queryRunner=new QueryRunner();
        conn=JdbcUtils.getConnerction();
        String sql="select * from users";
        List<Object[]> query = queryRunner.query(conn, sql, new ArrayListHandler());
        JdbcUtils.CloseAll(conn);
        return query;
    }

    public static Boolean DelectCHoosen(String st,int col) throws SQLException, IOException, ClassNotFoundException {
        QueryRunner queryRunner=new QueryRunner();
        conn=JdbcUtils.getConnerction();
        String sql="delete from users where id=? or name=? or password=?";
        int update;
        if(col==0){
            update = queryRunner.update(conn, sql, Integer.parseInt(st), st, st);
        }else {
            update = queryRunner.update(conn, sql, 0, st, st);
        }
        JdbcUtils.CloseAll(conn);
        if(update!=0){
            return true;
        }else {
            return false;
        }
    }

    public static Boolean AddUser(String name,String psw) throws SQLException, IOException, ClassNotFoundException {
        QueryRunner queryRunner=new QueryRunner();
        conn=JdbcUtils.getConnerction();
        String sql="insert into users values(?,?,?)";
        int update = queryRunner.update(conn, sql, null, name, psw);
        if(update==0){
            return false;
        }else {
            return true;
        }
    }

    public static Boolean updatePsw(String name,String psw) throws SQLException, IOException, ClassNotFoundException {
        QueryRunner queryRunner=new QueryRunner();
        conn=JdbcUtils.getConnerction();
        String sql="update users set password=? where name= ?";
        int update = queryRunner.update(conn, sql, psw, name);
        if(update==0){
            return false;
        }else {
            return true;
        }
    }

    @Test
    public void c1() throws Exception {
        selectAll();
    }
}
