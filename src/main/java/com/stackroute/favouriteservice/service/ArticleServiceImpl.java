package com.stackroute.favouriteservice.service;

import static java.util.Objects.isNull;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favouriteservice.entity.Article;
import com.stackroute.favouriteservice.exception.ArticleAllreadyExistsException;
import com.stackroute.favouriteservice.exception.ArticleNotFoundException;
import com.stackroute.favouriteservice.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleRepository articleRepository;
	

	@Override
	public List<Article> deleteArticle(String author,String publishedAt) throws ArticleNotFoundException {
		List<Article> articles = null;
		  if(!StringUtils.isEmpty(author) && !"null".equalsIgnoreCase(author) && !StringUtils.isBlank(publishedAt)) {
			  Article articleToDelete = articleRepository.findByAuthorAndPublishedAt(author,publishedAt);
			  String userId = articleToDelete.getUserId();
			  articleRepository.delete(articleToDelete);
			  articles  = getMyArticles(userId);
			  }
		  else if(!StringUtils.isBlank(publishedAt)){
			  Article articleToDelete = articleRepository.findByPublishedAt(publishedAt);
			  String userId = articleToDelete.getUserId();
			  articleRepository.delete(articleToDelete);
			  articles  = getMyArticles(userId);
		  }
		  
		return articles;
	}

	@Override
	public List<Article> getMyArticles(String userId) {
		 List<Article> articles = null;
		  if(!StringUtils.isBlank(userId)) {
			  articles = articleRepository.findByUserId(userId);
		  }
		return articles;
	}

	@Override
	public boolean saveArticle(Article articleEntity) throws ArticleAllreadyExistsException {
		boolean isSaved = false;
		if(isNull(articleRepository.findByAuthorAndPublishedAt(articleEntity.getAuthor(), articleEntity.getPublishedAt()))) {
			articleRepository.save(articleEntity);
			isSaved =true;
		}
		else {
			throw new ArticleAllreadyExistsException("This Aricle  has been already added for the current user.");
		}
		
		return isSaved;
	}

}
