import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminGUI implements ActionListener {

    private JTabbedPane adminTab;
    private JTable histTable;
    private JButton histButton;

    public static void main(String[] args) {
        AdminGUI gui= new AdminGUI();
        gui.init();
    }

    private void init() {
        JFrame frame= new JFrame("Admin");

        tabs();
        history();

        frame.setLocationRelativeTo(null);  // Starts the program at the center
        frame.getContentPane().add(adminTab);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setVisible(true);
    }

    /** The tabs */
    private void tabs() {
        adminTab= new JTabbedPane(JTabbedPane.LEFT);
        adminTab.addTab("ALL HISTORY", history());
        JComponent addUser= makeTextPanel("ADD USER");
        adminTab.addTab("ADD USER", addUser);
        JComponent modify= makeTextPanel("MODIFY SCANNER SETTINGS");
        adminTab.addTab("MODIFY SCANNER SETTINGS", modify);
    }

    /** All user histories */
    private JComponent history() {
        JPanel panel= new JPanel();

        histButton= new JButton("Submit");
        histButton.setBounds(100, 100, 140, 40);

        // enter name label
        JLabel label= new JLabel();
        label.setText("Enter Name :");
        label.setBounds(10, 10, 100, 100);

        // empty label which will show event after button clicked
        JLabel label1= new JLabel();
        label1.setBounds(10, 110, 200, 100);

        // text field to enter name
        JTextField textfield= new JTextField();
        textfield.setBounds(110, 50, 130, 30);
        // add to panel
        panel.add(histButton);
        panel.add(label);
        panel.add(label1);
        panel.add(textfield);
        histButton.addActionListener(this);
        // Data to be displayed in the JTable
        String[][] data= {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };

        // Column Names
        String[] columnNames= { "Name", "Roll Number", "Department" };

        // Initializing the JTable
        histTable= new JTable(data, columnNames);
        JScrollPane sp= new JScrollPane(histTable);
        panel.add(sp);
        return panel;
    }

    private JComponent makeTextPanel(String text) {
        JPanel panel= new JPanel(false);
        JLabel filler= new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        histButton.setText("I've been clicked!");
    }
}