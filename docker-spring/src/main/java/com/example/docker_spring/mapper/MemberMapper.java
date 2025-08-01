package com.example.docker_spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.docker_spring.vo.MemberVO;

@Mapper
public interface MemberMapper {
    public List<MemberVO> selectAllMembers();

    public void insertMember(MemberVO vo);

}
