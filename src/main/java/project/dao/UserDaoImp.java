package project.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> allUsers() {
        String jpql = "SELECT users FROM User users";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        User user = getById(id);
        entityManager.remove(user);
    }

    @Override
    public void edit(Long id, User editUser) {
        User user = getById(id);
        user.setName(editUser.getName());
        user.setLastName(editUser.getLastName());
        user.setEmail(editUser.getEmail());
        entityManager.merge(user);
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }
}