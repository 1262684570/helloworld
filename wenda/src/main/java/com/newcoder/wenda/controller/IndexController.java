package com.newcoder.wenda.controller;

import com.newcoder.wenda.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

public class IndexController {
    @RequestMapping(path = {"/", "/index"},method = {RequestMethod.GET})
    @ResponseBody
    public String index(){
        return "Hello NowCoder";
    }

    @RequestMapping(path = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("userId") int userId,
                          @PathVariable("groupId") String groupId){
        return String.format("Profile Page of %s/%d",groupId,userId);
    }

    @RequestMapping(path = {"/vm"},method = {RequestMethod.GET})
    public String template(Model model){
        model.addAttribute("value1","vvvv1");
        List<String> colors = Arrays.asList(new String[]{"blue", "green", "red"});
        model.addAttribute("colors",colors);

        Map<String,String> map = new HashMap<>();
        for(int i = 0; i < 4; ++i){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("map",map);
        model.addAttribute("user", new User("LEE"));

        return "home";
    }

}
