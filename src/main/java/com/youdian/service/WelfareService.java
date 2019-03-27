package com.youdian.service;

import com.youdian.bean.Welfare;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/8 - 12:12
 */
public interface WelfareService {
    public List<Welfare> welfareList(HttpServletRequest request);

    public void updateWelfare(Welfare welfare);

    public Welfare getWelfareById(Integer id);
}
