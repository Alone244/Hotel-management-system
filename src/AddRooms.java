import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddRooms extends JFrame implements ActionListener {

    JButton add,cancel;
    JTextField troom,tprice;
    JComboBox caval,cclean,ctype;
    AddRooms(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblroom = new JLabel("Room number");
        lblroom.setFont(new Font("Tahoma", Font.PLAIN,18));
        lblroom.setBounds(60,80,120,30);
        add(lblroom);

        troom = new JTextField();
        troom.setBounds(200,80,150,30);
        add(troom);


        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN,18));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);

        String aval[] = {"Available", "Occupied"};
        caval = new JComboBox(aval);
        caval.setBounds(200,130,150,30);
        caval.setBackground(Color.WHITE);
        add(caval);

        JLabel lblclean = new JLabel("Cleaning status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN,18));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String sclean[] = {"Cleaned", "Dirty"};
        cclean = new JComboBox(sclean);
        cclean.setBounds(200,180,150,30);
        cclean.setBackground(Color.WHITE);
        add(cclean);

        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN,18));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

        tprice = new JTextField();
        tprice.setBounds(200,230,150,30);
        add(tprice);

        JLabel lbltype = new JLabel("Bed type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN,18));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        String typeOptions[] = {"Single bed", "Double bed"};
        ctype = new JComboBox(typeOptions);
        ctype.setBounds(200,280,150,30);
        ctype.setBackground(Color.WHITE);
        add(ctype);

        add = new JButton("Add Room");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(330,200,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String roomnumber = troom.getText();
            String availability = (String) caval.getSelectedItem();
            String status = (String) cclean.getSelectedItem();
            String price = tprice.getText();
            String type = (String) ctype.getSelectedItem();

            try{
                Conn conn = new Conn();
                String str = "insert into room values('"+roomnumber+"', '" +availability+"','"+status+"','"+price+"','"+type+"')";

                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null,"New room added successfully");
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddRooms();
    }
}
