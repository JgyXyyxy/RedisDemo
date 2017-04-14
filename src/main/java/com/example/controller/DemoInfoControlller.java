package com.example.controller;

import com.example.bean.DemoInfo;
import com.example.service.DemoInfoService;
import com.example.service.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by J on 2017/3/1.
 */
@RestController
public class DemoInfoControlller {

    @Autowired
    private DemoInfoService demoInfoService;


    @RequestMapping("/test1")
    public @ResponseBody DemoInfo test(){

        DemoInfo loaded1 = demoInfoService.findById(1);
        System.out.println("loaded1="+loaded1);
        DemoInfo loaded2 = demoInfoService.findById(2);
        System.out.println("loaded2="+loaded2);
        return loaded1;
    }





    @RequestMapping("/delete")
    public @ResponseBody
    String delete(long id){
        demoInfoService.deleteFromCache(id);
        return "ok";
    }



    @RequestMapping("/test")
    public @ResponseBody String test1(){

        demoInfoService.test();
        System.out.println("DemoInfoController.test1()");
        return "ok";

    }
}
