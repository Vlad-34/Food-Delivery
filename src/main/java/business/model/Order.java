package business.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order implements Serializable {
    private int orderId;
    //private static int orderCounter;
    // clientId?
    private User user;
    private LocalDateTime date;
    private int balance;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order(int id, User user, int balance) {
        this.date = LocalDateTime.now();
        this.orderId = id;
        this.user = user;
        this.balance = balance;
        //orderCounter++;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Order\n{" +
                "orderId=" + orderId +
                "\norderUser=" + user.getUsername() +
                ", \ndate=" + date +
                ", \nbalance=" + balance +
                "}\n";
    }

    @Override
    public int hashCode() {
        return orderId;
    }
}
