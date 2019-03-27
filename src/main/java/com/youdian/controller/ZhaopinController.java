package com.youdian.controller;

import com.youdian.bean.Zhaopin;
import com.youdian.service.ZhaopinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hs
 * @date 2019/3/7 - 11:53
 */
@Controller
@RequestMapping("/youdian")
public class ZhaopinController {
    @Autowired
    ZhaopinService zhaopinService;

    @RequestMapping("/zhaopinList")
    public String zhaopinList(Model model){
        List<Zhaopin> zhaopinList = zhaopinService.zhaopinList();
        model.addAttribute("zhaopinList",zhaopinList);
        return "zhaopinList";

    }

    @RequestMapping("/insertZhaopin")
    public String insertZhaopin(Zhaopin zhaopin){
        zhaopinService.insertZhaopin(zhaopin);
        return "redirect:/youdian/zhaopinList";
    }

    @RequestMapping("/updateZhaopin")
    public String updateZhaopin(Zhaopin zhaopin){
        zhaopinService.updateZhaopin(zhaopin);
        return "redirect:/youdian/zhaopinList";
    }

    @RequestMapping("/toUpdateZhaopin")
    public String toUpdateZhaopin(Model model,Integer id){
        Zhaopin zhaopin = zhaopinService.getZhaopinById(id);
        zhaopin.setId(id);
        model.addAttribute("zhaopin",zhaopin);
        return "updateZhaopin";
    }

    @RequestMapping("/deleteZhaopin")
    public String deleteZhaopin(Integer id){
        zhaopinService.deleteZhaopin(id);
        return "redirect:/youdian/zhaopinList";
    }
}
