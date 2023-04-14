package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class salary extends JFrame implements ActionListener
{
	int count=0;
	
	Connection con;
	ResultSet rs;
	Statement st;
	PreparedStatement pst1,pst2;
	
	JPanel jpanel1;
	
	JLabel label;
	JLabel label1;
	JLabel label2;
	JLabel label3;
	JLabel label4;
	JLabel label5;
	
	JTextField text1;
	JTextField text2[]=new JTextField[20];
	JTextField text3[]=new JTextField[20];
	JTextField text4[]=new JTextField[20];

	JCheckBox checkbox[]=new JCheckBox[20];
	
	JButton calc;
	JButton bprint;
	JButton bclose;
	JButton bsave;

	public salary()
	{	
		setTitle("Salary reports of DRIVERS");
		setBounds(150,20,700,700);
		setLayout(null);
		setResizable(false);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new BevelBorder(BevelBorder.RAISED));
		jpanel1.setBackground(new Color(204,255,255));
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 10, 675, 650);
        
        label=new JLabel();
        label.setFont(new Font("MS Sans Serif", 1, 18));
        label.setText("DRIVERS  SALARY  REPORTS");
        label.setBounds(200 ,-30, 500, 100);
        jpanel1.add(label); 
        
        label1=new JLabel();
        label1.setFont(new Font("MS Sans Serif", 1, 18));
        label1.setText("SALARY PER DAY :");
        label1.setBounds(20 ,0, 500, 100);
        jpanel1.add(label1); 
        
        text1=new JTextField(20);
        text1.setFont(new Font("Courier New", 1, 16));
        text1.setBounds(250,40,200,30);
        jpanel1.add(text1);
            
        label2=new JLabel();
        label2.setFont(new Font("MS Sans Serif", 1, 16));
        label2.setText("DRIVER  NO");
        label2.setBounds(20 ,70, 100, 50);
        jpanel1.add(label2); 
        
        label3=new JLabel();
        label3.setFont(new Font("MS Sans Serif", 1, 16));
        label3.setText("TOTAL NO OF DAYS PRESENT");
        label3.setBounds(160 ,45, 250, 100);
        jpanel1.add(label3); 
        
        label4=new JLabel();
        label4.setFont(new Font("MS Sans Serif", 1, 18));
        label4.setText("SALARY");
        label4.setBounds(450 ,45, 500, 100);
        jpanel1.add(label4);
        
        label5=new JLabel();
        label5.setFont(new Font("MS Sans Serif", 0, 18));
        label5.setText("PAID");
        label5.setBounds(590 ,45, 500, 100);
        jpanel1.add(label5);
        
        try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con=DriverManager.getConnection("jdbc:odbc:transportationDSN");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			rs=st.executeQuery("SELECT * FROM attendance ORDER BY dr_no");
			
			while(rs.next())
			{
				count++;
			}
   			con.setAutoCommit(false);
			con.commit();
   			con.close();
		}
		catch(Exception e)
		{
		}
			
		for(int i=0;i<count;i++)
        {
        	text2[i]=new JTextField(20);
        	text2[i].setFont(new Font("Courier New", 1, 16));
        	text2[i].setEditable(false);
        	text2[i].setBounds(20,120+(i*30),100,20);
        	jpanel1.add(text2[i]);
        }
        
        for(int j=0;j<count;j++)
        {
        	text3[j]=new JTextField(20);
        	text3[j].setFont(new Font("Courier New", 1, 16));
        	text3[j].setEditable(false);
        	text3[j].setBounds(160,120+(j*30),250,20);
        	jpanel1.add(text3[j]);
       	}
        
        for(int k=0;k<count;k++)
        {
        	text4[k]=new JTextField(20);
        	text4[k].setFont(new Font("Courier New", 1, 16));
        	text4[k].setEditable(false);
        	text4[k].setBounds(450,120+(k*30),100,20);
        	jpanel1.add(text4[k]);
       	}
       	
       	for(int m=0;m<count;m++)
        {
        	checkbox[m]=new JCheckBox();
			checkbox[m].setBounds(600,120+(m*30),20,20);
			checkbox[m].setBackground(new Color(204,255,255));
			jpanel1.add(checkbox[m]);
       	}

        
        try
		{
			setconnection();
					
			String sql1="SELECT dr_no,days FROM attendance ORDER BY dr_no";
		
			st.executeQuery(sql1);
		
			rs=st.getResultSet();
			
			int i=0;
			
			while(rs.next())
			{
				text2[i].setText(Integer.toString(rs.getInt(1)));
				text3[i].setText(Integer.toString(rs.getInt(2)));
				i++;				
			}
			con.commit();
   			con.close();
		}
		catch(Exception e)
		{
			System.out.println(""+e);
		}

        bprint=new JButton();
        bprint.setText("BACK");
        bprint.setToolTipText("Print the Page");
        bprint.setBounds(30, 590, 130, 40);
        jpanel1.add(bprint);
        bprint.addActionListener(this);

        calc=new JButton();
        calc.setText("CALCULATE");
        calc.setToolTipText("Calculates the SALARY");
        calc.setBounds(195, 590, 130, 40);
        jpanel1.add(calc);
        calc.addActionListener(this);
        
        bsave=new JButton();
        bsave.setText("SAVE");
        bsave.setToolTipText("Update Salary to the DATABASE.");
        bsave.setBounds(360,590, 130, 40);
        jpanel1.add(bsave);
        bsave.addActionListener(this);  
        
        bclose=new JButton();
        bclose.setText("CLOSE");
        bclose.setToolTipText("Close the form.");
        bclose.setBounds(520,590, 130, 40);
        jpanel1.add(bclose);
        bclose.addActionListener(this);  
        
		setVisible(true);
	}

public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        int per=0;
        
        if(source.equals(calc))
        {
        	try
        	{
        		per=Integer.parseInt(text1.getText());
        	}
        	catch(Exception ee)
        	{
        		
        	}
        	int [] present=new int[15];
             	
        	for(int i=0;i<count;i++)
        	{
        		present[i]=Integer.parseInt(text3[i].getText());
        		
        		int sal=per*present[i];
        		
        		text4[i].setText(Integer.toString(sal));
        	}
        }
        else
        if(source.equals(bprint))
        {
        	dispose();
        }
        else
        if(source.equals(bsave))
        {
           int reply = JOptionPane.showConfirmDialog(this,"Are you Want to Paid Salary?","Transportation System V. 1.0",
													  JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		   if (reply == JOptionPane.YES_OPTION)
		   {
        	try
			{
//				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			  	con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
    			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
    			
			  	Statement stmt=con.createStatement();;
			 	
			 	for(int a=0;a<count;a++)			 	   
			  	{
			  		if(checkbox[a].isSelected()==true)
			  		{
						stmt.executeUpdate("UPDATE attendance SET days=0 WHERE dr_no="+text2[a].getText());
			  		}
			  	}	
			 	con.setAutoCommit(false);
			    JOptionPane.showMessageDialog(null,"SALARY PAID SUCCESSFULLY");
			}
			catch(Exception ee)
			{
			
			}
		  }
        }
        else
        if(source.equals(bclose))
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
			st=con.createStatement();
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

