package project.service;

import project.model.User;
import java.util.List;

public interface UserService {
    List<User> allUsers();
    void add(User user);
    void delete(Long id);
    void edit(Long id, User editUser);
    User getById(Long id);
}