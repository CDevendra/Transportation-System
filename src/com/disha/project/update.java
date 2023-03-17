package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class update extends JFrame implements ActionListener
{
	
	Connection con;
	ResultSet rs;
	
	JPanel jpanel1;
	JPanel jpanel2;
	
	JLabel jlabelupdatelabel;	
	JLabel jlabeld_no;
	JLabel jlabelv_no;
	
	JTextField jtextd_no;
	JTextField jtextv_no;
	
	JButton jbuttonupdate;
	JButton jbuttoncancel;

	public update()
	{	
		setTitle("Updation Process");
		setBounds(350,200,405,305);
		setLayout(null);
		setResizable(false);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel1.setBackground(new Color(255,255,204));
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 10, 370, 140);
 
		jlabelupdatelabel=new JLabel();
        jlabelupdatelabel.setFont(new Font("MS Sans Serif", 1, 22));
        jlabelupdatelabel.setText("UPDATION");
        jlabelupdatelabel.setBounds(130 ,-35, 250, 100);
        jpanel1.add(jlabelupdatelabel); 

        jlabelv_no=new JLabel();
        jlabelv_no.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelv_no.setText("ENTER  VEHICLE  NO");
        jlabelv_no.setBounds(20 ,15, 150, 100);
        jpanel1.add(jlabelv_no);
       
        jtextv_no=new JTextField(20);
        jtextv_no.setFont(new Font("Courier New", 1, 16));
        jpanel1.add(jtextv_no);
        jtextv_no.setBounds(170,50,100,30);
        
        jlabeld_no=new JLabel();
        jlabeld_no.setFont(new Font("MS Sans Serif", 1, 12));
        jlabeld_no.setText("ENTER  DRIVER  NO");
        jlabeld_no.setBounds(20 ,55, 150, 100);
        jpanel1.add(jlabeld_no);
      
        jtextd_no=new JTextField(20);
        jtextd_no.setFont(new Font("Courier New", 1, 16));
        jpanel1.add(jtextd_no);
        jtextd_no.setBounds(170,90,100,30);
           
        jpanel2=new JPanel();
		jpanel2.setLayout(null);
		jpanel2.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel2.setBackground(new Color(255,255,204));
        getContentPane().add(jpanel2);
        jpanel2.setBounds(10, 160, 370, 100);
   
        jbuttonupdate=new JButton();
        jbuttonupdate=new JButton("   UPDATE",new ImageIcon(update.class.getResource("../../../images/update.png")));
        jbuttonupdate.setToolTipText("Update the DATABASE.");
        jbuttonupdate.setBackground(Color.black);
        jbuttonupdate.setForeground(Color.white);
        jpanel2.add(jbuttonupdate);
        jbuttonupdate.setBounds(20, 25, 150, 60);
        jbuttonupdate.addActionListener(this);
        
        jbuttoncancel=new JButton();
        jbuttoncancel.setText("CANCEL");
        jbuttoncancel.setToolTipText("Cancel.");
        jbuttoncancel.setBackground(Color.black);
        jbuttoncancel.setForeground(Color.white);
        jpanel2.add(jbuttoncancel);
        jbuttoncancel.setBounds(200, 25, 150, 60);
        jbuttoncancel.addActionListener(this);
       
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        if(source.equals(jbuttonupdate))
        {
        	try
        	{
        		setconnection();
        		
        		Statement st1;
        		Statement st2;
        		Statement st3;
        		
        		st1=con.createStatement();
        		st2=con.createStatement();
        		st3=con.createStatement();
        		
        		int driver_no=Integer.parseInt(jtextd_no.getText());
        		int vehicle_no=Integer.parseInt(jtextv_no.getText());
        	
        		String sql1="UPDATE driver SET d_available='yes' WHERE d_no="+driver_no;
				String sql2="UPDATE vehicle SET v_available='yes' WHERE v_no="+vehicle_no;
			
				st3.executeUpdate("DELETE * FROM customer WHERE d_no="+driver_no +"AND v_no="+vehicle_no);
				st1.executeUpdate(sql1);
        		st2.executeUpdate(sql2);
        	        		
        		String dt="SUCCESS";
				String dm="UPDATION  DONE  SUCCESSFULLY";
				int dtype=JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
				
				jtextd_no.setText("");
				jtextv_no.setText("");

        		con.setAutoCommit(false);
				con.commit();
				con.close();
        	}
        	catch(Exception e)
        	{
        		String dt="ERROR";
				String dm="NO SUCH RECORD FOUND...!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        	}
        }
        else
        if(source.equals(jbuttoncancel))
        {
        	dispose();
        } 
    }
    
   public void setconnection()
   {
   		try
   		{
//   			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//    		con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			con.setAutoCommit(false);
   		}
   		catch(Exception e)
   		{
   			String dt="ERROR";
			String dm="ERROR"+e;
			int dtype=JOptionPane.ERROR_MESSAGE;
			JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
   		}
   }
}
	