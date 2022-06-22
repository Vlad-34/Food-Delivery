package presentation.views;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.awt.event.ActionListener;

public class ProductManagementView extends JFrame {

    private JTextField ratingTextField;
    private JTextField titleTextField;
    private JTextField caloriesTextField;
    private JTextField proteinTextField;
    private JTextField sodiumTextField;
    private JTextField priceTextField;
    private JTextField fatTextField;
    private JTable productTable;
    private JButton addProductButton;
    private JButton composeProductButton;
    private JButton modifyProductButton;
    private JButton deleteProductButton;
    private JButton finishComposingButton;
    private JTable composingTable;

    public ProductManagementView() {
        this.setBounds(100, 100, 1019, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        JLabel productManagementLabel = new JLabel("PRODUCT MANAGEMENT VIEW");
        productManagementLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        productManagementLabel.setHorizontalAlignment(SwingConstants.CENTER);
        productManagementLabel.setBounds(374, 10, 256, 13);
        this.getContentPane().add(productManagementLabel);

        JLabel ratingLabel = new JLabel("Rating");
        ratingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ratingLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        ratingLabel.setBounds(35, 75, 70, 13);
        this.getContentPane().add(ratingLabel);

        this.ratingTextField = new JTextField();
        this.ratingTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.ratingTextField.setBounds(115, 72, 96, 19);
        this.getContentPane().add(this.ratingTextField);
        this.ratingTextField.setColumns(10);

        JLabel titleLabel = new JLabel("Title");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        titleLabel.setBounds(35, 46, 70, 13);
        this.getContentPane().add(titleLabel);

        this.titleTextField = new JTextField();
        this.titleTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.titleTextField.setColumns(10);
        this.titleTextField.setBounds(115, 43, 96, 19);
        this.getContentPane().add(this.titleTextField);

        JLabel caloriesLabel = new JLabel("Calories");
        caloriesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        caloriesLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        caloriesLabel.setBounds(35, 104, 70, 13);
        this.getContentPane().add(caloriesLabel);

        this.caloriesTextField = new JTextField();
        this.caloriesTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.caloriesTextField.setColumns(10);
        this.caloriesTextField.setBounds(115, 101, 96, 19);
        this.getContentPane().add(this.caloriesTextField);

        JLabel proteinLabel = new JLabel("Protein");
        proteinLabel.setHorizontalAlignment(SwingConstants.CENTER);
        proteinLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        proteinLabel.setBounds(35, 133, 70, 13);
        this.getContentPane().add(proteinLabel);

        fatTextField = new JTextField();
        fatTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fatTextField.setColumns(10);
        fatTextField.setBounds(115, 157, 96, 19);
        getContentPane().add(fatTextField);

        JLabel fatLabel = new JLabel("Fat");
        fatLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fatLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fatLabel.setBounds(35, 160, 70, 13);
        getContentPane().add(fatLabel);

        this.proteinTextField = new JTextField();
        this.proteinTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.proteinTextField.setColumns(10);
        this.proteinTextField.setBounds(115, 130, 96, 19);
        this.getContentPane().add(this.proteinTextField);

        JLabel sodiumLabel = new JLabel("Sodium");
        sodiumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sodiumLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        sodiumLabel.setBounds(35, 189, 70, 13);
        this.getContentPane().add(sodiumLabel);

        this.sodiumTextField = new JTextField();
        this.sodiumTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.sodiumTextField.setColumns(10);
        this.sodiumTextField.setBounds(115, 186, 96, 19);
        this.getContentPane().add(this.sodiumTextField);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        priceLabel.setBounds(35, 218, 70, 13);
        this.getContentPane().add(priceLabel);

        this.priceTextField = new JTextField();
        this.priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.priceTextField.setColumns(10);
        this.priceTextField.setBounds(115, 215, 96, 19);
        this.getContentPane().add(this.priceTextField);

        this.addProductButton = new JButton("Add Product");
        this.addProductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.addProductButton.setBounds(35, 264, 176, 21);
        this.getContentPane().add(this.addProductButton);

        this.composeProductButton = new JButton("Compose Product");
        this.composeProductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.composeProductButton.setBounds(35, 357, 176, 21);
        this.getContentPane().add(this.composeProductButton);

        this.modifyProductButton = new JButton("Modify Product");
        this.modifyProductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.modifyProductButton.setBounds(35, 295, 176, 21);
        this.getContentPane().add(this.modifyProductButton);

        this.deleteProductButton = new JButton("Delete Product");
        this.deleteProductButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.deleteProductButton.setBounds(35, 326, 176, 21);
        this.getContentPane().add(this.deleteProductButton);

        finishComposingButton = new JButton("Finish Composing");
        finishComposingButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        finishComposingButton.setBounds(35, 388, 176, 21);
        getContentPane().add(finishComposingButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(250, 37, 350, 372);
        this.getContentPane().add(scrollPane);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setBounds(610, 37, 350, 372);
        getContentPane().add(scrollPane_1);

        productTable = new JTable();
        productTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setViewportView(productTable);

        composingTable = new JTable();
        composingTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane_1.setViewportView(composingTable);
    }

    public double getRatingTextField() {
        return Double.parseDouble(ratingTextField.getText());
    }

    public String getTitleTextField() {
        return titleTextField.getText();
    }

    public Integer getFatTextField() {
        return Integer.parseInt(fatTextField.getText());
    }

    public int getCaloriesTextField() {
        return Integer.parseInt(caloriesTextField.getText());
    }

    public int getProteinTextField() {
        return Integer.parseInt(proteinTextField.getText());
    }

    public int getSodiumTextField() {
        return Integer.parseInt(sodiumTextField.getText());
    }

    public int getPriceTextField() {
        return Integer.parseInt(priceTextField.getText());
    }

    public void setProductTable(TableModel tableModel) {
        this.productTable.setModel(tableModel);
    }

    public void setComposingTable(TableModel tableModel) {
        this.composingTable.setModel(tableModel);
    }

    public JTable getProductTable() {
        return this.productTable;
    }

    public JTable getComposingTable() {
        return this.composingTable;
    }


    public void addAddProductListener(ActionListener action) {
        this.addProductButton.addActionListener(action);
    }

    public void addComposeProductListener(ActionListener action) {
        this.composeProductButton.addActionListener(action);
    }

    public void addModifyProductListener(ActionListener action) {
        this.modifyProductButton.addActionListener(action);
    }

    public void addDeleteProductListener(ActionListener action) {
        this.deleteProductButton.addActionListener(action);
    }
    public void finishComposingListener(ActionListener action) {
        this.finishComposingButton.addActionListener(action);
    }
}
