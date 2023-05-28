import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class StudentDetails implements ActionListener
{
   JFrame f;
   JLabel name1,regno1,dept1,year1,roomno1,messFee1,hostelFee1;
   JLabel name2,regno2,dept2,year2,roomno2,messFee2,hostelFee2;
   JButton close;
   String selreg = "2012074";
   public StudentDetails(String s)
   {
	  selreg = s;
      f = new JFrame("Details");
      f.setSize(500,200);
      f.setVisible(true);
      f.setLayout(null);
      name1 = new JLabel("Name: ");
      name2 = new JLabel("-");
      f.add(name1);f.add(name2);
      name1.setBounds(50,20,50,20);
      name2.setBounds(100,20,80,20);
      regno1 = new JLabel("RegNo:");
      regno2 = new JLabel("-");
      f.add(regno1);f.add(regno2);
      regno1.setBounds(220,20,60,20);
      regno2.setBounds(280,20,60,20);
      dept1 = new JLabel("Department: ");
      dept2 = new JLabel("-");
      f.add(dept1);f.add(dept2);
      dept1.setBounds(50,50,100,20);
      dept2.setBounds(150,50,30,20);
      year1 = new JLabel("Year: ");
      year2 = new JLabel("-");
      f.add(year1);f.add(year2);
      year1.setBounds(220,50,50,20);
      year2.setBounds(270,50,60,20);
      roomno1 = new JLabel("Room No: ");
      roomno2 = new JLabel("-");   
      f.add(roomno1);f.add(roomno2);
      roomno1.setBounds(50,80,85,20);
      roomno2.setBounds(135,80,60,20);
      hostelFee1 = new JLabel("Hostel Fees: ");
      hostelFee2 = new JLabel("-");
      f.add(hostelFee1);f.add(hostelFee2);
      hostelFee1.setBounds(220,80,100,20);
      hostelFee2.setBounds(320,80,50,20);
      messFee1 = new JLabel("Mess Fees: ");
      messFee2 = new JLabel("-");
      f.add(messFee1);f.add(messFee2);
      f.add(close);
      messFee1.setBounds(50,110,100,20);
      messFee2.setBounds(150,110,50,20);
      f.add(messFee1);f.add(messFee2);
      close = new JButton ("Close");
      f.add(close);
      close.setBounds(220,110,80,25);
      close.addActionListener(this);
      
      
      
      Connection c = null;
	    Statement stmt = null;
	    String regno="",name="",roomno="",dept="",year="",hostelFee="",messFee="";
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HostelManagement","Admin", "123");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         stmt = c.createStatement();
	         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"StudentDetails\" where \"RegNo\"='"+selreg+"';" );
	         while ( rs.next() ) {
	            regno = rs.getString("RegNo");
	            name = rs.getString("Name");
	            roomno = rs.getString("RoomNo");
	            dept = rs.getString("Dept");
	            year = rs.getString("Year");
	            hostelFee = rs.getString("HostelFees");
	            messFee = rs.getString("MessFees");
	         }
	         rs.close();
	         stmt.close();
	         c.close();
	      } catch ( Exception e1 ) {
	         System.err.println( e1.getClass().getName()+": "+ e1.getMessage() );
	         System.exit(0);
	      } 
	      name2.setText(name);regno2.setText(regno);dept2.setText(dept);year2.setText(year);
	      roomno2.setText(roomno);hostelFee2.setText(hostelFee);messFee2.setText(messFee);
   }
   public void actionPerformed(ActionEvent e)
   {
	   
      f.setVisible(false);   
   }
   public static void main(String arg[])
   {
     // StudentDetails s = new StudentDetails();
   }
}