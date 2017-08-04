package org.mukund.service;

import org.mukund.Exception.BadRequestException;
import org.mukund.Exception.NotFoundException;
import org.mukund.entity.User;
import org.mukund.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public User findOne(String id) {
        User user=repository.findOne(id);
        if(user==null){
            throw new NotFoundException("User with id"+id+" not found");//return 404
        }
        return user;
    }

    @Override
    @Transactional(readOnly=true)
    public List<User> findAll() {


        return repository.findAll();
    }

    @Override
    @Transactional
    public User create(User user) {
        User userExists=repository.findByEmail(user.getEmail());
        if(userExists!=null){
            throw new BadRequestException("User with email="+userExists.getEmail()+" already exists");
        }

        return repository.create(user);
    }

    @Override
    @Transactional
    public void delete(String id) {
        if(repository.findOne(id)==null){
            throw new BadRequestException("User with id="+id+" doesn't exist");
        }
        repository.delete(repository.findOne(id));
    }

    @Override
    @Transactional
    public User update(String id,User user) {
        User usr=repository.findOne(id);
        if(usr==null){
            throw new NotFoundException("User with id ="+id+" not found");
        }

        return repository.update(user);
    }
}
