package com.mybm.staticviews.user;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 20:00
 */
public class DeleteUser extends JFrame {

    private JTable table;

    private JScrollPane jScrollPane;

    private DefaultTableModel model;

    private JButton[] b;

    private JPanel panel;

    public DeleteUser(String s){
        super(s);
        String[] c=new String[]{"用户编号","用户名","密码"};
        Object[][] o=null;
        model=new DefaultTableModel(o,c);
        table=new JTable(model);
        jScrollPane=new JScrollPane(table);
        panel=new JPanel();
        this.add(panel);
        panel.add(jScrollPane);
        b=new JButton[2];
        b[0]=new JButton("删除");
        b[1]=new JButton("退出");
        panel.add(b[0]);
        panel.add(b[1]);
        this.setSize(500,600);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}
