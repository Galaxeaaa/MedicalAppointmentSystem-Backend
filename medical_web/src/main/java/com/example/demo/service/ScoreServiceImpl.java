package com.example.demo.service;

import com.example.demo.dao.ScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    public boolean setScore(String did, String score) {
        System.out.println(did + "'s score:" + score);
        return scoreDao.setScore(did, score);
    }

}

