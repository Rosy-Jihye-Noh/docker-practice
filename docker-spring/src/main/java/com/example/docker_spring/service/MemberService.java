package com.example.docker_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.docker_spring.mapper.MemberMapper;
import com.example.docker_spring.vo.MemberVO;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    public List<MemberVO> selectAllMembers() {
        return memberMapper.selectAllMembers();
    }

    public void insertMember(MemberVO vo) {
        memberMapper.insertMember(vo);
    }
}
