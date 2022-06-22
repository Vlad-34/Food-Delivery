package presentation.views;

import business.model.UserType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginRegisterView extends JFrame {

    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JComboBox typeComboBox;
    private JButton loginButton;
    private JButton registerButton;

    public LoginRegisterView() {
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        JLabel loginRegisterLabel = new JLabel("LOGIN/REGISTER");
        loginRegisterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginRegisterLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loginRegisterLabel.setBounds(117, 10, 202, 19);
        this.getContentPane().add(loginRegisterLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        usernameLabel.setBounds(49, 59, 74, 13);
        this.getContentPane().add(usernameLabel);

        this.usernameTextField = new JTextField();
        this.usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.usernameTextField.setColumns(10);
        this.usernameTextField.setBounds(170, 56, 186, 19);
        this.getContentPane().add(this.usernameTextField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordLabel.setBounds(49, 109, 74, 13);
        this.getContentPane().add(passwordLabel);

        this.passwordTextField = new JPasswordField();
        this.passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.passwordTextField.setBounds(170, 106, 186, 19);
        this.getContentPane().add(this.passwordTextField);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        typeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        typeLabel.setBounds(49, 159, 74, 13);
        getContentPane().add(typeLabel);

        this.typeComboBox = new JComboBox();
        this.typeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.EMPLOYEE, UserType.CLIENT}));
        this.typeComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.typeComboBox.setBounds(170, 155, 186, 21);
        getContentPane().add(this.typeComboBox);

        this.loginButton = new JButton("LOGIN");
        this.loginButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.loginButton.setBounds(77, 211, 102, 21);
        getContentPane().add(this.loginButton);

        this.registerButton = new JButton("REGISTER");
        this.registerButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.registerButton.setBounds(256, 209, 102, 21);
        this.getContentPane().add(this.registerButton);
    }

    public String getUsernameTextField() {
        return this.usernameTextField.getText();
    }

    public String getPasswordTextField() {
        return String.valueOf(this.passwordTextField.getPassword());
    }

    public UserType getTypeComboBox() {
        return (UserType) typeComboBox.getSelectedItem();
    }

    public void addLoginListener(ActionListener action) {
        this.loginButton.addActionListener(action);
    }

    public void addRegisterListener(ActionListener action) {
        this.registerButton.addActionListener(action);
    }
}