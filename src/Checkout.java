import com.sun.net.httpserver.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

public class Checkout  extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel lblroomno,checkintime,checkouttime;

    JButton checkout,back;
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);

        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30,80,100,30);
        add(lblid);

        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        JLabel lblroom = new JLabel("Room number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);

        lblroomno = new JLabel();
        lblroomno.setBounds(150,130,100,30);
        add(lblroomno);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30,180,100,30);
        add(lblcheckin);

        checkintime = new JLabel();
        checkintime.setBounds(150,180,100,30);
        add(checkintime);

        JLabel lblcheckout = new JLabel("Checkout Time");
        lblcheckout.setBounds(30,230,100,30);
        add(lblcheckout);

        checkouttime = new JLabel();
        checkouttime.setBounds(200,230,100,30);
        add(checkouttime);

        Date date = new Date();
        checkouttime = new JLabel(""+date);
        checkouttime.setBounds(150,230,150,30);
        add(checkouttime);

        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        checkout.addActionListener(this);
        add(back);


        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                lblroomno.setText(rs.getString("room"));
                checkintime.setText(rs.getString("checkintime"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,400,250);
        add(image);

        setBounds(300,200,800,400);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout){
            String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
            String query2 = "update room set availability = 'Available' where roomnumber = '"+lblroomno.getText()+"'";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null, "Successfull checkout");
                setVisible(false);
                new Reception();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new Checkout();
    }
}
