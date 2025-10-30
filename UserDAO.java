package com.example.pblj.dao;
import java.util.List;
import com.example.pblj.entity.User;

public interface UserDAO {
    void save(User user);
    User get(int id);
    List<User> list();
    void update(User user);
    void delete(int id);
}
