package com.wangl.locust.service;

import java.util.List;

import com.wangl.locust.entity.News;

public interface INewsService{
	public void save(News news);
	public void saveAll(List<News> newsList);
}
