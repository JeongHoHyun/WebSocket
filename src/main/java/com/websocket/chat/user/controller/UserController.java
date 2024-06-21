package com.websocket.chat.user.controller;

import com.websocket.chat.user.model.UserVO;
import com.websocket.chat.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String loginPage(HttpServletRequest request){
        // 회원가입 페이지로 이동
        logger.info("GET URL = {}", request.getRequestURL());
        return "user/register";
    }

    @PostMapping("/register")
    public String login(@ModelAttribute UserVO vo, HttpServletRequest request){
        // 회원가입 요청
        logger.info("POST URL = {}", request.getRequestURL());
        logger.info("ID = {}", vo.getUser_id());
        logger.info("PW = {}", vo.getUser_pw());
        logger.info("PW = {}", vo.getUser_name());
        // DB 저장
        userService.registerUser(vo);
        return "redirect:/";
    }

    @GetMapping("/duplication_check")
    public ResponseEntity<Map<String, Integer>> duplicationCheck(@RequestParam String user_id, HttpServletRequest request){
        // ID 중복체크
        logger.info("GET URL = {}", request.getRequestURL());
        logger.info("ID = {}", user_id);
        // DB 조회
        int count = userService.duplicationCheck(user_id);
        logger.info("Duplicate Check Result = {}", count);
        // singletonMap으로 생성된 맵은 변경할 수 없다. 키나 값을 추가 제거, 변경하려고하면 UnsupportedOperationException 발생
        // 단일 요소 전송이나 설정에서 유용하고 복잡한 데이터 구조나 여러 항목을 필요로 하는 경우에는 적합하지 않다.
        Map<String, Integer> response = Collections.singletonMap("count", count);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/login")
    public String registerPage(HttpServletRequest request){
        logger.info("URL = {}", request.getRequestURL());
        return "/user/login";
    }
}
