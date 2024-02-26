import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoForm extends JFrame {

    private JTextField nameField, addressField, emailField, locationField, ageField;
    private JRadioButton maleRadioButton, femaleRadioButton;
    private ButtonGroup genderGroup;

    public UserInfoForm() {
        setTitle("User Information Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        try {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(7, 2));

            panel.add(new JLabel("Name:"));
            nameField = new JTextField();
            panel.add(nameField);

            panel.add(new JLabel("Address:"));
            addressField = new JTextField();
            panel.add(addressField);

            panel.add(new JLabel("Email Address:"));
            emailField = new JTextField();
            panel.add(emailField);

            panel.add(new JLabel("Location:"));
            locationField = new JTextField();
            panel.add(locationField);

            panel.add(new JLabel("Age:"));
            ageField = new JTextField();
            panel.add(ageField);

            panel.add(new JLabel("Gender:"));
            maleRadioButton = new JRadioButton("Male");
            femaleRadioButton = new JRadioButton("Female");
            genderGroup = new ButtonGroup();
            genderGroup.add(maleRadioButton);
            genderGroup.add(femaleRadioButton);
            JPanel genderPanel = new JPanel();
            genderPanel.add(maleRadioButton);
            genderPanel.add(femaleRadioButton);
            panel.add(genderPanel);

            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    submitUserInfo();
                }
            });
            panel.add(submitButton);

            add(panel);
            setVisible(true);
            System.out.println("Frame visibility set to true");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void submitUserInfo() {
        String name = nameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String location = locationField.getText();
        int age = Integer.parseInt(ageField.getText());
        String gender = maleRadioButton.isSelected() ? "Male" : "Female";

        
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Email Address: " + email);
        System.out.println("Location: " + location);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);

        openECommerceSystem();
    }

    private void openECommerceSystem() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ECommerceSystem();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UserInfoForm();
            }
        });
    }
}

