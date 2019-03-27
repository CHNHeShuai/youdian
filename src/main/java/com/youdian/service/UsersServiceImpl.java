package com.youdian.service;

import com.youdian.bean.Users;
import com.youdian.mapper.UsersMapper;
import com.youdian.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/16 - 20:54
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersMapper usersMapper;
    @Override
    @CacheEvict(value = "users",allEntries = true)
    public void updateUsers(Users users) {
        String pass = MD5Utils.md5(users.getPassword());
        users.setPassword(pass);
        usersMapper.updatePassword(users);
        usersMapper.updateUsers(users);
    }

    @Override
    @Cacheable(value = "users",key = "#username")
    public Users getUsers(String username) {
        return usersMapper.getUsers(username);
    }

    @Override
    @CacheEvict(value = "users",allEntries = true)
    public void updatePassword(Users users) {
        String pass = MD5Utils.md5(users.getPassword());
        users.setPassword(pass);
        usersMapper.updatePassword(users);
    }

    @Override
    @Cacheable(value = "users")
    public List<Users> usersList() {
        return usersMapper.usersList();
    }

    @Override
    @Cacheable(value = "users",key = "#id")
    public Users getUsersById(Integer id) {
        return usersMapper.getUsersById(id);
    }

    @Override
    @CacheEvict(value = "users",allEntries = true)
    public void deleteUsers(Integer id) {
        usersMapper.deleteUsers(id);
    }

    @Override
    @CacheEvict(value = "users",allEntries = true)
    public void addUsers(Users users) {
        String pass = MD5Utils.md5(users.getPassword());
        users.setPassword(pass);
        usersMapper.addUsers(users);
    }
}
