package com.nowcoder.community.controller;


import com.nowcoder.community.Service.AlphaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    AlphaService alphaService;
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello";
    }
    @RequestMapping("/data")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

//    @RequestMapping("/http")
//    public void http(HttpServletRequest request, HttpServletResponse response){
//        System.out.println(request.getMethod());
//        System.out.println(request.getServletPath());
//        Enumeration<String> enumeration = request.getHeaderNames();
//        while (enumeration.hasMoreElements()){
//            String name = enumeration.nextElement();
//            String value = request.getHeader(name);
//            System.out.println(name+": "+value);
//        }
//        System.out.println(request.getParameter("code"));
//
//        response.setContentType("text/html;charset=utf-8");
//        try(PrintWriter pw = response.getWriter()) {
//
//            pw.write("<h1>niukewang</h1>");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    @RequestMapping(path = "/students",method = RequestMethod.GET)
//    @ResponseBody
//    public String getStudents(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
//                              @RequestParam(name = "limit",required = false,defaultValue = "1")int limit){
//        System.out.println(current);
//        System.out.println(limit);
//        return "some students";
//    }
//
//    @RequestMapping(path = "/student.html/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public String getStudent(@PathVariable("id")int id){
//        System.out.println(id);
//        return "a stuident";
//    }

    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(@RequestParam(required = false,defaultValue = "1")String name,
                              @RequestParam(required = false,defaultValue = "1")int age){
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","ali");
        modelAndView.addObject("age",30);
        modelAndView.setViewName("/demo/view.html");
        return modelAndView;
    }

    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age",80);
        return "/demo/view";
    }

    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp(){
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",21);
        emp.put("salary",80000);
        return emp;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        List<Map<String, Object>> res = new ArrayList<>();
        Map<String,Object> emp = new HashMap<>();
        emp.put("name","张三");
        emp.put("age",21);
        emp.put("salary",80000);
        res.add(emp);
        return res;
    }
}
