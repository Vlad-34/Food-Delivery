package data;

import business.model.BaseProduct;
import business.model.MenuItem;
import business.model.Order;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Writer {
    public static ArrayList<MenuItem> getMenuItems(String filepath) {
        ArrayList<MenuItem> menuItemList;

        try {
            menuItemList = (ArrayList<MenuItem>) Files.lines(Path.of(filepath)).skip(1).map(line -> {
                        String[] field = line.split(",");
                        String title = field[0];
                        double rating = Double.parseDouble(field[1]);
                        int calories = Integer.parseInt(field[2]);
                        int protein = Integer.parseInt(field[3]);
                        int fat = Integer.parseInt(field[4]);
                        int sodium = Integer.parseInt(field[5]);
                        int price = Integer.parseInt(field[6]);

                return (MenuItem) new BaseProduct(title, rating, calories, protein, fat, sodium, price, 0);
                    }
            ).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return menuItemList;
    }

    public static TableModel buildTable(ArrayList<MenuItem> menuItemList) {
        String[] header = { "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price" };
        String[][] data = new String[menuItemList.size()][7];

        for(int i = 0; i < menuItemList.size(); i++) {
            MenuItem currentMenuItem = menuItemList.get(i);
            data[i][0] = currentMenuItem.getTitle();
            data[i][1] = String.valueOf(currentMenuItem.getRating());
            data[i][2] = String.valueOf(currentMenuItem.getCalories());
            data[i][3] = String.valueOf(currentMenuItem.getProtein());
            data[i][4] = String.valueOf(currentMenuItem.getFat());
            data[i][5] = String.valueOf(currentMenuItem.getSodium());
            data[i][6] = String.valueOf(currentMenuItem.computePrice());
        }
        return new DefaultTableModel(data, header);
    }
    public static TableModel buildOrderTable(ArrayList<Map.Entry<Order, ArrayList<MenuItem>>> orderList) {
        String[] header = { "Orders" };
        String[][] data = new String[orderList.size()][1];

        for(int i = 0; i < orderList.size(); i++) {
            data[i][0] = orderList.get(i).toString();
        }
        return new DefaultTableModel(data, header);
    }
    public static void placeOrder(Order orderKey, ArrayList<MenuItem> menuItems){
        try {
            FileWriter fileWriter = new FileWriter("bill.txt");
            fileWriter.write(orderKey.toString() + menuItems.toString());
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}