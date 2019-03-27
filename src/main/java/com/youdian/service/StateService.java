package com.youdian.service;

import com.youdian.bean.State;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/7 - 17:51
 */
public interface StateService {

    public State getStateById(Integer id,HttpServletRequest request);

    public List<State> stateList(HttpServletRequest request);

    public void insertState(State state);

    public void updateState(State state);

    public void deleteState(Integer id);

    public void updatePageview(State state);

    public List<State> stateListByDesc(HttpServletRequest request);
    public State getNextId(Integer id);
}
