package presentation.views;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JFrame {
    private JLabel employeeNameLabel;

    public EmployeeView() {
        this.setBounds(100, 100, 640, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        this.employeeNameLabel = new JLabel("EMPLOYEE VIEW");
        this.employeeNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        this.employeeNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.employeeNameLabel.setBounds(231, 10, 164, 13);
        this.getContentPane().add(this.employeeNameLabel);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameLabel.setBounds(30, 35, 555, 13);
        this.getContentPane().add(nameLabel);
    }

    public void setEmployeeNameLabel(String name) {
        this.employeeNameLabel.setText("Name: " + name);
    }
}
