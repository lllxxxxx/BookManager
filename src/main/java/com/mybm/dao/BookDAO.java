package com.mybm.dao;

import com.mybm.dao.base.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;

/**
 * @author: lllxxx
 * @description:
 * @date: 2022/5/12 12:36
 */
public class BookDAO {

    private static Connection conn;

    public static Boolean AddBook(String[] s1, String com) throws Exception{
        QueryRunner queryRunner=new QueryRunner();
        conn= JdbcUtils.getConnerction();
        String sql="insert into book values(?,?,?,?,?,?,?,?)";
        int update = queryRunner.update(conn, sql, null, s1[0], com, s1[1], s1[2], s1[3], s1[4], s1[5]);
        if(update==0){
            return false;
        }else {
            return true;
        }
    }
}
