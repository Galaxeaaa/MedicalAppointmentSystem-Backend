package com.example.demo.service;

import java.util.List;

import com.example.demo.History;

public interface HistoryService {
	 List<History> getHistory(String userName);
	 
}
