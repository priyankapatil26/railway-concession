import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*; 
class railconc extends JFrame implements ActionListener
{
	CardLayout cl;
	GridBagLayout gb;
	GridBagConstraints gbc;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	JPanel p,p1,login,register,std,conc;
	//For Login Form
	JLabel user,pass,new_user,main;
	JTextField usertf,passtf;
	JButton loginbtn,exitbtn,create;
	//For Registration Form
		JLabel username,password,retype;
		JTextField t1;
		JPasswordField t2,t3;
		JButton save,back;
	
	//for student form
		JLabel fullname,email,dob,gender,address,contact,division,branch,admissionyear,mainstd;
		JTextField tfuser,tfemail,tfdob,tfgender,tfcontact,tfdivision,tfbranch,tfadmission;
		JTextArea taddress;
		JButton b1,b2;
		JComboBox j1=new JComboBox();
		/*j1.addItem("New");
		j1.addItem("Occasional");
		j1.addItem("Regular");*/

	//for concession form

		JButton print;
		JLabel l1,l2,l3;
		JTextField tfissue,tffrom,tfto;
		JLabel mainconc;

		public railconc(){
		//setVisible(true);
		setSize(500,568);
		show();
		gb=new GridBagLayout();
		gbc=new GridBagConstraints();
		//gbc1=new GridBagConstraints();

		Font mfnt=new Font("Arial",Font.BOLD,25);//font
		p=new JPanel();
		p1=new JPanel();
		login=new JPanel();
		register=new JPanel();
		std=new JPanel();
		conc=new JPanel();
		main=new JLabel("RAILWAY CONCESSION FORM");
		user=new JLabel("UserName");
		pass=new JLabel("Password");
		new_user=new JLabel("New User ?");
		usertf=new JTextField(10);
		passtf=new JPasswordField(10);
		loginbtn=new JButton("Login");
		exitbtn=new JButton("Exit");
		create=new JButton("Create New Account");

		main.setFont(mfnt);
		user.setForeground(Color.white);
		pass.setForeground(Color.white);
		new_user.setForeground(Color.white);
		Insets ss=new Insets(5,5,5,5);
		gbc.insets=ss;
		cl=new CardLayout();
		p1.setLayout(cl);
		p.setLayout(cl);
		login.setBackground(new Color(150,70,70));
		register.setBackground(new Color(150,70,70));
		main.setForeground(Color.white);
		gbc.fill=GridBagConstraints.BOTH;
		loginbtn.addActionListener(this);
		exitbtn.addActionListener(this);
		create.addActionListener(this);
		login.setLayout(gb);
		//adding on panel
		addLogin(main,1,2,4,1);
		addLogin(user,2,5,1,1);
		addLogin(pass,2,6,1,1);
		addLogin(new_user,2,9,1,1);
		addLogin(usertf,4,5,1,1);
		addLogin(passtf,4,6,1,1);
		addLogin(loginbtn,4,7,1,1);
		addLogin(exitbtn,4,8,1,1);
		addLogin(create,4,9,1,1);
		
		username=new JLabel("UserName");
		password=new JLabel("Password");
		retype=new JLabel("Retype Password");
		username.setForeground(Color.white);
		password.setForeground(Color.white);
		retype.setForeground(Color.white);
		t1=new JTextField(10);
		t2=new JPasswordField(10);
		t3=new JPasswordField(10);
		save=new JButton("Save");
		back=new JButton("Back");
		save.addActionListener(this);
		back.addActionListener(this);
		register.setLayout(gb);
		addRegistration(username,2,2,1,1);
		addRegistration(password,2,3,1,1);
		addRegistration(retype,2,4,1,1);
		addRegistration(t1,4,2,1,1);
		addRegistration(t2,4,3,1,1);
		addRegistration(t3,4,4,1,1);
		addRegistration(save,2,5,1,1);
		addRegistration(back,4,5,1,1);

		//student initialization
		b1=new JButton("Get Concession");
		b2=new JButton("BACK");
		b1.addActionListener(this);
		b2.addActionListener(this);
		mainstd=new JLabel("Student Registration");
		fullname=new JLabel("Full Name");
		email=new JLabel("Email-Id");		
		dob=new JLabel("DOB");		
		gender=new JLabel("Gender");				
		address=new JLabel("Address");		
		contact=new JLabel("Contact");	
		division=new JLabel("Division");
		branch=new JLabel("Branch");					
		admissionyear=new JLabel("Admission-Year");		
		tfuser=new JTextField(10);
		tfemail=new JTextField(10);
		tfgender=new JTextField(10);
		tfdob=new JTextField(10);
		tfcontact=new JTextField(10);
		tfdivision=new JTextField(10);
		tfbranch=new JTextField(10);
		tfadmission=new JTextField(10);
		taddress=new JTextArea(4,4);
		mainstd.setFont(mfnt);
		std.setBackground(new Color(150,70,70));
		mainstd.setForeground(Color.white);
		fullname.setForeground(Color.white);
		email.setForeground(Color.white);
		dob.setForeground(Color.white);
		gender.setForeground(Color.white);
		address.setForeground(Color.white);
		contact.setForeground(Color.white);
		division.setForeground(Color.white);
		branch.setForeground(Color.white);
		admissionyear.setForeground(Color.white);
		
	
		
		//adding on panels
		std.setLayout(gb);
		addStudent(mainstd,1,2,4,1);
		addStudent(fullname,2,4,1,1);
		addStudent(email,2,5,1,1);
		addStudent(dob,2,6,1,1);
		addStudent(gender,2,7,1,1);
		addStudent(address,2,8,1,1);
		addStudent(contact,2,9,1,1);
		addStudent(division,2,10,1,1);
		addStudent(branch,2,11,1,1);
		addStudent(admissionyear,2,12,1,1);
		addStudent(tfuser,4,4,1,1);
		addStudent(tfemail,4,5,1,1);
		addStudent(tfdob,4,6,1,1);
		addStudent(tfgender,4,7,1,1);
		addStudent(taddress,4,8,1,1);
		addStudent(tfcontact,4,9,1,1);
		addStudent(tfdivision,4,10,1,1);
		addStudent(tfbranch,4,11,1,1);
		addStudent(tfadmission,4,12,1,1);
		addStudent(b1,2,13,1,1);
		addStudent(b2,4,13,1,1);
		
		//conc initialization
		print=new JButton("PRINT");
		print.addActionListener(this);
		l1=new JLabel("From Station");
		l2=new JLabel("To Station");
		l3=new JLabel("Issue Date");
		mainconc=new JLabel("Concession Form");
		tfissue=new JTextField();
		tffrom=new JTextField();
		tfto=new JTextField();
		mainconc.setFont(mfnt);
		mainconc.setForeground(Color.white);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.white);
		conc.setBackground(new Color(150,70,70));

