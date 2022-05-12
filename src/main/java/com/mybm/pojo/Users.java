package com.mybm.pojo;

import com.mybm.dao.baseAnnotation.TableName;
import com.mybm.dao.baseAnnotation.WordName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 8:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(name = "users")
public class Users {

    @WordName(name = "id")
    private Integer id;

    @WordName(name = "name")
    private String name;

    @WordName(name = "password")
    private String password;

}
