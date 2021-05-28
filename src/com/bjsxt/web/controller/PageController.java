package com.bjsxt.web.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/login")
    public String showLogin(HttpServletRequest request, Map<String, String> map, Model model, HttpSession session) {
        //第一种方式：通过request获取ServletContext对象
        //ServletContext servletContext = request.getSession().getServletContext();
        //第二种方式:通过session获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("msg","Hello Bjsxt");
        return "login";
    }

    @RequestMapping("/login2")
    public void showLogin2(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setAttribute("msg","Old Lu");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
    }

    @RequestMapping("/login3")
    public String showLogin3(Model model){
        model.addAttribute("msg","Bjsxt");
        return "forward:/WEB-INF/jsp/login.jsp";
    }

    @RequestMapping("/login4")
    public String showLogin4(Model model){
        model.addAttribute("msg","ITBZ");
        return "login";
    }

    @RequestMapping("/redirectLogin")
    public String redirectLogin(){
        return "redirect:/page/login4";
    }
}
