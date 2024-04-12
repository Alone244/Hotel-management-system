import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener {
Choice ccustomer;

JTextField troom,tname,tcheck,tpaid,tpending;

JButton check,update,back;
UpdateCheck(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel text = new JLabel("Update status");
    text.setFont(new Font("Tahoma",Font.PLAIN,20));
    text.setBounds(90,20,200,30);
    text.setForeground(Color.BLUE);
    add(text);

    ccustomer = new Choice();
    ccustomer.setBounds(200,80,150,25);
    add(ccustomer);

    JLabel lblid = new JLabel("Update status");
    lblid.setBounds(30,80,100,20);
    add(lblid);

    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("select * from customer");
        while(rs.next()){
            ccustomer.add(rs.getString("number"));
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
    JLabel lblroom = new JLabel("Room number");
    lblroom.setBounds(30,120,100,20);
    add(lblroom);

    troom = new JTextField();
    troom.setBounds(200,120,150,25);
    add(troom);

    JLabel lblname = new JLabel("Name");
    lblname.setBounds(30,160,100,20);
    add(lblname);

    tname = new JTextField();
    tname.setBounds(200,160,150,25);
    add(tname);

    JLabel checkin = new JLabel("Check-in time");
    checkin.setBounds(30,200,100,20);
    add(checkin);

    tcheck = new JTextField();
    tcheck.setBounds(200,200,150,25);
    add(tcheck);

    JLabel lblpaid = new JLabel("Check-in time");
    lblpaid.setBounds(30,240,100,20);
    add(lblpaid);

    tpaid = new JTextField();
    tpaid.setBounds(200,240,150,25);
    add(tpaid);

    JLabel lblpending = new JLabel("Check-in time");
    lblpending.setBounds(30,280,100,20);
    add(lblpending);

    tpending = new JTextField();
    tpending.setBounds(200,280,150,25);
    add(tpending);

    check = new JButton("Check");
    check.setBackground(Color.BLACK);
    check.setForeground(Color.WHITE);
    check.setBounds(30,340,100,30);
    check.addActionListener(this);
    add(check);

    update = new JButton("Update");
    update.setBackground(Color.BLACK);
    update.setForeground(Color.WHITE);
    update.setBounds(150,340,100,30);
    update.addActionListener(this);
    add(update);

    back = new JButton("Back");
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setBounds(270,340,100,30);
    back.addActionListener(this);
    add(back);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
    JLabel image = new JLabel(i1);
    image.setBounds(400,50,500,300);
    add(image);

    setBounds(300,200,980,500);
    setVisible(true);
}

public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == check){
        String id = ccustomer.getSelectedItem();
        String query = "select * from customer where number = '"+id+"' ";
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                troom.setText(rs.getString("room"));
                tname.setText(rs.getString("name"));
                tcheck.setText(rs.getString("checkintime"));
                tpaid.setText(rs.getString("deposit"));
            }
            ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+troom.getText()+"'");
            while(rs2.next()){
                String  price= rs2.getString("price");
                int amountpaid = Integer.parseInt(price) - Integer.parseInt(tpaid.getText());
                tpending.setText(""+amountpaid);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    else if(ae.getSource() == update){
        String number = ccustomer.getSelectedItem();
        String room = troom.getText();
        String name = tname.getText();
        String checkin = tcheck.getText();
        String deposit = tpaid.getText();

        try{
            Conn c = new Conn();
            c.s.executeUpdate("update customer set room = '"+room+"',name = '"+name+"',deposit = '"+deposit+"' where roomnumber = '"+number+"'");
            JOptionPane.showMessageDialog(null,"Data updated succesfully");

            setVisible(false);
            new Reception();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    else if(ae.getSource() == back){
        setVisible(false);
        new Reception();
    }
}
public static void main(String[] args){
    new UpdateCheck();
}

}
