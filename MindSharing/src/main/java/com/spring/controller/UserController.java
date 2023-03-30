package com.spring.controller;

import com.spring.Form.UserCreateForm;
import com.spring.Repository.UserRepository;
import com.spring.Service.UserService;
import com.spring.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm, Model model) {

        model.addAttribute("userCreateForm", userCreateForm);
        return "signup_form";
    }

    @PostMapping(path = "/signup", produces = "application/json")
//    @PostMapping("/signup")
    @ResponseBody
    public String signup(@RequestParam String name, @RequestParam String password, @ModelAttribute UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }

        userService.create(name, password);


//        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
//            bindingResult.rejectValue("password2", "passwordInCorrect",
//                    "2개의 패스워드가 일치하지 않습니다.");
//            return "signup_form";
//        }

        return "name : " + name + ", password : " + password;
    }

}

