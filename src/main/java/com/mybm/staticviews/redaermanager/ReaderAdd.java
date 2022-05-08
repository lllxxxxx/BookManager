package com.mybm.staticviews.redaermanager;

import javax.swing.*;
import java.awt.*;

public class ReaderAdd {

    public static void add1(){
        JFrame adj=new JFrame("读者信息添加");
        adj.setSize(600,600);

        JPanel adp=new JPanel();
        adj.add(adp);
        adp.setLayout(null);
        JLabel Id=new JLabel("编号：");
        JLabel name=new JLabel("姓名：");
        JLabel category=new JLabel("类别：");
        JLabel sex=new JLabel("性别：");
        JLabel age=new JLabel("年龄：");
        JLabel tel=new JLabel("电话：");
        JLabel depart=new JLabel("所在部门：");
        JLabel date=new JLabel("注册日期：");
        JButton add=new JButton("添加");
        JButton close=new JButton("关闭");
        JTextField idTxt=new JTextField();
        JTextField nameTxt=new JTextField();
        JTextField ageTxt=new JTextField();
        JTextField telTxt=new JTextField();
        JTextField departTxt=new JTextField();
        JTextField dateTxt=new JTextField();

        String[] items={"教师","学生"};
        JComboBox cateBox=new JComboBox(items);

        JRadioButton man=new JRadioButton("男");
        JRadioButton woman=new JRadioButton("女");

        ButtonGroup sexB=new ButtonGroup();
        sexB.add(man);
        sexB.add(woman);

        adp.add(Id);
        Id.setBounds(10,10,80,25);
        adp.add(name);
        name.setBounds(310,10,80,25);

        adp.add(category);
        category.setBounds(10,110,80,25);
        adp.add(sex);
        sex.setBounds(310,110,80,25);

        adp.add(age);
        age.setBounds(10,210,80,25);
        adp.add(tel);
        tel.setBounds(310,210,80,25);

        adp.add(depart);
        depart.setBounds(10,310,80,25);
        adp.add(date);
        date.setBounds(310,310,80,25);

        adp.add(idTxt);
        idTxt.setBounds(55,10,190,25);
        adp.add(nameTxt);
        nameTxt.setBounds(365,10,190,25);

        adp.add(cateBox);
        cateBox.setBounds(55,110,110,25);
        adp.add(man);
        man.setBounds(365,110,80,25);
        adp.add(woman);
        woman.setBounds(450,110,80,25);

        adp.add(ageTxt);
        ageTxt.setBounds(55,210,190,25);
        adp.add(telTxt);
        telTxt.setBounds(365,210,190,25);

        adp.add(departTxt);
        departTxt.setBounds(55,310,190,25);
        adp.add(dateTxt);
        dateTxt.setBounds(365,310,190,25);

        adp.add(add);
        add.setBounds(200,410,90,25);
        adp.add(close);
        close.setBounds(310,410,90,25);

        adp.setBackground(Color.yellow);

        adj.setVisible(true);
        adj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        ReaderAdd.add1();
    }

}
