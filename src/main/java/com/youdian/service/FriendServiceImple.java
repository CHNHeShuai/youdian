package com.youdian.service;

import com.youdian.bean.Friend;
import com.youdian.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/25 - 13:02
 */
@Service
public class FriendServiceImple implements FriendService {
    @Autowired
    FriendMapper friendMapper;
    @Override
    @Cacheable(value = "friend")
    public List<Friend> friendList(HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        List<Friend> friendList = friendMapper.friendList();
        for (Friend friend : friendList){
            friend.setImage(path+"/"+friend.getImage());
        }
        return friendList;
    }

    @Override
    @Cacheable(value = "friend",key = "#id")
    public Friend getFriendById(Integer id,HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        Friend friend = friendMapper.getFriendById(id);
        friend.setImage(path+"/"+friend.getImage());
        return friend;
    }

    @Override
    @CacheEvict(value = "friend",allEntries = true)
    public void deleteFriend(Integer id) {
        friendMapper.deleteFriend(id);
    }

    @Override
    @CacheEvict(value = "friend",allEntries = true)
    public void addFriend(Friend friend) {
        friendMapper.addFriend(friend);
    }
}
