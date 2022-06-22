package business.model;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;
    private UserType type;
    private Integer orderCounter;

    public Integer getOrderCounter() {
        return orderCounter;
    }

    public void setOrderCounter(Integer orderCounter) {
        this.orderCounter = orderCounter;
    }

    public User(String username, String password, UserType type, int orderCounter) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.orderCounter = orderCounter;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }
}
