package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

class attendance extends JFrame implements ActionListener,ItemListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i=0,y=60;
	int [] driver=new int[50];
	Calendar cal1;
	
	JLabel l1,l2,l3;
	String strdate;
	JPanel p;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	String str;
	
	JButton submit,home;
	
	JCheckBox cb[]=new JCheckBox[61];
	Font f=new Font("MS Sans Serif",1,35);
	Font f1=new Font("Arial",4,18);
	
	JComboBox cbox;
	
	Date date;
	GregorianCalendar cal;
	
	String a[]=new String[80];
	
	public attendance()
	{
		super("DRIVER ATTENDENCE ENTRY");
		setLocation(100,20);
		setSize(650,650);
		
		Container c=getContentPane();
		c.setLayout(null);

    	p=new JPanel();
	   	p.setLayout(null);
		p.setBorder(new LineBorder(Color.RED,1));
        p.setBackground(new Color(255,255,204));
		p.setBounds(10,10,615,595);
		c.add(p); 
	  
	  	l1=new JLabel(" Driver Attendance");
	  	l1.setFont(f);
	    l1.setBounds(150,-20,350,80);
	   	p.add(l1);
	    
	    submit=new JButton("SUBMIT");
	    submit.setMnemonic('S');
		submit.setFont(new Font("Arial",4,15));
		submit.setBounds(500,500,100,35);
		submit.addActionListener(this);
		p.add(submit);

	    home=new JButton("HOME");
	   	home.setMnemonic('H');
		home.setFont(new Font("Arial",4,15));
		home.setBounds(500,550,100,35);
		home.addActionListener(this);
		p.add(home); 	
	    
		l2=new JLabel("Date :-");
		l2.setFont(f1);
		l2.setBounds(460,45,80,30);
		p.add(l2);
	    
		date=new Date();
		cal=new GregorianCalendar();
		strdate=cal.get(Calendar.DATE)+" / "+(cal.get(Calendar.MONTH)+1)+" / "+(cal.get(Calendar.YEAR));
			    
		l3=new JLabel(strdate); 
		l3.setFont(new Font("Arial",4,15));   
		l3.setBounds(520,45,150,30);
		p.add(l3);
		
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=stmt.executeQuery("SELECT * FROM att") ;
			
			while(rs.next()) 
			{
				if(cal.get(Calendar.DATE)==rs.getInt(2))
		         {
		        	JOptionPane.showMessageDialog(null,"Attendance can perform at only once in a one day");
			  		dispose();
			        return ;
		         }
			} 
			
			rs = stmt.executeQuery("select * from driver");	 
			int count=0,z=0;
			while(rs.next()) 
			{
				count++;
			}	
			  
			if(count<8)
			    z=(int)180/count;
			else
			if(count<16&&count>7)
				z=(int)400/count;
			else
				z=(int)700/count;
			
			rs=stmt.executeQuery("select * from driver ORDER BY d_no");	 
			
			while(rs.next())
			{
				if(rs.getString(6).equals("no"))
			    {
			    	cb[i]=new JCheckBox(""+rs.getString(1)+" : "+rs.getString(2),true);
			     	cb[i].setBounds(80,y,300,20);
					cb[i].addItemListener(this);
					cb[i].setFont(f1);
					cb[i].setBackground(new Color(255,255,204));
					p.add(cb[i]);
					y=y+z;
			    }
			    else
			    {			     
			    	driver[i]=rs.getInt(1);					     		
			     	cb[i]=new JCheckBox(""+rs.getString(1)+" : "+rs.getString(2));
			     	cb[i].setBounds(80,y,300,20);
					cb[i].addItemListener(this);
					cb[i].setFont(f1);
					cb[i].setBackground(new Color(255,255,204));
					p.add(cb[i]);
					y=y+z;				
				}
				i++;
			}//while
			rs.close();
    		con.setAutoCommit(false);
    		con.commit();
    		con.close();	
		}//try
		catch(Exception s)
		{
			System.out.println(s);
		}
		setVisible(true);
	}	//  Constructor
	
	public void actionPerformed(ActionEvent e) {
		String but = e.getActionCommand();

		if (e.getSource() == submit) {
			int j = 0;

			try {

//			    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			    con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
				con = DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
				Statement st1 = con.createStatement();

				stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery("SELECT * FROM attendance");
				while (j < i && rs.next()) {
					if (cb[j].isSelected() == true) {
						int days = rs.getInt(2);
						days++;

						insert(rs.getInt(1), days);
						stmt.executeUpdate("UPDATE driver SET d_available='yes' WHERE d_no=" + driver[j]);
					} else {
//				        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			            con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
						con = DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
						Statement st = con.createStatement();

						st.executeUpdate("UPDATE driver SET d_available='absent' WHERE d_no=" + driver[j]);
					}
					j++;
				}
				st1.executeUpdate("UPDATE att SET flag=" + cal.get(Calendar.DATE) + " where id=1");

				JOptionPane.showMessageDialog(null, "ATTENDANCE PERFORM SUCCESSFULLY");
				con.setAutoCommit(false);
				con.commit();
				con.close();

				dispose();
			} catch (Exception b) {
				JOptionPane.showMessageDialog(null, "Attendance can perform at only once in a one day" + b);
				dispose();
			}
		} // if

		if (e.getSource() == home) {
			dispose();
		}
	} // actionPerformed

	void insert(int dno, int count) {
		try {
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con=DriverManager.getConnection("jdbc:odbc:transportationDSN");
			con = DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			stmt = con.createStatement();

			stmt.executeUpdate("UPDATE attendance SET days=" + count + " where dr_no=" + dno);
			con.setAutoCommit(false);
		} // Con try

		catch (Exception k) {
			JOptionPane.showMessageDialog(null, k);
		}

	}

	public void itemStateChanged(ItemEvent IE) {
	}

	public static void main(String args[]) {
		new attendance();
	}
}			//	end of class

