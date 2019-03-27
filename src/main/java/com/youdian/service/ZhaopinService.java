package com.youdian.service;

import com.youdian.bean.Zhaopin;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/7 - 11:44
 */
public interface ZhaopinService {

    public Zhaopin getZhaopinById(Integer id);

    public List<Zhaopin> zhaopinList();

    public void insertZhaopin(Zhaopin zhaopin);

    public void updateZhaopin(Zhaopin zhaopin);

    public void deleteZhaopin(Integer id);
}
