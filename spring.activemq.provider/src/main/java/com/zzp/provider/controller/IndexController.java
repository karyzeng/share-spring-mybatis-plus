package com.zzp.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description 跳转url controller
 * @Author Garyzeng
 * @since 2020.02.24
 **/
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String updateSendFlag(Model model) {
        model.addAttribute("url", "http://www.baidu.com");
        return "index";
    }

}
