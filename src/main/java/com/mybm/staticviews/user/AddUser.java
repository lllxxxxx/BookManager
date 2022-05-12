package com.mybm.staticviews.user;

import com.mybm.dao.UserDAO;

import javax.swing.*;
import java.awt.*;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 19:47
 */
public class AddUser extends JFrame {


    private JLabel[] l1;

    private JTextField[] f1;

    private JButton b1,b2;

    private JPanel panel,p1,p2;

    public AddUser(String s){
        super(s);
        l1=new JLabel[2];
        f1=new JTextField[2];

        p1=new JPanel(new BorderLayout());
        p2=new JPanel();
        panel=new JPanel(new GridLayout(2,2,10,30));
//        panel.setBackground(Color.MAGENTA);
        p1.add(panel,BorderLayout.CENTER);
        p1.add(p2,BorderLayout.SOUTH);
        this.add(p1);

        this.setSize(500,300);
        b1=new JButton("添加");
        b2=new JButton("取消");
        p2.add(b1);
        p2.add(b2);
        b1.addActionListener(e -> {
            Boolean is=false;
            try {
                is=UserDAO.AddUser(f1[0].getText(),f1[1].getText());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if(is){
                JOptionPane.showMessageDialog(null,"succ");
            }else {
                JOptionPane.showMessageDialog(null,"error");
            }
        });
        b2.addActionListener(e -> {
            this.dispose();
        });
        String[] c=new String[]{"用户名","密码"};
        for(int i=0;i<2;i++){
            l1[i]=new JLabel(c[i]);
            f1[i]=new JTextField();
            panel.add(l1[i]);
            panel.add(f1[i]);
        }
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}
