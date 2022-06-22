package business.interfaces;

import business.model.MenuItem;
import business.model.Order;
import presentation.views.ClientView;
import presentation.views.ProductManagementView;
import presentation.views.ReportsGenerationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IDeliveryServiceProcessing {
    // admin functions
    void addProduct(ProductManagementView productManagementView, ClientView clientView);
    void composeProduct(ArrayList<MenuItem> composeItemList, ProductManagementView productManagementView);
    void modifyProduct(ProductManagementView productManagementView, ClientView clientView);
    void deleteProduct(ProductManagementView productManagementView, ClientView clientView);
    void finishComposing(ProductManagementView productManagementView, ClientView clientView, ArrayList<MenuItem> composeItemList);

    List<MenuItem> importMenu();

    void generateReportAfterTimeInterval(ReportsGenerationView reportsGenerationView, HashMap<Order, ArrayList<MenuItem>> orders);
    void generateReportAfterNumberAndValue(ReportsGenerationView reportsGenerationView, HashMap<Order, ArrayList<MenuItem>> orders);
    void generateReportAfterDate(ReportsGenerationView reportsGenerationView, HashMap<Order, ArrayList<MenuItem>> orders);
    public void generateReportAfterOrderNumber(ReportsGenerationView reportsGenerationView);

        // client functions
    List<MenuItem>getMenuItems(String filepath); // search
    void placeOrder(ArrayList<MenuItem> cartMenuItems, int orderId, HashMap<Order, ArrayList<MenuItem>> orders);
}
