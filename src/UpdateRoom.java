import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.imageio.stream.ImageInputStreamImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice ccustomer;

    JTextField troom,tavailable,tstatus,tpaid,tpending;

    JButton check,update,back;
    UpdateRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Update Room status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);

        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        JLabel lblid = new JLabel("Customer id");
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
        lblroom.setBounds(30,130,100,20);
        add(lblroom);

        troom = new JTextField();
        troom.setBounds(200,130,150,25);
        add(troom);

        JLabel lblname = new JLabel("Availability");
        lblname.setBounds(30,180,100,20);
        add(lblname);

        tavailable = new JTextField();
        tavailable.setBounds(200,180,150,25);
        add(tavailable);

        JLabel checkin = new JLabel("Cleaning status");
        checkin.setBounds(30,230,100,20);
        add(checkin);

        tstatus = new JTextField();
        tstatus.setBounds(200,230,150,25);
        add(tstatus);

        check = new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
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
                }

                ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = '"+troom.getText()+"'");
                while(rs2.next()){
                    tavailable.setText(rs2.getString("availability"));
                    tstatus.setText(rs2.getString("cleaning_status"));
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = troom.getText();
            String available = tavailable.getText();
            String status = tstatus.getText();

            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability = '"+available+"',cleaning_status = '"+status+"' where roomnumber ='"+room+"' ");
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
        new UpdateRoom();
    }

}
