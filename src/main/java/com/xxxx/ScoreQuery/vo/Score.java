package com.xxxx.ScoreQuery.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Score {

    private Integer sId;

    private Integer tId;

    private Integer cScore;

    private Integer mScore;

    private Integer eScore;

    private Integer score;

    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    private Integer ranking;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public Integer getcScore() {
        return cScore;
    }

    public void setcScore(Integer cScore) {
        this.cScore = cScore;
    }

    public Integer getmScore() {
        return mScore;
    }

    public void setmScore(Integer mScore) {
        this.mScore = mScore;
    }

    public Integer geteScore() {
        return eScore;
    }

    public void seteScore(Integer eScore) {
        this.eScore = eScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}