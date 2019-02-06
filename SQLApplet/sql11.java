import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.applet.*;

//<applet code="sql11.class" width=700 height=400>
//<param name="img" value="ankur.jpg">
//</applet>

public class sql11 extends JApplet implements ActionListener {
	JMenuBar menubar1;
	JMenu menu1, menu2, menu3;
	JMenuItem menuitem1, menuitem2, menuitem3, menuitem4, menuitem5, menuitem6,
			menuitem7, menuitem8, menuitem9, menuitem10, menuitem11,
			menuitem12, menuitem13, menuitem14, menuitem15, menuitem16;
	JPanel pinsert, pupdate, pdelete, pprocedure, pdatabasemetadata, pselect,
			presultsetmetadata, pdos, pabout;
	JButton binss, binsp, bupds, bupdp, bdels, bdelp, bexecuteproc,
			bcreateproc, bstaticselect, bdynamicselect, brmeta1, brmeta2,
			bdmeta1, bdmeta2, bfread, bresult, brcollabel, brcolname,
			brcoltype, babout, bselectclear, btest;
	JTextField text1, text2, text3, text4, text5, text6, text7, text8, text19,
			text9, text11, text12;
	JTable myJTable;
	JTextArea ta1;
	List l1;
	JLabel label1, labelinsert1, labelinsert2, labelinsert3, labelupdate1,
			labelupdate2, labelupdate3, labeldelete1, labelproc1, labelproc2,
			labeldatabasemetadata, labelresultset1, labelresultset2,
			selectlabel1;
	Image img;
	Icon paboutbackground = new ImageIcon("ankur4.jpg");
	Icon icon1 = new ImageIcon("0001.gif");
	Icon icon2 = new ImageIcon("00002.jpg");
	Icon icon3 = new ImageIcon("00003.jpg");
	Icon icon4 = new ImageIcon("00004.jpg");
	Icon icon5 = new ImageIcon("00005.jpg");
	Icon icon6 = new ImageIcon("00006.gif");
	Icon icon7 = new ImageIcon("00007.gif");
	Icon icon8 = new ImageIcon("00008.gif");
	Icon icon9 = new ImageIcon("00009.jpg");
	Icon icon10 = new ImageIcon("00010.gif");
	Icon icon11 = new ImageIcon("00011.gif");
	Icon icon12 = new ImageIcon("00012.gif");

	// Icon icon9=new ImageIcon("00009.gif");
	// MediaTracker tracker;
	// String
	// l1data[]={"getDatabaseProductName","getDriverName","getDriverVersion"};

