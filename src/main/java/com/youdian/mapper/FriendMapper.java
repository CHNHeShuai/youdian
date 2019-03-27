package com.youdian.mapper;

import com.youdian.bean.Friend;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/25 - 12:55
 */
@Mapper
public interface FriendMapper {

    @Select("select * from friend")
    public List<Friend> friendList();

    @Select("select * from friend where id=#{id}")
    public Friend getFriendById(Integer id);

    @Delete("delete from friend where id=#{id}")
    public void deleteFriend(Integer id);

    @Insert("insert into friend(companyname,image) values(#{companyname},#{image})")
    public void addFriend(Friend friend);
}
