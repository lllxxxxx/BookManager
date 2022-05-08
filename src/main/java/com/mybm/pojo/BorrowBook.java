package com.mybm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 8:22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBook {

    private String borrowdates;

    private Double fine;

    private String ISBN;

    private String readerid;

    private String returndate;

}
