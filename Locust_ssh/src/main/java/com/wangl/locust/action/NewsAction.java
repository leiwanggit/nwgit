package com.wangl.locust.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinaedustar.common.web.BaseAction;
import com.wangl.locust.entity.News;
import com.wangl.locust.service.INewsService;

@SuppressWarnings("serial")
public class NewsAction extends BaseAction{
	@Autowired
	private INewsService newsService;

	public String jsoup(){
		try {
       	 	// 从文件中加载 HTML 文档
			String url ="http://news.baidu.com/";
			Document doc2 = Jsoup.connect(url).get();
			Element contents=doc2.getElementsByClass("hotnews").first();
			Elements tagAs=contents.getElementsByTag("a");
			List<News> newsList = new ArrayList<News>();
			for (Element ele :tagAs) {
				System.out.println("<a> html="+ele.attr("href"));
				System.out.println("<a> title="+ele.html());
				News news=new News();
				news.setTitle(ele.html());
				news.setUrl(ele.attr("href"));
				news.setFrom("http://news.baidu.com/");
				newsList.add(news);
			}
			if(newsList!=null && newsList.size()>0){
				this.newsService.saveAll(newsList);
			}
			//this.rendJson(EXE_SUCCESS, "this is true");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
