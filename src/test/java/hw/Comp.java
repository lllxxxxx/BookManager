package hw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: lllxxx
 * @description:
 * @date: 2022/5/10 12:51
 */
public class Comp extends JFrame implements ActionListener {

    private JLabel label1,label2;
    private JButton button1,button2;
    private JPanel panel;
    private JTextField field1,field2;

    public Comp(){
        label1=new JLabel("第一个数字");
        label2=new JLabel("第二个数字");
        panel=new JPanel(new FlowLayout());
        button1=new JButton("相加");
        button2=new JButton("退出");
        field1=new JTextField(10);
        field2=new JTextField(10);
        add(panel);
        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);
        panel.add(button1);
        panel.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);
        setSize(250,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            int a= Integer.parseInt(field1.getText().trim());
            int b= Integer.parseInt(field2.getText().trim());
            JOptionPane.showMessageDialog(null,a+b);
        }else {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Comp();
    }
}
