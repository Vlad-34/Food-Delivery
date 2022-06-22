package presentation.views;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.awt.event.ActionListener;

public class ClientView extends JFrame {

    private JTextField searchTextField;
    private JTable productTable;
    private JTable cartTable;
    private JButton searchButton;
    private JButton addToCartButton;
    private JButton deleteFromCartButton;
    private JButton placeOrderButton;

    public ClientView() {
        this.setBounds(100, 100, 640, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        JLabel clientLabel = new JLabel("CLIENT VIEW");
        clientLabel.setHorizontalAlignment(SwingConstants.CENTER);
        clientLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        clientLabel.setBounds(252, 10, 122, 13);
        this.getContentPane().add(clientLabel);

        this.searchTextField = new JTextField();
        this.searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.searchTextField.setToolTipText("");
        this.searchTextField.setBounds(35, 58, 175, 19);
        this.getContentPane().add(this.searchTextField);
        this.searchTextField.setColumns(10);

        JLabel searchLabel = new JLabel("Search for Products:");
        searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchLabel.setBounds(35, 35, 130, 13);
        this.getContentPane().add(searchLabel);

        this.searchButton = new JButton("SEARCH");
        this.searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.searchButton.setBounds(220, 57, 85, 21);
        this.getContentPane().add(this.searchButton);

        JScrollPane productScrollPane = new JScrollPane();
        productScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        productScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        productScrollPane.setBounds(25, 87, 275, 300);
        this.getContentPane().add(productScrollPane);

        productTable = new JTable();
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        productScrollPane.setViewportView(productTable);

        JScrollPane cartScrollPane = new JScrollPane();
        cartScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        cartScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        cartScrollPane.setBounds(325, 87, 275, 300);
        this.getContentPane().add(cartScrollPane);

        cartTable = new JTable();
        cartTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        cartScrollPane.setViewportView(cartTable);

        this.addToCartButton = new JButton("Add to Cart");
        this.addToCartButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.addToCartButton.setBounds(46, 403, 147, 21);
        this.getContentPane().add(this.addToCartButton);

        this.deleteFromCartButton = new JButton("Delete from Cart");
        this.deleteFromCartButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.deleteFromCartButton.setBounds(239, 403, 147, 21);
        this.getContentPane().add(this.deleteFromCartButton);

        this.placeOrderButton = new JButton("Place Order");
        this.placeOrderButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.placeOrderButton.setBounds(432, 403, 147, 21);
        this.getContentPane().add(this.placeOrderButton);
    }

    public String getSearchTextField() {
        return searchTextField.getText();
    }

    public JTable getProductTable() {
        return productTable;
    }

    public void setProductTable(TableModel tableModel) {
        this.productTable.setModel(tableModel);
    }

    public JTable getCartTable() {
        return cartTable;
    }

    public void setCartTable(TableModel tableModel) {
        this.cartTable.setModel(tableModel);
    }

    public void addSearchListener(ActionListener action) {
        this.searchButton.addActionListener(action);
    }

    public void addAddToCartListener(ActionListener action) {
        this.addToCartButton.addActionListener(action);
    }

    public void addDeleteFromCartListener(ActionListener action) {
        this.deleteFromCartButton.addActionListener(action);
    }

    public void addPlaceOrderListener(ActionListener action) {
        this.placeOrderButton.addActionListener(action);
    }
}
