package c;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Ca extends JFrame implements ActionListener
{    
   JButton ad,SUB,MUL,DIV,EQ,CL; 
   JButton b[]=new JButton[10];
    int i,r,n1,n2;
    JTextField res;
    char op; 
   public Ca()
  {
     
      setLayout(new BorderLayout());
      JLabel p=new JLabel();
      p.setSize(6,6);
      p.setLayout(new GridLayout(5,5));
      for(int i=0;i<=9;i++)
      {
        b[i]=new JButton(i+"");
        p.add(b[i]);
        b[i].addActionListener(this);
      }
      ad=new JButton("+");
      p.add(ad);
      ad.addActionListener(this);
 
      SUB=new JButton("-");
      p.add(SUB);
      SUB.addActionListener(this);
 
      MUL=new JButton("*");
      p.add(MUL);
      MUL.addActionListener(this);
 
      DIV=new JButton("/");
      p.add(DIV);
      DIV.addActionListener(this);
 
      EQ=new JButton("=");
      p.add(EQ);
      EQ.addActionListener(this);
 
      CL=new JButton("C");
      p.add(CL);
      CL.addActionListener(this);
 
      res=new JTextField(10);
      add(p,BorderLayout.CENTER);
      add(res,BorderLayout.NORTH);
      setVisible(true);
      setSize(250,200);
     }
public void actionPerformed(ActionEvent ae)
{
  JButton pb=(JButton)ae.getSource();
	if(pb==CL)
	{
	 r=n1=n2=0;
	 res.setText("");
	}
	else
		if(pb==EQ)
		{
 		 n2=Integer.parseInt(res.getText());
  		 eval();
  		 res.setText(""+r);
		}
 
		else
		{
 		  boolean opf=false;
 		  if(pb==ad)
			{ op='+';
			  opf=true;
			}
 		  if(pb==SUB)
			{ 
 			  op='-';
			opf=true;
			}
		  if(pb==MUL)
			{
			  op='*';
			  opf=true;
			  }
		  if(pb==DIV)
			{ 
			  op='/';opf=true;
			  }
	
		  if(opf==false)
		  {
  		   for(i=0;i<10;i++)
		   {
		  	if(pb==b[i])
     		  	{
           	   	String t=res.getText();
           		t+=i;
            		res.setText(t);
		  	}
		   }
		  }
		  else
		  {
    		n1=Integer.parseInt(res.getText());
     		res.setText("");
		 }
		}
}
int eval()
{
	switch(op)
	{
 	case '+':   r=n1+n2;  break;
 	case '-':    r=n1-n2;   break;
 	case '*':    r=n1*n2; break;
 	case '/':    r=n1/n2; break;
 
	}
	return 0;
}
 
  public static void main(String arg[])
  {
      new Ca();
   }
}