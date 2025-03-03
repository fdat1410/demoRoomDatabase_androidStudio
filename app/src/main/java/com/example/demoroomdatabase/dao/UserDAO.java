package com.example.demoroomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.demoroomdatabase.entity.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM User")
    List<User> getAll();

    @Query("SELECT * FROM User WHERE id = :id")
    User getUserById(int id);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);
    @Update
    void update(User user);
    @Query("UPDATE User SET name = :name, email = :email, password = :password WHERE id = :id")
    void updateUserById(int id, String name, String email, String password);

}
