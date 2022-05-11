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

public class SelectAndUpadte extends JFrame implements ActionListener {

    private JLabel[] jLabels;
    private JButton[] buttons;
    private JPanel panel,tolp,toppan,tablepan,P;
    private JTextField[] fields;
    private ButtonGroup group;
    private JRadioButton[] radioButtons;
    private JComboBox comboBox;

    private JButton b1;
    private JLabel l1;
    private JTextField f1;

    private JTable table;
    private JScrollPane js;
    private DefaultTableModel model;

    public SelectAndUpadte(String s){
        super(s);
        Object[][] o=null;
        String[] c=new String[]{};
        P=new JPanel();
        tolp=new JPanel(new BorderLayout());
        toppan=new JPanel();
        tablepan=new JPanel();

        model=new DefaultTableModel(o,c);
        table=new JTable(model);
        js=new JScrollPane(table);
        l1=new JLabel("读者类型");
        f1=new JTextField(10);
        b1=new JButton("查询");
        toppan.add(l1);
        toppan.add(f1);
        toppan.add(b1);
        tablepan.add(js);
        tolp.add(toppan,BorderLayout.NORTH);
        tolp.add(tablepan,BorderLayout.SOUTH);

        P.add(tolp);

        String[] label=new String[]{"编号","姓名","类别","性别","年龄","电话","所在部门","注册日期"};
        String[] btt=new String[]{"添加","关闭"};
        panel=new JPanel();
        radioButtons=new JRadioButton[2];
        radioButtons[0]=new JRadioButton("男");
        radioButtons[1]=new JRadioButton("女");
        comboBox=new JComboBox();
        fields=new JTextField[6];
        ViewUtiles.bottom2(label,btt,panel,jLabels,fields,buttons,radioButtons,comboBox,this);
        P.add(panel);
        this.add(P);
        this.setSize(561,700);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
