package com.mybm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 8:19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReaderType {

    private Integer id;

    private Integer limit;

    private String typename;

}
