package com.stackroute.favouriteservice.service;

import java.util.List;

import com.stackroute.favouriteservice.entity.Article;
import com.stackroute.favouriteservice.exception.ArticleAllreadyExistsException;
import com.stackroute.favouriteservice.exception.ArticleNotFoundException;

public interface ArticleService {

	boolean saveArticle(Article articleEntity) throws ArticleAllreadyExistsException;

	List<Article> deleteArticle(String author,String publishedAt) throws ArticleNotFoundException;

	List<Article> getMyArticles(String userId);

}
