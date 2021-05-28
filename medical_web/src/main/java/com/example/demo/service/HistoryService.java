package com.example.demo.service;

import java.util.List;

import com.example.demo.History;
import com.example.demo.Report;

public interface HistoryService {
	 List<History> getHistory(String userName);
	    boolean addHistory(History  report);
}
