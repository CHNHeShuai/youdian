package com.youdian.service;

import com.youdian.bean.State;
import com.youdian.mapper.StateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/7 - 17:51
 */
@Service
public class StateServiceImpl implements StateService {

    @Autowired
    StateMapper stateMapper;
    @Override
    @Cacheable(value = "state",key = "#id")
    public State getStateById(Integer id,HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        State state = stateMapper.getStateById(id);
        state.setImage(path+"/"+state.getImage());
        return state;
    }

    @Override
    @Cacheable(value = "state",key = "#root.methodName")
    public List<State> stateList(HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        List<State> stateList = stateMapper.stateList();
        for (State state : stateList){
            state.setImage(path+"/"+state.getImage());
        }
        return stateList;
    }

    @Override
    @CacheEvict(value = "state",allEntries = true)
    public void insertState(State state) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        state.setUpdatetime(date);
        stateMapper.insertState(state);
    }

    @Override
    @CacheEvict(value = "state",allEntries = true)
    public void updateState(State state) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        state.setUpdatetime(date);
        stateMapper.updateState(state);
    }

    @Override
    @CacheEvict(value = "state",allEntries = true)
    public void deleteState(Integer id) {
        stateMapper.deleteState(id);
    }

    @Override
    @CacheEvict(value = "state",allEntries = true)
    public void updatePageview(State state) {
        /*int pageview = state.getPageview();
        pageview = pageview + 1;*/
        state.setPageview(state.getPageview()+1);
        stateMapper.updatePageview(state);
    }

    @Override
    @Cacheable(value = "state",key = "#root.methodName")
    public List<State> stateListByDesc(HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        List<State> stateList = stateMapper.stateListByDesc();
        for (State state : stateList){
            state.setImage(path+"/"+state.getImage());
        }
        return stateList;
    }

    @Override
//    @Cacheable(value = "state")
    public State getNextId(Integer id) {
        return stateMapper.getNextId(id);
    }
}
