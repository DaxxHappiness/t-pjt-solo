package com.mrseo3o3.pjt_solo.service;

import com.mrseo3o3.pjt_solo.domain.dto.UserDto;
import com.mrseo3o3.pjt_solo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    // UserService method
    public int getUserCount() {
        return this.userDao.getUserCount();
    }

    public int getUserCheck(String email) {
        return this.userDao.hasUser(email);
    }

    public UserDto getUserOne(String email) {
        return this.userDao.getUserOne(email);
    }

    public int addUserOne(UserDto userDto) {
        return this.userDao.addUserOne(userDto);
    }
}
