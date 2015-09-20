package com.wangl.locust.dao;

import java.util.List;

import com.wangl.locust.entity.News;

public interface INewsDao {
	public void save(News news);
	public void saveAll(List<News> newsList);
}
