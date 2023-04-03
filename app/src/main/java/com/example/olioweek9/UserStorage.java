package com.example.olioweek9;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage userStorage = null;

    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public static UserStorage getInstance(){
        if (userStorage == null){
            userStorage = new UserStorage();
        }
        return userStorage;
    }


    public void saveUsers(Context context){
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
        } catch (IOException e) {
            System.out.println("Rakettien tallentaminen ei onnistunut");
            //throw new RuntimeException(e);
        }

    }

    public void loadUsers(Context context){
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Lukeminen epäonnistui");
        } catch (IOException e) {
           // throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
           // throw new RuntimeException(e);
        }
    }



}
