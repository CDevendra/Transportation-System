package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class login extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet rs;
	static int cnt=1;
	boolean flag=true;
	
	JPanel jpanel1;
	JPanel jpanel2;
	
	JLabel jlabelloginlabel;	
	JLabel jlabelusername;
	JLabel jlabelpassword;
	
	JTextField jtextusername;
	JPasswordField jtextpassword;
	
	JButton ok;
	JButton cancel;

	public login()
	{	
		super("System Operator's Login");
		setBounds(320,200,400,300);
		setLayout(null);
		setResizable(false);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new LineBorder(new Color(255, 0, 51)));
		jpanel1.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 10, 370, 140);
 
		jlabelloginlabel=new JLabel();
        jlabelloginlabel.setFont(new Font("MS Sans Serif", 1, 18));
        jlabelloginlabel.setText("Transportation  Systems");
        jlabelloginlabel.setBounds(80 ,-35, 500, 100);
        jpanel1.add(jlabelloginlabel); 
        
        jlabelusername=new JLabel();
        jlabelusername.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelusername.setText("ENTER  USER NAME");
        jlabelusername.setBounds(20 ,15, 150, 100);
        jpanel1.add(jlabelusername);
      
        jtextusername=new JTextField(20);
        jtextusername.setFont(new Font("Courier New", 1, 16));
        jpanel1.add(jtextusername);
        jtextusername.setBounds(150,50,200,30);
     
        jlabelpassword=new JLabel();
        jlabelpassword.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelpassword.setText("ENTER  PASSWORD");
        jlabelpassword.setBounds(20 ,55, 150, 100);
        jpanel1.add(jlabelpassword);

        jtextpassword=new JPasswordField(20);
        jtextpassword.setFont(new Font("Courier New", 1, 16));
        jpanel1.add(jtextpassword);
        jtextpassword.setBounds(150,90,200,30);
        
         jpanel2=new JPanel();
		jpanel2.setLayout(null);
		jpanel2.setBorder(new LineBorder(new Color(255, 0, 51)));
		jpanel2.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel2);
        jpanel2.setBounds(10, 160, 370, 100);
   
        ok=new JButton("OK",new ImageIcon(login.class.getResource("../../../images/keys.gif")));
        ok.setToolTipText("Login Button.");
        jpanel2.add(ok);
        ok.setBounds(20, 25, 150, 60);

        cancel=new JButton("CANCEL",new ImageIcon(login.class.getResource("../../../images/exit.png")));
        cancel.setToolTipText("Cancel.");
        jpanel2.add(cancel);
        cancel.setBounds(200, 25, 150, 60);
       
        ok.addActionListener(this);
		cancel.addActionListener(this);
     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	public void setconnection()
	{
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con=DriverManager.getConnection("jdbc:odbc:transportationDSN");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			st=con.createStatement();
			con.setAutoCommit(false);
		}
		catch(Exception e)
		{
			String dt="ERROR";
			String dm="ERROR:"+e;
			int dtype=JOptionPane.ERROR_MESSAGE;
			JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
		}
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String s1=a.getActionCommand();
		if(s1.equals("CANCEL"))
		{
			System.exit(0);
		}
		else 
		if(s1.equals("OK"))
		{
			try
			{
				String s2=jtextusername.getText();
				String s3=jtextpassword.getText();
				
				setconnection(); 
				
				rs=st.executeQuery("select * from Login");
				
				whileloop:while(rs.next())
				{	
					cnt++;
					if(s2.equals(rs.getString(1)))
					{
						if(s3.equals(rs.getString(2)))
						{
							flag=true;
							mainwindow main=new mainwindow();
							setVisible(false);
							break whileloop;
						}
						else
						{
							String dt="ERROR";
							String dm="INVALID PASSWORD";
							int dtype=JOptionPane.ERROR_MESSAGE;
							JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
						
							jtextusername.setText("");
							jtextpassword.setText("");
						}
					}
					else
					{
						flag=false;
					}
					
				}
				
				if(flag==false)
				{
					if(cnt>3)
						 {
		 					JOptionPane.showMessageDialog(null,"Limit Occurs ,Please Login again");
		 					System.exit(0);
		 				}
					String dt="ERROR";
					String dm="INVALID USERNAME";
					int dtype=JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
				
					jtextusername.setText("");
					jtextpassword.setText("");
				}
				con.commit();
   				con.close();
			}
			catch(Exception e)
			{
				String dt="ERROR";
				String dm="SQL ERROR:"+e;
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
			
				jtextpassword.setText("");
			}
		}
	}
}
