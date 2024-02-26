import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ECommerceSystem extends JFrame {

    private BufferedImage backgroundImage;

    public ECommerceSystem() {
        try {
            
            backgroundImage = ImageIO.read(new File("C:\\Users\\admin\\OneDrive\\69073a6af4e0c9f74924e30fa0f5bf2d.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setTitle("Ambok Enterprise");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Ambok.com");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, BorderLayout.NORTH);

        
        JPanel productsPanel = new JPanel(new GridLayout(0, 1, 10, 10)); 
        productsPanel.setOpaque(false); 
        JScrollPane productsScrollPane = new JScrollPane(productsPanel);
        productsScrollPane.setOpaque(false); 
        productsScrollPane.getViewport().setOpaque(false); 
        panel.add(productsScrollPane, BorderLayout.CENTER);

       
        String[] productNames = {"MT.Dew", "Sprite", "Royal", "Coke", "7 UP"};
        double[] productPrices = {20, 20, 20, 20, 20};
        String[] imagePaths = {
            "C:\\Users\\admin\\OneDrive\\Mtn_Dew.jpg",
            "C:\\Users\\admin\\OneDrive\\gettyimages-458260673-612x612.jpg",
            "C:\\Users\\admin\\OneDrive\\front_fr.12.full.jpg",
            "C:\\Users\\admin\\OneDrive\\15-09-26-RalfR-WLC-0098_-_Coca-Cola_glass_bottle_(Germany).jpg",
            "C:\\Users\\admin\\OneDrive\\gettyimages-458609271-612x612.jpg"
        };

        for (int i = 0; i < productNames.length; i++) {
            JPanel productPanel = new JPanel(new BorderLayout());
            productPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            productPanel.setOpaque(false); 

            
            BufferedImage productImage = loadImage(imagePaths[i]);
            if (productImage != null) {
                ImageIcon imageIcon = new ImageIcon(productImage.getScaledInstance(150, -1, Image.SCALE_DEFAULT));
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
                productPanel.add(imageLabel, BorderLayout.CENTER);
            }

            JPanel detailsPanel = new JPanel(new GridLayout(2, 1)); 
            JLabel nameLabel = new JLabel(productNames[i]);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nameLabel.setForeground(Color.BLACK); 
            detailsPanel.add(nameLabel);

            JLabel priceLabel = new JLabel("₱" + productPrices[i]);
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            priceLabel.setForeground(Color.BLACK); 
            detailsPanel.add(priceLabel);

            productPanel.add(detailsPanel, BorderLayout.SOUTH);

            JButton addToCartButton = new JButton("Add to Cart");
            addToCartButton.addActionListener(new AddToCartListener(productNames[i], productPrices[i]));
            addToCartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            productPanel.add(addToCartButton, BorderLayout.EAST);

            productsPanel.add(productPanel);
        }

        
        JPanel cartPanel = new JPanel(new BorderLayout());
        JLabel cartLabel = new JLabel("Shopping Cart:");
        cartLabel.setFont(new Font("Arial", Font.BOLD, 16));
        cartPanel.add(cartLabel, BorderLayout.NORTH);
        JTextArea cartTextArea = new JTextArea(10, 30);
        cartTextArea.setEditable(false);
        JScrollPane cartScrollPane = new JScrollPane(cartTextArea);
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);
        JButton checkOutButton = new JButton("Check Out");
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                JOptionPane.showMessageDialog(ECommerceSystem.this, "Thank you for your purchase!");
                cartTextArea.setText(""); 
            }
        });
        cartPanel.add(checkOutButton, BorderLayout.SOUTH);
        panel.add(cartPanel, BorderLayout.EAST);

        add(panel);

        setVisible(true);
    }

    private class AddToCartListener implements ActionListener {
        private String productName;
        private double productPrice;

        public AddToCartListener(String productName, double productPrice) {
            this.productName = productName;
            this.productPrice = productPrice;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(ECommerceSystem.this, productName + " added to cart!");
        }
    }

    private BufferedImage loadImage(String imagePath) {
        try {
            return ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ECommerceSystem();
            }
        });
    }
}
