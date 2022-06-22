package presentation;

import business.DeliveryService;
import business.UserManagement;
import business.model.*;
import business.model.MenuItem;
import data.Writer;
import presentation.views.*;

import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Controller {
    private LoginRegisterView loginRegisterView = new LoginRegisterView();
    private ClientView clientView;
    private EmployeeView employeeView;
    private AdminView adminView;
    private ProductManagementView productManagementView;
    private ReportsGenerationView reportsGenerationView;
    private DeliveryService deliveryService = new DeliveryService();
    private HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<Order, ArrayList<MenuItem>>();
    private int orderId = 1;

    private ArrayList<MenuItem> cartMenuItems = new ArrayList<>();
    private ArrayList<MenuItem> searchMenuItems = new ArrayList<>();
    private ArrayList<MenuItem> composeItemList = new ArrayList<>();

    public Controller(ClientView clientView, EmployeeView employeeView, AdminView adminView, ProductManagementView productManagementView, ReportsGenerationView reportsGenerationView) {
        this.cartMenuItems = new ArrayList<>();

        this.clientView = clientView;
        this.employeeView = employeeView;
        this.adminView = adminView;
        this.productManagementView = productManagementView;
        this.reportsGenerationView = reportsGenerationView;

        this.loginRegisterView.setVisible(true);

        this.loginRegisterView.addLoginListener(new LoginListener());
        this.loginRegisterView.addRegisterListener(new RegisterListener());

        this.clientView.addSearchListener(new SearchListener());
        this.clientView.addAddToCartListener(new AddToCartListener());
        this.clientView.addDeleteFromCartListener(new DeleteFromCartListener());
        this.clientView.addPlaceOrderListener(new PlaceOrderListener());

        this.adminView.addProductManagementViewListener(new ProductManagementViewListener());
        this.adminView.addImportMenuListener(new ImportMenuListener());
        this.adminView.addReportsGenerationViewListener(new ReportsGenerationViewListener());

        this.productManagementView.addAddProductListener(new AddProductListener());
        this.productManagementView.addComposeProductListener(new ComposeProductListener());
        this.productManagementView.addModifyProductListener(new ModifyProductListener());
        this.productManagementView.addDeleteProductListener(new DeleteProductListener());
        this.productManagementView.finishComposingListener(new FinishComposingListener());

        this.reportsGenerationView.addTimeIntervalListener(new TimeIntervalListener());
        this.reportsGenerationView.addNumberAndValueOfOrders(new NumberAndValueOfOrders());
        this.reportsGenerationView.addNumberOfTimesOrdered(new NumberOfTimesOrdered());
        this.reportsGenerationView.addProductsOrderedOnASpecifiedDate(new ProductsOrderedOnASpecifiedDate());
    }

    public class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean ok = UserManagement.isAccountAlreadyMade(loginRegisterView.getUsernameTextField(), loginRegisterView.getPasswordTextField(), loginRegisterView.getTypeComboBox());
            assert ok : "The account does not exist!";
            //assert UserManagement.getCurrentUser() != null : "User-ul curent nu se poate extrage din fisier!";
            if (loginRegisterView.getTypeComboBox() == UserType.ADMIN)
                adminView.setVisible(true);
            else if (loginRegisterView.getTypeComboBox() == UserType.EMPLOYEE)
                employeeView.setVisible(true);
            else if (loginRegisterView.getTypeComboBox() == UserType.CLIENT)
                clientView.setVisible(true);
        }
    } // done

    public class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            UserManagement.register(loginRegisterView.getUsernameTextField(), loginRegisterView.getPasswordTextField(), loginRegisterView.getTypeComboBox());
        }
    }

    public class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            searchMenuItems = (ArrayList<MenuItem>) deliveryService.getMenuItemList().stream().filter(t ->
                    t.getTitle().toLowerCase().contains(clientView.getSearchTextField().toLowerCase()) ||
                    clientView.getSearchTextField().toLowerCase().contains("rating") && clientView.getSearchTextField().toLowerCase().contains(String.valueOf(t.getRating())) ||
                    clientView.getSearchTextField().toLowerCase().contains("calories") && clientView.getSearchTextField().toLowerCase().contains(String.valueOf(t.getCalories())) ||
                    clientView.getSearchTextField().toLowerCase().contains("protein") && clientView.getSearchTextField().toLowerCase().contains(String.valueOf(t.getProtein())) ||
                    clientView.getSearchTextField().toLowerCase().contains("fat") && clientView.getSearchTextField().toLowerCase().contains(String.valueOf(t.getFat())) ||
                    clientView.getSearchTextField().toLowerCase().contains("sodium") && clientView.getSearchTextField().toLowerCase().contains(String.valueOf(t.getSodium())) ||
                    clientView.getSearchTextField().toLowerCase().contains("price") && clientView.getSearchTextField().toLowerCase().contains(String.valueOf(t.getPrice()))
            ).collect(Collectors.toList());
            assert searchMenuItems.size() != 0 : "There are no items in the imported file that matches with the search criteria!";
            TableModel productTableModel = Writer.buildTable(searchMenuItems);
            clientView.setProductTable(productTableModel);
        }
    } // done

    public class AddToCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(searchMenuItems.size() != 0)
                cartMenuItems.add(searchMenuItems.get(clientView.getProductTable().getSelectedRow()));
            else
                cartMenuItems.add(deliveryService.getMenuItemList().get(clientView.getProductTable().getSelectedRow()));
            TableModel productTableModel = Writer.buildTable(cartMenuItems);
            clientView.setCartTable(productTableModel);
        }
    } // done

    public class DeleteFromCartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cartMenuItems.remove(cartMenuItems.get(clientView.getCartTable().getSelectedRow()));
            TableModel productTableModel = Writer.buildTable(cartMenuItems);
            clientView.setCartTable(productTableModel);
        }
    } // done

    public class PlaceOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.placeOrder(cartMenuItems, orderId, orders);
            new Observer().update(employeeView, orders);
        }
    } // done

    public class ProductManagementViewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productManagementView.setVisible(true);
            TableModel tableModel = Writer.buildTable(deliveryService.getMenuItemList());
            productManagementView.setProductTable(tableModel);
        }
    } // done

    public class ImportMenuListener implements ActionListener { // DONE
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.importMenu();
            TableModel productTableModel = Writer.buildTable(deliveryService.getMenuItemList());
            clientView.setProductTable(productTableModel);
            productManagementView.setProductTable(productTableModel);
        }
    } // done

    public class ReportsGenerationViewListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            reportsGenerationView.setVisible(true);
        }
    } // done

    public class AddProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.addProduct(productManagementView, clientView);
        }
    } // done

    public class FinishComposingListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.finishComposing(productManagementView, clientView, composeItemList);
        }
    } // done

    public class ComposeProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.composeProduct(composeItemList, productManagementView);
        }
    } // done

    public class ModifyProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.modifyProduct(productManagementView, clientView);
        }
    } // done

    public class DeleteProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.deleteProduct(productManagementView, clientView);
        }
    } // done

    public class TimeIntervalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.generateReportAfterTimeInterval(reportsGenerationView, orders);
        }
    } // done

    public class NumberAndValueOfOrders implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.generateReportAfterNumberAndValue(reportsGenerationView, orders);
        }
    }

    public class NumberOfTimesOrdered implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.generateReportAfterOrderNumber(reportsGenerationView);
        }
    } // done

    public class ProductsOrderedOnASpecifiedDate implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.generateReportAfterDate(reportsGenerationView, orders);
        }
    } // done
}
