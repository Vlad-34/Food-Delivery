package business;

import business.interfaces.IDeliveryServiceProcessing;
import business.model.BaseProduct;
import business.model.CompositeProduct;
import business.model.MenuItem;
import business.model.Order;
import data.Serializer;
import data.Writer;
import presentation.views.ClientView;
import presentation.views.ProductManagementView;
import presentation.views.ReportsGenerationView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService implements IDeliveryServiceProcessing {
    private ArrayList<MenuItem> menuItemList;

    // admin functions

    /**
     * @pre Checks that menuItemList is not null.
     * @param productManagementView is the GUI element.
     * @param clientView is the GUI element.
     * @post Checks that menuItemList is not null.
     */
    @Override
    public void addProduct(ProductManagementView productManagementView, ClientView clientView) {
        assert menuItemList != null;
        menuItemList.add(new BaseProduct(productManagementView.getTitleTextField(), productManagementView.getRatingTextField(), productManagementView.getCaloriesTextField(), productManagementView.getProteinTextField(), productManagementView.getFatTextField(), productManagementView.getSodiumTextField(), productManagementView.getPriceTextField(), 0));
        assert menuItemList != null;
        TableModel productTableModel = Writer.buildTable(menuItemList);
        productManagementView.setProductTable(productTableModel);
        clientView.setProductTable(productTableModel);
    }

    /**
     * @pre Checks that menuItemList is not null.
     * @pre Checks that composeItemList is not null.
     * @param composeItemList is the list of items that contain the new composite item.
     * @param productManagementView is the GUI element.
     */
    @Override
    public void composeProduct(ArrayList<MenuItem> composeItemList, ProductManagementView productManagementView) {
        assert menuItemList != null;
        assert composeItemList != null;
        composeItemList.add(menuItemList.get(productManagementView.getProductTable().getSelectedRow()));
        TableModel productTableModel = Writer.buildTable(composeItemList);
        productManagementView.setComposingTable(productTableModel);
    }

    /**
     * @pre Checks that menuItemList is not null.
     * @param productManagementView is the GUI element.
     * @param clientView is the GUI element.
     * @param composeItemList is the list of items that contain the new composite item.
     */
    @Override
    public void finishComposing(ProductManagementView productManagementView, ClientView clientView, ArrayList<MenuItem> composeItemList){
        MenuItem composedProduct = new CompositeProduct(composeItemList);
        assert menuItemList != null;
        menuItemList.add(composedProduct);
        TableModel productTableModel = Writer.buildTable(menuItemList);
        productManagementView.setProductTable(productTableModel);
        clientView.setProductTable(productTableModel);
    }

    /**
     * @pre Checks that menuItemList is not null.
     * @param productManagementView is the GUI element.
     * @param clientView is the GUI element.
     */
    @Override
    public void modifyProduct(ProductManagementView productManagementView, ClientView clientView) {
        assert menuItemList != null;
        menuItemList.get(productManagementView.getProductTable().getSelectedRow()).setTitle(productManagementView.getTitleTextField());
        menuItemList.get(productManagementView.getProductTable().getSelectedRow()).setRating(productManagementView.getRatingTextField());
        menuItemList.get(productManagementView.getProductTable().getSelectedRow()).setCalories(productManagementView.getCaloriesTextField());
        menuItemList.get(productManagementView.getProductTable().getSelectedRow()).setProtein(productManagementView.getProteinTextField());
        menuItemList.get(productManagementView.getProductTable().getSelectedRow()).setFat(productManagementView.getFatTextField());
        menuItemList.get(productManagementView.getProductTable().getSelectedRow()).setSodium(productManagementView.getSodiumTextField());
        menuItemList.get(productManagementView.getProductTable().getSelectedRow()).setPrice(productManagementView.getPriceTextField());
        TableModel productTableModel = Writer.buildTable(menuItemList);
        productManagementView.setProductTable(productTableModel);
        clientView.setProductTable(productTableModel);
    }

    /**
     * @pre Checks that menuItemList is not null.
     * @param productManagementView is the GUI element.
     * @param clientView is the GUI element.
     */
    @Override
    public void deleteProduct(ProductManagementView productManagementView, ClientView clientView) {
        assert menuItemList != null;
        menuItemList.remove(productManagementView.getProductTable().getSelectedRow());
        TableModel productTableModel = Writer.buildTable(menuItemList);
        productManagementView.setProductTable(productTableModel);
        clientView.setProductTable(productTableModel);
    }

    /**
     * @post Checks that imported file via explorer.exe is valid.
     * @return A list of menuItems.
     */
    @Override
    public List<MenuItem> importMenu() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV File", "csv");
        fileChooser.setFileFilter(filter);
        fileChooser.setCurrentDirectory(new File("."));
        int returnVal = fileChooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Menu Imported.");
            menuItemList = Writer.getMenuItems(fileChooser.getSelectedFile().getAbsolutePath());
        }
        assert menuItemList != null : "The file could not be imported!";
        TreeSet<MenuItem> treeSet = new TreeSet<>();
        treeSet.addAll(menuItemList);
        menuItemList.clear();
        menuItemList.addAll(treeSet);
        return menuItemList;
    }

    public ArrayList<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    /**
     * @pre Checks that HashMap is not null.
     * @param reportsGenerationView is the GUI element.
     * @param orders is orders HashMap.
     * @post Checks that a report exists.
     */
    @Override
    public void generateReportAfterTimeInterval(ReportsGenerationView reportsGenerationView, HashMap<Order, ArrayList<MenuItem>> orders) {
        assert orders != null;
        ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> report = (ArrayList<Map.Entry<Order, ArrayList<MenuItem>>>) orders.entrySet().stream().filter(t -> t.getKey().getDate().getHour() >= (Integer) reportsGenerationView.getStartIntervalComboBox()).filter(t -> t.getKey().getDate().getHour() <= (Integer) reportsGenerationView.getEndIntervalComboBox()).collect(Collectors.toList());
        assert report.size() != 0 : "There are no orders placed in this time interval!";
        TableModel productTableModel = Writer.buildOrderTable(report);
        reportsGenerationView.setReportTable(productTableModel);
    }

    /**
     * @pre Checks that HashMap is not null.
     * @param reportsGenerationView is the GUI element.
     * @param orders is orders HashMap.
     * @post Checks that a report exists.
     */
    @Override
    public void generateReportAfterNumberAndValue(ReportsGenerationView reportsGenerationView, HashMap<Order, ArrayList<MenuItem>> orders) {
        assert orders != null;
        ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> report = (ArrayList<Map.Entry<Order, ArrayList<MenuItem>>>) orders.entrySet().stream().filter(t -> t.getKey().getUser().getOrderCounter() >= (Integer) reportsGenerationView.getUserOrderNumberTextField()).filter(t -> t.getKey().getBalance() >= (Integer) reportsGenerationView.getPriceTextField()).collect(Collectors.toList());
        assert report.size() != 0 : "There are no clients that have ordered more that this input number times with an order greater that input number!";
        TableModel productTableModel = Writer.buildOrderTable(report);
        reportsGenerationView.setReportTable(productTableModel);
    }

    /**
     * @pre Checks that HashMap is not null.
     * @param reportsGenerationView is the GUI element.
     * @param orders is orders HashMap.
     * @post Checks that a report exists.
     */
    @Override
    public void generateReportAfterDate(ReportsGenerationView reportsGenerationView, HashMap<Order, ArrayList<MenuItem>> orders) {
        assert orders != null;
        ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> report = (ArrayList<Map.Entry<Order, ArrayList<MenuItem>>>) orders.entrySet().stream().filter(t -> t.getKey().getDate().getDayOfMonth() == reportsGenerationView.getDayComboBox()).filter(t -> t.getKey().getDate().getMonthValue() == reportsGenerationView.getMonthComboBox()).filter(t -> t.getKey().getDate().getYear() == reportsGenerationView.getYearComboBox()).collect(Collectors.toList());
        assert report.size() != 0 : "There are no orders placed on this date";
        TableModel productTableModel = Writer.buildOrderTable(report);
        reportsGenerationView.setReportTable(productTableModel);
    }


    /**
     * @param reportsGenerationView is the GUI element.
     * @post Checks that a report exists.
     */
    @Override
    public void generateReportAfterOrderNumber(ReportsGenerationView reportsGenerationView) {
        ArrayList<MenuItem> report = (ArrayList<MenuItem>) menuItemList.stream().filter(t -> t.getOrderCounter() >= reportsGenerationView.getOrderedMoreThanTextField()).collect(Collectors.toList());
        assert report.size() != 0 : "There are no products that have been ordered more than input number times!";
        TableModel productTableModel = Writer.buildTable(report);
        reportsGenerationView.setReportTable(productTableModel);
    }

    // client functions
    @Override
    public ArrayList<MenuItem> getMenuItems(String filepath) {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        try {
            FileInputStream file1 = new FileInputStream(filepath);
            ObjectInputStream in = new ObjectInputStream(file1);
            menuItems = (ArrayList<MenuItem>) in.readObject();
            in.close();
            file1.close();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch(WriteAbortedException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return menuItems;
    }

    public void placeOrder(ArrayList<MenuItem> cartMenuItems, int orderId, HashMap<Order, ArrayList<MenuItem>> orders){
        int orderPrice = 0;
        for(MenuItem mi : cartMenuItems){
            orderPrice += mi.getPrice();
            menuItemList.get(menuItemList.indexOf(mi)).setOrderCounter(menuItemList.get(menuItemList.indexOf(mi)).getOrderCounter() + 1);
        }
        UserManagement.setCurrentUser();
        Order newOrder = new Order(orderId, UserManagement.getCurrentUser(), orderPrice);
        orders.put(newOrder, cartMenuItems);
        Writer.placeOrder(newOrder, cartMenuItems);
        JOptionPane.showMessageDialog(null, "The order has been placed successfully!");
    }
}
