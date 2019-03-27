package com.youdian.service;

import com.youdian.bean.Example;
import com.youdian.mapper.ExampleMapper;
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
 * @date 2019/3/1 - 10:13
 */
@Service
public class ExampleServiceImpl implements ExampleService {

    @Autowired
    ExampleMapper exampleMapper;


    @Override
    @Cacheable(value = "example",key = "#root.methodName")
    public Example getExampleByCid(Integer id,HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        Example example = exampleMapper.getExampleByCid(id);
        example.setImage(path+"/"+example.getImage());
        return example;
    }

    @Override
    @Cacheable(value = "example",key = "#root.methodName")
    public List<Example> examplesList(HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        List<Example> exampleList = exampleMapper.examplesList();
        for (Example example:exampleList){
            //获取image数组
            String[] imgs = example.getImage().split(",");
            //循环修改数组的每一项
            for (int i = 0;i<imgs.length;i++){
                imgs[i] = path+"/"+ imgs[i] ;
            }
            String image = String.join(",", imgs);
            example.setImage(image);
        }
        return exampleList;
    }

    @Override
    @Cacheable(value = "example",key = "#id")
    public Example getExampleById(Integer id,HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        Example example = exampleMapper.getExampleById(id);
        //获取image数组
        String[] imgs = example.getImage().split(",");
        //循环修改数组的每一项
        for (int i = 0;i<imgs.length;i++){
            imgs[i] = path+"/"+ imgs[i] ;
        }
        String image = String.join(",", imgs);
        example.setImage(image);
        return example;
    }

    @Override
    @CacheEvict(value = "example",allEntries = true)
    public void updateExample(Example example) {
        exampleMapper.updateExample(example);
    }

    @Override
    @CacheEvict(value = "example",allEntries = true)
    public void insertExample(Example example) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        example.setCreatetime(date);
        exampleMapper.insertExample(example);
    }

    @Override
    @CacheEvict(value = "example",allEntries = true)
    public void deleteExample(Integer id) {
        exampleMapper.deleteExample(id);
    }

    @Override
    @Cacheable(value = "example",key = "#root.methodName")
    public List<Example> exampleListByDesc(HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        List<Example> exampleList = exampleMapper.exampleListByDesc();
        for (Example example : exampleList){
            example.setImage(path+"/"+example.getImage());
        }
        return exampleList;
    }

    @Override
    @Cacheable(value = "example",key = "#root.methodName")
    public List<Example> getExampleListByCid(Integer cid,HttpServletRequest request) {
        //获取项目相对路径
        String path = request.getScheme()+ "://" +request.getServerName()+":"+request.getServerPort()+request.getContextPath();
        List<Example> exampleList = exampleMapper.getExampleListByCid(cid);
        for (Example example:exampleList){
            example.setLog(1);
            //获取image数组
            String[] imgs = example.getImage().split(",");
            //循环修改数组的每一项
            for (int i = 0;i<imgs.length;i++){
                imgs[i] = path+"/"+ imgs[i] ;
            }
            String image = String.join(",", imgs);
            example.setImage(image);
        }
        return exampleList;
    }

    @Override
    @CacheEvict(value = "example",allEntries = true)
    public void updatePageview(Example example) {
        example.setPageview(example.getPageview()+1);
        exampleMapper.updatePageview(example);
    }

    @Override
    public Example getNextId(Integer id) {
        return exampleMapper.getNextId(id);
    }
}
