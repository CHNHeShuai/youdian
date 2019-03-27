package com.youdian.service;

import com.youdian.bean.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/1 - 10:12
 */
public interface ExampleService {
    public Example getExampleByCid(Integer id,HttpServletRequest request);

    //获取项目列表
    public List<Example> examplesList(HttpServletRequest request);

    public Example getExampleById(Integer id,HttpServletRequest request);

    public void  updateExample(Example example);

    public void insertExample(Example example);

    public void deleteExample(Integer id);

    public List<Example> exampleListByDesc(HttpServletRequest request);

    public List<Example> getExampleListByCid(Integer cid,HttpServletRequest request);
    public void updatePageview(Example example);
    public Example getNextId(Integer id);
}
