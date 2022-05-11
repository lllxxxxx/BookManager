package com.mybm.staticviews.redaermanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author: lllxxx
 * @description:
 * @date: 2022/5/9 8:37
 */
public class ViewUtiles {
    public static void bottom(String[] labels ,String[] butts, JPanel panel,JLabel[] jLabel,JTextField[] field,JButton[] buttons,int lab,int bot,ActionListener th){
        panel.setLayout(new BorderLayout());
        JPanel paneltop=new JPanel(new GridLayout(2,4,10,10));
        JPanel panelbot=new JPanel();
        jLabel=new JLabel[lab];
        buttons=new JButton[bot];
//        field=new JTextField[lab];
        for (int i = 0; i < lab; i++) {
            jLabel[i]=new JLabel(labels[i]);
            field[i]=new JTextField(5);
            paneltop.add(jLabel[i]);
            paneltop.add(field[i]);
        }
        panel.add(paneltop,BorderLayout.CENTER);
        panel.add(panelbot,BorderLayout.SOUTH);
        for (int i = 0; i < bot; i++) {
            buttons[i]=new JButton(butts[i]);
            buttons[i].addActionListener(th);
            panelbot.add(buttons[i]);
        }
    }

    public static void bottom2(String[] labels ,String[] butts, JPanel panel,JLabel[] jLabel,JTextField[] field,JButton[] buttons,JRadioButton[] ratio,JComboBox comboBox,ActionListener th){
        panel.setLayout(new BorderLayout());
        JPanel paneltop=new JPanel(new GridLayout(4,4,10,10));
//        JPanel paneltop=new JPanel(new FlowLayout(4));
        JPanel panelbot=new JPanel(new FlowLayout());
        JPanel small=new JPanel(new GridLayout(1,2));
        jLabel=new JLabel[8];
        buttons=new JButton[2];
//        field=new JTextField[lab];
        for (int i = 0; i < 2; i++) {
            jLabel[i]=new JLabel(labels[i]);
            field[i]=new JTextField(5);
            paneltop.add(jLabel[i]);
            paneltop.add(field[i]);
        }
        jLabel[2]=new JLabel(labels[2]);
        jLabel[3]=new JLabel(labels[3]);
        paneltop.add(jLabel[2]);
        comboBox.addItem("教师");
        comboBox.addItem("学生");
        paneltop.add(comboBox);
        ButtonGroup group=new ButtonGroup();
        group.add(ratio[0]);
        group.add(ratio[1]);
        paneltop.add(jLabel[3]);
        small.add(ratio[0]);
        small.add(ratio[1]);
        paneltop.add(small);

        for (int i = 4; i < 8; i++) {
            jLabel[i]=new JLabel(labels[i]);
            field[i-2]=new JTextField(5);
            paneltop.add(jLabel[i]);
            paneltop.add(field[i-2]);
        }

        panel.add(paneltop,BorderLayout.CENTER);
        panel.add(panelbot,BorderLayout.SOUTH);
        for (int i = 0; i < 2; i++) {
            buttons[i]=new JButton(butts[i]);
            buttons[i].addActionListener(th);
            panelbot.add(buttons[i]);
        }
    }
}
