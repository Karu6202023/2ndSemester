import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountLogin extends JFrame {

    private JTextField usernameField, passwordField;
    private JButton loginButton, createAccountButton;
    private String correctUsername = "user";
    private String correctPassword = "password";

    public AccountLogin() {
        setTitle("Account Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        panel.add(loginButton);

        createAccountButton = new JButton("Create Account");
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });
        panel.add(createAccountButton);

        add(panel);
        setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            openUserInfoForm();
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect username or password. Please try again.");
        }
    }

    private void createAccount() {
        
        JOptionPane.showMessageDialog(this, "Account created successfully!");
    }

    private void openUserInfoForm() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserInfoForm();
                dispose(); 
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AccountLogin();
            }
        });
    }
}
