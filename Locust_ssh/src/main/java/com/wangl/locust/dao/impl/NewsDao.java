package com.wangl.locust.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.wangl.locust.dao.INewsDao;
import com.wangl.locust.entity.News;

@Repository
public class NewsDao extends HibernateDaoSupport implements INewsDao{

	private HibernateTemplate temp = null;
	
	public void save(News news){
		this.temp = this.getHibernateTemplate();
		this.temp.save(news);
	}
	
	public void saveAll(List<News> newsList){
		this.temp = this.getHibernateTemplate();
		for (News news : newsList) {
			this.temp.save(news);
		}
	}
	
	
	@Autowired
    public NewsDao(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
