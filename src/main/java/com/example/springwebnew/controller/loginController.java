package com.example.springwebnew.controller;

import com.example.springwebnew.mapper.departmentMapper;
import com.example.springwebnew.pojo.department;
import com.example.springwebnew.pojo.employee;
import com.example.springwebnew.service.departmentService;
import com.example.springwebnew.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class loginController {
    @Autowired
    departmentService departmentService;
    @Autowired
    employeeService employeeService;


    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session){
        if(StringUtils.hasLength(username)&&"123456".equals(password)){
            session.setAttribute("userInfo",username);
            return "redirect:/main.html";}
        else{
            model.addAttribute("msg","用户名或密码错误");
            return "index";
        }
    }

    @RequestMapping("/userList")
    public String userlist(Model model){
        List<employee> employees = employeeService.list();
        List<department> departments = departmentService.list();
        model.addAttribute("departments",departments);
        model.addAttribute("userInfomation",employees);
        return "list";
    }

    @GetMapping("/emp")
    public String gotoAddPg(Model model){
        List<department> departments = departmentService.list();
        model.addAttribute("departments",departments);
        return "/emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(employee employee){
        employeeService.save(employee);
        return "redirect:/userList";
    }

    @PostMapping("/save")
    public String updateEmp(employee employee){
        employeeService.updateById(employee);
        return "redirect:/userList";
    }

    @GetMapping("/Toupdate/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        employee employee = employeeService.getById(id);
        model.addAttribute("employee",employee);
        List<department> departments = departmentService.list();
        model.addAttribute("departments",departments);
        return "/emp/update";
    }

    @GetMapping("/Todelete/{id}")
    public String toDelete(@PathVariable("id") Integer id){
        employeeService.removeById(id);
        return "redirect:/userList";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
