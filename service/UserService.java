package service;

import model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<Integer, User> users= new HashMap<>();
    public User createUser(int id, String name) {
        User user = new User(id, name);
        users.put(id, user);
        return user;
    }
    public Map<Integer, User> getUsers() {
        return users;
    }
    public Collection<User>getAllUsers() {
        return users.values();
    }
}
