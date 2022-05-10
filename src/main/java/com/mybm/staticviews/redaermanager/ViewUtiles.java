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
}
