package com.xxxx.ScoreQuery.dao;

import com.xxxx.ScoreQuery.vo.Score;

import java.util.List;

public interface ScoreMapper {
    int insert(Score record);

    int insertSelective(Score record);

    List<Score> selectScore(Integer t_id);
}