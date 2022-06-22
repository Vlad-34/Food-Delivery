import presentation.Controller;
import presentation.views.*;

public class Main {
    public static void main(String[] args) {
        ClientView clientView = new ClientView();
        EmployeeView employeeView = new EmployeeView();
        AdminView adminView = new AdminView();
        ProductManagementView productManagementView = new ProductManagementView();
        ReportsGenerationView reportsGenerationView = new ReportsGenerationView();

        Controller controller = new Controller(clientView, employeeView, adminView, productManagementView, reportsGenerationView);
    }
}
