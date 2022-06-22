package presentation.views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AdminView extends JFrame {
    private JButton productManagementViewButton;
    private JButton importMenuViewButton;
    private JButton reportsViewButton;

    public AdminView() {
        this.setBounds(100, 100, 450, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        JLabel adminLabel = new JLabel("ADMIN VIEW");
        adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adminLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        adminLabel.setBounds(149, 10, 138, 13);
        this.getContentPane().add(adminLabel);

        this.productManagementViewButton = new JButton("Manage Products");
        this.productManagementViewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.productManagementViewButton.setBounds(122, 59, 192, 21);
        this.getContentPane().add(this.productManagementViewButton);

        this.importMenuViewButton = new JButton("Import from CSV File");
        this.importMenuViewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.importMenuViewButton.setBounds(122, 130, 192, 21);
        this.getContentPane().add(this.importMenuViewButton);

        this.reportsViewButton = new JButton("Generate Reports");
        this.reportsViewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.reportsViewButton.setBounds(122, 201, 192, 21);
        this.getContentPane().add(this.reportsViewButton);
    }

    public void addProductManagementViewListener(ActionListener action) {
        this.productManagementViewButton.addActionListener(action);
    }

    public void addImportMenuListener(ActionListener action) {
        this.importMenuViewButton.addActionListener(action);
    }

    public void addReportsGenerationViewListener(ActionListener action) {
        this.reportsViewButton.addActionListener(action);
    }
}
