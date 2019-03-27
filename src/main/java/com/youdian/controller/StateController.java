package com.youdian.controller;

import com.youdian.bean.State;
import com.youdian.service.StateService;
import com.youdian.util.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hs
 * @date 2019/3/7 - 17:54
 */
@Controller
@RequestMapping("/youdian")
public class StateController {

    @Autowired
    StateService stateService;

    @RequestMapping("/stateList")
    public String stateList(Model model,HttpServletRequest request){
        List<State> stateList = stateService.stateList(request);
        model.addAttribute("stateList",stateList);
        return "stateList";
    }

    @RequestMapping("/insertState")
    public String insertState(State state, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile,
                              HttpServletRequest request, Model model){
        String image = UploadImage.uploadImage(imageFile, request);
        state.setImage(image);
        stateService.insertState(state);
        return "redirect:/youdian/stateList";
    }

    @RequestMapping("/updateState")
    public String updateState(State state, BindingResult bindingResult, @RequestParam(value = "image") MultipartFile imageFile,
                              HttpServletRequest request, Model model){
        //接受前台上传的图片
        String image = UploadImage.uploadImage(imageFile, request);
        state.setImage(image);
        stateService.updateState(state);
        return "redirect:/youdian/stateList";
    }

    @RequestMapping("/toUpdateState")
    public String toUpdateState(Integer id,Model model,HttpServletRequest request){
        State state = stateService.getStateById(id,request);
        state.setId(id);
        model.addAttribute("state",state);
        return "updateState";
    }

    @RequestMapping("/deleteState")
    public String deleteState(Integer id){
        stateService.deleteState(id);
        return "redirect:/youdian/stateList";
    }
}
