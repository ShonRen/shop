package com.ml.dao;

import java.util.List;

import com.ml.entity.User;

public interface UserDao {
     public User findByName(String username);
     public void save(User user);
}

