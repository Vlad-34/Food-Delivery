package data;

import business.model.User;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Serializer {
    public static void serializeUser(ArrayList<User> users, String fileName) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(users);
            out.close();
            file.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static ArrayList<User> deserializeUser(String fileName) {
        ArrayList<User> userList = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);
            userList = (ArrayList<User>)in.readObject();
            in.close();
            file.close();
        } catch (EOFException exception) {
            JOptionPane.showMessageDialog(null, "No account ever created in this app.");
        } catch (ClassCastException | ClassNotFoundException | IOException exception) {
            exception.printStackTrace();
        }
        return userList;
    }
}
