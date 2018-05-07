package com.kk.user.service;


import com.kk.user.bean.User;
import com.kk.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userDao;

    public User findByUsernameAndPassword(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
    public User save(User user) {
        return userDao.save(user);
    }

    public User findOne(Integer id) {

       Optional<User>  bean = userDao.findById(id);
       return bean.get();

    }


    public boolean checkLogin(User user) {
        return findByUsernameAndPassword(user.getUsername(), user.getPassword()) == null ? false : true;
    }


}
