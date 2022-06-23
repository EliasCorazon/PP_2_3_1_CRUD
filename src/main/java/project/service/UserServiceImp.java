package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.dao.UserDao;
import project.model.User;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(@Qualifier("userDaoImp") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public void edit(Long id, User editUser) {
        userDao.edit(id, editUser);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
