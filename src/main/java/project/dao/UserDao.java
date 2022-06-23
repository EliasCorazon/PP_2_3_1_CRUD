package project.dao;

import project.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(Long id, User editUser);
    User getById(Long id);
}