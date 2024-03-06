import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateLoginFrame extends JFrame implements ActionListener {
    private JTextField unField;
    private JPasswordField passField;
    private JButton logButton;
    private JButton cAccountButton;
    private JLabel greeting;
    private AccountManager accManager;

    public CreateLoginFrame() {
        accManager = new AccountManager();
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\user.MYCOMPUTER\\OneDrive\\shopping-cart-with-cereals.jpg");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        
        JLabel l1 = new JLabel("Username:");
        l1.setBounds(50, 50, 200, 20);
        add(l1);

        unField = new JTextField();
        unField.setBounds(50, 75, 200, 20);
        add(unField);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(50, 100, 200, 20);
        add(l2);

        passField = new JPasswordField();
        passField.setBounds(50, 125, 200, 20);
        add(passField);

        logButton = new JButton("Login");
        logButton.setBounds(50, 175, 100, 30);
        logButton.addActionListener(this);
        add(logButton);

        cAccountButton = new JButton("Create Account");
        cAccountButton.setBounds(200, 175, 150, 30);
        cAccountButton.addActionListener(this);
        add(cAccountButton);

        greeting = new JLabel("");
        greeting.setBounds(50, 225, 300, 20);
        add(greeting);

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logButton) {
            String un = unField.getText();
            String pass = new String(passField.getPassword());

            if (accManager.login(un, pass)) {
                greeting.setText("Welcome, " + un);
                HelloFrame helloFrame = new HelloFrame();
                helloFrame.setVisible(true);
            } else {
                greeting.setText("Invalid Username or Password");
            }
        } else if (e.getSource() == cAccountButton) {
            CreateAccountFrame cAccountFrame = new CreateAccountFrame(accManager);
            cAccountFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        CreateLoginFrame logFrame = new CreateLoginFrame();
        logFrame.setVisible(true);
    }
}

class AccountManager {
    private String[][] accounts;

    public AccountManager() {
        accounts = new String[10][3];
    }

    public boolean login(String un, String pass) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i][0] != null && accounts[i][0].equals(un)) {
                return accounts[i][1].equals(pass);
            }
        }
        return false;
    }

    public void createAccount(String un, String pass, String fName, String lName) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i][0] == null) {
                accounts[i][0] = un;
                accounts[i][1] = pass;
                accounts[i][2] = fName + " " + lName;
                break;
            }
        }
    }
}

class CreateAccountFrame extends JFrame implements ActionListener {
    private JTextField unField;
    private JPasswordField passField;
    private JTextField fNameField;
    private JTextField lNameField;
    private JButton cButton;
    private AccountManager accManager;

    public CreateAccountFrame(AccountManager accManager) {
        this.accManager = accManager;
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        JLabel l1 = new JLabel("Username:");
        l1.setBounds(50, 50, 200, 20);
        add(l1);

        unField = new JTextField();
        unField.setBounds(150, 50, 200, 20);
        add(unField);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(50, 80, 200, 20);
        add(l2);

        passField = new JPasswordField();
        passField.setBounds(150, 80, 200, 20);
        add(passField);

        JLabel l3 = new JLabel("First Name:");
        l3.setBounds(50, 110, 200, 20);
        add(l3);

        fNameField = new JTextField();
        fNameField.setBounds(150, 110, 200, 20);
        add(fNameField);

        JLabel l4 = new JLabel("Last Name:");
        l4.setBounds(50, 140, 200, 20);
        add(l4);

        lNameField = new JTextField();
        lNameField.setBounds(150, 140, 200, 20);
        add(lNameField);

        cButton = new JButton("Create Account");
        cButton.setBounds(150, 200, 150, 30);
        cButton.addActionListener(this);
        add(cButton);

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cButton) {
            String username = unField.getText();
            String password = new String(passField.getPassword());
            String firstname = fNameField.getText();
            String lastname = lNameField.getText();

            accManager.createAccount(username, password, firstname, lastname);
            JOptionPane.showMessageDialog(this, "Successfully created an Account!");
            dispose();
        }
    }
}

