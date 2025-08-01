package com.example.docker_spring.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired; // 추가
import java.util.List; // 추가
import com.example.docker_spring.vo.MemberVO; // 추가
import com.example.docker_spring.service.MemberService; // 추가

@RestController
public class AppController {

    @Autowired MemberService service;

    @GetMapping("/hello")
    public String hello() {
        return "정말 좋은 아침!!!";
    }

    @GetMapping("/members")
    public List<MemberVO> selectListMembers(){
        return service.selectAllMembers();
    }

}