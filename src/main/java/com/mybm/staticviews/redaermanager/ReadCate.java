package com.mybm.staticviews.redaermanager;

/**
 * @author: lllxxx
 * @date: 2022.5.11
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReadCate extends JFrame implements ActionListener {

    private JPanel[] panel;
    private JButton[] buttons;
    private JLabel[] labels;
    private JTextField[] fields;

    private JButton b1;
    private JLabel l1;
    private JTextField f1;

    private JTable table;
    private JScrollPane js;
    private DefaultTableModel model;

    public ReadCate(String s){
        super(s);
        this.setSize(500,800);
        Object[][] o=null;
        String[] c=new String[]{};
        String[] label=new String[]{"读者类型编号","读者类型名称","可借图书数量","可借图书期限"};
        String[] filed=new String[]{"添加","修改","删除","退出"};
        panel=new JPanel[5];
        for (int i = 0; i < panel.length; i++) {
            panel[i]=new JPanel();
        }
        panel[0].setLayout(new FlowLayout());
        panel[1].setLayout(new BorderLayout());
        this.add(panel[0]);

        model=new DefaultTableModel(o,c);
        table=new JTable(model);
        js=new JScrollPane(table);
        l1=new JLabel("读者类型");
        f1=new JTextField(10);
        b1=new JButton("查询");
        panel[4].add(l1);
        panel[4].add(f1);
        panel[4].add(b1);
        panel[3].add(js);
        panel[1].add(panel[4],BorderLayout.NORTH);
        panel[1].add(panel[3],BorderLayout.SOUTH);
        panel[0].add(panel[1]);
        fields=new JTextField[4];
        ViewUtiles.bottom(label,filed,panel[2],labels,fields,buttons,4,4,this);
        panel[0].add(panel[2]);

        this.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
