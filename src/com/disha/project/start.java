package com.disha.project;   

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.geom.*;
import java.io.*;
import javax.swing.border.*;

public class start extends JWindow
{
	JPanel jpanel1,jpanel2;
	
	JLabel jlabel1;
	JLabel jlabel2;
	JLabel jlabel3;
	JLabel jlabel4;
	JLabel jlabel5;
	JLabel jlabel6;
	
	JProgressBar jprogressbar;
	
	public start()
	{
		setBounds(250,40,500,680);
		Container c=getContentPane();
		c.setLayout(null);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new BevelBorder(BevelBorder.RAISED));
		jpanel1.setBounds(10, 10, 475, 100);
        c.add(jpanel1);
        
        jlabel1=new JLabel();
        jlabel1.setFont(new Font("MS Sans Serif", 1, 35));
        jlabel1.setText("Transportation  System");
        jlabel1.setBounds(50 ,0, 500, 100);
        jpanel1.add(jlabel1); 
	
     	jlabel2=new JLabel();
        jlabel2.setIcon(new ImageIcon(start.class.getResource("../../../images/main.gif")));
        jlabel2.setBounds(50, 100, 470, 350);
        c.add(jlabel2);
              
        jprogressbar = new JProgressBar();
        jprogressbar.setBackground(new Color(255, 0, 51));
        c.add(jprogressbar);
         
        jpanel2=new JPanel();
		jpanel2.setLayout(null);
		jpanel2.setBorder(new BevelBorder(BevelBorder.RAISED));
		jpanel2.setBounds(10, 480, 475, 185);
        c.add(jpanel2); 
          
        jlabel3=new JLabel();
        jlabel3.setFont(new Font("MS Sans Serif", 1, 24));
        jlabel3.setText("...  Developed By  ...");
        jlabel3.setBounds(140 ,-30, 500, 100);
        jpanel2.add(jlabel3);
         
        jlabel4=new JLabel();
        jlabel4.setFont(new Font("MS Sans Serif", 1, 20));
        jlabel4.setText("Disha K. Kolte");
        jlabel4.setBounds(150 ,25, 500, 100);
        jpanel2.add(jlabel4);
        
        jlabel5=new JLabel();
        jlabel5.setFont(new Font("MS Sans Serif", 1, 20));
        jlabel5.setText("Nikita R. Mahajan");
        jlabel5.setBounds(150 ,60, 500, 100);
        jpanel2.add(jlabel5);
        
       
		for (int i = 0; i < 401; i++) {
			jprogressbar.setBounds(50, 440, i, 30);
			jprogressbar.setFont(new Font("MS Sans Serif", 1, 14));
			jprogressbar.setString("Loading..." + (i / 4) + "%");
			jprogressbar.setValue(i);  
			jprogressbar.setStringPainted(true);
//			for (int j = 0; j < 15000; j++)
//				for (int k = 0; k < 1500; k++);
			try {
				Thread.sleep(20);
			} catch (Exception e) {
			}
			setVisible(true);
		}	
   		setVisible(true);  
   		
//   		for(int l=0;l<150000;l++);

   		dispose();
   		new login();
	}
	
	public static void main(String a[])
	{
		new start();
	}
} 
