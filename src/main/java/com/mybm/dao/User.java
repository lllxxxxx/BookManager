package com.mybm.dao;

import com.mybm.dao.base.BaseDAO;
import com.mybm.pojo.Users;


/**
 * @author: lllxxx
 * @description:
 * @date: 2022/5/12 20:07
 */
public class User extends BaseDAO<Users> {


    public User(Class clazz) {
        super(clazz);
    }

    public static void main(String[] args) {
        User user=new User(Users.class);
        int i = user.InsertPojo(new Users(null, "lllxxx", "xxxx"));
        System.out.println(i);
    }

}
