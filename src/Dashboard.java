
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard() {
        setBounds(0,0,1550,1000);

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel = new JMenu("Hotel Management");
        hotel.setForeground(Color.RED);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);



        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addEmployee = new JMenuItem("Add Employee");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        JMenuItem addrooms = new JMenuItem("Add room");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem addDriver = new JMenuItem("Add Driver");
        addDriver.addActionListener(this);
        admin.add(addDriver);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Add Employee")){
            new AddEmployee();
    }
        else if(ae.getActionCommand().equals("Add room")){
            new AddRooms();
        }
        else if(ae.getActionCommand().equals("Add Driver")){
            new AddDriver();
        }
        else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }

    }

    public static void main(String[] args){
        new Dashboard();
    }
}