	public void init() {
		// JMenuBar menubar1;
		// JMenu menu1,menu2;
		// JMenuItem
		// menuitem1,menuitem2,menuitem3,menuitem4,menuitem5,menuitem6,menuitem7,menuitem8,menuitem9,menuitem10,menuitem11,menuitem12;
		menubar1 = new JMenuBar();
		menu1 = new JMenu("File");
		menu2 = new JMenu("Directory");
		menu3 = new JMenu("Misc");

		menu1.add(menuitem1 = new JMenuItem("Create"));
		menu1.add(menuitem2 = new JMenuItem("Delete"));
		menu1.add(menuitem3 = new JMenuItem("Rename"));
		menu1.add(menuitem4 = new JMenuItem("Copy"));
		menu1.add(menuitem5 = new JMenuItem("Move"));
		menu1.add(menuitem6 = new JMenuItem("Write to file"));
		menu1.add(menuitem7 = new JMenuItem("Read from file"));
		menu2.add(menuitem8 = new JMenuItem("Create"));
		menu2.add(menuitem9 = new JMenuItem("Delete"));
		menu2.add(menuitem10 = new JMenuItem("Rename"));
		menu2.add(menuitem11 = new JMenuItem("Copy"));
		menu2.add(menuitem12 = new JMenuItem("Move"));
		menu3.add(menuitem13 = new JMenuItem("Tree"));
		menu3.add(menuitem14 = new JMenuItem("Time"));
		menu3.add(menuitem15 = new JMenuItem("Date"));
		menu3.add(menuitem16 = new JMenuItem("Version"));

		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		// menubar1.setBackground(new Color(128,128,255));
		menu1.setBackground(new Color(255, 128, 128));
		menu2.setBackground(new Color(128, 128, 255));
		menu3.setBackground(new Color(255, 128, 128));
		setJMenuBar(menubar1);

		Color clr1 = new Color(128, 0, 64);
		myJTable = new JTable(18, 3);

		pinsert = new JPanel();
		pupdate = new JPanel();
		pdelete = new JPanel();
		pprocedure = new JPanel();
		pdatabasemetadata = new JPanel();
		presultsetmetadata = new JPanel();
		pselect = new JPanel();
		// pdos=new JPanel();
		pabout = new JPanel();

		JTabbedPane jt = new JTabbedPane();
		jt.add("INSERT", pinsert);
		jt.add("UPDATE", pupdate);
		jt.add("DELETE", pdelete);
		jt.add("PROCEDURE", pprocedure);
		jt.add("DATA-BASE METADATA", pdatabasemetadata);
		jt.add("RESULTSET METADATA", presultsetmetadata);
		jt.add("SELECT QUERY", pselect);
		// jt.add("DOS",pdos);
		jt.add("ABOUT", pabout);

		getContentPane().add(jt);

		text1 = new JTextField(10);
		text2 = new JTextField(10);
		text3 = new JTextField(10);
		text4 = new JTextField(10);
		text5 = new JTextField(10);
		text6 = new JTextField(10);
		text7 = new JTextField(10);
		text8 = new JTextField(10);
		text19 = new JTextField(10);
		text9 = new JTextField(10);
		text11 = new JTextField(30);
		text12 = new JTextField(30);
		ta1 = new JTextArea(5, 15);
		l1 = new List(7);
		label1 = new JLabel();
		labelinsert1 = new JLabel();
		labelinsert2 = new JLabel();
		labelinsert3 = new JLabel();
		labelupdate1 = new JLabel();
		labelupdate2 = new JLabel();
		labelupdate3 = new JLabel();
		labeldelete1 = new JLabel();
		labelproc1 = new JLabel();
		labelproc2 = new JLabel();
		labeldatabasemetadata = new JLabel();
		labelresultset1 = new JLabel();
		labelresultset2 = new JLabel();
		selectlabel1 = new JLabel();

		bselectclear = new JButton("CLEAR");
		binss = new JButton("static insert");
		binsp = new JButton("dynamic insert");
		bupds = new JButton("static update");
		bupdp = new JButton("dynamic update");
		bdels = new JButton("static delete");
		bdelp = new JButton("dynamic delete");
		bexecuteproc = new JButton("execute procedure");
		bcreateproc = new JButton("create procedure");
		bstaticselect = new JButton("static select");
		bdynamicselect = new JButton("dynamic select");
		brmeta1 = new JButton("get column count");
		brmeta2 = new JButton("get column type name");
		// bdmeta1=new JButton("get catalog");
		// bdmeta2=new JButton("get driver version");
		bfread = new JButton("FILE READ");
		bresult = new JButton("RESULT");
		btest = new JButton("TEST");

		babout = new JButton("onlyankur@hotmail.com", paboutbackground);
		babout.setForeground(Color.white);

		pdatabasemetadata.add(l1);
		pinsert.add(binss);
		pinsert.add(binsp);
		pinsert.add(text1);
		pinsert.add(text2);
		pinsert.add(text3);
		pupdate.add(bupds);
		pupdate.add(bupdp);
		pdelete.add(bdels);
		pdelete.add(bdelp);
		pprocedure.add(bexecuteproc);
		pprocedure.add(bcreateproc);
		pselect.add(bstaticselect);
		pselect.add(bdynamicselect);
		pselect.add(text4);
		pselect.add(bselectclear);
		pupdate.add(text5);
		pupdate.add(text6);
		pupdate.add(text7);
		pselect.add(myJTable);
		pdelete.add(text8);
		pprocedure.add(text19);
		pprocedure.add(ta1);
		presultsetmetadata.add(bresult);
		presultsetmetadata.add(text9);
		presultsetmetadata.add(labelresultset1);
		presultsetmetadata.add(labelresultset2);
		presultsetmetadata.add(text11);
		// pabout.add(babout);
		pinsert.add(labelinsert1);
		pinsert.add(labelinsert2);
		pinsert.add(labelinsert3);
		pupdate.add(labelupdate1);
		pupdate.add(labelupdate2);
		pupdate.add(labelupdate3);
		pdelete.add(labeldelete1);
		pprocedure.add(labelproc1);
		pprocedure.add(labelproc2);
		pdatabasemetadata.add(labeldatabasemetadata);
		presultsetmetadata.add(label1);
		pselect.add(selectlabel1);
		// pdos.add(btest);
		// pdos.add(text12);
		// pdos.add(menubar1);

		binss.addActionListener(this);
		binsp.addActionListener(this);
		bupds.addActionListener(this);
		bupdp.addActionListener(this);
		bdels.addActionListener(this);
		bdelp.addActionListener(this);
		bexecuteproc.addActionListener(this);
		bcreateproc.addActionListener(this);
		bstaticselect.addActionListener(this);
		bdynamicselect.addActionListener(this);
		brmeta1.addActionListener(this);
		brmeta2.addActionListener(this);
		bfread.addActionListener(this);
		bresult.addActionListener(this);
		bselectclear.addActionListener(this);
		l1.addActionListener(this);
		btest.addActionListener(this);
		menuitem1.addActionListener(this);
		menuitem2.addActionListener(this);
		menuitem3.addActionListener(this);
		menuitem4.addActionListener(this);
		menuitem5.addActionListener(this);
		menuitem6.addActionListener(this);
		menuitem7.addActionListener(this);
		menuitem8.addActionListener(this);
		menuitem9.addActionListener(this);
		menuitem10.addActionListener(this);
		menuitem11.addActionListener(this);
		menuitem12.addActionListener(this);
		menuitem13.addActionListener(this);
		menuitem14.addActionListener(this);
		menuitem15.addActionListener(this);
		menuitem16.addActionListener(this);

		pinsert.setBackground(new Color(255, 128, 0));
		pupdate.setBackground(new Color(255, 128, 128));
		pdelete.setBackground(new Color(0, 138, 35));
		pprocedure.setBackground(new Color(128, 128, 192));
		pselect.setBackground(Color.red);
		pdatabasemetadata.setBackground(new Color(0, 183, 183));
		ta1.setBackground(new Color(192, 192, 192));
		ta1.setForeground(Color.black);
		presultsetmetadata.setBackground(new Color(157, 157, 0));
		// pdos.setBackground(new Color(123,62,62));
		// ---------------------------------------------
		pinsert.setLayout(null);
		// text1.setBounds(150,30,150,20);
		text1.setBounds(5, 55, 150, 20);
		text2.setBounds(205, 55, 150, 20);
		text3.setBounds(405, 55, 150, 20);
		binsp.setBounds(10, 130, 150, 30);
		binss.setBounds(210, 130, 150, 30);

		labelinsert1.setBounds(06, 40, 140, 10);
		labelinsert1.setForeground(Color.black);
		labelinsert1.setText("Employee Number ");

		labelinsert2.setBounds(206, 40, 140, 10);
		labelinsert2.setForeground(Color.black);
		labelinsert2.setText("Employee Name ");

		labelinsert3.setBounds(406, 40, 140, 10);
		labelinsert3.setForeground(Color.black);
		labelinsert3.setText("Employee Email ");
		// ---------------------------------------------
		pupdate.setLayout(null);
		text5.setBounds(5, 55, 150, 20);
		text6.setBounds(205, 55, 150, 20);
		text7.setBounds(405, 55, 150, 20);
		bupdp.setBounds(10, 130, 150, 30);
		bupds.setBounds(210, 130, 150, 30);

		labelupdate1.setBounds(06, 40, 140, 10);
		labelupdate1.setForeground(new Color(128, 0, 64));
		labelupdate1.setText("Employee Number ");

		labelupdate2.setBounds(206, 40, 140, 10);
		labelupdate2.setForeground(new Color(128, 0, 64));
		labelupdate2.setText("Employee Name ");

		labelupdate3.setBounds(406, 40, 140, 10);
		labelupdate3.setForeground(new Color(128, 0, 64));
		labelupdate3.setText("Employee Email ");
		// ------------------------------------------------------
		pdelete.setLayout(null);
		text8.setBounds(5, 55, 150, 20);
		bdelp.setBounds(10, 130, 150, 30);
		bdels.setBounds(210, 130, 150, 30);

		labeldelete1.setBounds(06, 40, 140, 10);
		labeldelete1.setForeground(Color.black);
		labeldelete1.setText("Employee Number ");
		// --------------------------------------------------
		pprocedure.setLayout(null);
		text19.setBounds(8, 55, 150, 20);
		bexecuteproc.setBounds(10, 90, 150, 70);

		labelproc1.setBounds(06, 40, 140, 10);
		labelproc1.setForeground(new Color(0, 64, 64));
		labelproc1.setText("Enter procedure name ");

		labelproc2.setBounds(210, 40, 440, 10);
		labelproc2.setForeground(new Color(0, 64, 64));
		labelproc2.setText("Enter code to create a new procedure here...... ");

		ta1.setBounds(210, 60, 350, 100);
		bcreateproc.setBounds(210, 175, 350, 30);

		// ------------------------------------------------

		pdatabasemetadata.setLayout(null);
		l1.setBounds(55, 40, 240, 230);
		l1.setBackground(Color.pink);
		labeldatabasemetadata
				.setText("Double click on an item to view its details");
		// labeldatabasemetadata.setBounds(21,10,50,300);
		labeldatabasemetadata.setBounds(55, 5, 300, 30);

		labeldatabasemetadata.setForeground(new Color(0, 46, 91));

		l1.add("getDatabaseProductName");
		l1.add("getDriverName");
		l1.add("getDriverVersion");
		l1.add("SCHEMA LIST");
		l1.add("TYPE INFO");
		l1.add("getDatabaseProductVersion");
		l1.add("getURL");
		l1.add("getUserName");
		l1.add("getDriverMajorVersion");
		l1.add("getDriverMinorVersion");
		l1.add("getSchemaTerm");
		l1.add("getSearchStringEscape");
		l1.add("getSQLKeywords");
		l1.add("getStringFunctions");
		l1.add("getSystemFunctions");
		l1.add("getCatalogTerm");
		l1.add("getTimeDateFunctions");
		l1.add("getProcedureTerm");

		// ---------------------------------------------------------
		presultsetmetadata.setLayout(null);
		text9.setBounds(5, 55, 150, 20);
		text11.setBounds(205, 55, 150, 20);
		bresult.setBounds(10, 130, 150, 30);
		labelresultset1.setBounds(06, 40, 140, 10);
		labelresultset1.setForeground(Color.black);
		labelresultset1.setText("Enter Column No. ");

		labelresultset2.setBounds(206, 40, 140, 10);
		labelresultset2.setForeground(Color.black);
		labelresultset2.setText("Enter Table Name ");

		label1.setBounds(55, 5, 600, 30);
		// -------------------------------------------------------
		pselect.setLayout(null);
		// bselectclear.setBounds(210,450,75,30);
		text4.setBounds(8, 55, 150, 20);
		bstaticselect.setBounds(210, 400, 350, 30);
		bdynamicselect.setBounds(10, 90, 150, 70);
		selectlabel1.setBounds(8, 35, 130, 20);
		selectlabel1.setForeground(Color.white);
		selectlabel1.setText("Employee Number");

		/*
		 * labelproc1.setBounds(06,40,140,10); labelproc1.setForeground(new
		 * Color(0,64,64)); labelproc1.setText("Enter procedure name ");
		 * 
		 * labelproc2.setBounds(210,40,440,10); labelproc2.setForeground(new
		 * Color(0,64,64));
		 * labelproc2.setText("Enter code to create a new procedure here...... "
		 * );
		 */

		myJTable.setBounds(210, 60, 350, 300);
		myJTable.setGridColor(Color.pink);

		// -------------------------------------------------------
		pabout.setLayout(new BorderLayout());
		pabout.add(babout);

		// -----------------------------------------------

		// pdos.setLayout(null);

		// -------------------------------------------------

	}// end of init()

	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();

