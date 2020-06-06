package com.uabc.edu.appswbd.demo_examen.web;

import javax.servlet.http.HttpServletRequest;

import com.uabc.edu.appswbd.demo_examen.model.User;
import com.uabc.edu.appswbd.demo_examen.service.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {

    @GetMapping()
    public String getHome() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @Autowired
    private MyUserDetailsService userService;

    @GetMapping("/registrar")
    public String getRegister(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registrar";
    }

    @RequestMapping(path = "/saveUser", method = RequestMethod.POST)
    public String getSaveUser(@RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "password", required = true) String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setActive(true);
        user.setRoles("ROLE_USER");
        userService.saveUser(user);
        return "redirect:/";
    }
}