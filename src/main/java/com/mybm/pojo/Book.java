package com.mybm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: lllxxx
 * @description:
 * @date: 2022/5/12 12:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String isbn;
    private String bookType;
    private String name;
    private String author;
    private String publisher;
    private String time;
    private Integer price;
}
