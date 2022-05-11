package com.mybm.staticviews.redaermanager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 11:18
 */
public class BookCate extends JFrame {

    private JPanel panel,n,n2,n3,n4,n5;

    private JLabel libCate,l1,l2;

    private JButton select,f1,f2,f3,f4;

    private JTextField t1,b1,b2;

    private JTable table;

    private JScrollPane jScrollPane;

    private DefaultTableModel model;

    public BookCate(String s){
        super(s);

        this.setSize(500,500);

        panel=new JPanel(new BorderLayout());
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel.setBackground(Color.yellow);
        this.add(this.panel);


        //north
        n=new JPanel();
        libCate=new JLabel("图书类型");
        t1=new JTextField(15);
        select=new JButton("查询");
        n.add(libCate);
        n.add(t1);
        n.add(select);
        panel.add(n,BorderLayout.NORTH);



        //center
        String[] cate=new String[]{"图书类型编号","图书类型名称"};
        Object[][] c=null;
        model=new DefaultTableModel(c,cate);
        table=new JTable(model);
        jScrollPane=new JScrollPane(table);
        n2=new JPanel();
        n2.add(jScrollPane);
        panel.add(n2,BorderLayout.CENTER);


        //bottom
        n3=new JPanel(new BorderLayout());
        n3.setBackground(Color.yellow);
        panel.add(n3,BorderLayout.SOUTH);
        n4=new JPanel(new GridLayout(2,2));
        n5=new JPanel();
        l1=new JLabel("图书类型编号:");
        l2=new JLabel("图书类型名称:");

        b1=new JTextField();
        b2=new JTextField();

        n4.add(l1);
        n4.add(b1);
        n4.add(l2);
        n4.add(b2);

        n3.add(n4,BorderLayout.NORTH);
        n3.add(n5,BorderLayout.SOUTH);
        f1=new JButton("添加");
        f2=new JButton("修改");
        f3=new JButton("删除");
        f4=new JButton("退出");
        n5.add(f1);
        n5.add(f2);
        n5.add(f3);
        n5.add(f4);





        this.setVisible(true);
    }



}
