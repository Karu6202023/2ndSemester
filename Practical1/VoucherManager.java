import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VoucherManager {
    private Map<String, Voucher> vouchers;
    private Map<String, String> paymentMethods;

    public VoucherManager() {
        vouchers = new HashMap<>();
        vouchers.put("NEWUSER10", new Voucher(10.0, "NEWUSER10", "10% Discount", "C:\\Users\\user.MYCOMPUTER\\OneDrive\\voucher1_icon.png"));
        vouchers.put("LOYALTY20", new Voucher(20.0, "LOYALTY20", "20% Discount", "C:\\Users\\user.MYCOMPUTER\\OneDrive\\voucher2_icon.png"));
        vouchers.put("SALE50", new Voucher(50.0, "SALE50", "$50 Discount", "C:\\Users\\user.MYCOMPUTER\\OneDrive\\voucher3_icon.png"));

        paymentMethods = new HashMap<>();
        paymentMethods.put("GCash", "C:\\Users\\user.MYCOMPUTER\\OneDrive\\gcash_icon.png");
        paymentMethods.put("PayPal", "C:\\Users\\user.MYCOMPUTER\\OneDrive\\paypal_icon.png");
        paymentMethods.put("Cash on Delivery", "C:\\Users\\user.MYCOMPUTER\\OneDrive\\cod_icon.png");
    }

    public String[] getAvailableVouchers() {
        return vouchers.keySet().toArray(new String[0]);
    }

    public Voucher getVoucher(String voucherCode) {
        return vouchers.getOrDefault(voucherCode, null);
    }

    public String[] getPaymentMethods() {
        return paymentMethods.keySet().toArray(new String[0]);
    }

    public String getPaymentMethodIcon(String methodName) {
        return paymentMethods.getOrDefault(methodName, null);
    }

    public static class Voucher {
        private double discount;
        private String code;
        private String description;
        private String iconPath;

        public Voucher(double discount, String code, String description, String iconPath) {
            this.discount = discount;
            this.code = code;
            this.description = description;
            this.iconPath = iconPath;
        }

        public double getDiscount() {
            return discount;
        }

        public String getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }

        public String getIconPath() {
            return iconPath;
        }
    }
}
