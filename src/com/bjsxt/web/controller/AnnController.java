package com.bjsxt.web.controller;

import com.bjsxt.pojo.Address;
import com.bjsxt.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
//http://localhost:8888/springmvcanndemo/suibian/ann
@RequestMapping("/suibian")
public class AnnController {

    //http://localhost:8888/springmvcanndemo/ann
    @RequestMapping("/ann")
    public ModelAndView annDemo(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("msg","Hello Old Lu");
        return modelAndView;
    }

    /**
     * 通过HttpServletRequest对象获取请求参数
     */
    @RequestMapping("/getData")
    public ModelAndView getRequestParameter(HttpServletRequest request){
        String username = request.getParameter("name");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("username",username);
        return modelAndView;
    }

    /**
     * 通过SpringMVC参数注入方式获取请求参数-注入多参数
     * @param username
     * @param userage
     * @return
     */
    @RequestMapping("/addUsers")
    public ModelAndView addUsers(String username,int userage){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("name",username);
        modelAndView.addObject("age",userage);
        return modelAndView;
    }

    /**
     * @RequestParam使用
     * @param username
     * @param userage
     * @return
     */
    @RequestMapping("/addUsers2")
    public ModelAndView addUsers2(@RequestParam(value = "name",required = false,defaultValue = "oldlu") String username, @RequestParam("age") int userage){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("name",username);
        modelAndView.addObject("age",userage);
        return modelAndView;
    }

    /**
     * 如果userlike用的是List<String>集合的话,是必须要加@RequestParam注解的。但当是String[]的时候是不需要加注解的
     * @param username
     * @param userlike
     * @return
     */
    @RequestMapping("/addUsers3")
    public ModelAndView addUsers3(String username,@RequestParam List<String> userlike){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("name",username);
        String temp = "";
        for (String str:userlike){
           temp += str+" ";
        }
        modelAndView.addObject("userlike",temp);
        return modelAndView;
    }

    /**
     * 注入单个对象到Pojo
     * @param user
     * @return
     */
    @RequestMapping("/addUsers4")
    public ModelAndView addUsers4(Users user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("name",user.getUsername());
        String temp = "";
        for (String str:user.getUserlike()){
            temp += str+" ";
        }
        modelAndView.addObject("userlike",temp);
        return modelAndView;
    }

    /**
     * 注入关联对象
     * @param user
     * @return
     */
    @RequestMapping("/addUsers5")
    public ModelAndView addUsers5(Users user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("user",user.toString());
        modelAndView.addObject("address",user.getAddress().toString());
        return modelAndView;
    }

    /**
     * 注入存放对象的List集合
     * @param user
     * @return
     */
    @RequestMapping("/addUsers6")
    public ModelAndView addUsers6(Users user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("user",user.toString());
        modelAndView.addObject("address",user.getAddressList());
        return modelAndView;
    }

    /**
     * 注入存放对象的Map集合
     * @param user
     * @return
     */
    //@RequestMapping(value = "/addUsers7",method = RequestMethod.POST)
    //@GetMapping(name="/addUsers7")
    @PostMapping(name = "/addUsers7")
    public ModelAndView addUsers7(Users user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index.jsp");
        modelAndView.addObject("user",user.toString());
        Set<Map.Entry<String, Address>> set = user.getAddressMap().entrySet();
        modelAndView.addObject("address",set);
        return modelAndView;
    }
}
