package com.mybm.staticviews.user;

import com.mybm.dao.UserDAO;
import com.mybm.pojo.Users;

import javax.swing.*;
import java.awt.*;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 19:29
 */
public class ModPsw extends JFrame {

    private JLabel[] l1;

    private JTextField[] f1;

    private JButton b1,b2;

    private JPanel panel,p1,p2;

    private UserDAO user;

    public ModPsw(String s){
        super(s);
        user=new UserDAO(Users.class);
        l1=new JLabel[4];
        f1=new JTextField[4];

        p1=new JPanel(new BorderLayout());
        p2=new JPanel();
        panel=new JPanel(new GridLayout(4,2,10,30));
//        panel.setBackground(Color.MAGENTA);
        p1.add(panel,BorderLayout.CENTER);
        p1.add(p2,BorderLayout.SOUTH);
        this.add(p1);

        this.setSize(500,300);
        b1=new JButton("添加");
        b2=new JButton("取消");
        p2.add(b1);
        p2.add(b2);
        String[] c=new String[]{"用户名","原密码","新密码","确认新密码"};
        for(int i=0;i<4;i++){
            l1[i]=new JLabel(c[i]);
            f1[i]=new JTextField();
            panel.add(l1[i]);
            panel.add(f1[i]);
        }
        b1.addActionListener(e -> {
            int is=0;
            try {
                is =user.UpdatePojo(new String[]{"password"},new String[]{"name"},new Object[]{f1[3].getText(),f1[0].getText()});
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if(is!=0){
                JOptionPane.showMessageDialog(null,"succ");
            }else {
                JOptionPane.showMessageDialog(null,"error");
            }
        });
        b2.addActionListener(e -> {
            this.dispose();
        });
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }



}
