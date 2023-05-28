import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.*;
public class HostelManagement implements ActionListener{
	JFrame f;
	JPanel p,homePanel,hp1,hp2,stuPanel,roomPanel;
	JLabel title,name,pass;
	JTextField username;
	JPasswordField password;
	JButton login,stuDetails,roomDetails,logOut,addStudent;
	JTable stuTable,roomTable;
	JButton close;
	DefaultTableModel tmodel,tmodel1;
	int flag,flag1;
	
	public HostelManagement(int x) 
	{
		flag=0;flag1=0;
		f = new JFrame("Hostel Management");
		f.setSize(800,500);
		f.setVisible(true);
		f.setLayout(null);
	}
	void loginPage()
	{
		p = new JPanel();
		f.add(p);
		p.setBounds(200,100,400,250);
		p.setLayout(null);
		p.setBackground(Color.LIGHT_GRAY);
		title = new JLabel("Login Page");
		p.add(title);
		title.setBounds(160,10,100,30);
		
		name = new JLabel("Username: ");
		p.add(name);
		name.setBounds(100,70,100,20);
		
		username = new JTextField();
		p.add(username);
		username.setBounds(200,70,150,20);
		
		pass = new JLabel("Password:");
		p.add(pass);
		pass.setBounds(100,100,100,20);
		
		password = new JPasswordField();
		p.add(password);
		password.setBounds(200,100,150,20);
		
		login = new JButton("Login");
		p.add(login);
		login.setBounds(160,150,100,30);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				p.setVisible(false);
				homePanel.setVisible(true);
				flag=0;flag1=0;
				tmodel.setRowCount(0);
				tmodel1.setRowCount(0);
			}
		});
		
	}
	public void homePage()
	{
		homePanel = new JPanel();
		f.add(homePanel);
		homePanel.setBounds(0,0,800,500);
		homePanel.setLayout(null);
		hp1 = new JPanel();
		homePanel.add(hp1);
		hp1.setBounds(0,0,250,500);
		hp1.setBackground(Color.gray);
		hp1.setLayout(null);
		roomDetails = new JButton("Room Details");
		hp1.add(roomDetails);
		roomDetails.setBounds(50, 50, 150, 50);
		roomDetails.addActionListener(this);
		
		stuDetails = new JButton("Student Details");
		hp1.add(stuDetails);
		stuDetails.setBounds(50,150,150,50);
		stuDetails.addActionListener(this);
		
		addStudent = new JButton("Add Student");
		hp1.add(addStudent);
		addStudent.setBounds(50,250,150,50);
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AddStudents add = new AddStudents();
				add.f.setVisible(true);
				stuPanel.setVisible(false);
				hp2.setVisible(true);
				flag = 0;
				tmodel.setRowCount(0);
			}
		});
		
		logOut = new JButton("Logout");
		hp1.add(logOut);		
		logOut.setBounds(50,350,150,50);
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				homePanel.setVisible(false);
				stuPanel.setVisible(false);
				p.setVisible(true);
			}
		});
		hp1.add(logOut);
		hp2 = new JPanel();
		homePanel.add(hp2);
		hp2.setBounds(250,0,550,470);
		hp2.setLayout(null);
		JLabel lb = new JLabel("Welcome");
		hp2.add(lb);
		lb.setBounds(230, 150, 200, 100);
		homePanel.setVisible(false);
		
	}
	public void dispStudents()
	{
		stuPanel = new JPanel();
		homePanel.add(stuPanel);
		stuPanel.setBounds(250,0,550,470);
		tmodel = new DefaultTableModel();
		stuTable = new JTable(tmodel);
		stuPanel.add(new JScrollPane(stuTable),BorderLayout.CENTER);
		tmodel.addColumn("RegNo");
		tmodel.addColumn("Name");
		tmodel.addColumn("RoomNo");
		stuTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		stuTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	String s = stuTable.getValueAt(stuTable.getSelectedRow(), 0).toString();
	        	System.out.println(s);
	        	JFrame f1;
	        	   JLabel title,name1,regno1,dept1,year1,roomno1,messFee1,hostelFee1;
	        	   JLabel name2,regno2,dept2,year2,roomno2,messFee2,hostelFee2;
	        	 
	        	   JButton close;
	        	   
	        	   f1 = new JFrame("Students Details");
	        	      f1.setSize(400,550);
	        	      f1.setVisible(true);
	        	      f1.setLayout(null);
	        	      title = new JLabel("Student Details");
	        	      f1.add(title);
	        	      title.setBounds(150,20,200,30);
	        	      name1 = new JLabel("Name: ");
	        	      f1.add(name1);
	        	      name2 = new JLabel("-");
	        	      f1.add(name2);
	        	      name1.setBounds(40,70,100,30);
	        	      name2.setBounds(160,70,200,30);
	        	      regno1 = new JLabel("RegNo:");
	        	      f1.add(regno1);
	        	      regno2 = new JLabel("-");
	        	      f1.add(regno2);
	        	      regno1.setBounds(40,120,100,30);
	        	      regno2.setBounds(160,120,200,30);
	        	      dept1 = new JLabel("Department: ");
	        	      dept2 = new JLabel("-");
	        	      f1.add(dept1);f1.add(dept2);
	        	      dept1.setBounds(40,170,100,30);
	        	      dept2.setBounds(160,170,200,30);
	        	      year1 = new JLabel("Year: ");
	        	      year2 = new JLabel("-");
	        	      f1.add(year1);f1.add(year2);
	        	      year1.setBounds(40,220,100,30);
	        	      year2.setBounds(160,220,200,30);
	        	      roomno1 = new JLabel("Room No: ");
	        	      roomno2 = new JLabel("-");  
	        	      f1.add(roomno1);f1.add(roomno2);
	        	      roomno1.setBounds(40,270,100,30);
	        	      roomno2.setBounds(160,270,200,30);
	        	      hostelFee1 = new JLabel("Hostel Fees: ");
	        	      hostelFee2 = new JLabel("-");
	        	      f1.add(hostelFee1);f1.add(hostelFee2);
	        	      hostelFee1.setBounds(40,320,100,30);
	        	      hostelFee2.setBounds(160,320,200,30);
	        	      messFee1 = new JLabel("Mess Fees: ");
	        	      messFee2 = new JLabel("-");
	        	      f1.add(messFee1);f1.add(messFee2);
	        	      messFee1.setBounds(40,370,100,30);
	        	      messFee2.setBounds(160,370,200,30);
	        	      close = new JButton("Close");
	        	      f1.add(close);
	        	      close.addActionListener(new ActionListener(){
		        	         public void actionPerformed(ActionEvent e)
		        	         {
		        	            f1.setVisible(false);
		        	            flag=0;flag1=0;
		        	            //tmodel.setRowCount(0);
		        	            tmodel1.setRowCount(0);
		        	         }   
		        	      });
	        	      close.setBounds(150,450,100,30);
	        	      Connection c = null;
	        		    Statement stmt = null;
	        		    String regno="",name="",roomno="",dept="",year="",hostelFee="",messFee="";
	        		      try {
	        		         Class.forName("org.postgresql.Driver");
	        		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HostelManagement","Admin", "123");
	        		         c.setAutoCommit(false);
	        		         System.out.println("Opened database successfully");
	        		         stmt = c.createStatement();
	        		         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"StudentDetails\" where \"RegNo\"='"+s+"';" );
	        		         while ( rs.next() ) {
	        		            regno = rs.getString("RegNo");
	        		            name = rs.getString("Name");
	        		            roomno = rs.getString("RoomNo");
	        		            dept = rs.getString("Dept");
	        		            year = rs.getString("Year");
	        		            hostelFee = rs.getString("HostelFess");
	        		            messFee = rs.getString("MessFess");
	        		         }
	        		         rs.close();
	        		         stmt.close();
	        		         c.close();
	        		      } catch ( Exception e1 ) {
	        		         System.err.println( e1.getClass().getName()+": "+ e1.getMessage() );
	        		        // System.exit(0);
	        		      } 
	        		      name2.setText(name);regno2.setText(regno);dept2.setText(dept);year2.setText(year);
	        		      roomno2.setText(roomno);hostelFee2.setText(hostelFee);messFee2.setText(messFee);
	        }
	    });
		stuPanel.setVisible(false);
		
		
	}
	public void dispRooms()
	{
		roomPanel = new JPanel();
		homePanel.add(roomPanel);
		roomPanel.setBounds(250,0,550,470);
		roomPanel.setVisible(false);
		tmodel1 = new DefaultTableModel();
		roomTable = new JTable(tmodel1);
		roomPanel.add(new JScrollPane(roomTable),BorderLayout.CENTER);
		tmodel1.addColumn("RoomNo");
		tmodel1.addColumn("Name");
		tmodel1.addColumn("RegNo");
		tmodel1.addColumn("Status");
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(roomTable.getModel());
        roomTable.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand()=="Student Details")
		{
			stuPanel.setVisible(true);
			hp2.setVisible(false);
			flag1=0;
			tmodel1.setRowCount(0);
			if (flag==0) {
			flag++;
			Connection c = null;
		    Statement stmt = null;
		    String regno,name,roomno;
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HostelManagement","Admin", "123");
		         c.setAutoCommit(false);
		         System.out.println("Opened database successfully");
		         stmt = c.createStatement();
		         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"StudentDetails\";" );
		         while ( rs.next() ) {
		            regno = rs.getString("RegNo");
		            name = rs.getString("Name");
		            roomno = rs.getString("RoomNo");
		            tmodel.addRow(new Object[] {regno,name,roomno});
		         }
		         rs.close();
		         stmt.close();
		         c.close();
		      } catch ( Exception e1 ) {
		         System.err.println( e1.getClass().getName()+": "+ e1.getMessage() );
		       //  System.exit(0);
		      }}
		}
		else if (e.getActionCommand()=="Room Details")
		{
			roomPanel.setVisible(true);
			stuPanel.setVisible(false);
			hp2.setVisible(false);
			tmodel.setRowCount(0);
			//tmodel1.setRowCount(0);
			flag=0;
			if (flag1==0) {
			flag1++;
			Connection c = null;
		    Statement stmt = null;
		    String regno,name,roomno,status;
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HostelManagement","Admin", "123");
		         c.setAutoCommit(false);
		         System.out.println("Opened database successfully");
		         stmt = c.createStatement();
		         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"RoomDetails\";" );
		         while ( rs.next() ) {
		            roomno = rs.getString("RoomNo");
		            name = rs.getString("StudentName");
		            regno = rs.getString("RegNo");
		            status = rs.getString("Status");
		            tmodel1.addRow(new Object[] {roomno,name,regno,status});
		            
		         }
		         rs.close();
		         stmt.close();
		         c.close();
		      } catch ( Exception e1 ) {
		         System.err.println( e1.getClass().getName()+": "+ e1.getMessage() );
		       //  System.exit(0);
		      }}
		}
		
	}
	public static void main(String[] args) {
		
		HostelManagement l = new HostelManagement(0);
		l.loginPage();
		l.homePage();
		l.dispStudents();
		l.dispRooms();
		
	}

}