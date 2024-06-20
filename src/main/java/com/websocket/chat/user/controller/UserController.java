package com.websocket.chat.user.controller;

import com.websocket.chat.user.model.UserVO;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request){
        logger.info("GET URL = {}", request.getRequestURL());
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserVO vo, HttpServletRequest request){
        logger.info("POST URL = {}", request.getRequestURL());
        logger.info("ID = {}", vo.getId());
        logger.info("PW = {}", vo.getPw());
        return "redirect:/";
    }

    @GetMapping("/register")
    public String registerPage(HttpServletRequest request){
        logger.info("URL = {}", request.getRequestURL());
        return "/user/register";
    }
}
