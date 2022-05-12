package com.mybm.dao.base;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mybm.dao.baseAnnotation.TableName;
import com.mybm.dao.baseAnnotation.WordName;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import javax.sql.DataSource;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


/**
 * @author: lllxxx
 * @description: 先用自定义注解表示T的表名 还有字段名字
 * @date: 2022/5/12 19:31
 */
public class BaseDAO<T> {

    private String tableName;

    private String[] wordName;

    private DataSource dataSource;

    private QueryRunner queryRunner;

    private Class aClass;



    public BaseDAO(Class clazz) {
        this.aClass=clazz;
        InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("druid");
        Properties properties=new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
             dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        queryRunner=new QueryRunner(dataSource);
        TableName annotations = (TableName) clazz.getAnnotation(TableName.class);
        tableName=annotations.name();
        Field[] fields = clazz.getDeclaredFields();
        wordName=new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            WordName annotation = fields[i].getAnnotation(WordName.class);
            wordName[i]=annotation.name();
        }
    }

    /**
     * @param :
     * @return Boolean
     * @author lllxxx
     * @description 查询全部
     */
    public List<T> SelectAll()  {
        try {
            return queryRunner.query("select * from " + tableName, new BeanListHandler<T>(aClass));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param para 放名字
     * @param real 放具体值
     * @return 部分查询结果
     */
    public List<T> SelectPartly(String[] para,Object[] real){
        String sql="select * from "+tableName+" where ";
        for (int i = 0; i < para.length; i++) {
            sql=sql+para[i]+"=? ";
        }
        try {
            return queryRunner.query(sql,real,new BeanListHandler<T>(aClass));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description: 增加单个实体类
     * @param pojo
     * @return 改变的行数 正常就是1 错误返回-1
     */
    public int InsertPojo(T pojo){
        String sql="insert into "+tableName+" values(";
        Class<T> clazz= (Class<T>) pojo.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        Object[] o=new Object[declaredFields.length];
        for (int i = 0; i < declaredFields.length; i++) {
            try {
                PropertyDescriptor pd=new PropertyDescriptor(declaredFields[i].getName(),clazz);
                sql=sql+"?,";
                Method readMethod = pd.getReadMethod();
                o[i]=readMethod.invoke(pojo);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sql=sql.substring(0,sql.length()-1);
        sql=sql+")";
        try {
            return queryRunner.update(sql,o);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int UpdatePojo(T pojo){
        return 1;
    }
}
