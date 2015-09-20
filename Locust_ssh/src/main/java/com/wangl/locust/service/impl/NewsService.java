package com.wangl.locust.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wangl.locust.dao.impl.NewsDao;
import com.wangl.locust.entity.News;
import com.wangl.locust.service.INewsService;

@Service
public class NewsService implements INewsService {

	@Autowired
	public NewsDao newsDao;
	
	@Override
	public void save(News news) {
		this.newsDao.save(news);
	}

	@Override
	public void saveAll(List<News> newsList) {
		this.newsDao.saveAll(newsList);
	}


}
