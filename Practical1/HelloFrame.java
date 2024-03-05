import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HelloFrame extends JFrame implements ActionListener {

    private JLabel greeting;
    private PrintWriter writer;
    private JTextField idField;
    private JTextField fnameField;
    private JTextField miField;
    private JTextField lnameField;
    private JTextField cField;
    private JTextField ylField;
    private JCheckBox checkBoxMale;
    private JCheckBox checkBoxFemale;
    private JCheckBox checkBoxTerms;
    private List<String> cartItems;

    private JFrame ecommerceFrame;

    public static void main(String[] args) {
        new HelloFrame();
    }

    public HelloFrame() {
        cartItems = new ArrayList<>();

        JFrame frame = new JFrame("Personal Credentials");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        greeting = new JLabel("");
        greeting.setFont(new Font("Arial", Font.BOLD, 18));
        greeting.setHorizontalAlignment(JLabel.CENTER);

        JLabel title = new JLabel("Personal Credentials");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBounds(150, 10, 200, 30);

        JLabel idLabel = new JLabel("Phone Number:");
        idLabel.setBounds(50, 60, 100, 20);
        idField = new JTextField();
        idField.setBounds(150, 60, 150, 20);

        JLabel fNameLabel = new JLabel("Full Name:");
        fNameLabel.setBounds(50, 100, 100, 20);
        fnameField = new JTextField();
        fnameField.setBounds(150, 100, 150, 20);

        JLabel miLabel = new JLabel("Age:");
        miLabel.setBounds(310, 100, 50, 20);
        miField = new JTextField();
        miField.setBounds(340, 100, 40, 20);

        JLabel lNameLabel = new JLabel("Email Address:");
        lNameLabel.setBounds(50, 140, 100, 20);
        lnameField = new JTextField();
        lnameField.setBounds(150, 140, 150, 20);

        JLabel cLabel = new JLabel("Location:");
        cLabel.setBounds(50, 180, 100, 20);
        cField = new JTextField();
        cField.setBounds(150, 180, 150, 20);

        JLabel ylLabel = new JLabel("Date of Birth:");
        ylLabel.setBounds(50, 220, 100, 20);
        ylField = new JTextField();
        ylField.setBounds(150, 220, 150, 20);

        JButton button = new JButton("Submit");
        button.setBounds(270, 300, 100, 30);
        button.addActionListener(this);

        checkBoxMale = new JCheckBox("Male");
        checkBoxMale.setBounds(50, 260, 100, 20);

        checkBoxFemale = new JCheckBox("Female");
        checkBoxFemale.setBounds(200, 260, 100, 20);

        checkBoxTerms = new JCheckBox("Agree to terms and policy");
        checkBoxTerms.setBounds(50, 290, 200, 20);

        panel.add(title);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(fNameLabel);
        panel.add(fnameField);
        panel.add(miLabel);
        panel.add(miField);
        panel.add(lNameLabel);
        panel.add(lnameField);
        panel.add(cLabel);
        panel.add(cField);
        panel.add(ylLabel);
        panel.add(ylField);
        panel.add(button);
        panel.add(checkBoxMale);
        panel.add(checkBoxFemale);
        panel.add(checkBoxTerms);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(greeting, BorderLayout.SOUTH);

        frame.setVisible(true);

        try {
            String filePath = "output.txt";
            writer = new PrintWriter(new FileWriter(filePath));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String IdNumber = idField.getText();
        String fName = fnameField.getText();
        String mI = miField.getText();
        String lName = lnameField.getText();
        String c = cField.getText();
        String yearLevel = ylField.getText();
        String gender = "";

        if (checkBoxMale.isSelected()) {
            gender = checkBoxMale.getText();
        } else if (checkBoxFemale.isSelected()) {
            gender = checkBoxFemale.getText();
        }

        String termsPolicy = checkBoxTerms.isSelected() ? "Agreed to terms and policy" : "Did not agree to terms and policy";

        String preferredSports = "";

        String message = "*******************************\n" +
                "Personal Information Required:\n" +
                "ID Number: " + IdNumber + "\n" +
                "First Name: " + fName + "\n" +
                "Middle Initial: " + mI + "\n" +
                "Last Name: " + lName + "\n" +
                "Email Address: " + c + "\n" +
                "Location: " + c + "\n" +
                "Date of Birth: " + yearLevel + "\n" +
                "Gender: " + gender + "\n" +
                "Preferred Sports: " + preferredSports + "\n" +
                "Terms and Policy: " + termsPolicy + "\n" +
                "*******************************";

        greeting.setText("Welcome, " + fName);

        writer.println(message);
        writer.close();

        openECommerceFrame();
    }

    private void openECommerceFrame() {
        new ECommerceFrame(cartItems);
    }

    public List<String> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }
}

