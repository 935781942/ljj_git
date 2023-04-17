package com.xxxx.ScoreQuery.service;

import com.github.pagehelper.util.StringUtil;
import com.xxxx.ScoreQuery.ResultInfo;
import com.xxxx.ScoreQuery.dao.ScoreMapper;
import com.xxxx.ScoreQuery.dao.StudentMapper;
import com.xxxx.ScoreQuery.dao.TestMapper;
import com.xxxx.ScoreQuery.vo.Score;
import com.xxxx.ScoreQuery.vo.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private TestMapper testMapper;

    @Resource
    private ScoreMapper scoreMapper;

    /**
     * 根据学号查询最近考试的成绩
     * @param id
     * @param name
     * @return
     */
    /*public ResultInfo selectScore(String id,String name){
        ResultInfo<Student> resultInfo = new ResultInfo<>();

        if(StringUtil.isEmpty(id)){
            resultInfo.setCode(0);
            resultInfo.setMsg("学号不能为空！");
            return resultInfo;
        }
        if(StringUtil.isEmpty(name)){
            resultInfo.setCode(0);
            resultInfo.setMsg("姓名不能为空！");
            return resultInfo;
        }

        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(id));

        if(null == student){
            resultInfo.setCode(0);
            resultInfo.setMsg("学号不正确！");
            return resultInfo;
        }

        if(!name.equals(student.getName())){
            resultInfo.setCode(0);
            resultInfo.setMsg("姓名不正确！");
            return resultInfo;
        }

        ResultInfo<Score> resultInfo1 = new ResultInfo<>();



        List<Map<String,Object>> list1 = testMapper.selectPrimaryKey();
        Integer t_id = (Integer) list1.get(0).get("id");

        if(t_id == null){
            resultInfo1.setCode(0);
            resultInfo1.setMsg("没有考试项目，系统错误");
            return  resultInfo1;
        }
        //先根据t_id选出所有的指定时间段的考试成绩并且排序，在根据id选出指定的人的成绩并且填上排名
        List<Score> list2 = scoreMapper.selectScore(t_id);

        Integer s_id = Integer.parseInt(id);
        Score score = new Score();
        for (int i=0 ;i < list2.size();i++){
            if(s_id .equals(list2.get(i).getsId())){
                score.setsId(s_id);
                score.setName(list2.get(i).getName());
                score.setDate(list2.get(i).getDate());
                score.setcScore(list2.get(i).getcScore());
                score.seteScore(list2.get(i).getmScore());
                score.setmScore(list2.get(i).geteScore());
                score.setScore(list2.get(i).getScore());
                score.setRanking(i+1);
                break;
            }
        }
        if(score.getsId()==null){
            resultInfo1.setCode(0);
            resultInfo1.setMsg("在本次考试中您没有考试记录，请联系管理员！");
            return resultInfo1;
        }
        resultInfo1.setCode(1);
        resultInfo1.setMsg("查询成功！");
        resultInfo1.setResult(score);

        return resultInfo1;
    }*/

    /**
     * 根据学号查询以往全部的成绩
     * @param id
     * @param name
     * @return
     */
    public ResultInfo selectAllScore(String id,String name) {
        ResultInfo<Student> resultInfo = new ResultInfo<>();

        if(StringUtil.isEmpty(id)){
            resultInfo.setCode(0);
            resultInfo.setMsg("学号不能为空！");
            return resultInfo;
        }
        if(StringUtil.isEmpty(name)){
            resultInfo.setCode(0);
            resultInfo.setMsg("姓名不能为空！");
            return resultInfo;
        }

        Student student = studentMapper.selectByPrimaryKey(Integer.parseInt(id));

        if(null == student){
            resultInfo.setCode(0);
            resultInfo.setMsg("学号不正确！");
            return resultInfo;
        }

        if(!name.equals(student.getName())){
            resultInfo.setCode(0);
            resultInfo.setMsg("姓名不正确！");
            return resultInfo;
        }


        ResultInfo<List<Score>> resultInfo2 = new ResultInfo<>();

        Integer s_id = Integer.parseInt(id);

        List<Score> scoreList = new ArrayList<>();

        Score score = new Score();

        List<Map<String,Object>> list1 = testMapper.selectPrimaryKey();
        for(int i=0;i< list1.size();i++){
            Integer t_id = (Integer) list1.get(i).get("id");
            if(t_id == null){
                resultInfo2.setCode(0);
                resultInfo2.setMsg("没有考试项目，系统错误");
                return  resultInfo2;
            }
            //先根据t_id选出所有的指定时间段的考试成绩并且排序，在根据id选出指定的人的成绩并且填上排名
            List<Score> list2 = scoreMapper.selectScore(t_id);
            for (int j=0 ;j < list2.size();j++){
                if(s_id.equals(list2.get(j).getsId())){
                    score.setsId(s_id);
                    score.setName(list2.get(j).getName());
                    score.setDate(list2.get(j).getDate());
                    score.setcScore(list2.get(j).getcScore());
                    score.seteScore(list2.get(j).getmScore());
                    score.setmScore(list2.get(j).geteScore());
                    score.setScore(list2.get(j).getScore());
                    score.setRanking(j+1);
                    break;
                }
            }
            scoreList.add(score);
        }
        if(scoreList.get(0).getsId() == null){
            resultInfo2.setCode(0);
            resultInfo2.setMsg("您没有任何考试记录，请尽快联系管理员！");
            return resultInfo2;
        }
        resultInfo2.setCode(1);
        resultInfo2.setMsg("查询成功！");
        resultInfo2.setResult(scoreList);

        return resultInfo2;
    }
}
