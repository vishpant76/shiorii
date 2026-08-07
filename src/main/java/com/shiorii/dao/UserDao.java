package com.shiorii.dao;

import com.shiorii.DataStore;
import com.shiorii.entities.User;

public class UserDao {
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}
