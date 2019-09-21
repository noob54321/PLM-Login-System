import javax.swing.*;
import java.awt.*;

public class MainAt extends JFrame {
	
	private JLabel logo;
	private JLabel logo_label;
	private JLabel user_label;
	private JLabel pass_label;
	private JTextField user_txtbox;
	private JPasswordField pass_txtbox;
	private JButton con_but;
	private Font font1;
	
	public MainAt() {
		Init();
	}
	
	private void Init() {
		
		font1 = new Font("Verdana",Font.BOLD,24);
		
		Logo();
		User();
		Password();
		Confirm();
		
		setTitle("PLM-Attendance");
		setSize(500,650);
		setLayout(null);
		setResizable(false);
		getContentPane().setBackground(Color.DARK_GRAY);
		setVisible(true);
	}
	
	private void Logo() {
		logo = new JLabel();
		logo.setIcon(new ImageIcon("C:\\Users\\Flamel\\Desktop\\map.jpg"));
		logo.setBounds(200,50,100,100);
	
		logo_label = new JLabel("PLM ATTENDACE");
		logo_label.setForeground(Color.WHITE);
		logo_label.setBounds(200,150,200,50);
		
		add(logo);
		add(logo_label);
	}
	
	private void User() {
		user_label = new JLabel("Username:");
		user_label.setFont(font1);
		user_label.setBounds(50,200,400,50);
		user_label.setForeground(Color.WHITE);
		
		user_txtbox = new JTextField();
		user_txtbox.setBackground(Color.WHITE);
		user_txtbox.setBounds(50,250,400,50);
		user_txtbox.setFont(font1);
		
		add(user_label);
		add(user_txtbox);
	}
	
	private void Password() {
		pass_label =  new JLabel("Password:");
		pass_label.setFont(font1);
		pass_label.setBounds(50,300,400,50);
		pass_label.setForeground(Color.WHITE);
		
		pass_txtbox = new JPasswordField();
		pass_txtbox.setFont(font1);
		pass_txtbox.setBounds(50,350,400,50);
		pass_txtbox.setBackground(Color.WHITE);
		
		add(pass_label);	
		add(pass_txtbox);
	}
	
	private void Confirm() {
		con_but = new JButton();
		con_but.setText("Log In");
		con_but.setFont(font1);
		con_but.setBounds(150,450,200,50);
		con_but.setBackground(Color.YELLOW);
		
		add(con_but);
	}
	
	public static void main(String args[]) {
		MainAt mai = new MainAt();
	}
}
