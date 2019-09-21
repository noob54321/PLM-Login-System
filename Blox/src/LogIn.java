import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LogIn extends JFrame {
	
	private JTextField stud_idLabel;
	private JLabel stud_name;
	private JLabel room_name;
	private JLabel room_map;
	private JLabel stud_pic;
	private Font font1,font2;
	private JLabel time_label;
	private JLabel date_label;
	private JButton test_button; 
	
	public LogIn() {
		Init();
	}
	
	private void Init() {
		font1 = new Font("Verdana",Font.BOLD,64);
		
		Student_ID();
		Student_Name();
		Student_Pic();
		Room_Name();
		Room_Map();
		Time();
		Date();
		
		Test();
		
		Default();
		addTick();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setLayout(null);
	}
		
	private void Student_ID() {
		stud_idLabel = new JTextField();
		stud_idLabel.setText("");
		stud_idLabel.setBounds(0,0,700,200);
		stud_idLabel.setEditable(true);
		stud_idLabel.setBackground(Color.DARK_GRAY);
		stud_idLabel.setForeground(Color.WHITE);
		stud_idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stud_idLabel.setFont(font1);
		add(stud_idLabel);
	}
	
	private void Student_Name() {
		stud_name = new JLabel();
		stud_name.setText("");
		stud_name.setHorizontalAlignment(SwingConstants.CENTER);
		stud_name.setBounds(0,200,750,250);
		stud_name.setOpaque(true);
		stud_name.setBackground(Color.LIGHT_GRAY);
		stud_name.setFont(font1);
		add(stud_name);
	}
	
	private void Student_Pic() {
		stud_pic = new JLabel();
		stud_pic.setBounds(750,0,750,450);
		stud_pic.setOpaque(true);
		stud_pic.setBackground(Color.CYAN);
		stud_pic.setHorizontalAlignment(SwingConstants.CENTER);
		
		try {
			ImageIcon studicon = new ImageIcon(this.getClass().getResource("/prof.jpg"));
			Image studiconx = studicon.getImage().getScaledInstance(stud_pic.getWidth(), stud_pic.getHeight(),Image.SCALE_SMOOTH);
			stud_pic.setIcon(new ImageIcon(studiconx));
		}catch(Exception e) {
			e.printStackTrace();
		}
		add(stud_pic);
		
	}
	
	private void Room_Name() {
		room_name = new JLabel();
		room_name.setText("You are here :");
		room_name.setHorizontalAlignment(SwingConstants.CENTER);
		room_name.setBounds(0,450,500,250);
		room_name.setOpaque(true);
		room_name.setBackground(Color.GRAY);
		
		font2 = new Font("Verdana",Font.BOLD,54);
		room_name.setFont(font2);
		add(room_name);
		
	}
	
	private void Room_Map() {
		room_map = new JLabel();
		room_map.setBounds(500,450,900,250);
		room_map.setOpaque(true);
		room_map.setBackground(Color.WHITE);
		room_map.setHorizontalAlignment(SwingConstants.CENTER);
		
		try {
			ImageIcon roomicon = new ImageIcon(this.getClass().getResource("/unkn.png"));
			Image roomx = roomicon.getImage().getScaledInstance(room_map.getWidth(), room_map.getHeight(),Image.SCALE_SMOOTH);
			room_map.setIcon(new ImageIcon(roomx));
		}catch(Exception e) {
			e.printStackTrace();
		}

		add(room_map);
	}
	
	private void Time() {
		time_label = new JLabel();
		time_label.setBounds(0,700,700,75);
		time_label.setOpaque(true);
		time_label.setBackground(Color.BLACK);
		time_label.setForeground(Color.WHITE);
		time_label.setFont(font1);
		time_label.setHorizontalAlignment(SwingConstants.CENTER);
		add(time_label);
	}
	
	private void Date() {
		date_label = new JLabel();
		date_label.setBounds(700,700,700,75);
		date_label.setOpaque(true);
		date_label.setBackground(Color.BLACK);
		date_label.setForeground(Color.WHITE);
		date_label.setFont(font1);
		date_label.setHorizontalAlignment(SwingConstants.CENTER);
		add(date_label);
	}
	
	private void Default() {
		stud_idLabel.setText("-------------");
		stud_name.setText("-------------");
	}
	
	private void addTick() {
		Thread addTick = new Thread() {
			public void run() {
				try {
					for(;;) {
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
						Date date = new Date();
						
						//only time
						time_label.setText("Time: " + sdf.format(date));
						
						//only date
						sdf = new SimpleDateFormat("E yyyy/MM/dd");
						date_label.setText(sdf.format(date));
						
						sleep(1000);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		addTick.start();
	}
	
	private void Test() {
		test_button = new JButton(">>"); 
		test_button.setBounds(700,0,50,200);
		test_button.setBackground(Color.YELLOW);	
		test_button.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				stud_idLabel.setText("hello world");
	        }  
	    }); 
		
		add(test_button);
	}
	
	
	public static void main(String args[]) {
		
		try {
			LogIn log1 = new LogIn();
			log1.setVisible(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
