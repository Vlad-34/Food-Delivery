package presentation.views;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.Font;
import java.awt.event.ActionListener;

public class ReportsGenerationView extends JFrame {
    private JTextField orderedMoreThanTextField;
    private JTextField priceTextField;
    private JComboBox startIntervalComboBox;
    private JComboBox endIntervalComboBox;
    private JComboBox dayComboBox;
    private JComboBox monthComboBox;
    private JComboBox yearComboBox;
    private JButton timeIntervalButton;
    private JButton numberAndValueOfOrdersButton;
    private JButton numberOfTimesOrderedButton;
    private JButton productsOrderedOnASpecifiedDateButton;
    private JTable reportTable;
    private JTextField userOrderNumberTextField;

    public ReportsGenerationView() {
        this.setBounds(100, 100, 640, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        JLabel reportsGenerationLabel = new JLabel("REPORTS GENERATION VIEW");
        reportsGenerationLabel.setHorizontalAlignment(SwingConstants.CENTER);
        reportsGenerationLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        reportsGenerationLabel.setBounds(191, 10, 243, 13);
        this.getContentPane().add(reportsGenerationLabel);

        JLabel timeIntervalLabel = new JLabel("Time Interval");
        timeIntervalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeIntervalLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        timeIntervalLabel.setBounds(23, 47, 130, 13);
        this.getContentPane().add(timeIntervalLabel);

        this.startIntervalComboBox = new JComboBox();
        this.startIntervalComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.startIntervalComboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        this.startIntervalComboBox.setBounds(163, 45, 47, 21);
        this.getContentPane().add(this.startIntervalComboBox);

        JLabel toLabel = new JLabel("to");
        toLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        toLabel.setHorizontalAlignment(SwingConstants.CENTER);
        toLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        toLabel.setBounds(219, 49, 23, 13);
        this.getContentPane().add(toLabel);

        this.endIntervalComboBox = new JComboBox();
        this.endIntervalComboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
        this.endIntervalComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.endIntervalComboBox.setBounds(252, 45, 47, 21);
        this.getContentPane().add(this.endIntervalComboBox);

        JLabel dateLabel = new JLabel("Date");
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        dateLabel.setBounds(23, 88, 130, 13);
        this.getContentPane().add(dateLabel);

        this.dayComboBox = new JComboBox();
        this.dayComboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
        this.dayComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.dayComboBox.setBounds(163, 86, 47, 21);
        this.getContentPane().add(this.dayComboBox);

        this.monthComboBox = new JComboBox();
        this.monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
        this.monthComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.monthComboBox.setBounds(213, 86, 47, 21);
        this.getContentPane().add(this.monthComboBox);

        this.yearComboBox = new JComboBox();
        this.yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
        this.yearComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.yearComboBox.setBounds(264, 86, 60, 21);
        this.getContentPane().add(this.yearComboBox);

        JLabel orderedMoreThanLabel = new JLabel("Ordered More Than");
        orderedMoreThanLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderedMoreThanLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        orderedMoreThanLabel.setBounds(23, 131, 130, 13);
        this.getContentPane().add(orderedMoreThanLabel);

        this.orderedMoreThanTextField = new JTextField();
        this.orderedMoreThanTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.orderedMoreThanTextField.setBounds(163, 130, 136, 19);
        this.getContentPane().add(this.orderedMoreThanTextField);
        this.orderedMoreThanTextField.setColumns(10);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        priceLabel.setBounds(191, 179, 79, 13);
        this.getContentPane().add(priceLabel);

        this.priceTextField = new JTextField();
        this.priceTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.priceTextField.setColumns(10);
        this.priceTextField.setBounds(252, 176, 72, 19);
        this.getContentPane().add(this.priceTextField);

        this.timeIntervalButton = new JButton("Time Interval");
        this.timeIntervalButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.timeIntervalButton.setBounds(23, 230, 313, 21);
        this.getContentPane().add(this.timeIntervalButton);

        this.numberAndValueOfOrdersButton = new JButton("Number and Value of Orders");
        this.numberAndValueOfOrdersButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.numberAndValueOfOrdersButton.setBounds(23, 280, 313, 21);
        this.getContentPane().add(this.numberAndValueOfOrdersButton);

        this.numberOfTimesOrderedButton = new JButton("Number of Times Ordered");
        this.numberOfTimesOrderedButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.numberOfTimesOrderedButton.setBounds(23, 330, 313, 21);
        this.getContentPane().add(this.numberOfTimesOrderedButton);

        this.productsOrderedOnASpecifiedDateButton = new JButton("Products Ordered on a Specified Date");
        this.productsOrderedOnASpecifiedDateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        this.productsOrderedOnASpecifiedDateButton.setBounds(23, 380, 313, 21);
        this.getContentPane().add(this.productsOrderedOnASpecifiedDateButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(354, 47, 243, 372);
        this.getContentPane().add(scrollPane);

        JLabel lblUsersOrderNb = new JLabel("Users` order nb");
        lblUsersOrderNb.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsersOrderNb.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsersOrderNb.setBounds(0, 179, 148, 13);
        getContentPane().add(lblUsersOrderNb);

        userOrderNumberTextField = new JTextField();
        userOrderNumberTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        userOrderNumberTextField.setColumns(10);
        userOrderNumberTextField.setBounds(130, 176, 72, 19);
        getContentPane().add(userOrderNumberTextField);

        reportTable = new JTable();
        reportTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setViewportView(reportTable);
    }

    public int getOrderedMoreThanTextField() {
        return Integer.parseInt(orderedMoreThanTextField.getText());
    }
    public int getUserOrderNumberTextField() {
        return Integer.parseInt(userOrderNumberTextField.getText());
    }

    public int getPriceTextField() {
        return Integer.parseInt(priceTextField.getText());
    }

    public JTable getReportTable(){return this.reportTable;}
    public void setReportTable(TableModel tm){this.reportTable.setModel(tm);}

    public int getStartIntervalComboBox() {
        return Integer.parseInt(String.valueOf(startIntervalComboBox.getSelectedItem()));
    }

    public int getEndIntervalComboBox() {
        return Integer.parseInt(String.valueOf(endIntervalComboBox.getSelectedItem()));
    }

    public int getDayComboBox() {
        return Integer.parseInt(String.valueOf(dayComboBox.getSelectedItem()));
    }

    public int getMonthComboBox() {
        return Integer.parseInt(String.valueOf(monthComboBox.getSelectedItem()));
    }

    public int getYearComboBox() {
        return Integer.parseInt(String.valueOf(yearComboBox.getSelectedItem()));
    }

    public void addTimeIntervalListener(ActionListener action) {
        this.timeIntervalButton.addActionListener(action);
    }

    public void addNumberAndValueOfOrders(ActionListener action) {
        this.numberAndValueOfOrdersButton.addActionListener(action);
    }

    public void addNumberOfTimesOrdered(ActionListener action) {
        this.numberOfTimesOrderedButton.addActionListener(action);
    }

    public void addProductsOrderedOnASpecifiedDate(ActionListener action) {
        this.productsOrderedOnASpecifiedDateButton.addActionListener(action);
    }
}
