package org.mukund.repository;

import org.mukund.entity.User;

import java.util.List;

public interface UserRepository {
     User findOne(String id);
     List<User> findAll();
     User create(User user);
     void delete(User user);
     User update(User user);
     User findByEmail(String email);


}
