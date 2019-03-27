package com.youdian.service;

import com.youdian.bean.Users;
import com.youdian.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/16 - 20:51
 */
public interface UsersService {

    public void updateUsers(Users users);

    public Users getUsers(String username);

    public void updatePassword(Users users);
    public List<Users> usersList();
    public Users getUsersById(Integer id);
    public void deleteUsers(Integer id);
    public void addUsers(Users users);

}
