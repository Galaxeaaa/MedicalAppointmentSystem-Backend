package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ScoreDao {

    @Update("update doctor set score = score + #{score}, scoreNum = scoreNum + 1, scoreAvg = score / scoreNum where id = #{did}")
    boolean setScore(@Param("did") String did, @Param("score") String score);
}
