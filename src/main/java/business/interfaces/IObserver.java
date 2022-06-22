package business.interfaces;

import business.model.MenuItem;
import business.model.Order;
import presentation.views.EmployeeView;

import java.util.ArrayList;
import java.util.HashMap;

public interface IObserver {
    void update(EmployeeView employeeView, HashMap<Order, ArrayList<MenuItem>> orders);
}
