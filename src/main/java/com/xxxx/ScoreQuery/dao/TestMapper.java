package com.xxxx.ScoreQuery.dao;

import com.xxxx.ScoreQuery.vo.Test;

import java.util.List;
import java.util.Map;

public interface TestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    List<Map<String, Object>> selectPrimaryKey();
}