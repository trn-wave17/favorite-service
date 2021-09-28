package com.stackroute.favouriteservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.favouriteservice.entity.Article;

public interface ArticleRepository extends MongoRepository<Article, Integer> {
	
	List<Article> findByUserId(String userId);
	Article  findByAuthorAndPublishedAt(String author,String publishedAt);
	Article findByPublishedAt (String publishedAt);

}
