package com.mybm.staticviews.redaermanager;

/**
 * @author: lllxxx
 * @date: 2022.5.11
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderAdd extends JFrame implements ActionListener{

    private JLabel[] jLabels;
    private JButton[] buttons;
    private JPanel panel;
    private JTextField[] fields;
    private ButtonGroup group;
    private JRadioButton[] radioButtons;
    private JComboBox comboBox;


    public ReaderAdd(String s){
        super(s);
        String[] label=new String[]{"编号","姓名","类别","性别","年龄","电话","所在部门","注册日期"};
        String[] btt=new String[]{"添加","关闭"};
        panel=new JPanel();
        radioButtons=new JRadioButton[2];
        radioButtons[0]=new JRadioButton("男");
        radioButtons[1]=new JRadioButton("女");
        comboBox=new JComboBox();
        fields=new JTextField[6];
        ViewUtiles.bottom2(label,btt,panel,jLabels,fields,buttons,radioButtons,comboBox,this);
        this.add(panel);
        this.setSize(400,250);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
