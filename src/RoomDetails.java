import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoomDetails implements ActionListener
{
   JFrame f;
   JLabel name1,regno1,floor1,year1,roomno1,messFee1,hostelFee1;
   JLabel name2,regno2,floor2,year2,roomno2,messFee2,hostelFee2;
   JButton close;
   public RoomDetails()
   {
      f = new JFrame("Details");
      f.setSize(400,200);
      f.setVisible(true);
      f.setLayout(null);
      name1 = new JLabel("Name: ");
      name2 = new JLabel("Gowtham C");
      name1.setBounds(50,50,50,20);
      name2.setBounds(100,50,80,20);
      regno1 = new JLabel("RegNo:");
      regno2 = new JLabel("2012076");
      regno1.setBounds(220,50,60,20);
      regno2.setBounds(280,50,60,20);
      floor1 = new JLabel("Floor: ");
      floor2 = new JLabel("II");
      floor1.setBounds(220,20,60,20);
      floor2.setBounds(280,20,30,20);
      roomno1 = new JLabel("Room No: ");
      roomno2 = new JLabel("103");      
      roomno1.setBounds(50,20,85,20);
      roomno2.setBounds(135,20,30,20);
      close = new JButton ("Close");
      close.setBounds(150,110,80,25);
      close.addActionListener(this);
      f.add(name1);f.add(name2);
      f.add(regno1);f.add(regno2);
      f.add(floor1);f.add(floor2);
      
      f.add(roomno1);f.add(roomno2);
      f.add(close);
   }
   public void actionPerformed(ActionEvent e)
   {
      f.setVisible(false);   
   }
   public static void main(String arg[])
   {
      RoomDetails s = new RoomDetails();
   }
}