import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
import java.lang.*;


public class frel extends Frame 
{
	TextArea tx1,tx2,tx3;
	Label l1,l2,l3;
	



	void min(float a, float b)
	{
		if(a<b)
		return a;
		else
		return b;
	}

	void max(float a, float b)
	{
		if(a>b)	
		return a;
		else 
		return b;
	}

	frel()
	{	l1=new Label("Relation R:");
		l2=new Label("Relation S:");
		l3=new Label(" R o S:");
		setLayout(new FlowLayout(FlowLayout.LEFT,20,50));
		tx1 = new TextArea(10,20);
		tx2 = new TextArea(10,20);
		tx3 = new TextArea(10,20);
		
		add(l1);
		add(tx1);
		add(l2);
		add(tx2);
		add(l3);
		add(tx3);

		MenuBar mb = new MenuBar();
		Menu S = new Menu("Start");
		Menu m1 = new Menu("Construct Relation");
		Menu m2 = new Menu("Compose");
		
		MenuItem m3 = new MenuItem("Check Equivalence");
		MenuItem m4 = new MenuItem("Make Equivalent");
		MenuItem m5 = new MenuItem("Exit");
		
		MenuItem m11 = new MenuItem("Cosine");
		MenuItem m12 = new MenuItem("Max-Min");
		MenuItem m13 = new MenuItem("Absolute Exponential");
		
		MenuItem m21 = new MenuItem("Max-Min");
		MenuItem m22 = new MenuItem("Max-Product");
		
		S.add(m1);
		S.add(m2);
		S.add(m3);
		S.add(m4);
		S.add(m5);
		
		m1.add(m11);
		m1.add(m12);
		m1.add(m13);

		m2.add(m21);
		m2.add(m22);

		mb.add(S);
		setMenuBar(mb);


		m3.addActionListener(new Eqchk());

		m5.addActionListener(new Exit());
		m11.addActionListener(new Con_cos());
		m12.addActionListener(new Con_mm());
		m13.addActionListener(new Con_absexp());
		m21.addActionListener(new Cmp_mm());
		m22.addActionListener(new Cmp_mp());
	}
	
	class Exit implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}

	class Con_cos implements ActionListener
	{
		public void ActionPerformed(ActionEvent e)
		{

			float nr,dr;
			float sum,s1,s2,s3;			

			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(i==j)
					c[i][j]=1;
					sum=0;
					s1=0;
					s2=0;
					s3=0;
					for(int k=0;k<N;k++)
					{
						sum+=(a[i][k]*a[j][k]);
						s1+=a[i][k]*a[i][k];
						s2+=a[j][k]*a[j][k];
							
					}
					if(sum<0)
					sum*=-1;
					
					s3=s1*s2;
					s3=sqrt(s3);
					c[i][j]=sum/s3;
				}
			}
		
		
					
		}		
		
	}

	class Con_mm implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			float nr,dr;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{	
					nr=0;dr=0;
					for(int k=0;k<N;k++)
					{	
						nr+=min(a[i][k],a[j][k]);
						dr+=max(a[i][k],a[j][k]);	
					}
					
					c[i][j]=nr/dr;
				}
			}
		



		}
	}


	class Con_absexp implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		

		}
	}

	class Cmp_mm implements ActionListener
	{
		public void actionPerformeed(ActionEvent e)
		{
			float x;
			float max;
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{	max=0;
					for(int k=0;k<N;k++)
					{	
						x=min(a[i][k],b[k][j])
						if(x>max)
						max=x;
					}
					
					c[i][j]=max;
				}
			}
		
		}		

	}

	class Cmp_mp implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{	
					max=0;
					for(int k=0;k<N;k++)
					{	
						x=a[i][k]*b[k][j];
						if(x>max)
						max=x;
					}
					
					c[i][j]=max;
				}
			}
		


		}
	}


	class Eqchk implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		int flg1,flg2,flg3;
		flg1=0;
		flg2=0;
		flg3=0;	
		float v,v1,v2,v3;
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				/*CHECKING REFLEXIVE PROPERTY*/
				if(i==j)
				{
				if(c[i][j]!=1)
				flg1=1;
				}

				/*CHECKING SYMMETRIC PROPERTY*/
				if(c[i][j]!=c[j][i])
				{
				flg2=1;
				}
		
				/*CHECKING TRANSITIVE PROPERTY*/
				for(int k=0;k<N;k++)
				{
					v1=c[i][j];
					v2=c[j][k];
					v3=c[i][k];
				
					if(v1<v2)
					v=v1;
					else
					v=v2;
					
					if(v3<v)
					flg3=1;
				}

						
			}	
			

		}
		if((flg1+flg2+flg3)>0)
		
		***NOT AN EQUIVALENCE RELATION***
		
		else
	
		***EQUIVALENCE RELATION***
		}

}		

	class adapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}

	public static void main(String args[])
	{
		Frame f = new frel();
		f.setSize(500,500);
		f.setTitle("Fuzzy Relations");
		f.setVisible(true);
		f.show();
	}
}

