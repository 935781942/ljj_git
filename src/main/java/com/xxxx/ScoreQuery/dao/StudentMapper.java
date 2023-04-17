package com.xxxx.ScoreQuery.dao;

import com.xxxx.ScoreQuery.vo.Student;


public interface StudentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);


}