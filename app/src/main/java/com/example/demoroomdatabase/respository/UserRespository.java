package com.example.demoroomdatabase.respository;

import android.content.Context;

import com.example.demoroomdatabase.dao.UserDAO;
import com.example.demoroomdatabase.dao.UserRoomDatabase;
import com.example.demoroomdatabase.entity.User;

import java.util.List;

public class UserRespository {
    UserDAO userDAO ;
    public UserRespository(Context context){
        UserRoomDatabase userRoomDatabase = UserRoomDatabase.getInstance(context);
        userDAO = userRoomDatabase.userDao();
    }
    public void insert(User user){
        userDAO.insert(user);
    }
    public void delete(User user){
        userDAO.delete(user);
    }
    public List<User> getAll(){
        return userDAO.getAll();
    }
    public User getUserById(int id){
        return userDAO.getUserById(id);
    }
    public void update(User user){
        userDAO.update(user);
    }
    public void updateUserById(int id, String name, String email, String password){
        userDAO.updateUserById(id, name, email, password);
    }
}
