package org.mukund.service;

import org.mukund.entity.User;


import java.util.List;

public interface UserService {
     User findOne(String id);
     List<User> findAll();
     User create(User user);
     void delete(String id);
     User update(String id,User user);
     User authenticate(String param,String password);
}
