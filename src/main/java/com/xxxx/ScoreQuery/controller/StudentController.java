package com.xxxx.ScoreQuery.controller;

import com.xxxx.ScoreQuery.ResultInfo;
import com.xxxx.ScoreQuery.service.StudentService;
import com.xxxx.ScoreQuery.vo.Score;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("student")
@Controller
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 接受前端ajax所传过来的的参数
     * 如果基本信息输入错误，不会发生跳转，原有信息也不会发生改变
     * 如果查询成功则会返回正确的resultInfo,其中已经封装好成绩，前端自行取值
     * @param id
     * @param name
     * @return
     */
    @PostMapping("RecentAchievements")
    @ResponseBody
    public ResultInfo RecentAchievements(String id,String name) {
        ResultInfo resultInfo = studentService.selectAllScore(id,name);
        if(resultInfo.getCode()==1){
            List<Score> list = (List<Score>) resultInfo.getResult();
            Score score = list.get(0);
            resultInfo.setResult(score);
            resultInfo.setCode(1);
            resultInfo.setMsg("查询成功！");
        }
        return resultInfo;
    }

    /**
     * 查询以往的成绩
     * @param id
     * @param name
     * @return
     */
    @PostMapping("AllGrades")
    @ResponseBody
    public ResultInfo AllGrades(String id,String name) {
        return studentService.selectAllScore(id,name);
    }
    
}
