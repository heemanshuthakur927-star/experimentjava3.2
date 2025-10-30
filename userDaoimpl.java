package com.example.pblj.dao;

import java.util.List;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.example.pblj.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) {
        getSession().save(user);
    }

    @Override
    public User get(int id) {
        return getSession().get(User.class, id);
    }

    @Override
    public List<User> list() {
        return getSession().createQuery("from User", User.class).list();
    }

    @Override
    public void update(User user) {
        getSession().update(user);
    }

    @Override
    public void delete(int id) {
        User u = get(id);
        if (u != null) getSession().delete(u);
    }
}
