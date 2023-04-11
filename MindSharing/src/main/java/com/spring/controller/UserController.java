package com.spring.controller;

import com.spring.Repository.UserRepository;
import com.spring.Service.BaseException;
import com.spring.Service.UserService;
import com.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> addUser(@RequestBody Map<String, String> payload) {

        String username = payload.get("username");
        String email = payload.get("useremail");
        String password = payload.get("password");

//        System.out.println("username : " + username);
//        System.out.println("email : " + email);
//        System.out.println("password : " + password);

        userService.signup(username, email, password);

        List<User> users = userService.getUsers();

        System.out.println("유저 회원가입 완료 : " + users);

        return ResponseEntity.ok("유저 회원가입 완료");
    }

    @PostMapping("/login")
    @ResponseBody
    public String login() {
        return "로그인 완료";
    }

    @GetMapping("/user/list")
    @ResponseBody
    public List<User> getUsers() {

        List<User> users = userService.getUsers();

        if (users == null) return null;

        return userService.getUsers();
    }

//    @GetMapping("/signup")
//    public String signup(UserCreateForm userCreateForm, Model model) {
//
//        model.addAttribute("userCreateForm", userCreateForm);
//        return "signup_form";
//
//    }
//
//    //로그인 컨트롤러
//    @GetMapping("/login")
//    public String login() {
//        return "login_form";
//    }
//
////    @PostMapping(path = "/signup", produces = "application/json")
//    @PostMapping("/signup")
//    @ResponseBody
//    public String signup(@RequestParam String name, @RequestParam String password, @ModelAttribute UserCreateForm userCreateForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "signup_form";
//        }
//
//        userService.create(name, password);
//
//
////        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
////            bindingResult.rejectValue("password2", "passwordInCorrect",
////                    "2개의 패스워드가 일치하지 않습니다.");
////            return "signup_form";
////        }
//
//
//        return "name : " + name + ", password : " + password;
//    }

    @ResponseBody
    @GetMapping("/home")
    public void kakaoCallback(@RequestParam String code) throws BaseException {
        String access_Token = userService.getKaKaoAccessToken(code);
        userService.createKakaoUser(access_Token);
    }
}

