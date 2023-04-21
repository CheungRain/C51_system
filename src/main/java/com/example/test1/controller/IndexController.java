package com.example.test1.controller;
import com.example.test1.entity.OrdinaryData;
import com.example.test1.entity.TopData;
import com.example.test1.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings({"all"})
@Controller
public class IndexController {

    private int tOrd=0,hOrd=0,tTop=10,hTop=10;
    private String s1 = "data from C51:";//14
    private String s2 = "data send to C51:";//17
    private String s3 = "temperature(℃):";//12
    private String s4 = "humidity(%):";//9
    private String s5 = "temperature threshold(℃):";//22
    private String s6 = "humidity threshold(%):";//19
    OrdinaryData test = new OrdinaryData();
    @RequestMapping("/index")
    public String index(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/index/send")
    @ResponseBody
    public OrdinaryData indexSendData(@RequestParam int temTop,@RequestParam int humTop,
                                      Model model,HttpServletRequest request) throws InterruptedException {
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        Thread.sleep(10000);
        tTop=temTop;
        hTop=humTop;
        test.setTem(tOrd);
        test.setHum(hOrd);
        tOrd++;
        hOrd++;
        return test;
    }

    @GetMapping("/index/get-and-send-data")
    @ResponseBody
    public TopData getAndSendData(@RequestParam("tem") int tem, @RequestParam("hum") int hum,Model model,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        System.out.printf("\033[32m"+"%-15s %-15s %-4d %-12s %-8d %-18s %-25s %-4d %-22s %-4d\n"
                ,s1,s3,tem,s4,hum,s2,s5,tTop,s6,hTop);
        tOrd=tem;
        hOrd=hum;
        TopData top = new TopData();
        top.setTemTop(tTop);
        top.setHumTop(hTop);
        return top;
    }

}
