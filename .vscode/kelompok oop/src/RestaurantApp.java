import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class RestaurantApp extends JFrame implements ActionListener {
    private Map<String, Double> menu;
    private JTextArea orderArea;
    private JButton[] itemButtons;
    private JButton checkoutButton;
    private JButton cancelButton;
    private JButton clearButton;
    private JButton addMenuItemButton;
    private JTextField itemNameField;
    private JTextField itemPriceField;
    private Map<String, Integer> orderList;

    public RestaurantApp() {
        setTitle("Aplikasi Restoran");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menu = new HashMap<>();
        menu.put("Nasi Goreng", 15.0);
        menu.put("Mie Goreng", 12.0);
        menu.put("Ayam Bakar", 20.0);
        menu.put("Es Teh", 3.0);
        menu.put("Es Jeruk", 4.0);

        JPanel menuPanel = new JPanel(new GridLayout(menu.size(), 1));
        itemButtons = new JButton[menu.size()];
        int buttonIndex = 0;
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            itemButtons[buttonIndex] = new JButton(item.getKey() + " - Rp " + item.getValue());
            itemButtons[buttonIndex].addActionListener(this);
            menuPanel.add(itemButtons[buttonIndex]);
            buttonIndex++;
        }

        orderArea = new JTextArea(15, 30);
        orderArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(orderArea);

        checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(this);

        cancelButton = new JButton("Batalkan");
        cancelButton.addActionListener(this);

        clearButton = new JButton("Hapus Item");
        clearButton.addActionListener(this);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(menuPanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(checkoutButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(clearButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel addMenuPanel = new JPanel(new GridLayout(2, 3));
        addMenuItemButton = new JButton("Tambah Menu");
        addMenuItemButton.addActionListener(this);

        JLabel nameLabel = new JLabel("Nama Item:");
        JLabel priceLabel = new JLabel("Harga:");

        itemNameField = new JTextField();
        itemPriceField = new JTextField();

        addMenuPanel.add(nameLabel);
        addMenuPanel.add(itemNameField);
        addMenuPanel.add(addMenuItemButton);
        addMenuPanel.add(priceLabel);
        addMenuPanel.add(itemPriceField);
        addMenuPanel.add(new JLabel());

        contentPanel.add(addMenuPanel, BorderLayout.SOUTH);

        add(contentPanel);
        orderList = new HashMap<>();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < menu.size(); i++) {
            if (e.getSource() == itemButtons[i]) {
                String buttonText = itemButtons[i].getText();
                String itemName = buttonText.split(" - ")[0];
                if (orderList.containsKey(itemName)) {
                    orderList.put(itemName, orderList.get(itemName) + 1);
                } else {
                    orderList.put(itemName, 1);
                }
                updateOrderArea();
            }
        }

        if (e.getSource() == checkoutButton) {
            double totalAmount = calculateTotal();
            JOptionPane.showMessageDialog(this, "Total Pembayaran: Rp " + totalAmount);
            clearOrder();
        }

        if (e.getSource() == cancelButton) {
            clearOrder();
        }

        if (e.getSource() == clearButton) {
            String input = JOptionPane.showInputDialog(this, "Masukkan nama item yang akan dihapus:");
            if (input != null && !input.isEmpty()) {
                if (orderList.containsKey(input)) {
                    if (orderList.get(input) > 1) {
                        orderList.put(input, orderList.get(input) - 1);
                    } else {
                        orderList.remove(input);
                    }
                    updateOrderArea();
                } else {
                    JOptionPane.showMessageDialog(this, "Item tidak ada dalam daftar pesanan.");
                }
            }
        }

        if (e.getSource() == addMenuItemButton) {
            String itemName = itemNameField.getText();
            String priceText = itemPriceField.getText();
            if (!itemName.isEmpty() && !priceText.isEmpty()) {
                try {
                    double price = Double.parseDouble(priceText);
                    menu.put(itemName, price);
                    updateMenu();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Harga harus dalam format angka.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Mohon isi Nama Item dan Harga.");
            }
        }
    }

    private void updateOrderArea() {
        orderArea.setText("");
        for (Map.Entry<String, Integer> order : orderList.entrySet()) {
            String itemName = order.getKey();
            int quantity = order.getValue();
            double price = menu.get(itemName);
            orderArea.append(itemName + " - " + quantity + "x - Rp " + price * quantity + "\n");
        }
    }

    private double calculateTotal() {
        double totalAmount = 0.0;
        for (Map.Entry<String, Integer> order : orderList.entrySet()) {
            String itemName = order.getKey();
            int quantity = order.getValue();
            double price = menu.get(itemName);
            totalAmount += price * quantity;
        }
        return totalAmount;
    }

    private void clearOrder() {
        orderList.clear();
        updateOrderArea();
    }

    private void updateMenu() {
        JPanel menuPanel = new JPanel(new GridLayout(menu.size(), 1));
        for (int i = 0; i < menu.size(); i++) {
            itemButtons[i] = new JButton((String) menu.keySet().toArray()[i] + " - Rp " + menu.values().toArray()[i]);
            itemButtons[i].addActionListener(this);
            menuPanel.add(itemButtons[i]);
        }
        getContentPane().add(menuPanel, BorderLayout.NORTH);
        getContentPane().validate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RestaurantApp::new);
    }
}
