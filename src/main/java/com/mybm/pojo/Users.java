package com.mybm.pojo;

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
public class Users {

    private Integer id;

    private String name;

    private String password;

}
