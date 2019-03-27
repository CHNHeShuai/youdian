package com.youdian.mapper;

import com.youdian.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/16 - 20:06
 */
@Mapper
public interface UsersMapper {

    @Update("update  users set username=#{username},password=#{password},image=#{image},telephone=#{telephone},email=#{email} where id=#{id}")
    public void updateUsers(Users users);

    @Select("select * from users where username=#{username}")
    public Users getUsers(String username);

    @Update("update  users set password=#{password} where id=#{id}")
    public void updatePassword(Users users);

    @Select("select * from users")
    public List<Users> usersList();

    @Select("select * from users where id=#{id}")
    public Users getUsersById(Integer id);

    @Delete("delete from users where id=#{id}")
    public void deleteUsers(Integer id);

    @Insert("insert into users(username,password,image,telephone,email) values(#{username},#{password},#{image},#{telephone},#{email})")
    public void addUsers(Users users);
}
