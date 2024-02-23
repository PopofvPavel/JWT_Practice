package com.example.lecpractice.controllers;

import com.example.lecpractice.dto.AuthRequest;
import com.example.lecpractice.entity.UserInfo;
import com.example.lecpractice.repository.UserRepository;
import com.example.lecpractice.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/auth")
public class AuthController {

    final UserRepository userRepository;
    final JwtService jwtService;

    @Autowired
    public AuthController(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model ) {
        AuthRequest authRequest = new AuthRequest();
        model.addAttribute("authRequest", authRequest);
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AuthRequest authRequest, Model model) {
        UserInfo userInfo;
        userInfo = userRepository.findUserByUsername(authRequest.getUsername());
        if (userInfo != null && !authRequest.getPassword().isEmpty()) {
            if (authRequest.getPassword().equals(userInfo.getPassword())) {
                //JWT TOKEN
                String token = jwtService.generateToken(userInfo.getName());
                System.out.println("token = " + token);
                model.addAttribute("token", token);
                return "redirect:/weather";
            } else {
                model.addAttribute("error", "Wrong password");
                return "loginForm";
            }

        } else {
            model.addAttribute("error", "User not found of password is empty");
            return "loginForm";
        }
    }

    @GetMapping("/new")
    public String showUserCreateForm(Model model) {
        UserInfo userInfo = new UserInfo();
        model.addAttribute("userInfo", userInfo);
        return "newUserForm";
    }

    @PostMapping("/new")
    @ResponseBody
    public ResponseEntity<UserInfo> createUser(@ModelAttribute("UserInfo") UserInfo userInfo) {

        userRepository.addUser(userInfo);
        System.out.println(userInfo);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }
}
