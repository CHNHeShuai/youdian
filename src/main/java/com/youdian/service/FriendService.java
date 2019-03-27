package com.youdian.service;

import com.youdian.bean.Friend;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/25 - 13:00
 */
public interface FriendService {
    public List<Friend> friendList(HttpServletRequest request);

    public Friend getFriendById(Integer id,HttpServletRequest request);

    public void deleteFriend(Integer id);
    public void addFriend(Friend friend);
}
