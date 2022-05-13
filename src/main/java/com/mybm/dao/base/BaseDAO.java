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
import java.util.*;


/**
 * @author: lllxxx
 * @description: 先用自定义注解表示T的表名 还有字段名字
 * @date: 2022/5/12 19:31
 */
public class BaseDAO<T> {

    private String tableName;

    private String[] wordName;

    private Map<String,String> wordMap;

    private Class[] wordType;

    private DataSource dataSource;

    private QueryRunner queryRunner;

    private Class aClass;



    public BaseDAO(Class clazz) {
        this.aClass=clazz;
        wordMap=new HashMap<>();
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
        wordType=new Class[fields.length];
        for (int i = 0; i < fields.length; i++) {
            WordName annotation = fields[i].getAnnotation(WordName.class);
            wordName[i]=annotation.name();
            wordType[i]=fields[i].getType();
            wordMap.put(fields[i].getName(),annotation.name());
        }
    }

    public static boolean isNumeric4(String str) {
        return str != null && str.chars().allMatch(Character::isDigit);
    }


    /**
     * @param :
     * @return Boolean
     * @author lllxxx
     * @description 查询全部
     */
    public List<T> SelectAllUseBean()  {
        try {
            return queryRunner.query("select * from " + tableName, new BeanListHandler<T>(aClass));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> SelectAllUseList()  {
        try {
            return queryRunner.query("select * from " + tableName, new ArrayListHandler());
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
    public List<T> SelectPartlyUseBean(String[] para,Object[] real){
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

    public List<T> SelectPartlyUseBeanAnd(String[] para,Object[] real){
        String sql="select * from "+tableName+" where ";
        for (int i = 0; i < para.length; i++) {
            sql=sql+para[i]+"=? and ";
        }
        sql=sql.substring(0,sql.length()-4);
        try {
            return queryRunner.query(sql,real,new BeanListHandler<T>(aClass));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<T> SelectPartlyUseBeanOr(String[] para,Object[] real){
        String sql="select * from "+tableName+" where ";
        for (int i = 0; i < para.length; i++) {
            sql=sql+para[i]+"=? or ";
        }
        sql=sql.substring(0,sql.length()-3);
        try {
            return queryRunner.query(sql,real,new BeanListHandler<T>(aClass));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> SelectPartlyUseList(String[] para,Object[] real){
        String sql="select * from "+tableName+" where ";
        for (int i = 0; i < para.length; i++) {
            sql=sql+para[i]+"=? ";
        }
        try {
            return queryRunner.query(sql,real,new ArrayListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> SelectPartlyUseListAnd(String[] para,Object[] real){
        String sql="select * from "+tableName+" where ";
        for (int i = 0; i < para.length; i++) {
            sql=sql+para[i]+"=? and ";
        }
        sql=sql.substring(0,sql.length()-4);
        try {
            return queryRunner.query(sql,real,new ArrayListHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Object[]> SelectPartlyUseListOr(String[] para,Object[] real){
        String sql="select * from "+tableName+" where ";
        for (int i = 0; i < para.length; i++) {
            sql=sql+para[i]+"=? or ";
        }
        sql=sql.substring(0,sql.length()-3);
        try {
            return queryRunner.query(sql,real,new ArrayListHandler());
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
        String sql="insert into "+tableName+" (";
        for (int i = 0; i < wordName.length; i++) {
            sql=sql+wordMap.get(wordName[i])+",";
        }
        sql=sql.substring(0,sql.length()-1)+") values (";
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

    public int UpdatePojo(String[] sets,String[] wheres,Object[] para){
        String sql="update "+tableName+" set ";
        for (int i = 0; i < sets.length; i++) {
            sql=sql+sets[i]+"=?,";
        }
        sql=sql.substring(0,sql.length()-1)+" where ";
        for (int i = 0; i < wheres.length; i++) {
            sql=sql+wheres[i]+"=?";
        }
        int i=-1;
        try {
            i=queryRunner.update(sql,para);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    /**
     * @description: cloum有参数删除指定列
     * @param cloum
     * @param para
     * @return 影响行数
     */

    public int DelectPojo(String cloum,String para){
        int is=-1;
        Boolean isNum=isNumeric4(para);
        if(isNum){   //是数字
            if(cloum==null){
                int j=0;
                for (int i = 0; i < wordName.length; i++) {
                    if(wordType[i].getName()==String.class.getName()){
                        j=j+1;
                    }
                }
                Object[] o=new Object[j];
                String sqlif="delete from "+tableName+" where ";
                List list=new ArrayList<>();
                for (int i = 0; i < wordName.length; i++) {
                    if(wordType[i].getName()!=String.class.getName()){
                        System.out.println(wordType[i].getClass().getName());
                        System.out.println(String.class.getName());
                        list.add(Integer.parseInt(para));
                        sqlif=sqlif+wordMap.get(wordName[i])+"= ? or ";
                    }
                }
                o=list.toArray();
                sqlif=sqlif.substring(0,sqlif.length()-3);
                try {
                    is=queryRunner.update(sqlif,o);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                String sqislse="delete from "+tableName+" where "+cloum+"=?";
                try {
                    is=queryRunner.update(sqislse,para);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }else {
            if(cloum==null){
                int j=0;
                for (int i = 0; i < wordName.length; i++) {
                    if(wordType[i].getName()==String.class.getName()){
                       j=j+1;
                    }
                }
                Object[] o=new Object[j];
                String sqlif="delete from "+tableName+" where ";
                List list=new ArrayList<>();
                for (int i = 0; i < wordName.length; i++) {
                    if(wordType[i].getName()==String.class.getName()){
                        list.add(para);
                        sqlif=sqlif+wordMap.get(wordName[i])+"= ? or ";
                    }
                }
                o=list.toArray();
                sqlif=sqlif.substring(0,sqlif.length()-3);
                try {
                    is=queryRunner.update(sqlif,o);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                String sqislse="delete from "+tableName+" where "+cloum+"=?";
                try {
                    is=queryRunner.update(sqislse,para);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return is;
    }
}
