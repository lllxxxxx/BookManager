package hw;

import com.mybm.staticviews.redaermanager.ViewUtiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: lllxxx
 * @description:
 * @date: 2022/5/10 9:58
 */
public class compu extends JFrame implements ActionListener {

    private JLabel[] labels;
    private JButton[] buttons;
    private JTextField[] fields;
    private JPanel panel;

    public compu(){
        String[] lab=new String[]{"第一个数字","第二个数字"};
        String[] but=new String[]{"相加","退出"};
        panel=new JPanel();
        fields=new JTextField[2];
        ViewUtiles.bottom(lab,but,panel,labels,fields,buttons,2,2,this);
        this.setSize(300,200);
        this.add(panel);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source.getText().equals("add")){
            JOptionPane.showMessageDialog(null,Integer.parseInt(fields[0].getText())+Integer.parseInt(fields[1].getText()));
        }else {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new compu();

    }
}
