import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class AddStudents implements ActionListener
{
   JFrame f;
   JLabel title,name1,regno1,dept1,year1,roomno1,messFee1,hostelFee1;
   JTextField name2,regno2,dept2,year2,roomno2,messFee2,hostelFee2;
   JButton submit,close;
   public AddStudents()
   {
	   f = new JFrame("Add Students");
	      f.setSize(400,550);
	      f.setVisible(true);
	      f.setLayout(null);
	      title = new JLabel("Enter Student Details");
	      f.add(title);
	      title.setBounds(130,20,200,30);
	      name1 = new JLabel("Name: ");
	      f.add(name1);
	      name2 = new JTextField();
	      f.add(name2);
	      name1.setBounds(40,70,100,30);
	      name2.setBounds(160,70,200,30);
	      regno1 = new JLabel("RegNo:");
	      f.add(regno1);
	      regno2 = new JTextField();
	      f.add(regno2);
	      regno1.setBounds(40,120,100,30);
	      regno2.setBounds(160,120,200,30);
	      dept1 = new JLabel("Department: ");
	      dept2 = new JTextField();
	      f.add(dept1);f.add(dept2);
	      dept1.setBounds(40,170,100,30);
	      dept2.setBounds(160,170,200,30);
	      year1 = new JLabel("Year: ");
	      year2 = new JTextField();
	      f.add(year1);f.add(year2);
	      year1.setBounds(40,220,100,30);
	      year2.setBounds(160,220,200,30);
	      roomno1 = new JLabel("Room No: ");
	      roomno2 = new JTextField();  
	      f.add(roomno1);f.add(roomno2);
	      roomno1.setBounds(40,270,100,30);
	      roomno2.setBounds(160,270,200,30);
	      hostelFee1 = new JLabel("Hostel Fees: ");
	      hostelFee2 = new JTextField();
	      f.add(hostelFee1);f.add(hostelFee2);
	      hostelFee1.setBounds(40,320,100,30);
	      hostelFee2.setBounds(160,320,200,30);
	      messFee1 = new JLabel("Mess Fees: ");
	      messFee2 = new JTextField();
	      f.add(messFee1);f.add(messFee2);
	      messFee1.setBounds(40,370,100,30);
	      messFee2.setBounds(160,370,200,30);
	      close = new JButton("Close");
	      f.add(close);
	      close.addActionListener(new ActionListener() {
	    	  public void actionPerformed(ActionEvent ev)
	    	  {
	    		  f.setVisible(false);
	    	  }
	      });
	      close.setBounds(80,450,100,30);
	      submit = new JButton ("Add");
	      f.add(submit);
	      submit.setBounds(230,450,100,30);
	      submit.addActionListener(this);

   }
   public void actionPerformed(ActionEvent e)
   {
      String name,regno,dept,year,roomno,hostelFee,messFee;
      name = name2.getText().toString();
      regno = regno2.getText().toString();
      dept = dept2.getText().toString();
      year = year2.getText().toString();
      roomno = roomno2.getText().toString();
      hostelFee = hostelFee2.getText().toString();
      messFee = messFee2.getText().toString();
      
      Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HostelManagement","Admin", "123");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");
         String que = "INSERT INTO \"StudentDetails\"(\"RegNo\",\"Name\", \"Dept\", \"Year\", \"RoomNo\", \"HostelFess\", \"MessFess\")"    
        			+"VALUES (?, ?, ?, ?, ?, ?, ?);";
 
         PreparedStatement pst = c.prepareStatement(que);
         pst.setString(1, regno);
         pst.setString(2, name);
         pst.setString(3, dept);
         pst.setString(4, year);
         pst.setString(5, roomno);
         pst.setString(6, hostelFee);
         pst.setString(7, messFee);
         pst.executeUpdate();
         
         que = "UPDATE public.\"RoomDetails\" SET \"StudentName\"=?, \"RegNo\"=?, \"Status\"=?"
         		+ "	WHERE \"RoomNo\"=?;";
         pst = c.prepareStatement(que);
         pst.setString(1, name);
         pst.setString(2, regno);
         pst.setString(3, "Occupied");
         pst.setString(4, roomno);
         pst.executeUpdate();         
         c.commit();
         c.close();
         
      }
      catch (Exception e1)
      {
    	  System.err.println( e1.getClass().getName()+": "+ e1.getMessage() );
          System.exit(0);
      }
      name2.setText("");regno2.setText("");dept2.setText("");year2.setText("");
      roomno2.setText("");hostelFee2.setText("");messFee2.setText("");
     // new HostelManagement();
      System.out.println("SUcces");

   }
   public static void main(String arg[])
   {
      AddStudents s = new AddStudents();
   }
}
