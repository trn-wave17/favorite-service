package com.stackroute.favouriteservice.controller;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favouriteservice.entity.Article;
import com.stackroute.favouriteservice.exception.ArticleAllreadyExistsException;
import com.stackroute.favouriteservice.exception.ArticleNotFoundException;
import com.stackroute.favouriteservice.service.ArticleService;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" }, maxAge = 4800)
@RequestMapping("/news/api/v1")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private Environment env;

	/**
	 * This method is used to save article
	 * for the current logged in user.
	 * @param model
	 * @param request
	 * @param response
	 * @return boolean
	 */

	@PostMapping(value = "/article", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveArticle(@RequestBody Article entity, HttpServletRequest request,
			HttpServletResponse response) {

		String token = getToken(request);
		String userId = getUserIdFromToken(token);
		if (nonNull(entity)) {
			try {
				entity.setUserId(userId);
				articleService.saveArticle(entity);
			} catch (ArticleAllreadyExistsException ex) {
				return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
			}
		}

		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	/**
	 * This method is used to fetch saved articles
	 * for the current logged in user.
	 * @param request
	 * @return List of articles
	 */

	@GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getArticles(HttpServletRequest request) {

		String token = getToken(request);
		String userId = getUserIdFromToken(token);
		if (!StringUtils.isBlank(userId)) {
			List<Article> articleList = articleService.getMyArticles(userId);
			return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.NO_CONTENT);
	}

	/**
	 *  This method is used to delete any saved article
	 * for the current logged in user.
	 * @param articleModel
	 * @return list of rest articles.
	 */
	@DeleteMapping(value = "/article", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteArticle(@RequestParam String author, @RequestParam String publishedAt,HttpServletRequest request) {
		String token = getToken(request);
		String userId = getUserIdFromToken(token);
		List<Article> articleList = new ArrayList<>();
		if(!StringUtils.isEmpty(userId)) {
			try {
				articleList = articleService.deleteArticle(author,publishedAt);
				} catch (ArticleNotFoundException e) {
				return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
			}
			
		}
		return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
	}

	
	/**
	 * Fetch JWT token from request.
	 * @param request
	 * @return token 
	 */
	private String getToken(HttpServletRequest request) {
		//final String authHeader = request.getHeader("Authorization");
		//final String token = authHeader.substring(7);
		return "Token";
	}

	/**
	 * Fetch userId from JWT token.
	 * @param token
	 * @return user Id
	 */
	private String getUserIdFromToken(String token) {
		/*
		 * String userId =
		 * Jwts.parser().setSigningKey(env.getProperty("newsapp.jwt.secret.key")).
		 * parseClaimsJws(token) .getBody().getSubject();
		 */
		return "Divyansh";
	}
}
