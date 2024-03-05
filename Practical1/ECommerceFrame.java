import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ECommerceFrame {

    private List<String> cartItems;
    private JTextArea cartTextArea;

    public ECommerceFrame(List<String> cartItems) {
        this.cartItems = cartItems;

        JFrame ecommerceFrame = new JFrame("Lazadog.ph™ - Encina Corporations");
        ecommerceFrame.setSize(1000, 800);
        ecommerceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ecommerceFrame.setLayout(new BorderLayout());

        ImageIcon icon = new ImageIcon("C:\\Users\\user.MYCOMPUTER\\OneDrive\\dj.png");
        ecommerceFrame.setIconImage(icon.getImage());

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

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setOpaque(false);
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(0, 0, 0, 0));

        JLabel headerLabel = new JLabel("Lazadog.ph™");
        headerLabel.setForeground(Color.LIGHT_GRAY);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerPanel.add(headerLabel);

        JPanel productsPanel = new JPanel(new GridLayout(6, 4, 10, 10)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                
                ImageIcon backgroundImage = new ImageIcon("C:\\Users\\user.MYCOMPUTER\\OneDrive\\shopping-cart-with-cereals.jpg");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

                
                Component[] components = getComponents();
                for (Component component : components) {
                    if (component instanceof JLabel) {
                        JLabel label = (JLabel) component;
                        label.setBackground(new Color(0, 0, 0, 100));
                        label.setOpaque(true);
                    }
                }
            }
        };
        productsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        productsPanel.setOpaque(false); 

        String[] productNames = {
                "Iphone-$1000",
                "Playstation-$2340",
                "Nike 3310-$347",
                "Samsung TV-$2999",
                "Apple Watch-$599",
                "Xbox Series X-$19999",
                "Adidas Sneakers-$249",
                "Canon Camera-$777",
                "Sony Headphones-$399",
                "Dell Laptop-$1299",
                "Lenovo Tablet-$299",
                "LG Refrigerator-$1799",
                "Bose Soundbar-$499",
                "LG Microwave-$199",
                "Asus Router-$99",
                "Google Home-$129",
                "Nescafe 3in1-$0.50",
                "Milo-$1.50"
        };

        String[] imagePaths = {
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\612kg3rGyYL.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\gettyimages-1139260063-612x612.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\63e666fb692b2_weird-shoes.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\jhbgfds.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\618HSW6un3L.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\c6117d5f-cad4-4350-8b57-8d87b825df0f.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\717IZ92ogwL.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\61bTno13iFL.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\61rFE093esL.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\61frSP0Sd1S.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\Lenovos-new-affordable-Android-tablet-costs-less-than-200-launches-in-April.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\51dTuOXIoPL.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\be47bccd-fb00-4d84-81da-be2f8ff2c6bb.__CR0,0,800,600_PT0_SX800_V1___.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\71BRtv0Vd7L.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\718k1vCWZHL.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\gettyimages-632250772-612x612.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\419DToHzaOL.jpg",
                "C:\\Users\\user.MYCOMPUTER\\OneDrive\\360_F_490394441_dSBWAaPj7mopVqf7D2v7D6YpL063AOPy.jpg"
        };

        for (int i = 0; i < productNames.length; i++) {
            JPanel productPanel = new JPanel();
            productPanel.setLayout(new BorderLayout());
            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            productPanel.setOpaque(false);

            JLabel productLabel = new JLabel(productNames[i]);
            productLabel.setHorizontalAlignment(SwingConstants.CENTER);
            productLabel.setForeground(Color.WHITE);
            productLabel.setBackground(new Color(0, 0, 0, 100)); // Set background color
            productPanel.add(productLabel, BorderLayout.NORTH);

            ImageIcon imageIcon = new ImageIcon(imagePaths[i]);
            Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            productPanel.add(imageLabel, BorderLayout.CENTER);

            JButton addToCartButton = new JButton("Add to Cart");
            int productId = i + 1;
            addToCartButton.addActionListener(event -> {
                cartItems.add(productNames[productId - 1]);
                updateCartTextArea();
            });
            productPanel.add(addToCartButton, BorderLayout.SOUTH);

            productsPanel.add(productPanel);
        }

        JScrollPane productsScrollPane = new JScrollPane(productsPanel);
        productsScrollPane.getViewport().setOpaque(false);
        productsScrollPane.setOpaque(false);
        productsScrollPane.setBorder(BorderFactory.createEmptyBorder());

        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cartPanel.setOpaque(false);

        JLabel cartLabel = new JLabel("Shopping Cart");
        cartLabel.setFont(new Font("Arial", Font.BOLD, 18));
        cartLabel.setForeground(Color.WHITE);
        cartPanel.add(cartLabel, BorderLayout.NORTH);

        cartTextArea = new JTextArea(20, 30);
        JScrollPane cartScrollPane = new JScrollPane(cartTextArea);
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);

        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(event -> {
            
            double totalPrice = computeTotalPrice();
            
            int option = JOptionPane.showConfirmDialog(ecommerceFrame, "Total price: $" + totalPrice + ". Do you want to continue?", "Checkout", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                cartItems.clear();
                updateCartTextArea();
                JOptionPane.showMessageDialog(ecommerceFrame, "Your order has been processed!");
            }
        });
        cartPanel.add(checkoutButton, BorderLayout.SOUTH);

        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(productsScrollPane, BorderLayout.CENTER);
        panel.add(cartPanel, BorderLayout.EAST);

        backgroundPanel.add(panel, BorderLayout.CENTER);

        ecommerceFrame.add(backgroundPanel);
        ecommerceFrame.setVisible(true);
    }

    private void updateCartTextArea() {
        cartTextArea.setText("");
        for (String item : cartItems) {
            cartTextArea.append(item + "\n");
        }
    }

    private double computeTotalPrice() {
        double totalPrice = 0.0;
        for (String item : cartItems) {
            String[] parts = item.split("-");
            if (parts.length == 2) {
                String priceStr = parts[1].substring(1); 
                double price = Double.parseDouble(priceStr);
                totalPrice += price;
            }
        }
        return totalPrice;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<String> cartItems = new ArrayList<>();
            new ECommerceFrame(cartItems);
        });
    }
}
