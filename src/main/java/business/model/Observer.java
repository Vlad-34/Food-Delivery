package business.model;

import business.interfaces.IObserver;
import presentation.views.EmployeeView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Observer implements IObserver {

    @Override
    public void update(EmployeeView employeeView, HashMap<Order, ArrayList<MenuItem>> orders) {
        JOptionPane.showMessageDialog(employeeView, "There are " + orders.size() + " orders to prepare!");
    }
}
