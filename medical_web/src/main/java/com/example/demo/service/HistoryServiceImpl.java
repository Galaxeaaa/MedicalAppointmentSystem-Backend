package com.example.demo.service;

import com.example.demo.History;
import com.example.demo.dao.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl implements HistoryService {
	@Autowired
	 private HistoryDao historyDao;
	
	
	  public List<History> getHistory(String name) {
		  
		  return historyDao.getHistory(name);
		  
		  
	  }
	  
	  public boolean addHistory(History  report) {
		  return historyDao.addHistory(report);
	  }
}