package com.youdian.service;

import com.youdian.bean.Zhaopin;
import com.youdian.mapper.ZhaopinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/7 - 11:44
 */
@Service
public class ZhaopinServiceImpl implements ZhaopinService {

    @Autowired
    ZhaopinMapper zhaopinMapper;
    @Override
    public Zhaopin getZhaopinById(Integer id) {
        return zhaopinMapper.getZhaopinById(id);
    }

    @Override
    public List<Zhaopin> zhaopinList() {
        return zhaopinMapper.zhaopinList();
    }

    @Override
    public void insertZhaopin(Zhaopin zhaopin) {
        //设置添加时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        zhaopin.setCreatetime(date);
        zhaopinMapper.insertZhaopin(zhaopin);
    }

    @Override
    public void updateZhaopin(Zhaopin zhaopin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        zhaopin.setCreatetime(date);
        zhaopinMapper.updateZhaopin(zhaopin);
    }

    @Override
    public void deleteZhaopin(Integer id) {
        zhaopinMapper.deleteZhaopin(id);
    }
}
