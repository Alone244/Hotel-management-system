import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener {
    JButton newCustomer,rooms,department,allEmployee,customers,managerInfo,checkout,update,roomstatus,Pickup,searchroom,logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        newCustomer =new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms =new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);

         department =new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);

         allEmployee =new JButton("ALL Employee");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.white);
        allEmployee.addActionListener(this);
        add(allEmployee);

         customers = new JButton("Customers Info");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.black);
        customers.setForeground(Color.white);
        customers.addActionListener(this);
        add(customers);

         managerInfo =new JButton("Manager Info");
        managerInfo.setBounds(10,230,200,30);
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.white);
        managerInfo.addActionListener(this);
        add(managerInfo);

         checkout =new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);

         update =new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

         roomstatus =new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.black);
        roomstatus.setForeground(Color.white);
        roomstatus.addActionListener(this);
        add(roomstatus);

         Pickup =new JButton("Pickup Services");
        Pickup.setBounds(10,390,200,30);
        Pickup.setBackground(Color.black);
        Pickup.setForeground(Color.white);
        Pickup.addActionListener(this);
        add(Pickup);


        searchroom =new JButton("Search room");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        searchroom.addActionListener(this);
        add(searchroom);

         logout =new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        ImageIcon il= new ImageIcon(ClassLoader.getSystemResource("icons/Fourth.jpg"));
        JLabel image =new JLabel(il);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200,800,570);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == newCustomer){
            new addcustomer();
        }
        else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()== department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == allEmployee){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource() == customers){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource() == roomstatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource() == Pickup){
            setVisible(false);
            new updateDriver();
        }
        else if(ae.getSource() == searchroom){
            setVisible(false);
            new searchRoom();
        }
        else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource() == logout){
            System.exit(0);
            setVisible(false);
        }
    }
    public static void main (String[] args){
        new Reception();
    }
}