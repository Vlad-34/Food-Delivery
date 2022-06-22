package business;

import business.model.User;
import business.model.UserType;
import data.Serializer;
import presentation.views.*;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserManagement implements Serializable {
    private LoginRegisterView loginRegisterView;
    private static User currentUser = null;
    private static ArrayList<User> userList = null;

    public UserManagement(){

    }

    public UserManagement(LoginRegisterView loginRegisterView) {
        this.loginRegisterView = loginRegisterView;
    }

    public static boolean isAccountAlreadyMade(String username, String password, UserType type) { // login
        String fileName = "file.txt";
        userList = Serializer.deserializeUser(fileName);
        assert userList != null : "There are no users in this app!";
        Integer orderCounter = 0;
        User user = new User(username, password, type, orderCounter);
        boolean ok = false;
        for (User fileUser : userList)
            if (user.getUsername().equals(fileUser.getUsername())){
                ok = true;
                currentUser = fileUser;
                break;
            }
        return ok;
    }

    public static void register(String username, String password, UserType type) {
        String fileName = "file.txt";
        ArrayList<User> userList = Serializer.deserializeUser(fileName);
        User user = new User(username, password, type, 0);
        boolean ok = false;
        for (User fileUser : userList)
            if (user.getUsername().equals(fileUser.getUsername()) || user.getPassword().equals(fileUser.getPassword())){
                ok = true;
                break;
            }
        assert ok == false : "There is already an account with the same username or the same password!";
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$");
        Matcher matcher = pattern.matcher(username);
        // assert matcher.matches() : "The username is invalid!";
        userList.add(user);
        Serializer.serializeUser(userList, fileName);
        assert userList != null : "Error: the user could not be registered!";
        JOptionPane.showMessageDialog(null, "The account has been made successfully");
    }
    public static User getCurrentUser(){
        return currentUser;
    }
    public static void setCurrentUser(){
        userList.get(userList.indexOf(currentUser)).setOrderCounter(userList.get(userList.indexOf(currentUser)).getOrderCounter() + 1);
        Serializer.serializeUser(userList, "file.txt");
    }
}