		// -------------------------------------------------------------------
		/*
		 * if(obj==menuitem1)//file >create {
		 * 
		 * Stringstr1=JOptionPane.showInputDialog(this,
		 * "Enter the  name of  the file along with the complete  path to be created "
		 * );
		 * 
		 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection
		 * con=DriverManager.getConnection("jdbc:odbc:ankur_db","sa","apkc");
		 * Statement st=con.createStatement();
		 * 
		 * }
		 */
		// -------------------------------------------------------------------
		if (obj == menuitem2)// file >delete
		{
			try {
				String str1 = JOptionPane
						.showInputDialog(this,
								"Enter the  name of  the file along with the complete  path to be deleted ");
				String str2 = "xp_cmdshell 'del " + str1 + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str2);

				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, str1
						+ "  sucessfully deleted", "File Deletion", 0, icon1);
			}// end of try
			catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		if (obj == menuitem3)// file >rename
		{
			try {
				String str1 = JOptionPane
						.showInputDialog(this,
								"Enter the  name of  the file along with the complete  path to be renamed ");
				String str2 = JOptionPane.showInputDialog(this,
						"Enter the  new name for the file");
				String str3 = "xp_cmdshell 'ren " + str1 + " " + str2 + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str3);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, str1 + " renamed to "
						+ str2, "File Renaming", 0, icon2);
			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		if (obj == menuitem4)// file >copy
		{
			try {
				String str1 = JOptionPane
						.showInputDialog(this,
								"Enter the  name of  the file along with the complete  path to be copied ");
				String str2 = JOptionPane
						.showInputDialog(
								this,
								"Enter the  new path where the file is to be copied along with the new file name also");
				String str3 = "xp_cmdshell 'copy " + str1 + " " + str2 + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str3);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, str1
						+ " copied sucessfully to " + str2, "File Deletion", 0,
						icon3);
			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		if (obj == menuitem5)// file >move
		{
			try {
				String str1 = JOptionPane
						.showInputDialog(this,
								"Enter the  name of  the file along with the complete  path to be moved");
				String str2 = JOptionPane
						.showInputDialog(
								this,
								"Enter the  new path where the file is to be moved along with the new file name also");
				String str3 = "xp_cmdshell 'move " + str1 + " " + str2 + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str3);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, str1 + " moved " + "to "
						+ str2, "File Moving", 0, icon4);
			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		/*
		 * if(obj==menuitem6)//file >write to file { String
		 * str1=JOptionPane.showInputDialog(this,
		 * "Enter the  name of  the file along with the complete  path to be created "
		 * ); String str2="xp_cmdshell 'del "+str1 +"'";
		 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection
		 * con=DriverManager
		 * .getConnection("jdbc:odbc:dsn_SQLServer_dbJDBC","sa","apkc");
		 * Statement st=con.createStatement(str2); }
		 */
		// -------------------------------------------------------------------
		if (obj == menuitem7)// file >read from file
		{
			try {
				String str1 = JOptionPane
						.showInputDialog(
								this,
								"Enter the  name of  the file along with the complete  path the contents of which you want displayed ");
				String str2 = "xp_cmdshell 'type " + str1 + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str2);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, " The contents of " + str1
						+ "have been sucessfully displayed",
						"Reading From File", 0, icon5);
			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		if (obj == menuitem8)// directory>create
		{
			try {
				String str1 = JOptionPane
						.showInputDialog(
								this,
								"Enter the  name of  the directory along with the complete  path to be created ");
				String str2 = "xp_cmdshell 'mkdir " + str1 + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str2);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, str1
						+ " directory has been sucessfully created ",
						"Directory Creation", 0, icon6);
			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		if (obj == menuitem9)// directory >delete
		{
			try {
				String str1 = JOptionPane
						.showInputDialog(
								this,
								"Enter the  name of  the directory along with the complete  path to be created ");
				String str2 = "xp_cmdshell 'rmdir/S/Q" + str1 + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str2);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, str1
						+ " directory has been sucessfully deleted",
						"Directory Deletion", 0, icon7);
			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		if (obj == menuitem10)// directory>rename
		{
			try {
				// String
				// str1=JOptionPane.showInputDialog(this,"Enter the  name of  the directory");
				// String str2="xp_cmdshell 'ren "+str1 +"'";

				String str1 = JOptionPane
						.showInputDialog(this,
								"Enter the  name of  the file along with the complete  path to be renamed");
				String str2 = JOptionPane
						.showInputDialog(
								this,
								"Enter the  new path where the file is to be renamed,specifying the complete  path is optional");
				String str3 = "xp_cmdshell 'ren " + str1 + " " + str2 + "'";

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str3);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, str1 + " renamed",
						"File Renaming", 0, icon8);
			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		/*
		 * if(obj==menuitem11)//directory>copy { String
		 * str1=JOptionPane.showInputDialog(this,
		 * "Enter the  name of  the file along with the complete  path to be created "
		 * ); String str2="xp_cmdshell 'del "+str1 +"'";
		 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection
		 * con=DriverManager
		 * .getConnection("jdbc:odbc:dsn_SQLServer_dbJDBC","sa","apkc");
		 * Statement st=con.createStatement(); }
		 */
		// -------------------------------------------------------------------
		/*
		 * if(obj==menuitem12)//directory>move { String
		 * str1=JOptionPane.showInputDialog(this,
		 * "Enter the  name of  the file along with the complete  path to be created "
		 * ); String str2="xp_cmdshell 'del "+str1 +"'";
		 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection
		 * con=DriverManager
		 * .getConnection("jdbc:odbc:dsn_SQLServer_dbJDBC","sa","apkc");
		 * Statement st=con.createStatement(); }
		 */
		// -------------------------------------------------------------------
		if (obj == menuitem13)// tree
		{
			try {
				String str1 = JOptionPane
						.showInputDialog(
								this,
								"Enter the  directory name of  the file along with the complete  path whose subdirectories paths have to be genereated ");
				String str2 = "xp_cmdshell 'tree " + str1 + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str2);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
				JOptionPane.showMessageDialog(this, " Tree", "Tree", 0, icon9);
			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// -------------------------------------------------------------------
		if (obj == menuitem14)// time
		{
			try {
				// String
				// str1=JOptionPane.showInputDialog(this,"Enter the  name of  the file along with the complete  path to be created ");
				String str2 = "xp_cmdshell 'time /T" + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str2);
				while (rs.next()) {
					JOptionPane.showMessageDialog(this, " Time is : "
							+ rs.getString(1), "Time", 0, icon10);
				}

			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// ------------------------------------------------------------------
		if (obj == menuitem15)// date
		{
			try {
				// String
				// str1=JOptionPane.showInputDialog(this,"Enter the  name of  the file along with the complete  path to be created ");
				String str2 = "xp_cmdshell 'date /T" + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str2);
				while (rs.next()) {
					JOptionPane.showMessageDialog(this, " Date is : "
							+ rs.getString(1), "Date", 0, icon11);
				}

			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// ------------------------------------------------------------------

		if (obj == menuitem16)// Version
		{
			try {
				// String
				// str1=JOptionPane.showInputDialog(this,"Enter the  name of  the file along with the complete  path to be created ");
				String str2 = "xp_cmdshell 'ver" + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str2);
				while (rs.next()) {
					JOptionPane.showMessageDialog(this, " Version is : "
							+ rs.getString(1), "Version", 0, icon12);
				}

			} catch (Exception e) {
				System.out.println("error in menu item");
			}

		}
		// ------------------------------------------------------------------

		if (obj == btest) {
			try {

				// String str1="xp_cmdshell 'dir c:\\ankur3'";
				String str1 = "xp_cmdshell " + "'" + text12.getText() + "'";
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str1);
				while (rs.next()) {
					System.out.println(rs.getString(1));
				}
			} catch (Exception e) {
				System.out.println("error in btest " + e.getMessage());
			}
		}// end of if obj==btest
		/*
		 * if(obj==bselectclear) { int i=dbJDBC.dbo.Employees.getColumnCount();
		 * 
		 * System.out.println("col count = "+i); //for(int
		 * j=1;j<dbJDBC.dbo.Employees.getColumnCount();j++); //{ dbJDBC.dbo.Employees.removeColumn(1); //}
		 * }//end of obj==bselectclear
		 */
		// ---------------------------------------------
		/*
		 * if(obj==babout) {
		 * img=getImage(getDocumentBase(),getParameter("img")); //THIS METHOD
		 * CALLS PAINT }
		 */

		if (obj == bresult) {
			try {
				String str6 = "select * from " + text11.getText();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(str6);

				ResultSetMetaData rsmd = rs.getMetaData();
				int i = rsmd.getColumnCount();
				
				
				String str1 = rsmd.getColumnLabel(Integer.parseInt(text9
						.getText()));
				String str2 = rsmd.getColumnName(Integer.parseInt(text9
						.getText()));
				// System.out.println("col count in table dbJDBC.dbo.Employees is : "+i);
				// System.out.println("col name of col no "+text9.getText()
				// +"is : " +str2);
				// System.out.println("col label of col no "+text9.getText()
				// +"is : " +str1);

				label1.setForeground(Color.white);
				label1.setText("col count in table dbJDBC.dbo.Employees is : " + i + "   "
						+ "Column Name : " + str2 + "   " + "Column Label : "
						+ str1);
				System.out.println("done");
			} catch (Exception e) {
				System.out.println("error in resultsetmetadata " + e);
			}
		}// end of obj==brcolocount

		if (obj == bfread) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement ps = con.createStatement();
				// ResultSet
				// rs=ps.executeQuery("execute xp_cmdshell 'mkdir ankur3'");
				// JOptionPane.showMessageDialog(this,"directory created","CREATE DIRECTORY",2);

				DatabaseMetaData dbmd = con.getMetaData();
			}// end or try
			catch (Exception e11) {
				System.out.println("error in bfread : " + e11);
			}
		}// end of obj==bfread

		if (obj == brmeta1) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from dbJDBC.dbo.Employees");
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				System.out.println("no of columns in given result set are "
						+ cols);

				for (int i = 1; i <= cols; i++) {
					System.out.println(rsmd.getColumnName(i));

				}

				while (rs.next()) {
					for (int i = 1; i <= cols; i++) {
						switch (rsmd.getColumnType(i)) {
						case java.sql.Types.INTEGER:
							System.out.println("datatype is integer");
							break;

						case java.sql.Types.VARCHAR:
							System.out.println("datatype is varchar");
							break;

						}// end of switch

					}// end of for
				}// end of while

			} catch (Exception e12) {
				System.out.println("error in brmeta1 : " + e12);
			}
		}// end of obj==brmeta1

		if (obj == bdmeta1) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");

				// gets the database name on which the dsn was created
				String str1 = con.getCatalog();
				System.out.println(str1);

				// gets the list of all databases
				DatabaseMetaData db = con.getMetaData();
				ResultSet rs = db.getCatalogs();

				System.out.println("following catalogs are availaible : ");
				while (rs.next()) {
					System.out.println(rs.getString("TABLE_CAT"));
				}

			}// end of try
			catch (Exception e10) {
				System.out.println("error in bdmeta1 : " + e10.getMessage());
			}
		}// end of obj==bdmeta1

		/*
		 * if(obj==bdmeta2) { try {
		 * Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); Connection
		 * con=DriverManager
		 * .getConnection("jdbc:odbc:dsn_SQLServer_dbJDBC","sa","apkc");
		 * 
		 * DatabaseMetaData db=con.getMetaData(); ResultSet rs=db.getSchemas();
		 * System
		 * .out.println("follwing schemas are availaible in this database : ");
		 * while(rs.next()) { System.out.println(rs.getString("TABLE_SCHEM")); }
		 * } catch(Exception e11) {
		 * System.out.println("error in bdmeta2 : "+e11); } }//end of if
		 * obj==bdmeta2
		 */

		if (obj == binss) {

			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				int i = st
						.executeUpdate("insert into dbJDBC.dbo.Employees values (1,'ankur','munirka')");
				System.out.println(i);
				JOptionPane.showMessageDialog(this,
						"Statement,executeInsert,insert",
						"VALUSES INSERTED THRU STATIC INSERT", 0);
			}// end of try
			catch (Exception e1) {
				System.out.println("error in static insert : " + e1);
			}
		}// end of if obj==binss

		if (obj == binsp) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				PreparedStatement ps = con
						.prepareStatement("insert into dbJDBC.dbo.Employees values (?,?,?)");
				ps.setInt(1, Integer.parseInt(text1.getText()));
				ps.setString(2, text2.getText());
				ps.setString(3, text3.getText());
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this,
						"Values inserted thru (PreparedStatement,executeUpdate,insert) are : "
								+ " ," + text1.getText() + " ,"
								+ text2.getText() + " ," + text3.getText(),
						"DYNAMIC INSERT QUERY SUCESSFULLY EXECUTED", 0);
			} catch (Exception e2) {
				System.out.println("error in dynamic insert : " + e2);

			}
		}// end of if obj==binsp

		if (obj == bupds) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				int i = st
						.executeUpdate("update  dbJDBC.dbo.Employees set ename='ankur',eaddr='munirka'  where eno=1");
				JOptionPane.showMessageDialog(this,
						"Statement,executeUpdate,update", "STATIC UPDATE", 0);
			} catch (Exception e9) {
				System.out.println("error in static update : " + e9);
			}
		}// end of if obj==bupds

		if (obj == bupdp) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				PreparedStatement ps = con
						.prepareStatement("update dbJDBC.dbo.Employees set ename=? , eaddr=? where eno=?");
				ps.setString(1, text6.getText());
				ps.setString(2, text7.getText());
				ps.setInt(3, Integer.parseInt(text5.getText()));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this,
						"PreparedStatement,executeUpdate,update",
						"DYNAMIC UPDATE", 0);
			} catch (Exception e8) {
				System.out.println("error in dynamic update : " + e8);
			}
		}// end of obj==bupdb

		if (obj == bdels) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				int i = st.executeUpdate("delete  from  dbJDBC.dbo.Employees where eno=1");
				JOptionPane.showMessageDialog(this,
						"Statement,executeUpdate,update", "STATIC DELETE", 0);
			} catch (Exception e9) {
				System.out.println("error in static update : " + e9);
			}
		}// end of obj==dels

		if (obj == bdelp) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				PreparedStatement ps = con
						.prepareStatement("delete dbJDBC.dbo.Employees where eno=?");
				ps.setInt(1, Integer.parseInt(text8.getText()));
				ps.executeUpdate();
				JOptionPane.showMessageDialog(this,
						"PreparedStatement,executeUpdate,update",
						"DYNAMIC DELETE", 0);
			} catch (Exception e8) {
				System.out.println("error in dynamic update : " + e8);
			}
			JOptionPane.showMessageDialog(this,
					"PreparedStatement,executeUpdate,delete", "DYNAMIC DELETE",
					0);
		}

		if (obj == bexecuteproc) {
			try {
				String str6 = "exec " + text19.getText();
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				PreparedStatement ps = con.prepareStatement(str6);
				ps.execute();
				JOptionPane.showMessageDialog(this, "procedure executed",
						"EXECUTING A PROCEDURE", 0);
			} catch (Exception e10) {
				System.out.println("error in executing procedure : " + e10);
			}

		}// end of bexecuteproc

		if (obj == bcreateproc) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				// PreparedStatement
				// ps=con.prepareStatement("create procedure p9 as begin insert into dbJDBC.dbo.Employees values(24,'vivek','teotia') end ");

				PreparedStatement ps = con.prepareStatement(ta1.getText());
				ps.execute();
				JOptionPane.showMessageDialog(this, "procedure created",
						"CREATE A NEW PROCEDURE", 0);
			} catch (Exception e10) {
				System.out.println("error in creating procedure : " + e10);
			}

		}// end of obj==bcreateproc

		if (obj == bstaticselect) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from dbJDBC.dbo.Employees");
				int i = 1;
				int j = 0;
				myJTable.setValueAt("Employee Number", 0, 0);
				myJTable.setValueAt("Employee Name", 0, 1);
				myJTable.setValueAt("Employoee Email", 0, 2);
				while (rs.next()) {

					/*
					 * System.out.println(rs.getString(1));
					 * System.out.println(rs.getString(2));
					 * System.out.println(rs.getString(3));
					 */

					// dbJDBC.dbo.Employees.addColumn((javax.swing.table.TableColumn)rs.getString(1));
					myJTable.setValueAt(rs.getString(1), i, j);
					j++;
					myJTable.setValueAt(rs.getString(2), i, j);
					j++;
					myJTable.setValueAt(rs.getString(3), i, j);
					i++;
					j = 0;

				}// end of while
			} catch (Exception e3) {
				System.out.println("error in static select : " + e3);
			}
		}// end of if obj==bstaticselect

		if (obj == bdynamicselect) {
			try {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
				PreparedStatement ps = con
						.prepareStatement("select * from dbJDBC.dbo.Employees where eno=?");
				ps.setInt(1, Integer.parseInt(text4.getText()));
				ResultSet rs = ps.executeQuery();

				int i = 0;
				int j = 0;
				while (rs.next()) {

					// System.out.println(rs.getString(1));
					// System.out.println(rs.getString(2));
					// System.out.println(rs.getString(3));

					try {

						myJTable.setValueAt(rs.getString(1), i, j);
						j++;
						System.out.println("i= " + i + "j= " + j);
						myJTable.setValueAt(rs.getString(2), i, j);
						j++;
						System.out.println("i= " + i + "j= " + j);
						myJTable.setValueAt(rs.getString(3), i, j);
						i++;
						j = 0;
						System.out.println("i= " + i + "j= " + j);
					} catch (Exception e5) {
						System.out.println("error in setting table values : "
								+ e5);
						System.out.println("i= " + i + "j= " + j);
					}

				}// end of while
			} catch (Exception e4) {
				System.out.println("error in dynamic select : " + e4);
			}
		}// end of if obj==bdynamicselect
		// _____________________________________________________
		if (obj == l1) {
			String str1 = l1.getSelectedItem();
			if (str1.equals("getDriverVersion")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str12 = dbmd.getDriverVersion();
					JOptionPane.showMessageDialog(this, str12,
							"getDriverVersion", 1);
				} catch (Exception e13) {
					System.out.println("error in getDriverVersion "
							+ e13.getMessage());
				}
			}
			// -----------------------------------------
			if (str1.equals("SCHEMA LIST")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					ResultSet rs = dbmd.getSchemas();
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
				} catch (Exception e) {
				}
			}// end of str1.equals schema list
			// -----------------------------------------
			if (str1.equals("TYPE INFO")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					ResultSet rs5 = dbmd.getTypeInfo();
					int i = 0;
					while (rs5.next()) {
						JOptionPane.showMessageDialog(this, "TYPE_NAME" + ":"
								+ rs5.getString("TYPE_NAME") + "\n"
								+ "LITERAL_PREFIX" + ":"
								+ rs5.getString("LITERAL_PREFIX") + "\n"
								+ "LITERAL_SUFFIX" + ":"
								+ rs5.getString("LITERAL_SUFFIX") + "\n"
								+ "CREATE_PARAMS" + ":"
								+ rs5.getString("CREATE_PARAMS") + "\n"
								+ "NULLABLE" + ":" + rs5.getString("NULLABLE")
								+ "\n" + "CASE_SENSITIVE" + ":"
								+ rs5.getString("CASE_SENSITIVE") + "\n"
								+ "SEARCHABLE" + ":"
								+ rs5.getString("SEARCHABLE") + "\n"
								+ "UNSIGNED_ATTRIBUTE" + ":"
								+ rs5.getString("UNSIGNED_ATTRIBUTE") + "\n"
								+ "FIXED_PREC_SCALE" + ":"
								+ rs5.getString("FIXED_PREC_SCALE") + "\n"
								+ "LOCAL_TYPE_NAME" + ":"
								+ rs5.getString("LOCAL_TYPE_NAME"),
								"TYPE-INFO", 0);
						i++;
					}
					System.out.println("total count= " + i);
				} catch (Exception e) {
				}
			}// end of str1.equals typeinfo
			// -----------------------------------------------------------------------
			if (str1.equals("getURL")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str7 = dbmd.getURL();
					JOptionPane.showMessageDialog(this, str7, "getURL", 1);
				} catch (Exception e) {
				}
			}// end of if str1.equals geturl
			// -----------------------------------------------------------------------
			if (str1.equals("getUserName")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str8 = dbmd.getUserName();
					JOptionPane.showMessageDialog(this, str8, "getUserName", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getusername
			// -----------------------------------------------------------------------
			if (str1.equals("getDatabaseProductName")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str9 = dbmd.getDatabaseProductName();
					JOptionPane.showMessageDialog(this, str9,
							"getDatabaseProductName", 1);
				} catch (Exception e) {
				}
			}// end of getdatabaseproductname
			// -----------------------------------------------------------------------
			if (str1.equals("getDriverName")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str10 = dbmd.getDriverName();
					JOptionPane.showMessageDialog(this, str10, "getDriverName",
							1);
				} catch (Exception e) {
				}
			}// end of str1.equals getdrivername

			// -----------------------------------------------------------------------
			if (str1.equals("getDatabaseProductVersion")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str11 = dbmd.getDatabaseProductVersion();
					JOptionPane.showMessageDialog(this, str11,
							"getProductVersion", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getdatabaseproductversion

			// -----------------------------------------------------------------------
			if (str1.equals("getDriverVersion")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str12 = dbmd.getDriverVersion();
					JOptionPane.showMessageDialog(this, str12,
							"getDriverVersion", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getdriverversion
			// -----------------------------------------------------------------------
			if (str1.equals("getDriverMajorVersion")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					// int i4=dbmd.getDriverMajorVersion();
					// JOptionPane.showMessageDialog(this,+str6,"getDriverMajorVersion",1);
				} catch (Exception e) {
				}
			}// end of str1.equals getdrivermajorversion

			// -----------------------------------------------------------------------
			if (str1.equals("getDriverMinorVersion")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					// int i5=dbmd.getDriverMinorVersion();
					// JOptionPane.showMessageDialog(this,+str6,"getDriverMinorVersion",1);
				} catch (Exception e) {
				}
			}// end of str1.equals getdriverminorversion
			// -----------------------------------------------------------------------
			if (str1.equals("getProcedureTerm")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str = dbmd.getProcedureTerm();
					JOptionPane.showMessageDialog(this, str,
							"getProcedureTerm", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getprocedureterm
			// ----------------------------------------------------------------
			// NOTWORKING
			// System.out.println("getprocedures : .......");
			// ResultSet rs=dbmd.getProcedures();
			// while(rs.next())
			// {
			// System.out.println(rs.getString(1));
			// }
			// ----------------------------------------------------------------
			// WORKING
			// boolean b=dbmd.supportsStoredProcedures();
			// System.out.println("support for stored procedures : "+b);
			// ----------------------------------------------------------------
			if (str1.equals("getSchemaTerm")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String schematerm = dbmd.getSchemaTerm();
					JOptionPane.showMessageDialog(this, schematerm,
							"getSchemaTerm", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getdriverminorversion

			// ----------------------------------------------------------------------
			if (str1.equals("getSearchStringEscape")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String searchstringescape = dbmd.getSearchStringEscape();
					JOptionPane.showMessageDialog(this, searchstringescape,
							"getSearchStringEscape", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getsearchstringescape

			// -------------------------------------------------------------------
			if (str1.equals("getSQLKeywords")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String sqlwords = dbmd.getSQLKeywords();
					JOptionPane.showMessageDialog(this, sqlwords + "/n",
							"getSQLKeywords", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getsqlkeywords

			// -------------------------------------------------------------------
			if (str1.equals("getStringFunctions")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String sqlfunctions = dbmd.getStringFunctions();
					JOptionPane.showMessageDialog(this, sqlfunctions + "/n",
							"getStringFunctions", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getstringfunctions

			// -------------------------------------------------------------------
			if (str1.equals("getSystemFunctions")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String sqlsystemfunctions = dbmd.getSystemFunctions(); // int
																			// i5=dbmd.getDriverMinorVersion();
					JOptionPane.showMessageDialog(this, sqlsystemfunctions,
							"getSystemFunctions", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getsystemfunctions

			// -------------------------------------------------------------------
			// NOT WORKING
			/*
			 * try { ResultSet rs1=dbmd.getTablePrivileges("","%","%");
			 * while(rs1.next()) { System.out.println(rs.getString(1)); } }
			 * catch(Exception e12) {
			 * System.out.println("error in gettableprivileges : "+e12); }
			 */
			// ---------------------------------------------------------------------------
			if (str1.equals("getCatalogTerm")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String catalogterm = dbmd.getCatalogTerm();
					JOptionPane.showMessageDialog(this, catalogterm,
							"getCatalogTerm", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getcatalogterm

			// --------------------------------------------------------------------------
			if (str1.equals("getTimeDateFunctions")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					Connection con = DriverManager.getConnection(
							"jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
					DatabaseMetaData dbmd = con.getMetaData();
					String str4 = dbmd.getTimeDateFunctions();
					JOptionPane.showMessageDialog(this, str4 + "/n",
							"getTimeDateFunctions", 1);
				} catch (Exception e) {
				}
			}// end of str1.equals getdriverminorversion

			// --------------------------------------------------------------------------

		}// end of obj=l1

	}// end of actionPerformed()

}// end of class