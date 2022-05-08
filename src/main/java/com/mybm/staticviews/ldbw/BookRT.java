package com.mybm.staticviews.ldbw;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 21:52
 */
public class BookRT extends JFrame {
    private JPanel[] ps;

    private JTable table;

    private JScrollPane jScrollPane;

    private DefaultTableModel model;

    private JLabel[] ltop,lbot;

    private JTextField[] ttpo,tbot;

    private JButton[] buttons;

    public BookRT(String s){
        super(s);
        this.setSize(600,800);
        String[] s1=new String[]{"读者编号","读者姓名","读者类别"};
        String[] s2=new String[]{"图书编号","图书名称","借书日期"};
        String[] s4=new String[]{"归还","关闭"};
        String[] s3=new String[]{"ISBN","类别","书名","作者","出版社","出版日期","印刷次数","单价","当前日期","超期天数","罚金","操作人员"};
        Object[][] o=null;

        ps=new JPanel[6];
        ltop=new JLabel[3];
        lbot=new JLabel[12];
        ttpo=new JTextField[3];
        tbot=new JTextField[12];
        buttons=new JButton[2];
        for (int i = 0; i < 6; i++) {
            ps[i]=new JPanel();
        }

        this.add(ps[0]);

        for (int i = 0; i < 3; i++) {
            ltop[i]=new JLabel(s1[i]);
            ttpo[i]=new JTextField(5);
            ps[1].add(ltop[i]);
            ps[1].add(ttpo[i]);
        }
        ps[0].setLayout(new BorderLayout());
        ps[0].add(ps[3],BorderLayout.NORTH);
        ps[0].add(ps[2],BorderLayout.CENTER);
        ps[2].setLayout(new GridLayout(6,4,10,10));
        ps[3].setLayout(new BorderLayout());
        ps[3].add(ps[1],BorderLayout.NORTH);
        ps[3].add(ps[4],BorderLayout.SOUTH);



        for (int i = 0; i < 12; i++) {
            lbot[i]=new JLabel(s3[i]);
            tbot[i]=new JTextField();
            ps[2].add(lbot[i]);
            ps[2].add(tbot[i]);
        }


        model=new DefaultTableModel(o,s2);
        table=new JTable(model);
        jScrollPane=new JScrollPane(table);


        ps[4].add(jScrollPane);
        ps[0].add(ps[5],BorderLayout.SOUTH);

        for (int i = 0; i < 2; i++) {
            buttons[i]=new JButton(s4[i]);
            ps[5].add(buttons[i]);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BookRT d=new BookRT("");
    }
}
