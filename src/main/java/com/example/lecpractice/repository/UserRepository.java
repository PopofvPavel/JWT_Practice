package com.example.lecpractice.repository;

import com.example.lecpractice.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Integer, UserInfo> users = new HashMap<>();

    public void addUser(UserInfo userInfo) {
        users.put(userInfo.getId(), userInfo);
    }

    public UserInfo findUserById(Integer id) {
        return users.getOrDefault(id, null);

    }

    public UserInfo findUserByUsername(String username) {
       var user =  users.values().stream().filter(u -> u.getName().equals(username)).findFirst();
        return user.orElse(null);
    }

    public Map<Integer, UserInfo> getUsers() {
        return users;
    }
}