		conc.setLayout(gb);
		addConcession(mainconc,1,1,4,1);
		addConcession(l1,2,4,1,1);
		addConcession(l2,2,5,1,1);
		addConcession(l3,2,6,1,1);
		addConcession(tffrom,4,4,1,1);
		addConcession(tfto,4,5,1,1);
		addConcession(tfissue,4,6,1,1);
		addConcession(print,3,7,1,1);
		//adding panels
		p.add("Login",login);
		p.add("Registration",register);
		p.add("student",std);
		p.add("Concession form",conc);
		add(p);
		//add(p1);
		
		//show();
		
		try
			{

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			    con=DriverManager.getConnection("jdbc:odbc:rail");
		}
		catch(Exception e)
			{
				usertf.setText("Error in Connection ");
			}
		
	}

	public void addLogin(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		login.add(cc);
	}

	public void addRegistration(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		register.add(cc);
	}
	
	public void addStudent(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		std.add(cc);
	}

	public void addConcession(Component cc,int col,int r,int w,int h)
	{
		gbc.gridx=col;
		gbc.gridy=r;
		gbc.gridwidth=w;
		gbc.gridheight=h;
		gb.setConstraints(cc,gbc);
		conc.add(cc);
	}

public void actionPerformed(ActionEvent ee)
	{
		
		if(ee.getSource()==loginbtn)
		{
			try
			{		
				ps=con.prepareStatement("Select * from Users where user=? and pass=?");	
				ps.setString(1,usertf.getText());
				ps.setString(2,passtf.getText());
				rs=ps.executeQuery();
				usertf.setText("");
				passtf.setText("");
				rs.next();
				usertf.setText(rs.getString(1));
				passtf.setText(rs.getString(2));
				JOptionPane.showMessageDialog(null,"login successfull");
				cl.show(p,"Concession form");
			}
			catch(Exception e)
			{
				
				JOptionPane.showMessageDialog(null,"Illegal User Name or Password");
				passtf.setText("");
			}
		}
		if(ee.getSource()==exitbtn)
			{
				System.exit(0);
			}
			if(ee.getSource()==create)
			{
				cl.show(p,"Registration");
			}
		
		if(ee.getSource()==save)
		{
			try
			{
				ps=con.prepareStatement("Insert into users values(?,?)");	
				String str1,str2;
				str1=t2.getText();
				str2=t3.getText();
				if(str1.equals(str2))
				{
					ps.setString(1,t1.getText());
					ps.setString(2,t2.getText());
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(null,"UserName successfully added");
					t2.setText("");
					t3.setText("");				
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please retype your UserName And Password correctly");
				}
			}
			catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Error in  making new account");
				} 
		}
		if(ee.getSource()==back)
			{
				cl.show(p,"Login");
				//t12.setText("");

			}
		if(ee.getSource()==b2)
			{
			cl.show(p,"Login");	
			}
		if(ee.getSource()==b1)
			{
			try
			{
				ps=con.prepareStatement("Insert into Student values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1,tfuser.getText());
				ps.setString(2,tfemail.getText());
				ps.setString(3,tfdob.getText());
				ps.setString(4,tfgender.getText());
				ps.setString(5,taddress.getText());
				ps.setString(6,tfcontact.getText());
				ps.setString(7,tfdivision.getText());
				ps.setString(8,tfbranch.getText());
				ps.setString(9,tfadmission.getText());
				
				int i;
				i=ps.executeUpdate();	
				JOptionPane.showMessageDialog(null,"students details successfully added");
				cl.show(p,"Concession form");
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Error in adding student details");
			}
		
		}
			/*if(ee.getSource()==print)
			{
			try
			{
				ps=con.prepareStatement("Insert into Billing values (?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,t24.getText());		
				ps.setString(2,t39.getText());		
				//ps.setString(2,t25.getText());
				//ps.setString(3,t26.getText());
				//ps.setInt(4,Integer.parseInt(t27.getText()));
				//ps.setInt(5,Integer.parseInt(t28.getText()));	
				//ps.setInt(6,Integer.parseInt(t30.getText()));
				ps.setInt(3,Integer.parseInt(t31.getText()));
				ps.setInt(4,Integer.parseInt(t32.getText()));
				ps.setInt(5,Integer.parseInt(t33.getText()));
				ps.setInt(6,Integer.parseInt(t34.getText()));
				ps.setString(7,(String)cb2.getSelectedItem());
				ps.setInt(8,Integer.parseInt(t35.getText()));
				ps.setString(9,t37.getText());
				ps.setInt(10,Integer.parseInt(t36.getText()));
				int i;
				i=ps.executeUpdate();
				JOptionPane.showMessageDialog(null,"Billing successfully done");
				
				//For printing the bill

				 PrintUtilities.printComponent(this);
		
			/*	ps=con.prepareStatement("Update Rooms set Status= 'Available' Where  RNo=?");
				ps.setInt(1,Integer.parseInt(t17.getText()));
				i=ps.executeUpdate();	
			}
			catch(Exception e)
			{
				t24.setText("Error in Billing");
				//t25.setText("");
				//t26.setText("");
				//t27.setText("");
				//t28.setText("");
				//t30.setText("");
				t31.setText("");
				t32.setText("");
				t33.setText("");
				t34.setText("");
				t35.setText("");
				t36.setText("");
				t37.setText("");
				//t38.setText("");
				t39.setText("");
			}
			}*/

			}

	public static void main(String[] args) 
	{
		
		railconc ht =new railconc();
	}
	}

