package org.mukund.service;

import org.mukund.entity.User;


import java.util.List;

public interface UserService {
    public User findOne(String id);
    public List<User> findAll();
    public User create(User user);
    public void delete(String id);
    public User update(String id,User user);
}
